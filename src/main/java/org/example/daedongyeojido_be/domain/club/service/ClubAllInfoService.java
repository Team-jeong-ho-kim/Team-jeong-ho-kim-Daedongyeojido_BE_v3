package org.example.daedongyeojido_be.domain.club.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.club.presentation.dto.response.AllClubResponse;
import org.example.daedongyeojido_be.domain.club.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubAllInfoService {

    private final ClubRepository clubRepository;

    public List<AllClubResponse> getAllClubs() {
        return clubRepository.findAll()
                .stream()
                .map(AllClubResponse::new)
                .toList();
    }
}

