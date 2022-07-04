package com.dh.dentalClinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorBadRequest(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()/*+ " capturado desde la clase... "+this.getClass().getName()+" de manera global"*/);
    }

}
