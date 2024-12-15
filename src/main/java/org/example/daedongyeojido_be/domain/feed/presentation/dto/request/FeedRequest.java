package org.example.daedongyeojido_be.domain.feed.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedRequest {

    @Size(max = 50, message = "제목은 50자 이내로 입력해주세요.")
    @NotBlank
    private String title;

    @Size(max = 10000, message = "글내용은 10000자 이내로 입력해주세요.")
    private String content;

    private String previewImageUrl;

    @Size(max = 150, message = "글 소개는 150자 아내로 입력해주세요.")
    private String introduction;

    @Size(max = 100, message = "url은 100자 이내로 입력해주세요.")
    private String url;

    private boolean isPublished;

}
