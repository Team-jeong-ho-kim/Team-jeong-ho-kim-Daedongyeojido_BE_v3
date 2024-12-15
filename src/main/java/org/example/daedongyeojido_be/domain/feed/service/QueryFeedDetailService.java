package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.repository.FeedRepository;
import org.example.daedongyeojido_be.domain.feed.exception.FeedNotFoundException;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedDetailResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryFeedDetailService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public FeedDetailResponse getFeedDetail(String feedUrl) {
        FeedDetailResponse response = feedRepository.findByFeedUrl(feedUrl);

        if(response == null) {
            throw FeedNotFoundException.EXCEPTION;
        }

        return response;
    }

}
