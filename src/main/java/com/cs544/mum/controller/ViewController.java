package com.cs544.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Commiting 
@Controller
public class ViewController {
	@RequestMapping("/")
	public String goToHomePage() {
		return "home";
	}

}
