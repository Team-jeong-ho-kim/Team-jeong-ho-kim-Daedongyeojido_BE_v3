package org.example.daedongyeojido_be.domain.auth.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class UserAlreadyTaken extends DaeDongException {

    public static final DaeDongException EXCEPTION = new UserAlreadyTaken();

    private UserAlreadyTaken(){
        super(ErrorCode.USER_ALREADY_TAKEN);
    }
}
