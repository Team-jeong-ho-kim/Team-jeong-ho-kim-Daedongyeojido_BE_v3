package org.example.daedongyeojido_be.global.config.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DayException extends RuntimeException{
    private final ErrorCode errorCode;





}
