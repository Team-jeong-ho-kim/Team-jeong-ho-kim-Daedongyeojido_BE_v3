package org.example.daedongyeojido_be.domain.feed.domain.repository;

import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedDetailResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedListResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.TemporaryFeedListResponse;

import java.util.List;
import java.util.Optional;

public interface FeedRepositoryCustom {

    List<FeedListResponse> findMyFeedsByUserId(Long userId);
    FeedDetailResponse findByFeedUrl(String feedUrl);
    List<TemporaryFeedListResponse> findTemporaryFeedsByUserId(Long userId);
    List<FeedListResponse> getFeeds();

}
