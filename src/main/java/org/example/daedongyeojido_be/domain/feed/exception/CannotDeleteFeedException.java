package org.example.daedongyeojido_be.domain.feed.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class CannotDeleteFeedException extends DayException {

    public static final CannotDeleteFeedException EXCEPTION = new CannotDeleteFeedException();

    private CannotDeleteFeedException() {
        super(ErrorCode.CANNOT_DELETE_FEED);
    }

}
