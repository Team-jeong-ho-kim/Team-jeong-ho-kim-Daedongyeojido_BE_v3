package org.example.daedongyeojido_be.domain.resume.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.resume.domain.Resume;
import org.example.daedongyeojido_be.domain.resume.domain.facade.ResumeFacade;
import org.example.daedongyeojido_be.domain.resume.repository.ResumeRepository;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.exception.NotAuthenticatedException;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteResumeService {
    private final ResumeRepository repository;
    private final ResumeFacade resumeFacade;
    private final UserFacade userFacade;

    public void deleteResume(Long id) {
        Resume resume = resumeFacade.findResumeById(id);
        User user = userFacade.currentUser();

        if(user != resume.getUser()) {
            throw new NotAuthenticatedException();
        }

        repository.delete(resume);
    }
}
