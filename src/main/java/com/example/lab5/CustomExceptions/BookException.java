package com.example.lab5.CustomExceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookException extends RuntimeException{
    private int statusCode;
    public BookException() {
    }

    public BookException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public BookException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookException(Throwable cause) {
        super(cause);
    }

    public BookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
