package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.repository.FeedRepository;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedListResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryFeedListService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public List<FeedListResponse> getFeedList() {
        return feedRepository.getFeeds();
    }

}
