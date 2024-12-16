package org.example.daedongyeojido_be.domain.resume.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.daedongyeojido_be.domain.club.domain.Club;
import org.example.daedongyeojido_be.domain.resume.presentation.dto.request.WriteUpdateResumeRequest;
import org.example.daedongyeojido_be.domain.user.domain.User;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private String major;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private String introduceSelf;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private String reasonApplication;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private String reasonMajor;

    @Size(max = 3000)
    @Column(nullable = true, length = 3000)
    private String wantFromClub;

    @Size(min = 10, max = 3000)
    @Column(nullable = false, length = 3000)
    private String assignment;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "club")
    private Club club;

    public void modify(WriteUpdateResumeRequest request) {
        this.major = request.major();
        this.introduceSelf = request.introduceSelf();
        this.reasonApplication = request.reasonApplication();
        this.reasonMajor = request.reasonMajor();
        this.wantFromClub = request.wantFromClub();
        this.assignment = request.assignment();
    }
}
