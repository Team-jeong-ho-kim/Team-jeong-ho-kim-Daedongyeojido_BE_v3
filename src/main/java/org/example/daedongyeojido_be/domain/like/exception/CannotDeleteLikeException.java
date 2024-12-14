package org.example.daedongyeojido_be.domain.like.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class CannotDeleteLikeException extends DayException {

    public static final CannotDeleteLikeException EXCEPTION = new CannotDeleteLikeException();

    private CannotDeleteLikeException() {
        super(ErrorCode.CANNOT_DELETE_LIKE);
    }

}
