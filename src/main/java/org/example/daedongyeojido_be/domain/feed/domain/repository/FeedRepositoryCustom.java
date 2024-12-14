package org.example.daedongyeojido_be.domain.feed.domain.repository;

import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedDetailResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedListResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.TemporaryFeedListResponse;

import java.util.List;

public interface FeedRepositoryCustom {

    List<FeedListResponse> findMyFeedsByUserId(Long userId);
    FeedDetailResponse findByFeedId(Long feedId);
    List<TemporaryFeedListResponse> findTemporaryFeedsByUserId(Long userId);

}
