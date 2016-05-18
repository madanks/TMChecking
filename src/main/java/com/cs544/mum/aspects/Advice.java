package com.cs544.mum.aspects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.cs544.mum.domain.Student;
import com.cs544.mum.service.StudentService;
import com.cs544.mum.util.CommonConstant;
import com.cs544.mum.util.Email;
import com.cs544.mum.util.EmailSender;

@Aspect
public class Advice {
	private static final Logger log = Logger.getLogger(Advice.class);

	@Autowired
	EmailSender emailSender;

	@Autowired
	StudentService studentservice;

	@AfterReturning(pointcut = "execution(* com.cs544.mum.controller.AppointmentController.getApproved(..)) && args (username))")
	public void traceAfterMethod(JoinPoint joinPoint, String username) {
		log.info("Inside Aspect now going to send send email to user");
		Student s = studentservice.findStudent(username);
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date dat = new Date();
		Email email = new Email();
		email.setSubject("TM Checking Approved");
		email.setMessage(String.format(CommonConstant.SIGN_UP_MESSAGE, date.format(dat), s.getCount()));
		email.setTo(CommonConstant.EMAIL_TO);
		email.setFrom(CommonConstant.EMAIL_FROM);
		emailSender.sendMail(email);
	}
}
