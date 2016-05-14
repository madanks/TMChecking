package com.cs544.mum.repository;

import org.springframework.data.repository.CrudRepository;

import com.cs544.mum.domain.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
