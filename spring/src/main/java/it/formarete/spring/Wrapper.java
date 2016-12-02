package it.formarete.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Wrapper {

	@Before("execution(* it.formarete.spring.Spring.getForce(..))")
	public void beforeGetForce(JoinPoint joinPoint) {
		System.out.println("Calculating force...");
	}

	@AfterReturning(pointcut = "execution(* it.formarete.spring.Spring.getForce(..))", returning = "result")
	public void afterReturningForce(JoinPoint joinPoint, Object result) {
		System.out.println("Force calculated, value was " + result);
	}
}
