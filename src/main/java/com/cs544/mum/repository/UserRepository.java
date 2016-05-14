package com.cs544.mum.repository;

import org.springframework.data.repository.CrudRepository;

import com.cs544.mum.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

}
