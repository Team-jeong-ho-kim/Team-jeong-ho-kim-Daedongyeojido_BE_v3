package org.example.daedongyeojido_be.domain.feed.domain.repository;

import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long>, FeedRepositoryCustom {
}
