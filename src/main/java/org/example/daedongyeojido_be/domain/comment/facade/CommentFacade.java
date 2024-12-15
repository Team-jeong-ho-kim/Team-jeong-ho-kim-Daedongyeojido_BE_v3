package org.example.daedongyeojido_be.domain.comment.facade;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.comment.domain.Comment;
import org.example.daedongyeojido_be.domain.comment.domain.repository.CommentRepository;
import org.example.daedongyeojido_be.domain.comment.exception.CommentNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

}
