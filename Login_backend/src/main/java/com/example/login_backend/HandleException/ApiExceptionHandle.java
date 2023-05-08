package com.example.login_backend.HandleException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandle {
    @ExceptionHandler(ErrorResponse.class)
    public ResponseEntity<ErrorResponse> handleException(ErrorResponse errorResponse){
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
