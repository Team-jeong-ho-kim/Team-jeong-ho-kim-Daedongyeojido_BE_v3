package org.example.daedongyeojido_be.domain.feed.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.daedongyeojido_be.domain.comment.domain.Comment;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "VARCHAR(150)")
    private String introduction;

    private String previewImageUrl;

    @Column(columnDefinition = "VARCHAR(100)")
    private String feedUrl;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ColumnDefault("0")
    private int heart;

    @Column(nullable = false)
    private boolean isPublished;

    @Column(nullable = false)
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user-id")
    private User user;

    @OneToMany(mappedBy = "feed")
    private List<Comment> comments;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public String generateUrl(String url) {
        if (url.isEmpty()) {
            return title.replace(" ", "-");
        } else {
            return url.replace(" ", "-");
        }
    }

    public String generateIntroduction(String introduction) {
        if (introduction.isEmpty()) {
            return content.substring(0, 150);
        } else {
            if(introduction.length() >= 150) {
                return introduction.substring(0, 150);
            } else {
                return introduction;
            }
        }
    }

    @Builder
    public Feed(String title, String content, String previewImageUrl, String introduction, String feedUrl, int heart, boolean isPublished, User user, String userName) {
        this.title = title;
        this.content = content;
        this.previewImageUrl = previewImageUrl;
        this.introduction = generateIntroduction(introduction);
        this.feedUrl = generateUrl(feedUrl);
        this.heart = heart;
        this.isPublished = isPublished;
        this.user = user;
        this.userName = userName;
    }

    public void updateFeed(String title, String content, String introduction, String feedUrl, String userName) {
        this.title = title;
        this.content = content;
        this.introduction = generateIntroduction(introduction);
        this.feedUrl = generateUrl(feedUrl);
        this.userName = userName;
    }

    public void plusLike() {
        this.heart += 1;
    }

    public void minusLike() {
        if(this.heart > 0)
            this.heart -= 1;
    }

}