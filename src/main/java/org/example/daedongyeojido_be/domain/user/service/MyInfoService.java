package org.example.daedongyeojido_be.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.example.daedongyeojido_be.domain.user.presentation.dto.Response.MyInfoResponse;
import org.example.daedongyeojido_be.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyInfoService {

    private final UserRepository userRepository;

    private final UserFacade userFaced;

    @Transactional(readOnly = true)
    public MyInfoResponse myInfo(){

        User user = userFaced.currentUser();

        return MyInfoResponse.builder()
                .name(user.getName())
                .introduce(user.getIntroduce())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
    }
}
