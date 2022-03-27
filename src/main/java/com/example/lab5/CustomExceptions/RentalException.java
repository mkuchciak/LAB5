package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class RentalException extends RuntimeException{
    private int statusCode;

    public RentalException() {
    }

    public RentalException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public RentalException(String message, Throwable cause) {
        super(message, cause);
    }

    public RentalException(Throwable cause) {
        super(cause);
    }

    public RentalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
