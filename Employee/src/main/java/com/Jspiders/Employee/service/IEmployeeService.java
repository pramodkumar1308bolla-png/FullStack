package com.Jspiders.Employee.service;

import java.util.List;

import com.Jspiders.Employee.dto.EmployeeDto;
import com.Jspiders.Employee.dto.ResponseDto;
import com.Jspiders.Employee.entity.Employee;

import jakarta.validation.Valid;

public interface IEmployeeService {
	ResponseDto<Employee> addEmployee(@Valid EmployeeDto e);

	ResponseDto<Employee> getEmpById(String id);

	List<Employee> viewAllEmployees();

	Employee viewEmployee(String id);

	ResponseDto<Employee> updateEmployee(Employee e);

	String deleteEmployee(String id);
}