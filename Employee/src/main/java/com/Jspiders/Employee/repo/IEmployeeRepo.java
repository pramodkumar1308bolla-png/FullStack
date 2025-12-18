package com.Jspiders.Employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jspiders.Employee.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, String>{

}
