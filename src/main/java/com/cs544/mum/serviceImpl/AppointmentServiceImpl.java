package com.cs544.mum.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.mum.dao.AppointmentDAO;
import com.cs544.mum.dao.StaffDAO;
import com.cs544.mum.dao.StudentDAO;
import com.cs544.mum.domain.Appointment;
import com.cs544.mum.domain.Staff;
import com.cs544.mum.domain.Student;
import com.cs544.mum.repository.AppointmentRepository;
import com.cs544.mum.service.AppointmentService;
import com.cs544.mum.util.SecurityUtil;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentRepository appointmentrepo;

	@Autowired
	private AppointmentDAO appointmentdao;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private StaffDAO staffDAO;

	public void save(Appointment appointment) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date = simpleDateFormat.parse(appointment.getTempdate());
		appointment.setDate(date);
		appointment.setCreatedDate(new Date());
		Staff s = staffDAO.findOne(SecurityUtil.getUsername());
		// appointment.setStaff(staff);
		appointment.setStaff(s);
		appointmentrepo.save(appointment);
	}

	public Appointment findOne(Long id) {
		return appointmentrepo.findOne(id);
	}

	public void delete(Appointment appointment) {
		appointmentrepo.delete(appointment);

	}

	public List<Appointment> findAvailableAppointment() {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date start = new Date();

		String s = date.format(start);
		String e = date.format(addDays(start, 7));
		String st = SecurityUtil.getUsername();
		List<Appointment> a = appointmentdao.findBydateBetween(st, s, e);
		return a;
	}

	public Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		// System.out.println(cal.getTime());
		return cal.getTime();
	}

	public List<Student> findTodayAppointment() {

		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		return appointmentdao.findTodaysAppointment(date.format(new Date()));

	}

	public List<Student> findWeekelyAppointment() {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date start = new Date();
		Date end = addDays(start, 7);
		return appointmentdao.findWeeklyAppointment(date.format(start), date.format(end));
	}

	public void approve(String username) {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Student s = studentDAO.findOne(username);
		
		
		for (Appointment app : s.getAppointmentList()) {
/*			System.out.println(date.format(d));
			System.out.println(date.format(app.getDate()));*/

			if (date.format(d).equals(date.format(app.getDate()))) {
				app.setCompleted(true);
				//appointmentdao.save(app);
				int count = s.getCount();
				s.setCount(count + 1);
				studentDAO.save(s);
			}
		}

	}

	public List<Appointment> findSelectedAppointment() {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date start = new Date();
		String username = SecurityUtil.getUsername();
		List<Appointment> a = appointmentdao.findselectedAppointment(date.format(start), username);
		return a;
	}
}
