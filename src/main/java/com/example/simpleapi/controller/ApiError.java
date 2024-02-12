package com.example.simpleapi.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError {

    private HttpStatus status;
    private String error;
    private String message;

    public ApiError(HttpStatus status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public HttpStatus getSatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
