package com.example.rinha.config;

import com.example.rinha.exception.NotFoundException;
import com.example.rinha.exception.UnprocessableEntityException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({UnprocessableEntityException.class, NotFoundException.class})
    public ResponseEntity<String> handleUnprocessableEntityException(UnprocessableEntityException ex) {
        return ResponseEntity.unprocessableEntity().body(ex.getMessage());
    }
}
