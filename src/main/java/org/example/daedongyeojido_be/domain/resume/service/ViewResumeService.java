package org.example.daedongyeojido_be.domain.resume.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.resume.domain.Resume;
import org.example.daedongyeojido_be.domain.resume.domain.facade.ResumeFacade;
import org.example.daedongyeojido_be.domain.resume.presentation.dto.response.ViewResumeResponse;
import org.example.daedongyeojido_be.domain.resume.repository.ResumeRepository;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViewResumeService {
    private final ResumeRepository resumeRepository;
    private final ResumeFacade resumeFacade;
    private final UserFacade userFacade;

    public ViewResumeResponse viewResume(Long resumeId) {
        Resume resume = resumeFacade.findResumeById(resumeId);
        User user = userFacade.currentUser();

        if(user != resume.getUser()) {
            throw new ArithmeticException();
        }

        return new ViewResumeResponse(
                resume.getMajor(),
                resume.getIntroduceSelf(),
                resume.getReasonApplication(),
                resume.getWantFromClub(),
                resume.getAssignment()
        );
    }
}
