package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.feed.domain.repository.FeedRepository;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.request.FeedRequest;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TemporarySaveFeedService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;

    @Transactional
    public void temporarySave(FeedRequest request) {
        User user = userFacade.currentUser();

        feedRepository.save(Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .previewImageUrl(request.getPreviewImageUrl())
                .introduction(request.getIntroduction())
                .feedUrl(request.getUrl())
                .isPublished(false)
                .user(user)
                .build());
    }

}
