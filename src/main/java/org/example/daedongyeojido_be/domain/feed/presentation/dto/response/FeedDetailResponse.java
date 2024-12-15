package org.example.daedongyeojido_be.domain.feed.presentation.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FeedDetailResponse {

    private Long feedId;

    private String userName;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private int heart;

    @QueryProjection
    public FeedDetailResponse(Long feedId, String userName, String title, String content, LocalDateTime createdAt, int heart) {
        this.feedId = feedId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.heart = heart;
    }

}