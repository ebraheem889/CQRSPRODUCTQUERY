package com.cqrs.demo.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(
            IllegalArgumentException.class)
    public Throwable[] handleInvalidArgument(
            IllegalArgumentException ex) {
        Map<String, String> errorMap = new HashMap<>();
        return ex.getSuppressed();
    }
}
