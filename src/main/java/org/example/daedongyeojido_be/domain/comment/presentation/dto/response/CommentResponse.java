package org.example.daedongyeojido_be.domain.comment.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponse {

    private Long commentId;

    private String comment;

    private String userName;

    private boolean isPublic;

    private LocalDateTime createdAt;

}
