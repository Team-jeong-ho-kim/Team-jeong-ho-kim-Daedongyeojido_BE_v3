package org.example.daedongyeojido_be.domain.auth.presentation.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.request.LoginRequest;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.request.LogoutRequest;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.request.RefreshTokenRequest;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.request.RegisterRequest;
import org.example.daedongyeojido_be.domain.auth.presentation.dto.response.LoginResponse;
import org.example.daedongyeojido_be.domain.auth.service.LoginService;
import org.example.daedongyeojido_be.domain.auth.service.LogoutService;
import org.example.daedongyeojido_be.domain.auth.service.RegisterService;
import org.example.daedongyeojido_be.domain.auth.service.ReissueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final LoginService loginService;

    private final RegisterService registerService;

    private final ReissueService reissueService;

    private final LogoutService logoutService;


    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequest request) {
        registerService.register(request);
    }

    @PatchMapping("/reissue")
    public LoginResponse reissue(@RequestBody @Valid RefreshTokenRequest request) {
        return reissueService.reissue(request);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody LogoutRequest logoutRequest) {
        logoutService.logout(logoutRequest);
    }
}
