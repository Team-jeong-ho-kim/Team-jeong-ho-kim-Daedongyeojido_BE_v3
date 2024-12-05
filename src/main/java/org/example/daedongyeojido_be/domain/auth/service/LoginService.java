package org.example.daedongyeojido_be.domain.auth.service;


import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.request.LoginRequest;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.response.LoginResponse;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.exception.PasswordMismatchException;
import org.example.daedongyeojido_be.domain.user.exception.UserNotFoundException;
import org.example.daedongyeojido_be.domain.user.repository.UserRepository;
import org.example.daedongyeojido_be.global.config.security.jwt.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public LoginResponse login(LoginRequest request) {

        if (userRepository.existsByUsername(request.username())) {
            User user = userRepository.findByUsername(request.username())
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);

            if (!passwordEncoder.matches(request.password(), user.getPassword()))
                throw PasswordMismatchException.EXCEPTION;

        }
        return jwtTokenProvider.receiveToken(request.username());
    }
}