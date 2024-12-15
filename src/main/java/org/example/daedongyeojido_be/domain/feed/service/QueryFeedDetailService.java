package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.repository.FeedRepository;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedDetailResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryFeedDetailService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public FeedDetailResponse getFeedDetail(Long feedId) {
        return feedRepository.findByFeedId(feedId);
    }

}
