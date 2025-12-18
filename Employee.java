package com.jspiders.onetoOne.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String department;

	// Bidirectional mapping
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private EmployeeDetails details;

	public Employee() {
		
	}

	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public EmployeeDetails getDetails() {
		return details;
	}

	public void setDetails(EmployeeDetails details) {
		this.details = details;
		details.setEmployee(this);
	}

//	public void setDetails(EmployeeDetails details2) {
		// TODO Auto-generated method stub
		
//	}
}
