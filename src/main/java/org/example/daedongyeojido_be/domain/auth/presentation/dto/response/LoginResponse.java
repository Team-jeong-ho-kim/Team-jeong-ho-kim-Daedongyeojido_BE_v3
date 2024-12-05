package org.example.daedongyeojido_be.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class LoginResponse {

    private String accessToken;

    private String refreshToken;

    private Date accessExpiredAt;

    private Date refreshExpiredAt;

}