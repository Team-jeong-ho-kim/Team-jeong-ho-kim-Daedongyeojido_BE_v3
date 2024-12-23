package org.example.daedongyeojido_be.domain.file.exception;


import org.example.daedongyeojido_be.global.config.error.exception.DayException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class FailFileException extends DayException {

    public static final DayException EXCEPTION = new FailFileException();

    private FailFileException(){
        super(ErrorCode.FAIL_FILE);
    }
}
