package org.example.daedongyeojido_be.domain.feed.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private String previewImageUrl;

    @Column(columnDefinition = "VARCHAR(100)")
    private String feedUrl;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String userName;

    public String generateUrl(String title) {
        return title.replace(" ", "-");
    }

    @Builder
    public Feed(String title, String content, String previewImageUrl, String userName, String createdAt) {
        this.title = title;
        this.content = content;
        this.previewImageUrl = previewImageUrl;
        this.feedUrl = generateUrl(title);
        this.userName = userName;
        this.createdAt = createdAt;
    }

    public void updateFeed(String title, String content, String userName, String createdAt) {
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.createdAt = createdAt;
    }

}