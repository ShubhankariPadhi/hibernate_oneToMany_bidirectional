package com.sbits.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // added to get the  auto increment ids but as the table contains manual id so increment id will override the value providing through object  
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="email")
	private String email;
	
public Student() {
	
}

public Student(int id, String fname, String lname, String email) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.email = email;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getEmail() {
	return email;
}

@Override
public String toString() {
	return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
}

public void setEmail(String email) {
	this.email = email;
}

}
