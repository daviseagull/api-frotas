package com.lab.engenharia.apifrotas.config.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestControllerAdvice
public class InvalidBodyExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<String>> feignArgumentNotValidErrorHandler(
      MethodArgumentNotValidException ex) {
    log.error("MethodArgumentNotValidException handler: ", ex);

    var allErrors = ex.getBindingResult().getAllErrors();

    var formattedErrors =
        allErrors.stream()
            .map(
                error -> {
                  var fieldName = ((FieldError) error).getField();
                  var errorMessage = error.getDefaultMessage();

                  return fieldName + " " + errorMessage;
                })
            .toList();

    log.warn("Error messages: {}", formattedErrors);

    return ok(emptyList());
  }
}
