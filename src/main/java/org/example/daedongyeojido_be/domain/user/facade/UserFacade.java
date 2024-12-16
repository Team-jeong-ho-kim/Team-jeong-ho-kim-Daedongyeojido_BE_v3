package org.example.daedongyeojido_be.domain.user.facade;


import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.exception.NotAuthenticatedException;
import org.example.daedongyeojido_be.domain.user.exception.UserNotFoundException;
import org.example.daedongyeojido_be.domain.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NotAuthenticatedException("인증되지 않는 유저입니다.");
        }

        String username = authentication.getName();

        return userRepository.findByUsername(username)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);


    }

}
