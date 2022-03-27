package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class AuthorException extends RuntimeException{

    private int statusCode;

    public AuthorException() {
    }

    public AuthorException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public AuthorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorException(Throwable cause) {
        super(cause);
    }

    public AuthorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
