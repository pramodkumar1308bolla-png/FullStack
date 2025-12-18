package com.Jspiders.Employee.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeDto {
	

	@NotBlank(message = "Ename Cannot be Empty.....!!!")
	String ename;
	@Pattern(regexp="AMZ-.*",message = "Dept Name Should Starts From AMZ....!!!")
	String deptName;
	double sal;
	@Email(message = "Please provide standard email...!!!!")

	String email;
	
	long phno;
	String designation;

	LocalDate dob;
	int age;
	@NotEmpty(message = "Atleast One Skill Should be Provide...!!")
	List<String>skills;

}
