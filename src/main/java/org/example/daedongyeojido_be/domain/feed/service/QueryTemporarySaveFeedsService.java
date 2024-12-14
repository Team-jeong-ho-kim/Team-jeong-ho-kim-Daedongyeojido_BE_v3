package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.repository.FeedRepository;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedListResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.TemporaryFeedListResponse;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryTemporarySaveFeedsService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    public List<TemporaryFeedListResponse> getTemporaryFeeds() {
        User user = userFacade.currentUser();
        return feedRepository.findTemporaryFeedsByUserId(user.getId());
    }

}
