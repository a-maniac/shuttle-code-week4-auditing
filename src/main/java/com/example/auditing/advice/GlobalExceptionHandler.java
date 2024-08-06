package com.example.auditing.advice;

import com.example.auditing.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException exception){
        ApiError apiError= new ApiError(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);

    }
}