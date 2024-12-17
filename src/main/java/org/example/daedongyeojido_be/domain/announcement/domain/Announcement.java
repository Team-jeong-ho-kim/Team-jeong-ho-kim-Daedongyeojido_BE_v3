package org.example.daedongyeojido_be.domain.announcement.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.daedongyeojido_be.domain.club.domain.Club;

import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String major;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private Date startDate;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private Date endDate;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private String recruitmentPost;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private String howToApply;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private String idealTalent;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private String assignment;

    @OneToOne
    @JoinColumn(referencedColumnName = "club")
    private Club club;
}
