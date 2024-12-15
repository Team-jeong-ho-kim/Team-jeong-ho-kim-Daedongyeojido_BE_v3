package org.example.daedongyeojido_be.domain.auth.service;


import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.auth.exception.UserAlreadyTaken;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.request.RegisterRequest;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.domain.enums.Role;
import org.example.daedongyeojido_be.domain.user.repository.UserRepository;
import org.example.daedongyeojido_be.global.config.security.auth.AuthDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthDetailsService authDetailsService;


    public void register(RegisterRequest request){
        if(userRepository.existsByUsername(request.getUsername())){
            throw UserAlreadyTaken.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .introduce(request.getIntroduce())
                        .role(Role.ADMIN)
                        .build());

    }
}
