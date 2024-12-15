package org.example.daedongyeojido_be.domain.club.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.club.domain.Club;
import org.example.daedongyeojido_be.domain.club.exception.ClubNotFoundException;
import org.example.daedongyeojido_be.domain.club.presentation.dto.request.ModifyClubRequest;
import org.example.daedongyeojido_be.domain.club.repository.ClubRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClubModifyService {

    private final ClubRepository clubRepository;

    @Transactional
    public void modifyClub(ModifyClubRequest request) {
        Club club = clubRepository.findByClubName(request.clubName())
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        club.modifyClub(
                request.clubName(),
                request.title(),
                request.introduction(),
                request.clubImageUrl(),
                request.clubBannerUrl()
        );
    }
}

