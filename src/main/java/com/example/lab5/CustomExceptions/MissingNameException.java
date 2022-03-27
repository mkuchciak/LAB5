package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class MissingNameException extends AuthorException{
    public MissingNameException() {
    }

    public MissingNameException(String message, int statusCode) {
        super(message, statusCode);
    }

    public MissingNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingNameException(Throwable cause) {
        super(cause);
    }

    public MissingNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
