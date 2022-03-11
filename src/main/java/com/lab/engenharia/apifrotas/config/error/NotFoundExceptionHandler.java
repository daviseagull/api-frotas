package com.lab.engenharia.apifrotas.config.error;

import com.lab.engenharia.apifrotas.exception.VehicleNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@RestControllerAdvice
public class NotFoundExceptionHandler {

  @ExceptionHandler(VehicleNotFoundException.class)
  public ResponseEntity<List<String>> notFoundErrorHandler(VehicleNotFoundException ex) {

    log.error("VehicleNotFoundException handler: ", ex);
    return status(OK).body(emptyList());
  }
}
