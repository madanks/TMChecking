package com.cs544.mum.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs544.mum.domain.Appointment;

public interface AppointmentDAO extends JpaRepository<Appointment, Long> {

	@Query("select a from Appointment a join a.studentList s where  a.date=:d")
	public List<Appointment> findBydate(@Param("d") Date d);

	@Query("select a from Appointment a join a.studentList s where  a.date between :start and :end")
	public List<Appointment> findByWeek(@Param("start") Date start, @Param("end") Date end);

	public List<Appointment> findBydateBetween( Date start, Date end);
}
