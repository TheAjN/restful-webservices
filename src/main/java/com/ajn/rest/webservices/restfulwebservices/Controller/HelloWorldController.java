package com.ajn.rest.webservices.restfulwebservices.Controller;

import com.ajn.rest.webservices.restfulwebservices.Bean.helloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //A controller that can handle REst requests
public class HelloWorldController {

    //@RequestMapping(path = "/hello-world", method = RequestMethod.GET)
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

    //Getters for hellowWorldBean is very crucial,
    // since without the getter, automatic conversion of response won't work

    //return a json structure o/p in the webpage
    @GetMapping(path="/hello-world-bean")
    public helloWorldBean helloWorldBean(){
        return new helloWorldBean("Hello World");
    }
}
