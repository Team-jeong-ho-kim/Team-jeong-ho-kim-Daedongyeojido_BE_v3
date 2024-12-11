package org.example.daedongyeojido_be.domain.user.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class UsernameNotFoundException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new UsernameNotFoundException();

    public UsernameNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
