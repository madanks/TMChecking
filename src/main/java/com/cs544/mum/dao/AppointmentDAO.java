package com.cs544.mum.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs544.mum.domain.Appointment;
import com.cs544.mum.domain.Student;

public interface AppointmentDAO extends JpaRepository<Appointment, Long> {

	@Query("select a from Appointment a join a.studentList s where  a.date=:d")
	public List<Appointment> findBydate(@Param("d") Date d);

	@Query("select a from Appointment a join a.studentList s where  a.date between :start and :end")
	public List<Appointment> findByWeek(@Param("start") Date start, @Param("end") Date end);

	@Query("select a from Appointment a where a.total>a.enrolled and DATE_FORMAT(a.date, '%Y-%m-%d') between :start and :end And a.id NOT IN(Select a.id from Appointment a join a.studentList s where s.userName=:username)")
	public List<Appointment> findBydateBetween(@Param("username") String student, @Param("start") String start,
			@Param("end") String end);

	@Query("select s from Appointment a join a.studentList s where DATE_FORMAT(a.date, '%Y-%m-%d') =:date and a.completed=false")
	public List<Student> findTodaysAppointment(@Param("date") String date);

	@Query("select s from Appointment a join a.studentList s where a.completed=false and DATE_FORMAT(a.date, '%Y-%m-%d') between :start AND :end")
	public List<Student> findWeeklyAppointment(@Param("start") String start, @Param("end") String end);

	@Query("select a from Appointment a join a.studentList s where a.completed=false and DATE_FORMAT(a.date, '%Y-%m-%d')>=:date and s.userName=:username")
	public List<Appointment> findselectedAppointment(@Param("date") String date, @Param("username") String username);
}
