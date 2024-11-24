package com.zolotograd.catalog.advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
  @ExceptionHandler(value = {MethodArgumentNotValidException.class,
          EntityNotFoundException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, Object> handelInvalidArgument(MethodArgumentNotValidException ex) {

    Map<String, Object> errorMap = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));

    return errorMap;
  }

}
