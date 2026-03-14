package com.example.UserManager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> handleUserException(UserException ex) {

        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "error", ex.getMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {

        return ResponseEntity
                .internalServerError()
                .body(Map.of(
                        "error", "Internal server error"
                ));
    }
}