package com.vamsite.codebucket.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {
	
	@Before("execution(public void com.vamsite.codebucket.aop.service.*.*(*))")
	public void beforeMethod(JoinPoint joinPoint) {
		
		System.out.println("Logging before method execution");
	}

}
