package com.ajn.rest.webservices.restfulwebservices.Filtering.Bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
//@JsonIgnoreProperties(value={"val1","val2"}) //Ignores fields val1 & val2 in the response (Static filtering)
@JsonFilter("SomeBeanFilter")  //This annotation must be mentioned when using dynamic filtering
public class SomeBean {

    private String val1;

  //  @JsonIgnore
    private String val2;

 //   @JsonIgnore     //Ignores this field when the object of this class is sent as a response
    private String val3;

}
