package org.example.daedongyeojido_be.domain.user.domain;


import jakarta.persistence.*;
import lombok.*;
import org.example.daedongyeojido_be.domain.user.domain.enums.Role;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    @Column(length = 255)
    private String password;

    @Column(length = 4)
    private String name;

    private String introduce;

    private String profileImageUrl;


    public void updateMyInfo(String name, String introduce, String profileImageUrl) {
        this.name = name;
        this.introduce = introduce;
        this.profileImageUrl = profileImageUrl;
    }
}
