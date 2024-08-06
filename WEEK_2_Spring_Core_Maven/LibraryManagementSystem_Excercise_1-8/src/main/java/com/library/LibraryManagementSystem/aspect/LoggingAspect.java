package com.library.LibraryManagementSystem.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


//@Aspect and @Component annotation added as part of Excercise 8 
@Aspect
@Component
public class LoggingAspect {
	
	//Before annotation and logBefore() method added as part of Excercise 8
	@Before("execution(* com.library.LibraryManagementSystem.service.BookService.*(..))")
    public void logBefore() {
        System.out.println("LoggingAspect: Before method execution");
    }
	//After annotation and logAfter() method added as part of Excercise 8
    @After("execution(* com.library.LibraryManagementSystem.service.BookService.*(..))")
    public void logAfter() {
        System.out.println("LoggingAspect: After method execution");
    }
	//logExecution method added as part of Excercise 3
	@Around("execution(* com.library.LibraryManagementSystem.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
