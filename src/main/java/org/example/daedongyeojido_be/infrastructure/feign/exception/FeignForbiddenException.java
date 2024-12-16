package org.example.daedongyeojido_be.infrastructure.feign.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class FeignForbiddenException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new FeignForbiddenException();

    public FeignForbiddenException(){
        super(ErrorCode.FEIGN_FORBIDDEN);
    }
}
