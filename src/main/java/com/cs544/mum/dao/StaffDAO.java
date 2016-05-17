package com.cs544.mum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs544.mum.domain.Staff;

public interface StaffDAO extends JpaRepository<Staff, String> {

}
