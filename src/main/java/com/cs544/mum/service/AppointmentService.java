package com.cs544.mum.service;

import java.text.ParseException;
import java.util.List;

import com.cs544.mum.domain.Appointment;
import com.cs544.mum.domain.Student;

public interface AppointmentService {

	public void save(Appointment appointment) throws ParseException;

	public Appointment findOne(Long id);

	public void delete(Appointment appointment);

	public List<Appointment> findAvailableAppointment();

	public List<Student> findTodayAppointment();

	public List<Student> findWeekelyAppointment();

	public void approve(String username);

	public List<Appointment> findSelectedAppointment();

}
