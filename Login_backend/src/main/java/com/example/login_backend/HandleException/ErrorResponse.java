package com.example.login_backend.HandleException;

public class ErrorResponse extends RuntimeException {
    private String message;

    public ErrorResponse(String message) {
        super(message);
    }


}
