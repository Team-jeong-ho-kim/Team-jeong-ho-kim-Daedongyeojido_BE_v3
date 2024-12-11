package org.example.daedongyeojido_be.domain.user.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class PasswordMismatchException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException(){
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
