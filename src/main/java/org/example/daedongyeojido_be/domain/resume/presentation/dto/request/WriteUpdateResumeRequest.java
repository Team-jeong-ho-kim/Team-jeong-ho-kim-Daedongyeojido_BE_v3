package org.example.daedongyeojido_be.domain.resume.presentation.dto.request;

import lombok.Builder;

@Builder
public record WriteUpdateResumeRequest(
        String major,
        String introduceSelf,
        String reasonApplication,
        String reasonMajor,
        String wantFromClub,
        String assignment,
        String clubName
) {
}
