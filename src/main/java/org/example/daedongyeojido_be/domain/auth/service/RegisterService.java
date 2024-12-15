package org.example.daedongyeojido_be.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.auth.exception.UserAlreadyTaken;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.request.RegisterRequest;
import org.example.daedongyeojido_be.domain.file.domain.DefaultImageProperties;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.repository.UserRepository;
import org.example.daedongyeojido_be.global.config.security.auth.AuthDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final DefaultImageProperties defaultImageProperties;



    public void register(RegisterRequest request){
        if(userRepository.existsByUsername(request.username())){
            throw UserAlreadyTaken.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .email(request.email())
                        .username(request.username())
                        .password(passwordEncoder.encode(request.password()))
                        .name(request.name())
                        .introduce(request.introduce())
                        .profileImageUrl(defaultImageProperties.ImageUrl())
                        .build());

    }
}
