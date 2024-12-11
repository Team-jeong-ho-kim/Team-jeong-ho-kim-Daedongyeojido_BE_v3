package org.example.daedongyeojido_be.domain.auth.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class RefreshTokenNotFoundException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException(){
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
