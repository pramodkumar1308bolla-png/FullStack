package com.Jspiders.Employee.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
	indexes= {
			@Index(name="id_dob",columnList="dob")
	}
)
public class Employee {
	@Id
	String eid;
	@Column(nullable = false)
	String ename;
	String deptName;
	double sal;
	@Column(unique = true)
	String email;
	@Column(nullable = false,unique = true)
	long phno;
	String designation;
	@Column(nullable = false)
	LocalDate dob;
	int age;
	@ElementCollection
	List<String>skills;
	

}
