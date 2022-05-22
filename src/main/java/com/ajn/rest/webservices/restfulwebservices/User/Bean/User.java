package com.ajn.rest.webservices.restfulwebservices.User.Bean;

import com.ajn.rest.webservices.restfulwebservices.User.dao.PostDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class User {

    private Integer id;

    //@Min(value=2)
    @Size(min=2,message = "Minimum size should be 2 characters")
    private String name;
    @Past
    private Date birthDate;

    @Autowired
    private PostDAO postDAO;

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

}
