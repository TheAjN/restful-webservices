package com.ajn.rest.webservices.restfulwebservices.User.Controller;


import com.ajn.rest.webservices.restfulwebservices.User.Bean.Post;
import com.ajn.rest.webservices.restfulwebservices.User.Bean.User;
import com.ajn.rest.webservices.restfulwebservices.User.Exception.noUserNameException;
import com.ajn.rest.webservices.restfulwebservices.User.Exception.userNotFoundException;
import com.ajn.rest.webservices.restfulwebservices.User.Repository.UserRepository;
import com.ajn.rest.webservices.restfulwebservices.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class UserResourceJPAController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //retrieve All Users
    @GetMapping("jpa/users")
    public List<User> retrieveAllUsers() {

        if(userService.findAll().isEmpty()){
            throw new userNotFoundException("NO Users added");
        }
        //   throw new handleAllExceptions();
        return userRepository.findAll(); //findAll() method is from the JpaRepository interface
    }

    //retrieve a user
    @GetMapping("jpa/users/{id}")
    public EntityModel<User> retrieveAUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        // Why Optional<> ?
        //Because if the Id does not exist, findById() is still going to return a proper object(empty object)
        // rather than returning null, which in turn prevent a null pointer exception


        if (user.isEmpty()) {
            throw new userNotFoundException("id - " + id);
        }

        //-------------  HATEOAS Framework -----------------//

        //Creating an EntityModel which is also compatible with links
        EntityModel <User> userEntityModel = EntityModel.of(user.get());

        //Creating a link to all users
        WebMvcLinkBuilder linkToAllUsers =
               WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        //adding the link to the model
        userEntityModel.add(linkToAllUsers.withRel("all-users"));

        //returning the object as type EntityModel
        return userEntityModel;
    }

    //Delete a user
    @DeleteMapping("jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
     //   User user = userService.deleteById(id);
        if (userRepository.findById(id).isEmpty()) {
            throw new userNotFoundException("id - " + id);
        }

        userRepository.deleteById(id);
    }


    //Create a user
    //input - details of a user
    //output - display the created user(return the created URI)
    @PostMapping("jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        //@RequestBody maps the request from the webpage to
        //the User object
        User savedUser = userRepository.save(user);

        if(savedUser.getName() == null || savedUser.getName().equals("") ){
            throw new noUserNameException("NO User name provided");
        }

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

    //gets all the posts from a single user
    @GetMapping("jpa/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable int id) {

        return userRepository.getById(id).getPostService().getAllPosts();
    }

    //gets a particular post from a single user
    @GetMapping("jpa/users/{id}/posts/{post_id}")
    public Post getUserPost(@PathVariable int id, @PathVariable int post_id) {

        return userRepository.getById(id).getPostService().getPost(id);
    }

    //create a post for a user
    @PostMapping("jpa/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post) {
        Post savedPost = userRepository.findById(id).isPresent() ? userRepository.findById(id)
                .get().getPostService().savePost(post) : new Post();

        URI locationPost = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{post_id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(locationPost).build();
    }

}
