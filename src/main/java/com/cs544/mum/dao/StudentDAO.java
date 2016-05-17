package com.cs544.mum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs544.mum.domain.Appointment;
import com.cs544.mum.domain.Student;

public interface StudentDAO extends JpaRepository<Student, String> {

}
