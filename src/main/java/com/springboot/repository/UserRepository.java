package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.User;

public interface UserRepository extends CrudRepository<User, String>{

	


}
