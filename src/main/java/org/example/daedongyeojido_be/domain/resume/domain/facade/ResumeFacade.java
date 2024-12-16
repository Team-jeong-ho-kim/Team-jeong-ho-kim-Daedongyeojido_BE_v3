package org.example.daedongyeojido_be.domain.resume.domain.facade;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.club.domain.Club;
import org.example.daedongyeojido_be.domain.club.repository.ClubRepository;
import org.example.daedongyeojido_be.domain.resume.domain.Resume;
import org.example.daedongyeojido_be.domain.resume.domain.ResumeListElement;
import org.example.daedongyeojido_be.domain.resume.exception.ResumeNotFoundException;
import org.example.daedongyeojido_be.domain.resume.repository.ResumeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ResumeFacade {
    private final ResumeRepository resumeRepository;

    public Resume findResumeById(Long id) {
        return resumeRepository.findById(id).orElseThrow(() -> ResumeNotFoundException.EXCEPTION);
    }

}
