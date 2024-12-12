package org.example.daedongyeojido_be.domain.auth.presentation.dto.request;

import jakarta.persistence.Column;


public record RegisterRequest(

    String email,
    String username,
    String password,
    @Column(length = 4)
    String name,
    @Column(length = 255)
    String introduce
) {
}
