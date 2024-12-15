package org.example.daedongyeojido_be.domain.club.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class ClubNotFoundException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new ClubNotFoundException();

    public ClubNotFoundException(){
        super(ErrorCode.CLUB_NOT_FOUND);
    }
}
