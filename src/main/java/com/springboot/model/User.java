package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")    //Table name from database
public class User {

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "gender")
	private String gender;

	public User() {
		super();
	}

	public User(String first_name, String last_name, String email, String password,  String gender) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
