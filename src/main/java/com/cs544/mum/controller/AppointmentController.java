package com.cs544.mum.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs544.mum.dao.AppointmentDAO;
import com.cs544.mum.domain.Appointment;
import com.cs544.mum.domain.AppointmentType;
import com.cs544.mum.domain.Student;
import com.cs544.mum.repository.AppointmentRepository;
import com.cs544.mum.repository.StudentRepository;
import com.cs544.mum.service.AppointmentService;

@Controller
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private AppointmentDAO appointmentdao;
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private StudentRepository studentRepository;
	private Date d = new Date();

	@RequestMapping("/add")
	public String addAppointment() {
		Appointment app = new Appointment();
		app.setBookedDate(new Date());
		app.setBuildingName("Varril");
		app.setCreatedDate(new Date());
		app.setDate(d);
		app.setType(AppointmentType.GROUP);
		appointmentService.save(app);

		return "redirect:/";
	}

	@RequestMapping("/look")
	private String appointmentToday() {
		List<Appointment> am = appointmentdao.findBydate(d);
		for (Appointment a : am) {
			System.out.println(a.getDate());
		}
		Date end = new Date();
		end.setDate(d.getDate() + 7);
		System.out.println(d);
		System.out.println(end);
		List<Appointment> a = appointmentdao.findByWeek(d, end);
		for (Appointment amm : a) {
			System.out.println(amm.getDate());
		}

		return "redirect:/";
	}

	@RequestMapping("/approve")
	private String approveAppointment() {
		Student s = studentRepository.findOne("mmm");
		s.setCount(s.getCount() + 1);
		studentRepository.save(s);

		Appointment a = appointmentRepository.findOne(1L);
		a.setCompleted(true);
		appointmentRepository.save(a);
		return "redirect:/";
	}

}
