package org.example.daedongyeojido_be.domain.like.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.user.domain.User;

@Entity
@Getter
@Table(name = "feed_like")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Builder
    public Like(User user, Feed feed) {
        this.user = user;
        this.feed = feed;
    }

}
