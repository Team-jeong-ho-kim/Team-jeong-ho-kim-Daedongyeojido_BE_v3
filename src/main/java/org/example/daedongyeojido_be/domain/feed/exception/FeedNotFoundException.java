package org.example.daedongyeojido_be.domain.feed.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class FeedNotFoundException extends DayException {

    public static final FeedNotFoundException EXCEPTION = new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);
    }

}
