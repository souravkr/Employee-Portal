package com.trickspy.thymeleafsecond.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {



	public Employee() {
		super();
	}

	public Employee(String lastName, String firstName, int id, String email) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="last_name")
	String lastName;
	
	@Column(name="first_name")
	String firstName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="email")
	String email;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee( String firstName,String lastName, int id) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [lastName=" + lastName + ", firstName=" + firstName + ", id=" + id + "]";
	}
	
	
}
