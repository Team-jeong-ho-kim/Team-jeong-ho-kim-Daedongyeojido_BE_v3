package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.feed.exception.CannotModifyFeedException;
import org.example.daedongyeojido_be.domain.feed.facade.FeedFacade;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.request.FeedRequest;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.domain.enums.Role;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateFeedService {

    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void updateFeed(Long feedId, FeedRequest request) {
        User user = userFacade.currentUser();
        if(!user.getRole().equals(Role.ADMIN)) {
            throw CannotModifyFeedException.EXCEPTION;
        }
        Feed feed = feedFacade.getFeed(feedId);

        if(!user.getId().equals(feed.getUser().getId())) {
            throw CannotModifyFeedException.EXCEPTION;
        }

        feed.updateFeed(request.getTitle(), request.getContent(), request.getContent(), request.getTitle(), request.getUserName());
    }

}
