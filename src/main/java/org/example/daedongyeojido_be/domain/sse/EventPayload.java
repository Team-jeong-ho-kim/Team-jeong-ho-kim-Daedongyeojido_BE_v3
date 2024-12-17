package org.example.daedongyeojido_be.domain.sse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventPayload {

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("heart")
    private int heart;

}
