package com.in28minutes.rest.webservices.restfulwebservices.aop;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void performTask() {
        System.out.println("Performing a task in MyService.");
        // enable it if you want to enable
       /* try {
            Thread.currentThread().wait(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }

    public String getMessage(String name) {
        return "Hello, " + name;
    }
}

