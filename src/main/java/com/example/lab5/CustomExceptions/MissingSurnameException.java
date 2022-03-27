package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class MissingSurnameException extends AuthorException{
    public MissingSurnameException() {
    }

    public MissingSurnameException(String message, int statusCode) {
        super(message, statusCode);
    }

    public MissingSurnameException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingSurnameException(Throwable cause) {
        super(cause);
    }

    public MissingSurnameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
