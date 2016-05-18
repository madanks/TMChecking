package com.cs544.mum.service;

import com.cs544.mum.domain.Student;

public interface StudentService {

	public void ChooseAppointment(long id);

	public void removeAppointment(long id);

	public int findCount();

	public Student findStudent(String username);

}
