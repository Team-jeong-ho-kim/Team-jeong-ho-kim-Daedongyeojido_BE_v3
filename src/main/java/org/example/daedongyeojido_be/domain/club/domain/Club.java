package org.example.daedongyeojido_be.domain.club.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Club {

    @Id
    @Column(name = "club_name", length = 20, nullable = false)
    private String clubName;

    private String title;

    private String introduction;

    private String clubImageUrl;

    private String clubBannerUrl;

    public void modifyClub(String clubName, String title, String introduction, String clubImageUrl, String clubBannerUrl) {
        this.clubName = clubName;
        this.title = title;
        this.introduction = introduction;
        this.clubImageUrl = clubImageUrl;
        this.clubBannerUrl = clubBannerUrl;
    }
}


