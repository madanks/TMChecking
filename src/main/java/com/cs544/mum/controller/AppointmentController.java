package com.cs544.mum.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs544.mum.dao.AppointmentDAO;
import com.cs544.mum.domain.Appointment;
import com.cs544.mum.domain.AppointmentType;
import com.cs544.mum.domain.Student;
import com.cs544.mum.domain.User;
import com.cs544.mum.repository.AppointmentRepository;
import com.cs544.mum.repository.StudentRepository;
import com.cs544.mum.service.AppointmentService;
import com.cs544.mum.service.StudentService;
import com.cs544.mum.util.SecurityUtil;

@Controller
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private StudentService studentService;

	private Date d = new Date();

	@RequestMapping(value = "/staff/addappointment", method = RequestMethod.GET)
	public String addAppointmentGet(Model model) {
		model.addAttribute("type", AppointmentType.values());
		model.addAttribute("appoinment", new Appointment());
		return "addAppointments";
	}

	@RequestMapping(value = "/staff/addappointment", method = RequestMethod.POST)
	public String addAppointment(Appointment appointment, BindingResult result) throws ParseException {

		if (result.hasErrors()) {
			return "redirect:/staff/addappointment";
		}
		try {
			appointmentService.save(appointment);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return "redirect:/staff/addappointment";
	}

	@RequestMapping(value = "/student/availableappointment", method = RequestMethod.GET)
	public String availableAppointment(Model model) {
		model.addAttribute("appointment", appointmentService.findAvailableAppointment());
		model.addAttribute("count", count());
		return "availableAppointments";
	}

	@RequestMapping(value = "/staff/todayslist", method = RequestMethod.GET)
	public String todayslist(Model model) {
		model.addAttribute("list", appointmentService.findTodayAppointment());
		return "listtoday";
	}

	@RequestMapping(value = "/staff/weekelylist", method = RequestMethod.GET)
	public String weekelylist(Model model) {
		model.addAttribute("list", appointmentService.findWeekelyAppointment());
		return "listweekely";
	}

	@RequestMapping(value = "/approve/{username}", method = RequestMethod.GET)
	public String getApproved(@PathVariable String username) {
		appointmentService.approve(username);
		return "redirect:/staff/todayslist";
	}

	@RequestMapping(value = "/selectappointment/{id}", method = RequestMethod.GET)
	public String getSelect(@PathVariable long id) {
		studentService.ChooseAppointment(id);
		return "redirect:/student/availableappointment";
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String getRemove(@PathVariable long id) {
		studentService.removeAppointment(id);
		return "redirect:/student/selectedappointment";
	}

	@RequestMapping(value = "/student/selectedappointment", method = RequestMethod.GET)
	public String selectedAppointment(Model model) {
		model.addAttribute("count", count());
		model.addAttribute("appointment", appointmentService.findSelectedAppointment());
		return "selectedappointments";
	}

	@RequestMapping("*")
	public String pageNotFound() {
		return "pagenotfound";
	}

	public int count() {
		return studentService.findCount();
	}
}
