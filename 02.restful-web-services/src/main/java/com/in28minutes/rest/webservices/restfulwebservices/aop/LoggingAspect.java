package com.in28minutes.rest.webservices.restfulwebservices.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

///*
/// Advices
//Before Advice	@Before	Runs before the method executes
//After Advice	@After	Runs after the method finishes (even if exception occurs)
//After Returning	@AfterReturning	Runs after method returns successfully
//After Throwing	@AfterThrowing	Runs if method throws exception
//Around Advice	@Around	Surrounds method; controls execution
//*/
     /*Aspect :Aspect is class where you define cross cutting concern (Advice) and pointcuts

        Advice : crosscutting concern implementation
        JoinPoint : Points in java program where you apply crosscutting concern (advice) eg: method,field,constructor. Only Method level Joinpoint are supported by java
        PointCut : define regular expression which identify places where advice will apply to join point.( expression language to express the join point.*/



@Aspect
@Component
public class LoggingAspect {

    Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(PointcutConstants.BEFORE_POINTCUT)
    public void serviceLayer() {}

    @Before("serviceLayer()") // Pointcut expression
    public void logBeforeMethod(JoinPoint joinPoint) {
       // this is advice what to do
        logger.info("Method " + joinPoint.getSignature().getName() + " is about to be called.");
    }

    // This will log after a method is executed
    // execution()-define pointcut
    //  * anyreturntype
    // com.example.demo.service.* -package name any class
    //.* any method
    // (..)parameter
    //* com.example.demo.service.*.*(..))
    @After("execution(* com.in28minutes.rest.webservices.restfulwebservices.aop.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        logger.info("Method " + joinPoint.getSignature().getName() + " has been called.");
    }
    @Around("execution(* com.in28minutes.rest.webservices.restfulwebservices.aop.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // proceed with the method execution

        long end = System.currentTimeMillis();

        System.out.println("Executed method: " + joinPoint.getSignature());
        System.out.println("Execution time: " + (end - start) + " ms");

        return result;
    }

    @AfterReturning(
            pointcut = "execution(* com.in28minutes.rest.webservices.restfulwebservices.aop.*.*(..))",
            returning = "result"
    )
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        System.out.println("Returned: " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.in28minutes.rest.webservices.restfulwebservices.aop.*.*(..))",
            throwing = "ex"
    )
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Exception: " + ex.getMessage());
    }
}
