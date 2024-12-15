package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.feed.domain.repository.FeedRepository;
import org.example.daedongyeojido_be.domain.feed.exception.CannotDeleteFeedException;
import org.example.daedongyeojido_be.domain.feed.facade.FeedFacade;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.domain.enums.Role;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void deleteFeed(Long feedId) {
        User user = userFacade.currentUser();
        if(!user.getRole().equals(Role.ADMIN)) {
            throw CannotDeleteFeedException.EXCEPTION;
        }
        Feed feed = feedFacade.getFeed(feedId);

        if(!user.getId().equals(feed.getUser().getId())) {
            throw CannotDeleteFeedException.EXCEPTION;
        }

        feedRepository.delete(feed);
    }

}
