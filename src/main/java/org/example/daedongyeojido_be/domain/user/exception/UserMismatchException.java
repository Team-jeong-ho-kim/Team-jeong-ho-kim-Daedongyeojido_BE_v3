package org.example.daedongyeojido_be.domain.user.exception;


import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class UserMismatchException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new UserMismatchException();

    public UserMismatchException(){
        super(ErrorCode.USER_MISMATCH);
    }
}
