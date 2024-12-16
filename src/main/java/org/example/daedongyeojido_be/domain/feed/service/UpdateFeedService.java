package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.feed.facade.FeedFacade;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.request.FeedRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateFeedService {

    private final FeedFacade feedFacade;

    @Transactional
    public void updateFeed(Long feedId, FeedRequest request) {
        Feed feed = feedFacade.getFeed(feedId);
        feed.updateFeed(request.getTitle(), request.getContent(), request.getContent(), request.getTitle(), request.getUserName());
    }

}
