package com.example.lab5.ExceptionsHandlers;

import com.example.lab5.CustomExceptions.BookException;
import com.example.lab5.CustomExceptions.RentalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Date;
import java.time.Instant;

@ControllerAdvice
public class RentalControllerExceptionHandler {

    @ExceptionHandler(RentalException.class)
    public ResponseEntity<ErrorResponse> handleMissingNameException(RentalException e){
        return new ResponseEntity<>(new ErrorResponse(e.getStatusCode(),
                e.getMessage(),
                Date.from(Instant.now())),
                HttpStatus.valueOf(e.getStatusCode()));
    }
}
