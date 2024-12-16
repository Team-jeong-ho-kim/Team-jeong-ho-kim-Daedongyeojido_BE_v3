package org.example.daedongyeojido_be.domain.resume.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.resume.domain.Resume;
import org.example.daedongyeojido_be.domain.resume.domain.facade.ResumeFacade;
import org.example.daedongyeojido_be.domain.resume.presentation.dto.request.WriteUpdateResumeRequest;
import org.example.daedongyeojido_be.domain.resume.repository.ResumeRepository;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.exception.UserMismatchException;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class ModifyResumeService {
    private final ResumeRepository resumeRepository;
    private final UserFacade userFacade;
    private final ResumeFacade resumeFacade;

    public void modifyResume(WriteUpdateResumeRequest request, Long resumeId) throws AuthenticationException {
        User user = userFacade.currentUser();
        Resume resume = resumeFacade.findResumeById(resumeId);

        if(user != resume.getUser()) {
            throw new UserMismatchException();
        }

        resume.modify(request);
    }
}
