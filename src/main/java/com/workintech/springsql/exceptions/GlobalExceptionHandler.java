package com.workintech.springsql.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<BurgerErrorResponse> handleException (BurgerException burgerException ){
BurgerErrorResponse response = new BurgerErrorResponse(burgerException.getMessage());
return new ResponseEntity<>(response,burgerException.getStatus());

    }

    public ResponseEntity<BurgerErrorResponse> handleException (Exception exception){

        BurgerErrorResponse response = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
