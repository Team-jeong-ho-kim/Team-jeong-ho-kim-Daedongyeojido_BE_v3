package org.example.daedongyeojido_be.domain.auth.service;


import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.auth.domain.RefreshToken;
import org.example.daedongyeojido_be.domain.auth.exception.RefreshTokenNotFoundException;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.request.RefreshTokenRequest;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.response.LoginResponse;
import org.example.daedongyeojido_be.domain.auth.repository.RefreshTokenRepository;
import org.example.daedongyeojido_be.global.config.security.jwt.JwtTokenProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReissueService {

    private final JwtTokenProvider jwtTokenProvider;

    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public LoginResponse reissue(RefreshTokenRequest request) {

        RefreshToken refreshToken = refreshTokenRepository.findByToken(request.getToken())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        return jwtTokenProvider.receiveToken(refreshToken.getUsername());
    }
}