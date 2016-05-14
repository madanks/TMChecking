package com.cs544.mum.service;

import java.util.List;

import com.cs544.mum.domain.Appointment;

public interface AppointmentService {

	public void save(Appointment appointment);

	public Appointment findOne(Long id);

	public void delete(Appointment appointment);

}
