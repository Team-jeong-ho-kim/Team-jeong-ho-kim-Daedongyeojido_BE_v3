package org.example.daedongyeojido_be.domain.comment.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class CommentNotFoundException extends DayException {

    public static final CommentNotFoundException EXCEPTION = new CommentNotFoundException();

    private CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }

}
