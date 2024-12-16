package org.example.daedongyeojido_be.domain.resume.presentation.dto.response;

import lombok.Getter;
import org.example.daedongyeojido_be.domain.resume.domain.ResumeListElement;

import java.util.List;

@Getter
public record ListViewResumeResponse(List<ResumeListElement> resumesList) {}
