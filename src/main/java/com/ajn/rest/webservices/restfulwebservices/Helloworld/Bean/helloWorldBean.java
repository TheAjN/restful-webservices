package com.ajn.rest.webservices.restfulwebservices.Helloworld.Bean;


public class helloWorldBean {
    private String message;

    public helloWorldBean(String message) {
        this.message = message;
    }

    //Getter is very crucial, since without the getter, automatic conversion of response won't work
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "helloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
