package org.example.daedongyeojido_be.domain.resume.presentation.dto.response;

import lombok.Builder;

@Builder
public record ViewResumeResponse(
        String major,
        String introduceSelf,
        String reasonApplication,
        String reasonMajor,
        String wantFromClub
) { }
