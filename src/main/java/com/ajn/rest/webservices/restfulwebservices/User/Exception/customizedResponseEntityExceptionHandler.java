package com.ajn.rest.webservices.restfulwebservices.User.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//What is @ControllerAdvice? - This enables the controller below to be applicable with all the other controllers
@ControllerAdvice
@RestController
//Why @RestController for this class?
//because this class is going to return a response back as an exception
public class customizedResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    // handles all exceptions
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse =
        new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));


        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // custom Exception
    @ExceptionHandler({userNotFoundException.class, noUserAvailableException.class})
    public final ResponseEntity<Object> handleUserNotFoundException(userNotFoundException ex,
                                                                     WebRequest request) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));


        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(noUserNameException.class)
    public final ResponseEntity<Object> handleNoUserNameException(noUserNameException e,WebRequest w){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),e.getMessage(),w.getDescription(false));

        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }


}
