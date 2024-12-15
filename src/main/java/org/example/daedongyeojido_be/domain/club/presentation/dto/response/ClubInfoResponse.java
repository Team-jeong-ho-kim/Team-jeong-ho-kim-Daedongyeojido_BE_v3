package org.example.daedongyeojido_be.domain.club.presentation.dto.response;

import lombok.Builder;

@Builder
public record ClubInfoResponse(
        String clubName,
        String title,
        String introduction,
        String clubImageUrl,
        String clubBannerUrl

        //동아리원 나중에 추가 바람
) {
}
