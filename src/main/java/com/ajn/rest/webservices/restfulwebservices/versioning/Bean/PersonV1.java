package com.ajn.rest.webservices.restfulwebservices.versioning.Bean;

public class PersonV1 {

    public String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
