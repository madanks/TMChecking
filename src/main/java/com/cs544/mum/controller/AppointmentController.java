package com.cs544.mum.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs544.mum.dao.AppointmentDAO;
import com.cs544.mum.domain.Appointment;
import com.cs544.mum.domain.AppointmentType;
import com.cs544.mum.service.AppointmentService;

@Controller
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentDAO appointmentdao;

	@RequestMapping("/staff/addAppointment")
	public String addAppointment() {
		Appointment app = new Appointment();
		app.setBookedDate(new Date());
		app.setBuildingName("Varril");
		app.setCreatedDate(new Date());
		app.setDate(new Date());
		app.setType(AppointmentType.GROUP);
		appointmentService.save(app);

		return "redirect:/";
	}
	@RequestMapping("/staff/appointmentToday")
	private String appointmentToday() {
		List<Appointment> am = appointmentdao.findBybookedDate(new Date());
		for(Appointment app:am){
			System.out.println(app.getCreatedDate());
		}
	
		return "redirect:/";
	}

}
