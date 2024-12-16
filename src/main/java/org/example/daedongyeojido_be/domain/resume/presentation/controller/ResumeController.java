package org.example.daedongyeojido_be.domain.resume.presentation.controller;

import org.example.daedongyeojido_be.domain.resume.domain.Resume;
import org.example.daedongyeojido_be.domain.resume.presentation.dto.request.WriteUpdateResumeRequest;
import org.example.daedongyeojido_be.domain.resume.presentation.dto.response.ViewResumeResponse;
import org.example.daedongyeojido_be.domain.resume.service.DeleteResumeService;
import org.example.daedongyeojido_be.domain.resume.service.ModifyResumeService;
import org.example.daedongyeojido_be.domain.resume.service.ViewResumeService;
import org.example.daedongyeojido_be.domain.resume.service.WriteResumeService;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController("/resume")
public class ResumeController {
    private WriteResumeService writeService;
    private ViewResumeService viewResumeService;
    private ModifyResumeService modifyResumeService;
    private DeleteResumeService deleteService;

    @PostMapping("/write")
    public void writeResume(@RequestBody WriteUpdateResumeRequest request) {
        writeService.writeResume(request);
    }

    @GetMapping("/{id}")
    public ViewResumeResponse viewResume(@PathVariable Long id) {
        return viewResumeService.viewResume(id);
    }

    @PatchMapping("/{id}")
    public void modifyResume(@RequestBody WriteUpdateResumeRequest request, @PathVariable Long resumeId) throws AuthenticationException {
        modifyResumeService.modifyResume(request, resumeId);
    }

    @DeleteMapping("/{id}")
    private void deleteResume(@PathVariable("id") Long resumeId) {
        deleteService.deleteResume(resumeId);
    }
}
