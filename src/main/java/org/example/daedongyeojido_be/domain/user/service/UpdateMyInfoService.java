package org.example.daedongyeojido_be.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.exception.PasswordMismatchException;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.example.daedongyeojido_be.domain.user.presentation.dto.Request.UpdateMyInfoRequest;
import org.example.daedongyeojido_be.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateMyInfoService {


    private final UserFacade userFaced;

    private final PasswordEncoder passwordEncoder;

    public void updateMyInfo(UpdateMyInfoRequest request){

        User user = userFaced.currentUser();

        if (!passwordEncoder.matches(request.password(), user.getPassword()))
            throw PasswordMismatchException.EXCEPTION;

        user.updateMyInfo(
                request.name(),
                request.introduce(),
                request.profileImageUrl());
    }
}
