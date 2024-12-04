package org.example.daedongyeojido_be.domain.auth.service;


import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.request.LogoutRequest;
import org.example.daedongyeojido_be.domain.auth.repository.RefreshTokenRepository;
import org.example.daedongyeojido_be.global.config.security.jwt.JwtTokenProvider;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class LogoutService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate<String, String> redisTemplate;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void logout(LogoutRequest logoutRequest) {

        String accessToken = logoutRequest.getAccessToken();

        // 토큰에서 사용자명 추출
        String username = jwtTokenProvider.getSubjectFromToken(accessToken);

        // Redis에서 해당 사용자의 리프레시 토큰 삭제
        refreshTokenRepository.deleteById(username);

        // Access token 무효화 처리 (Redis 블랙리스트에 추가)
        long expiration = jwtTokenProvider.getExpiration(accessToken);
        redisTemplate.opsForValue().set(accessToken, "logout", expiration, TimeUnit.MILLISECONDS);
    }
}
