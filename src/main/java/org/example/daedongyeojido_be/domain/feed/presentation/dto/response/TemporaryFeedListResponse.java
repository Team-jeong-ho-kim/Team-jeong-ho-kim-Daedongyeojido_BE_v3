package org.example.daedongyeojido_be.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TemporaryFeedListResponse {

    private Long feedId;

    private String title;

    private String introduction;

    private LocalDateTime updatedAt;

}
