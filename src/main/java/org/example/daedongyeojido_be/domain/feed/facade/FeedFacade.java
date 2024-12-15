package org.example.daedongyeojido_be.domain.feed.facade;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.feed.domain.repository.FeedRepository;
import org.example.daedongyeojido_be.domain.feed.exception.FeedNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeed(Long feedId) {
        return feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }

}
