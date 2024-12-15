package org.example.daedongyeojido_be.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UserRepository userRepository;

    @Transactional
    public void deleteUser(Long id){


        userRepository.deleteById(id);
    }


}
