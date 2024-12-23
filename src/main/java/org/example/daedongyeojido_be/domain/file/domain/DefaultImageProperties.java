package org.example.daedongyeojido_be.domain.file.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "default.profile")
public record DefaultImageProperties(String ImageUrl) {
}
