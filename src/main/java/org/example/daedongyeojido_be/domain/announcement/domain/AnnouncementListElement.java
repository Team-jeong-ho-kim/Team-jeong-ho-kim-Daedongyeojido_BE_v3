package org.example.daedongyeojido_be.domain.announcement.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class AnnouncementListElement {
    private String major;
    private Date startDate;
    private Date endDate;
    private String recruitmentPost;
    private String howToApply;
    private String idealTalent;
    private String assignment;
}
