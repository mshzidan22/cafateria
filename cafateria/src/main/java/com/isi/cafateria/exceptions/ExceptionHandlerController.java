package com.isi.cafateria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = ProductAmountlessThanOrderdExcption.class)
    public ResponseEntity<Object> lessProduct(ProductAmountlessThanOrderdExcption ex){
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(value = TareshNotSuffientException.class)
    public ResponseEntity<Object> tareshNotSuffient(TareshNotSuffientException ex){
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.NOT_ACCEPTABLE);
    }
}
