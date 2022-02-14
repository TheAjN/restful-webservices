package com.ajn.rest.webservices.restfulwebservices.User.Bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;
    private String name;
    private Date birthDate;

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
