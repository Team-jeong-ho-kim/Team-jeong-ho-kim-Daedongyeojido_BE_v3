package org.example.daedongyeojido_be.domain.resume.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.resume.domain.Resume;
import org.example.daedongyeojido_be.domain.resume.presentation.dto.request.WriteUpdateResumeRequest;
import org.example.daedongyeojido_be.domain.resume.repository.ResumeRepository;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteResumeService {
    private final ResumeRepository resumeRepository;
    private final UserFacade userFacade;

    public void writeResume(WriteUpdateResumeRequest request) {
        User user = userFacade.currentUser();

        Resume resume = Resume.builder()
                .major(request.major())
                .introduceSelf(request.introduceSelf())
                .reasonApplication(request.reasonApplication())
                .reasonMajor(request.reasonMajor())
                .wantFromClub(request.wantFromClub())
                .assignment(request.assignment())
                .user(user)
                .build();

        resumeRepository.save(resume);
    }
}
