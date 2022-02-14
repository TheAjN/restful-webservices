package com.ajn.rest.webservices.restfulwebservices.User.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionResponse {

    private Date date;
    private String message;
    private String details;

}
