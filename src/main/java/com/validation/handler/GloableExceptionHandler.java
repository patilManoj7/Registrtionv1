package com.validation.handler;

import com.validation.exception.ResouceNotFoundException;
import com.validation.util.Error;
import jakarta.validation.ConstraintViolationException;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.management.BadAttributeValueExpException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GloableExceptionHandler {
    @ExceptionHandler(ResouceNotFoundException.class)
    public ResponseEntity<Error> resourceNotFound(ResouceNotFoundException r, WebRequest request)
    {
        return new ResponseEntity<>(new Error(r.getMessage(),new Date(),request.getDescription(true)), HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> badAttributeValueExpException(MethodArgumentNotValidException e)
    {
        Map<String,String> errormap=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error->errormap.put(error.getField(),error.getDefaultMessage()));
        return  new ResponseEntity<>(errormap,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>> constraintViolationException(ConstraintViolationException ex)
    {
        Map<String,String> map=new HashMap<>();
        ex.getConstraintViolations().forEach(e->map.put(e.getPropertyPath().toString(),e.getMessage()));
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> dataIntegrityViolationException(DataIntegrityViolationException e)
    {

        return new ResponseEntity<>("Data Voilation Exception "+e.getCause()+e.getMessage(),HttpStatus.CONFLICT);
    }
}
