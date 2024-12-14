package org.example.daedongyeojido_be.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.comment.domain.Comment;
import org.example.daedongyeojido_be.domain.comment.exception.CannotModifyCommentException;
import org.example.daedongyeojido_be.domain.comment.facade.CommentFacade;
import org.example.daedongyeojido_be.domain.comment.presentation.dto.request.CommentRequest;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateCommentService {

    private final UserFacade userFacade;
    private final CommentFacade commentFacade;

    @Transactional
    public void updateComment(Long commentId, CommentRequest request) {
        User user = userFacade.currentUser();
        Comment comment = commentFacade.getComment(commentId);

        if(!user.equals(comment.getUser())) {
            throw CannotModifyCommentException.EXCEPTION;
        }

        comment.modify(request.getComment(), request.getIsPublic());
    }

}
