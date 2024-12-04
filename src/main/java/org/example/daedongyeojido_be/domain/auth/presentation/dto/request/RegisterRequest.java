package org.example.daedongyeojido_be.domain.auth.presentation.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {

    private String email;

    private String username;


    private String password;

    @Column(length = 4)
    private String name;

    @Column(length = 255)
    private String introduce;

}
