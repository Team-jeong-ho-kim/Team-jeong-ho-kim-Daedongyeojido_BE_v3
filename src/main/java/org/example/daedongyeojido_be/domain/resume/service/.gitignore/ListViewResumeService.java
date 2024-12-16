package org.example.daedongyeojido_be.domain.resume.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.club.domain.Club;
import org.example.daedongyeojido_be.domain.club.repository.ClubRepository;
import org.example.daedongyeojido_be.domain.resume.domain.ResumeListElement;
import org.example.daedongyeojido_be.domain.resume.domain.facade.ResumeFacade;
import org.example.daedongyeojido_be.domain.resume.presentation.dto.response.ListViewResumeResponse;
import org.example.daedongyeojido_be.domain.resume.repository.ResumeRepository;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.example.daedongyeojido_be.domain.user.repository.UserRepository;
import org.example.daedongyeojido_be.global.config.security.jwt.JwtTokenProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListViewResumeService {
    private final ResumeRepository resumeRepository;
    private final ClubRepository clubRepository;

    @Transactional(readOnly = true)
    public ListViewResumeResponse listViewResume(String clubName, HttpServletRequest request) {
        Optional<Club> club = clubRepository.findByClubName(clubName);
        List<ResumeListElement> resumeList = resumeRepository.findByClub(club)
                .stream()
                .map(resume -> {
                    return ResumeListElement.builder()
                            .major(resume.getMajor())
                            .introduceSelf(resume.getIntroduceSelf())
                            .reasonApplication(resume.getReasonApplication())
                            .reasonMajor(resume.getReasonMajor())
                            .wantFromClub(resume.getWantFromClub())
                            .assignment(resume.getAssignment())
                            .build();
                })
                .toList();

        return new ListViewResumeResponse(resumeList);

    }
}
