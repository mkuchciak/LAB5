package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class MissingPasswordException extends UserException{
    public MissingPasswordException() {
    }

    public MissingPasswordException(String message, int statusCode) {
        super(message, statusCode);
    }

    public MissingPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingPasswordException(Throwable cause) {
        super(cause);
    }

    public MissingPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
