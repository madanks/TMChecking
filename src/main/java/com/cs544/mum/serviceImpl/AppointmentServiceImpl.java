package com.cs544.mum.serviceImpl;

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
import com.cs544.mum.domain.Appointment;
import com.cs544.mum.repository.AppointmentRepository;
import com.cs544.mum.service.AppointmentService;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentRepository appointmentrepo;

	@Autowired
	private AppointmentDAO appointmentdao;

	public void save(Appointment appointment) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date = simpleDateFormat.parse(appointment.getTempdate());
		appointment.setDate(date);
		appointment.setCreatedDate(new Date());
		appointmentrepo.save(appointment);
	}

	public Appointment findOne(Long id) {
		return appointmentrepo.findOne(id);
	}

	public void delete(Appointment appointment) {
		appointmentrepo.delete(appointment);

	}

	public List<Appointment> findAvailableAppointment() {
		Date start = new Date();
		List<Appointment> a = appointmentdao.findBydateBetween(start, addDays(start, 7));
		return a;
	}

	public Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		System.out.println(cal.getTime());
		return cal.getTime();
	}
}
