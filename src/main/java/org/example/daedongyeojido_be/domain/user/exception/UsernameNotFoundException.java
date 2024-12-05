package org.example.daedongyeojido_be.domain.user.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class UsernameNotFoundException extends DayException {

    public static final DayException EXCEPTION = new UsernameNotFoundException();

    public UsernameNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
