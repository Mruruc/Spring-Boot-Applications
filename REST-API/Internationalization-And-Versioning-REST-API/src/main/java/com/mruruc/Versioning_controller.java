package com.mruruc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Versioning_controller {

    /**
     *
     * URI Versioning.
     */
    @GetMapping("/v1/person")
    public Person getFirstVersionOfPerson(){
        return new Person("John Doe");
    }
    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("John","Doe"));
    }

    /**
     *
     *Request Parameter Versioning.
     */

    @GetMapping(value = "/v1/person",params="version1")
    public Person getFirstVersionOfPersonRequestParameter(){
        return new Person("John Doe");
    }
    @GetMapping(value = "/v2/person",params ="version2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("John","Doe"));
    }

    /**
     * (Custom) Headers Versioning.
     */

    @GetMapping(value = "/v1/person/header",headers = "X-API-VERSION=1")
    public Person getFirstVersionOfPersonHeaderVersioning(){
        return new Person("John Doe");
    }
    @GetMapping(value = "/v2/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonHeaderVersioning(){
        return new PersonV2(new Name("John","Doe"));
    }
}
record Person(String name){}
record PersonV2(Name name){}
record Name(String first_Name,String last_Name){}
