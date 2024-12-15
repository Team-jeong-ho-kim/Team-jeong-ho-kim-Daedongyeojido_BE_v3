package org.example.daedongyeojido_be.domain.club.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ModifyClubRequest(


        @NotBlank
        @Size(min = 1, max = 20, message = "동아리 이름은 1글자 이상, 20글자 이하여야 합니다.")
        String clubName,

        @Size(max = 30, message = "동아리 타이틀은 30글자 이하로 작성하여야 합니다.")
        String title,

        @Size(max = 500, message = "소개 글은 500글자 이하로 작성하여야 합니다.")
        String introduction,
        String clubImageUrl,

        String clubBannerUrl

) {}
