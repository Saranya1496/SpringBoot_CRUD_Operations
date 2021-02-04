package com.springboot.crudrestfulwebservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//to convert the java class as employee entity
@Entity
@Table(name = "employees") 

public class Employee {
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.AUTO) //auto generate
	private long id;
	
	@Column(name="Fname")
	private String firstName;
	
	@Column(name="Lname")
	private String lastName;
	
	@Column(name="emailId")
	private String emailid;
	
	public Employee() {
		super();
	}
	public Employee(long id, String firstName, String lastName, String emailid) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	


}
