package org.example.daedongyeojido_be.domain.like.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class LikeExistException extends DayException {

    public static final LikeExistException EXCEPTION = new LikeExistException();

    private LikeExistException() {
        super(ErrorCode.LIKE_EXIST);
    }

}
