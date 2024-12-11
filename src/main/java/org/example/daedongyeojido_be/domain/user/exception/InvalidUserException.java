package org.example.daedongyeojido_be.domain.user.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class InvalidUserException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new InvalidUserException();

    public InvalidUserException() {
        super(ErrorCode.INVALID_USER);
    }
}
