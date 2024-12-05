package org.example.daedongyeojido_be.domain.auth.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class UserAlreadyTaken extends DayException {

    public static final DayException EXCEPTION = new UserAlreadyTaken();

    private UserAlreadyTaken(){
        super(ErrorCode.USER_ALREADY_TAKEN);
    }
}
