package org.example.daedongyeojido_be.domain.user.presentation.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.user.presentation.dto.Request.UpdateMyInfoRequest;
import org.example.daedongyeojido_be.domain.user.presentation.dto.Response.MyInfoResponse;
import org.example.daedongyeojido_be.domain.user.service.DeleteUserService;
import org.example.daedongyeojido_be.domain.user.service.MyInfoService;
import org.example.daedongyeojido_be.domain.user.service.UpdateMyInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final MyInfoService myInfoService;

    private final UpdateMyInfoService updateMyInfoService;

    private final DeleteUserService deleteUserService;

    @GetMapping("/my-info")
    public MyInfoResponse myInfo(){
        return myInfoService.myInfo();
    }

    @PatchMapping("/update")
    public void MyInfoUpdate(@RequestBody @Valid UpdateMyInfoRequest request){
        updateMyInfoService.updateMyInfo(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        deleteUserService.deleteUser(id);
    }




}
