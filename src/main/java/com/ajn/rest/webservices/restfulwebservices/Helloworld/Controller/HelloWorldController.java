package com.ajn.rest.webservices.restfulwebservices.Helloworld.Controller;

import com.ajn.rest.webservices.restfulwebservices.Helloworld.Bean.helloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController //A controller that can handle REst requests
public class HelloWorldController {

    //@RequestMapping(path = "/hello-world", method = RequestMethod.GET)
    @GetMapping(path = "/helloworld")
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

    //the {name} inside the curly brackets should match the variable as provided in the parameter
    //value of {name} must be provided in the url, since there is no response created for "/hello-world-bean/path-variable"
    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public helloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new helloWorldBean(String.format("Hello World, %s",name));
    }

}
