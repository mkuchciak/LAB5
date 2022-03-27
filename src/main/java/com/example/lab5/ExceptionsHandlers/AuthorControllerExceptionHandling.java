package com.example.lab5.ExceptionsHandlers;

import com.example.lab5.CustomExceptions.AuthorException;
import com.example.lab5.CustomExceptions.AuthorNotFoundException;
import com.example.lab5.CustomExceptions.MissingNameException;
import com.example.lab5.CustomExceptions.MissingSurnameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Date;
import java.time.Instant;

@ControllerAdvice
public class AuthorControllerExceptionHandling {
    @ExceptionHandler(AuthorException.class)
    public ResponseEntity<ErrorResponse> handleAuthorNotFoundException(AuthorException e){
        return new ResponseEntity<>(new ErrorResponse(e.getStatusCode(),
                e.getMessage(),
                Date.from(Instant.now())),
                HttpStatus.valueOf(e.getStatusCode()));
    }

}
