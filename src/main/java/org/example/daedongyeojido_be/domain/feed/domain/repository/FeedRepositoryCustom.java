package org.example.daedongyeojido_be.domain.feed.domain.repository;

import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedDetailResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedListResponse;

import java.util.List;

public interface FeedRepositoryCustom {

    List<FeedListResponse> findMyFeedsByUserId(Long userId);
    FeedDetailResponse findByFeedId(Long feedId);
    List<FeedListResponse> findTemporaryFeedsByUserId(Long userId);

}
