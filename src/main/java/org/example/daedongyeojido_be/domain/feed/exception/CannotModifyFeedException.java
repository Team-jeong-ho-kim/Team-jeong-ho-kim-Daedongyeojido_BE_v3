package org.example.daedongyeojido_be.domain.feed.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class CannotModifyFeedException extends DayException {

    public static final CannotModifyFeedException EXCEPTION = new CannotModifyFeedException();

    private CannotModifyFeedException() {
        super(ErrorCode.CANNOT_MODIFY_FEED);
    }

}
