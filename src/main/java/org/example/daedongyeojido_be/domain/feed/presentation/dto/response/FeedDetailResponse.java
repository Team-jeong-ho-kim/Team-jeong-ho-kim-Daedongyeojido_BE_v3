package org.example.daedongyeojido_be.domain.feed.presentation.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class FeedDetailResponse {

    private Long feedId;

    private String userName;

    private String title;

    private String content;

    private String createdAt;

    @QueryProjection
    public FeedDetailResponse(Long feedId, String userName, String title, String content, String createdAt) {
        this.feedId = feedId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

}
