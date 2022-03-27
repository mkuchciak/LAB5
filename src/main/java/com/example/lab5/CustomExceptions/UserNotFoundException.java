package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class UserNotFoundException extends UserException{
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
