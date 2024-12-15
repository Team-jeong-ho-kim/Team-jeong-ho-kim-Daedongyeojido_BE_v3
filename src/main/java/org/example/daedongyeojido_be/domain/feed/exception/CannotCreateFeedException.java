package org.example.daedongyeojido_be.domain.feed.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class CannotCreateFeedException extends DayException {

    public static final CannotCreateFeedException EXCEPTION = new CannotCreateFeedException();

    private CannotCreateFeedException() {
        super(ErrorCode.CANNOT_CREATE_FEED);
    }

}
