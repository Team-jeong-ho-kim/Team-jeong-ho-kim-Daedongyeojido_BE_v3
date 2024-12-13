package org.example.daedongyeojido_be.domain.user.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class UnAuthorizeException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new UnAuthorizeException();

    public UnAuthorizeException(){
        super(ErrorCode.UN_AUTHORIZE_EXCEPTION);
    }
}
