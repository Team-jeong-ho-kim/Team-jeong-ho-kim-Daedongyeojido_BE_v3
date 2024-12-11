package org.example.daedongyeojido_be.domain.auth.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class InValidTokenException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new InValidTokenException();

    public InValidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }
}
