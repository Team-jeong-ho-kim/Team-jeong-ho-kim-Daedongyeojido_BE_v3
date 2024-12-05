package org.example.daedongyeojido_be.global.config.error;


import lombok.*;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

    private String message;
    private Integer status;
    private LocalDateTime timestamp;
    private String description;

    public static ErrorResponse of(ErrorCode errorCode, String description){
        return ErrorResponse.builder()
                .message(errorCode.getMessage())
                .status(errorCode.getStatusCode())
                .timestamp(LocalDateTime.now())
                .description(description)
                .build();
    }

    public static ErrorResponse of(int statusCode, String description) {
        return ErrorResponse.builder()
                .message(description)
                .status(statusCode)
                .timestamp(LocalDateTime.now())
                .description(description)
                .build();
    }
}
