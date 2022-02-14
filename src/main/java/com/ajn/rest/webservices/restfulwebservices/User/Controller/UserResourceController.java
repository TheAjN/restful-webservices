package com.ajn.rest.webservices.restfulwebservices.User.Controller;


import com.ajn.rest.webservices.restfulwebservices.User.Bean.User;
import com.ajn.rest.webservices.restfulwebservices.User.Exception.userNotFoundException;
import com.ajn.rest.webservices.restfulwebservices.User.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceController {

    @Autowired
    private UserDAO userDAO;

    //retrieve All Users
    @GetMapping("users")
    public List<User> retrieveAllUsers() {
        return userDAO.findAll();
    }

    //retrieve a user
    @GetMapping("users/{id}")
    public User retrieveAUser(@PathVariable int id) {
        User user = userDAO.find(id);

        if(user == null){
            throw new userNotFoundException("id - "+ id);
        }

        return user;
    }


    //Create a user
    //input - details of a user
    //output - display the created user(return the created URI)
    @PostMapping("users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        //@RequestBody maps the request from the webpage to
        //the User object
        User savedUser = userDAO.save(user);

        //once a user is created
        // 1. we need to send a status code called CREATED (which is status code - 201)
        // for that we need to return ResponseEntity<T>
        //2. we need to set the created URI back as a response (output)
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()       //takes the current request URI ("/users)
                .path("/{id}")               //sets path of the current request
                .buildAndExpand(savedUser.getId())  //assign the {id} with the id which is created
                .toUri();       //convert it into a URI

        return ResponseEntity.created(location).build();    //assigns the URI,
                                                            //returns a response entity and the created
                                                            //user as a Response
    }

}