package com.cs544.mum.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs544.mum.domain.Appointment;

public interface AppointmentDAO extends JpaRepository<Appointment, Long> {

	public List<Appointment> findBybookedDate(Date d);
}
