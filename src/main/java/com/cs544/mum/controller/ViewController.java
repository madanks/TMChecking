package com.cs544.mum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs544.mum.domain.User;
import com.cs544.mum.util.SecurityUtil;

@Controller
public class ViewController {
	@RequestMapping("/")
	public String goToHomePage() {

		return "login";
	}

	@RequestMapping("/login")
	public String goToLoginPage() {
		return "login";
	}

	@RequestMapping("/home")
	public String goHomePage() {
		String user = SecurityUtil.getUsername();
		if (user.equals("")) {

			return "redirect:/";
		} else {
			return "home";
		}

	}

	@RequestMapping(value = "/error-login", method = RequestMethod.GET)
	public String invalidLogin(Model model) {
		model.addAttribute("error", true);
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	protected String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";

	}

}
