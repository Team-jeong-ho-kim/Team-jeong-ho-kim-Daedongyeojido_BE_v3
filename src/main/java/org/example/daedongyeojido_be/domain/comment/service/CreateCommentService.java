package org.example.daedongyeojido_be.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.comment.domain.Comment;
import org.example.daedongyeojido_be.domain.comment.domain.repository.CommentRepository;
import org.example.daedongyeojido_be.domain.comment.presentation.dto.request.CommentRequest;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.feed.facade.FeedFacade;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void createComment(Long feedId, CommentRequest request) {
        User user = userFacade.currentUser();
        Feed feed = feedFacade.getFeed(feedId);

        commentRepository.save(Comment.builder()
                        .comment(request.getComment())
                        .isPublic(request.getIsPublic())
                        .feed(feed)
                        .user(user)
                .build());
    }

}
