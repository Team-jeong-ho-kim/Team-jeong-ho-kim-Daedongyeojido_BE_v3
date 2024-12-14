package org.example.daedongyeojido_be.domain.comment.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class CannotDeleteCommentException extends DayException {

    public static final CannotDeleteCommentException EXCEPTION = new CannotDeleteCommentException();

    private CannotDeleteCommentException() {
        super(ErrorCode.CANNOT_DELETE_COMMENT);
    }

}
