package org.example.daedongyeojido_be.domain.user.presentation.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
public record MyInfoResponse(
        String name,
        String introduce,
        String profileImageUrl

) {


}
