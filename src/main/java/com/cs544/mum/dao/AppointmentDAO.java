package com.cs544.mum.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.mum.domain.Appointment;
@Repository
@Transactional
public interface AppointmentDAO extends JpaRepository<Appointment, Long> {

	public List<Appointment> findBybookedDate(Date d);
}
