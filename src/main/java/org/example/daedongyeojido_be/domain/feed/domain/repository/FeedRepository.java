package org.example.daedongyeojido_be.domain.feed.domain.repository;

import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long>, FeedRepositoryCustom {

    Feed findFeedByFeedUrl(String feedUrl);

}
