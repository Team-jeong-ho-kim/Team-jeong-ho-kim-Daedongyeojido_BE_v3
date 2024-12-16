package org.example.daedongyeojido_be.infrastructure.feign.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class FeignUnauthorizedException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new FeignUnauthorizedException();

    public FeignUnauthorizedException(){
        super(ErrorCode.FEIGN_UNAUTHORIZED);
    }
}
