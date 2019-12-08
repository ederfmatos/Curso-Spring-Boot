package com.edermatos.cursospring.handler;

import com.edermatos.cursospring.exceptions.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class RestExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public final ResponseEntity<BeanResponseException> handleParameterFoundException(ObjectNotFoundException ex, WebRequest request) {
        BeanResponseException errorDetails = new BeanResponseException(ex.getMessage(), request.getDescription(false), ObjectNotFoundException.class.getAnnotation(ResponseStatus.class).value());
        return new ResponseEntity<>(errorDetails, errorDetails.getStatus());
    }

}
