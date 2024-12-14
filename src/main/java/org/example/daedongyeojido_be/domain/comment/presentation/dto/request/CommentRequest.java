package org.example.daedongyeojido_be.domain.comment.presentation.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequest {

    @Size(max = 1000)
    private String comment;

    private Boolean isPublic;

}
