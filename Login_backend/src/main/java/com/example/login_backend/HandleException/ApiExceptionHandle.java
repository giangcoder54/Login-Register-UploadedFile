package com.example.login_backend.HandleException;

import com.example.login_backend.Response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandle {
    @ExceptionHandler(ErrorResponse.class)
    public ResponseEntity<MessageResponse> handleException(ErrorResponse errorResponse){
        MessageResponse MessageResponse = new MessageResponse(errorResponse.getMessage());
        return new ResponseEntity<>(MessageResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String MessageResponse = error.getDefaultMessage();
            errors.put(fieldName, MessageResponse);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
