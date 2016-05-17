package com.cs544.mum.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.mum.dao.AppointmentDAO;
import com.cs544.mum.dao.StudentDAO;
import com.cs544.mum.domain.Appointment;
import com.cs544.mum.domain.Student;
import com.cs544.mum.service.StudentService;
import com.cs544.mum.util.SecurityUtil;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private AppointmentDAO appointmentdao;

	public void ChooseAppointment(long id) {
		Appointment appo = appointmentdao.findOne(id);
		int e = appo.getEnrolled();
		appo.setEnrolled(e + 1);
		Student student = studentDAO.findOne(SecurityUtil.getUsername());
		student.setAppointmentList(appo);
		studentDAO.save(student);

	}

	public void removeAppointment(long id) {
		Appointment appo = appointmentdao.findOne(id);
		Student student = studentDAO.findOne("bimal");
		int e = appo.getEnrolled();
		appo.setEnrolled(e - 1);
		for (Student s : appo.getStudentList()) {
			appo.removeStudent(s);
			;
		}

		appointmentdao.save(appo);

		System.out.println("check");
	}
}
