package org.example.daedongyeojido_be.domain.club.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.club.domain.Club;
import org.example.daedongyeojido_be.domain.club.exception.ClubNotFoundException;
import org.example.daedongyeojido_be.domain.club.presentation.dto.response.ClubInfoResponse;
import org.example.daedongyeojido_be.domain.club.repository.ClubRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClubInfoService {

    private final ClubRepository clubRepository;

    public ClubInfoResponse getClubInfo(String clubName) {
        Club club = clubRepository.findByClubName(clubName)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        return new ClubInfoResponse(
                club.getClubName(),
                club.getTitle(),
                club.getIntroduction(),
                club.getClubImageUrl(),
                club.getClubBannerUrl()
        );
    }
}
