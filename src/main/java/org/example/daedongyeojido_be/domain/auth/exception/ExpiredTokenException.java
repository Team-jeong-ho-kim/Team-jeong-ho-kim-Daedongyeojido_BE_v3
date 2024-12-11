package org.example.daedongyeojido_be.domain.auth.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class ExpiredTokenException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
