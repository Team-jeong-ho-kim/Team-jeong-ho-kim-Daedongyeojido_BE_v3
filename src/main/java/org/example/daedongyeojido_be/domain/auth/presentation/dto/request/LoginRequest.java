package org.example.daedongyeojido_be.domain.auth.presentation.dto.request;


public record LoginRequest(
        String username,
        String password
) {

}
