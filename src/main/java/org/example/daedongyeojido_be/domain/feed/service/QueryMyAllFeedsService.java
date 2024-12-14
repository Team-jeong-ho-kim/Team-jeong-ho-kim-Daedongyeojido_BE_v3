package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.repository.FeedRepository;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedListResponse;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMyAllFeedsService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<FeedListResponse> getAllMyFeeds() {
        User user = userFacade.currentUser();
        return feedRepository.findMyFeedsByUserId(user.getId());
    }

}
