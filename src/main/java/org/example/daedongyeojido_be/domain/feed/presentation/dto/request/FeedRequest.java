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

    @Size(max = 10, message = "유저 이름은 10자 이내로 입력해주세요.")
    private String userName;

}
