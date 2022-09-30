package com.example.ct360JavaModule.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.logging.Logger;

@Aspect
@Configuration
public class AspectConfig {

    private Logger logger = Logger.getLogger(AspectConfig.class.getName());

    @Before(value = "execution(* com.example.ct360JavaModule.controllers.SimpleController.*(..))")
    public void logStatementBefore(JoinPoint joinPoint){
        logger.info("Executing:" + joinPoint); //+ "; Args:" + joinPoint.getArgs().toString() + "; Target:" + joinPoint.getTarget().toString());
    }

    @After(value = "execution(* com.example.ct360JavaModule.controllers.SimpleController.*(..))")
    public void logStatementAfter(JoinPoint joinPoint){
        logger.info("Executing:" + joinPoint); //+ "; Args:" + joinPoint.getArgs().toString() + "; Target:" + joinPoint.getTarget().toString());
    }

    @Around(value = "execution(* com.example.ct360JavaModule.controllers.SimpleController.*(..))")
    public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable{

        long startTime = System.currentTimeMillis();

        try{
            Object obj = joinPoint.proceed();
            long endTime = System.currentTimeMillis() - startTime;
            logger.info("Time taken by: " + joinPoint + " is :" + endTime + " millis.");
            return obj;
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }
        return null;
    }
}
