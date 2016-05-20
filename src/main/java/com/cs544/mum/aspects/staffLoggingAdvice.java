package com.cs544.mum.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.cs544.mum.logging.ILogger;

@Aspect
public class staffLoggingAdvice {
	private ILogger logger;

	public staffLoggingAdvice(ILogger logger) {
		this.logger = logger;
	}

	@AfterReturning("execution(* com.cs544.mum.controller.AppointmentController.addAppointment(..))")
	public void log(JoinPoint joinpoint) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		logger.log(" Staff " + name + " has created an appointment:");
	}


}
