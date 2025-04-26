package com.in28minutes.rest.webservices.restfulwebservices.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    Logger logger= LoggerFactory.getLogger(LoggingAspect.class);
   // execution()-define pointcut
  //  * anyreturntype
   // com.example.demo.service.* -package name any class
    //.* any method
    // (..)parameter
   //* com.example.demo.service.*.*(..))
    @Before("execution(* com.in28minutes.rest.webservices.restfulwebservices.aop.*.*(..))") // Pointcut expression
    public void logBeforeMethod(JoinPoint joinPoint) {
       // this is advice what to do
        logger.info("Method " + joinPoint.getSignature().getName() + " is about to be called.");
    }

    // This will log after a method is executed
    @After("execution(* com.in28minutes.rest.webservices.restfulwebservices.aop.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        logger.info("Method " + joinPoint.getSignature().getName() + " has been called.");
    }
}
