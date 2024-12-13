package org.example.daedongyeojido_be.domain.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@RedisHash
public class RefreshToken {

    @Id
    private String username;

    @Indexed
    private String token;

    @TimeToLive
    private Long timeToLive;
}
