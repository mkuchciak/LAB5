package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class RentalInvalidDateException extends RentalException{
    public RentalInvalidDateException() {
    }

    public RentalInvalidDateException(String message, int statusCode) {
        super(message, statusCode);
    }

    public RentalInvalidDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RentalInvalidDateException(Throwable cause) {
        super(cause);
    }

    public RentalInvalidDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
