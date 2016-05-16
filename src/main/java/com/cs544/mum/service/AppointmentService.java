package com.cs544.mum.service;

import java.text.ParseException;
import java.util.List;

import com.cs544.mum.domain.Appointment;

public interface AppointmentService {

	public void save(Appointment appointment) throws ParseException;

	public Appointment findOne(Long id);

	public void delete(Appointment appointment);

	public List<Appointment> findAvailableAppointment();

}
