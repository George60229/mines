package com.example.pashnev.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(WeightWrongException.class)
    public ResponseEntity<?>WeightWrongEx(WeightWrongException e, WebRequest req){
        ErrorDetails error= new ErrorDetails(new Date(),"Wrong parameter <weight>",req.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CountryWrongException.class)
    public ResponseEntity<?>CountryWrongEx(CountryWrongException e, WebRequest req){
        ErrorDetails error= new ErrorDetails(new Date(),"Wrong parameter <country>",req.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
