package com.ajn.rest.webservices.restfulwebservices.Helloworld.Controller;

import com.ajn.rest.webservices.restfulwebservices.Helloworld.Bean.helloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController //A controller that can handle REst requests
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;    //gets message from messages.properties file

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

    //---- i18n concept ----
//    @GetMapping(path = "/helloworldInternationalized")
//    public String helloWorldInternationalized(@RequestHeader(value = "Accept-language", required = false)
//                                                          Locale locale){
//
//
//        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
//    }

    // ============ i18n concept, but different approach ========

    @GetMapping(path = "/helloworldInternationalized")
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message",
                null,"Default Message", LocaleContextHolder.getLocale());
    }

}
