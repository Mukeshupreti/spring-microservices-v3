package com.in28minutes.rest.webservices.restfulwebservices.aop;

public class PointcutConstants {

    // execution()-define pointcut
    //  * anyreturntype
    // com.example.demo.service.* -package name any class
    //.* any method
    // (..)parameter
    //* com.example.demo.service.*.*(..))
    public static final String BEFORE_POINTCUT ="execution(* com.in28minutes.rest.webservices.restfulwebservices.aop.*.*(..))";
}
