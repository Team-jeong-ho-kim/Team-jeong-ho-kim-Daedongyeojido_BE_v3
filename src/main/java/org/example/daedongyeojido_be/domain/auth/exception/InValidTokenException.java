package org.example.daedongyeojido_be.domain.auth.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class InValidTokenException extends DayException {

    public static final DayException EXCEPTION = new InValidTokenException();

    public InValidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }
}
