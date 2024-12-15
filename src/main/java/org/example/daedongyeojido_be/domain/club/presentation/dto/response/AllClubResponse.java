package org.example.daedongyeojido_be.domain.club.presentation.dto.response;

import org.example.daedongyeojido_be.domain.club.domain.Club;

public record AllClubResponse(
        String clubName,
        String title,
        String clubBannerUrl
) {
    public AllClubResponse(Club club) {
        this(
                club.getClubName(),
                club.getTitle(),
                club.getClubBannerUrl()
        );
    }
}

