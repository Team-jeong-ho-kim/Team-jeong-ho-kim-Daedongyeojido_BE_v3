package org.example.daedongyeojido_be.domain.resume.exception;

import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class ResumeNotFoundException extends DaeDongException {
    public static final DaeDongException EXCEPTION = new ResumeNotFoundException();

    private ResumeNotFoundException() {
        super(ErrorCode.RESUME_NOT_FOUND);
    }
}
