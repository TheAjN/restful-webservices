package com.ajn.rest.webservices.restfulwebservices.User.Bean;

import com.ajn.rest.webservices.restfulwebservices.User.Service.PostService;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    //@Min(value=2)
    @Size(min=2,message = "Minimum size should be 2 characters")
    private String name;
    @Past
    private Date birthDate;

    //@Transient must be annotated if the field is of type Entity class

 //   @Autowired
    @Transient
    private PostService postService;

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        postService = new PostService();
    }

}
