package com.ajn.rest.webservices.restfulwebservices.User.Bean;

import com.ajn.rest.webservices.restfulwebservices.User.dao.PostDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
public class User {

    private Integer id;
    private String name;
    private Date birthDate;

    @Autowired
    private PostDAO postDAO;

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

}
