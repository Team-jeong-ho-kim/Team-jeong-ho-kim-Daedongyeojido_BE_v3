package org.example.daedongyeojido_be.domain.like.domain.repository;

import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.like.domain.Like;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long>{

    boolean existsLikeByUserAndFeed(User user, Feed feed);
    void deleteLikeByUserAndFeed(User user, Feed feed);

}
