package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException{
    private int statusCode;

    public UserException() {
    }

    public UserException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
