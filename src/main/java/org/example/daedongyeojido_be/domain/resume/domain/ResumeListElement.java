package org.example.daedongyeojido_be.domain.resume.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ResumeListElement {
    private String major;
    private Date date;
    private String introduceSelf;
    private String reasonApplication;
    private String reasonMajor;
    private String wantFromClub;
    private String assignment;
}
