package com.cs544.mum.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.mum.domain.Appointment;
import com.cs544.mum.repository.AppointmentRepository;
import com.cs544.mum.service.AppointmentService;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentRepository appointmentrepo;

	public void save(Appointment appointment) {
		appointmentrepo.save(appointment);

	}

	public Appointment findOne(Long id) {
		return appointmentrepo.findOne(id);
	}

	public void delete(Appointment appointment) {
		appointmentrepo.delete(appointment);

	}

}
