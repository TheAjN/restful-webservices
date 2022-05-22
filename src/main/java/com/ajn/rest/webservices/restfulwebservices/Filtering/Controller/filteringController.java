package com.ajn.rest.webservices.restfulwebservices.Filtering.Controller;

import com.ajn.rest.webservices.restfulwebservices.Filtering.Bean.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class filteringController {

    //========= Dynamic Filtering ===========//

    //response - val1, val2 (filter out val3)
    @GetMapping("/filtering")
    public MappingJacksonValue getSomeBean(){
        //return new SomeBean("value1","value2","value3");

        SomeBean someBean = new SomeBean("value1","value2","value3");

        //Creating a filter
        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                SimpleBeanPropertyFilter.filterOutAllExcept("val1","val2");

        //Setting the filter name and adding the filter/s
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBeanFilter",simpleBeanPropertyFilter);

        //Mapping filter/s with the Bean object
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    //Filter val1
    @GetMapping("/filtering-list")
    public MappingJacksonValue getListBean(){
        //return Arrays.asList(new SomeBean("value21","value44","value56"),new SomeBean("value33","value34","value76"));

        List<SomeBean> someBeanList =
                Arrays.asList(new SomeBean("value21","value44","value56"),new SomeBean("value33","value34","value76"));

        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                SimpleBeanPropertyFilter.filterOutAllExcept("val2","val3");

        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBeanFilter",simpleBeanPropertyFilter);




        MappingJacksonValue mappingJacksonValueList = new MappingJacksonValue(someBeanList);

        mappingJacksonValueList.setFilters(filters);

        return  mappingJacksonValueList;
    }
}
