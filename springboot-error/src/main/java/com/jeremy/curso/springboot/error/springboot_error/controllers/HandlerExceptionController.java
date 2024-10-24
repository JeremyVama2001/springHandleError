package com.jeremy.curso.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.jeremy.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.jeremy.curso.springboot.error.springboot_error.models.Error;


@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divisionByZero(Exception ex){
        
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error división por zero");
        error.setMessagee(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);

        //return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(NoHandlerFoundException nException){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("ApiREST no econtrado");
        error.setMessagee(nException.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex){
        Map<String, Object> error = new HashMap<>();
        error.put("date",new Date());
        error.put("error", "Numero incorrecto, no es un digito");
        error.put("messsage", ex.getMessage());
        error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler({NullPointerException.class, 
        HttpMessageNotWritableException.class,
        UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex){
        Map<String, Object> error = new HashMap<>();
        error.put("date",new Date());
        error.put("error", "El rol o usuario no existe");
        error.put("messsage", ex.getMessage());
        error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }
}
