package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class RentalNotFoundException extends RentalException{
    public RentalNotFoundException() {
    }

    public RentalNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }

    public RentalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RentalNotFoundException(Throwable cause) {
        super(cause);
    }

    public RentalNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
