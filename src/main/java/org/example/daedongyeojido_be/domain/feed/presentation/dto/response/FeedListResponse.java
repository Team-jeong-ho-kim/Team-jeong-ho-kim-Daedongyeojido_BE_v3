package org.example.daedongyeojido_be.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FeedListResponse {

    private Long feedId;

    private String userName;

    private String title;

    private String createdAt;

    private String content;

    private String previewImageUrl;

}
