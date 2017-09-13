package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.User;
import com.springboot.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/getUserOne", method = RequestMethod.GET)
	public User UserOne() {
		Optional<User> u = userRepository.findById("madhu@gmail.com");
		if (u.isPresent()) {
			return u.get();
		} else {
			return (new User());
		}
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		Iterable<User> temp = userRepository.findAll();
		for (User u : temp) {
			allUsers.add(u);
		}
		return allUsers;
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public User UserSpecifiedOne(@PathVariable("id") String id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {
			return (new User());
		}
	}

	// localhost:8080/addUser?fname=madhu&lname=goli
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public List<User> addNewUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname,
			@RequestParam("email") String email, @RequestParam("pswd") String pswd,
			@RequestParam("gender") String gender) {
		userRepository.save(new User(fname, lname, email, pswd, gender));

		List<User> allUsers = new ArrayList<User>();

		Iterable<User> temp = userRepository.findAll();

		for (User u : temp) {
			allUsers.add(u);
		}
		return allUsers;

	}

}
