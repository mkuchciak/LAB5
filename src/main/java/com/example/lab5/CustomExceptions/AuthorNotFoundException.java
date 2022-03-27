package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class AuthorNotFoundException extends AuthorException{
    public AuthorNotFoundException() {
    }

    public AuthorNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }

    public AuthorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorNotFoundException(Throwable cause) {
        super(cause);
    }

    public AuthorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
