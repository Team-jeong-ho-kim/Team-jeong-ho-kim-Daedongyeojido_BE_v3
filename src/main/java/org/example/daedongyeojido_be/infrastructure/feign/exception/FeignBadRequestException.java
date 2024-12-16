package org.example.daedongyeojido_be.infrastructure.feign.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class FeignBadRequestException extends DaeDongException {

    public final static DaeDongException EXCEPTION = new FeignBadRequestException();

    public FeignBadRequestException(){
        super(ErrorCode.FEIGN_BAD_REQUEST);
    }
}
