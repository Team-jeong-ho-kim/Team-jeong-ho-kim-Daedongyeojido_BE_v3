package org.example.daedongyeojido_be.domain.comment.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class CannotModifyCommentException extends DayException {

    public static final CannotModifyCommentException EXCEPTION = new CannotModifyCommentException();

    private CannotModifyCommentException() {
        super(ErrorCode.CANNOT_MODIFY_COMMENT);
    }

}
