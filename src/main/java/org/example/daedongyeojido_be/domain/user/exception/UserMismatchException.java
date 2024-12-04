package org.example.daedongyeojido_be.domain.user.exception;


import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class UserMismatchException extends DayException {

    public static final DayException EXCEPTION = new UserMismatchException();

    public UserMismatchException(){
        super(ErrorCode.USER_MISMATCH);
    }
}
