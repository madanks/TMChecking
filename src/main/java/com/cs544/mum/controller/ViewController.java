package com.cs544.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Commiting 
@Controller
public class ViewController {
	@RequestMapping("/")
	public String goToHomePage() {
		return "test";
	}
	@RequestMapping("/test")
	public String goToHomePag() {
		return "test";
	}

	@RequestMapping(value="/admin/home" , method = RequestMethod.GET)
	public String  privateHome ()
	{
		return "home" ; 
	}
	 
}
