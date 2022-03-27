package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class BookNotFoundException extends BookException{
    public BookNotFoundException() {
    }

    public BookNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }

    public BookNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
