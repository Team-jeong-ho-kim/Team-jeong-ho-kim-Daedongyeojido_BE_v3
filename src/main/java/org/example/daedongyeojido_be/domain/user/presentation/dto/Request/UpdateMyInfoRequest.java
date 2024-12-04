package org.example.daedongyeojido_be.domain.user.presentation.dto.Request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateMyInfoRequest {

    private String email;

    private String username;

    private String password;

    private String name;

    private String introduce;


}
