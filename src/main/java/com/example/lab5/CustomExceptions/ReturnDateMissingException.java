package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class ReturnDateMissingException extends RentalException{

    public ReturnDateMissingException() {
    }

    public ReturnDateMissingException(String message, int statusCode) {
        super(message, statusCode);
    }

    public ReturnDateMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReturnDateMissingException(Throwable cause) {
        super(cause);
    }

    public ReturnDateMissingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
