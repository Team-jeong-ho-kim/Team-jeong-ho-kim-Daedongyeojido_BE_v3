package org.example.daedongyeojido_be.domain.user.exception;


import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class UserNotFoundException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}