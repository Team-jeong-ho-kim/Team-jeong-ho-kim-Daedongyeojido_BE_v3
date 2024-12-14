package org.example.daedongyeojido_be.domain.comment.domain.repository;

import org.example.daedongyeojido_be.domain.comment.presentation.dto.response.CommentResponse;
import org.example.daedongyeojido_be.domain.user.domain.User;

import java.util.List;

public interface CommentRepositoryCustom {

    List<CommentResponse> findByFeedId(Long feedId, User user);

}
