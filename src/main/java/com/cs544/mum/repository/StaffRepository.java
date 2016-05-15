package com.cs544.mum.repository;

import org.springframework.data.repository.CrudRepository;

import com.cs544.mum.domain.Staff;

public interface StaffRepository extends CrudRepository<Staff, String> {

}
