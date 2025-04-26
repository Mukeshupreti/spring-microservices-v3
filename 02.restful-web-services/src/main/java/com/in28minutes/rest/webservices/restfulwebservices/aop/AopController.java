package com.in28minutes.rest.webservices.restfulwebservices.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
    @Autowired
    MyService myService;
    @GetMapping("/run")
    public String runService(){
        myService.performTask();
        return "run success";
    }
}
