package org.example.daedongyeojido_be.domain.user.exception;

public class NotAuthenticatedException extends RuntimeException{

    public NotAuthenticatedException(String message){
        super(message);
    }
}
