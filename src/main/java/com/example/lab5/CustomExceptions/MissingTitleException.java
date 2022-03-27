package com.example.lab5.CustomExceptions;

import lombok.Getter;

@Getter
public class MissingTitleException extends BookException{
    public MissingTitleException() {
    }

    public MissingTitleException(String message, int statusCode) {
        super(message, statusCode);
    }

    public MissingTitleException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingTitleException(Throwable cause) {
        super(cause);
    }

    public MissingTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
