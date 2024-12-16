package org.example.daedongyeojido_be.domain.announcement.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import org.example.daedongyeojido_be.domain.announcement.domain.AnnouncementListElement;

import java.util.List;

@Getter
@Builder
public record ListViewAnnouncementResponse(
        List<AnnouncementListElement> announcementList
) {
}
