package com.ajn.rest.webservices.restfulwebservices.versioning.Controller;

import com.ajn.rest.webservices.restfulwebservices.versioning.Bean.Name;
import com.ajn.rest.webservices.restfulwebservices.versioning.Bean.PersonV1;
import com.ajn.rest.webservices.restfulwebservices.versioning.Bean.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class versioningController {

    // ======= versioning via URI ===========

    @GetMapping("v1/version-name")
    public PersonV1 personV1(){
        return new PersonV1("Abhishek J");
    }

    @GetMapping("v2/version-name")
    public PersonV2 personV2(){
        return  new PersonV2(new Name("Abhishek","Jagannath"));
    }

    // ======= versioning via params ===========

    @GetMapping(value = "version-name/versionType", params = "version1")
    public PersonV1 personParamsV1(){
        return new PersonV1("Abhishek J (params)");
    }

    @GetMapping(value = "version-name/versionType", params = "version2")
    public PersonV2 personParamsV2(){
        return new PersonV2(new Name("Abhishek","Jagannath (Param)"));
    }


    // ======= versioning via headers ===========

    @GetMapping(value = "version-name/headerType", headers = "header1")
    public PersonV1 personHeaderV1(){
        return new PersonV1("Abhishek J (Header)");
    }

    @GetMapping(value = "version-name/headerType", headers = "header2")
    public PersonV2 personHeaderV2(){
        return new PersonV2(new Name("Abhishek","Jagannath (Header)"));
    }


    // ======= versioning via producers (Content negotiation) ===========

    @GetMapping(value = "version-name/producerType", produces = "application/vnd.company.app-v1+json")
    public PersonV1 personProducerV1(){
        return new PersonV1("Abhishek J (Producer)");
    }

    @GetMapping(value = "version-name/producerType", produces = "application/vnd.company.app-v2+json")
    public PersonV2 personProducerV2(){
        return new PersonV2(new Name("Abhishek","Jagannath (Producer)"));
    }


}


