package org.example.daedongyeojido_be.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.comment.domain.repository.CommentRepository;
import org.example.daedongyeojido_be.domain.comment.presentation.dto.response.CommentResponse;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.exception.UserNotFoundException;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<CommentResponse> getComments(Long feedId) {
        User user = null;

        try {
            user = userFacade.currentUser();
        } catch (UserNotFoundException e) {
            user = null;
        }

        return commentRepository.findByFeedId(feedId, user);
    }

}
