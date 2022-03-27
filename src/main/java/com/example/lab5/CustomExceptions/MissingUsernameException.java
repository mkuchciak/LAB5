package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class MissingUsernameException extends UserException{
    public MissingUsernameException() {
    }

    public MissingUsernameException(String message, int statusCode) {
        super(message, statusCode);
    }

    public MissingUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingUsernameException(Throwable cause) {
        super(cause);
    }

    public MissingUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
