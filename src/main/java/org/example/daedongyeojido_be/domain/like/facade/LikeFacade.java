package org.example.daedongyeojido_be.domain.like.facade;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.like.domain.repository.LikeRepository;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeFacade {

    private final LikeRepository likeRepository;

    public boolean checkLiked(User user, Feed feed) {
        return likeRepository.existsLikeByUserAndFeed(user, feed);
    }

}
