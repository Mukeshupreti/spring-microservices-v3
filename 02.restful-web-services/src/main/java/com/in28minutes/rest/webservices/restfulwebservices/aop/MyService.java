package com.in28minutes.rest.webservices.restfulwebservices.aop;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void performTask() {
        System.out.println("Performing a task in MyService.");
    }

    public String getMessage(String name) {
        return "Hello, " + name;
    }
}

