package com.cs544.mum.repository;

import org.springframework.data.repository.CrudRepository;

import com.cs544.mum.domain.Student;

public interface StudentRepository extends CrudRepository<Student, String> {

}
