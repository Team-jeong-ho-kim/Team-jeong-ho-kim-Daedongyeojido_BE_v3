package org.example.daedongyeojido_be.domain.user.presentation.dto.Request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


public record UpdateMyInfoRequest(

        String username,
        String password,
        String name,
        String introduce,
        String profileImageUrl
) {




}
