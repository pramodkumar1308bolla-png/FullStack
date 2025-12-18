package com.Jspiders.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Jspiders.Employee.dto.EmployeeDto;
import com.Jspiders.Employee.dto.ResponseDto;
import com.Jspiders.Employee.entity.Employee;
import com.Jspiders.Employee.service.IEmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService service;

	@PostMapping("saveEmp")
	ResponseEntity<ResponseDto<Employee>> addEmployee(@RequestBody @Valid EmployeeDto e) {
		return new ResponseEntity<ResponseDto<Employee>>(service.addEmployee(e), HttpStatus.ACCEPTED);
	}

	@GetMapping("/byId") 
	public ResponseEntity<ResponseDto<Employee>> getEmpById(@RequestParam String id) {
		return new ResponseEntity<ResponseDto<Employee>>(service.getEmpById(id), HttpStatus.FOUND);
	}

	@GetMapping("viewAll")
	List<Employee> viewAllEmployees() {
		return service.viewAllEmployees();
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Employee> viewEmployeeById(@PathVariable String id) {
		return new ResponseEntity<Employee>(service.viewEmployee(id), HttpStatus.FOUND);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDto<Employee>> updateEmployee(@RequestBody Employee e) {
		return new ResponseEntity<ResponseDto<Employee>>(service.updateEmployee(e), HttpStatus.CONTINUE);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
		return new ResponseEntity<String>(service.deleteEmployee(id), HttpStatus.GONE);
	}

}