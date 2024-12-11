package org.example.daedongyeojido_be.domain.file.exception;


import org.example.daedongyeojido_be.global.config.error.exception.DaeDongException;
import org.example.daedongyeojido_be.global.config.error.exception.ErrorCode;

public class FailFileException extends DaeDongException {

    public static final DaeDongException EXCEPTION = new FailFileException();

    private FailFileException(){
        super(ErrorCode.FAIL_FILE);
    }
}
