package com.Jspiders.Employee.serviceImp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Jspiders.Employee.Exception.IdNotFoundException;
import com.Jspiders.Employee.dto.EmployeeDto;
import com.Jspiders.Employee.dto.ResponseDto;
import com.Jspiders.Employee.entity.Employee;
import com.Jspiders.Employee.entity.IdGenerator;
import com.Jspiders.Employee.repo.IEmployeeRepo;
import com.Jspiders.Employee.repo.IdGeneratorRepo;
import com.Jspiders.Employee.service.IEmployeeService;

@Service
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	IEmployeeRepo repo;
	
	@Autowired
	IdGeneratorRepo generatorRepo;
	private ModelMapper mapper= new ModelMapper();

	@Override
	public ResponseDto<Employee> addEmployee(EmployeeDto edto) {
		Employee e=mapper.map(edto, Employee.class);
		// TODO Auto-generated method stub
		String id=generatedId();
		e.setEid(id);
		int age=calculateAge(e.getDob());
		Employee e1 = repo.save(e);
		ResponseDto<Employee> response = ResponseDto.<Employee>builder().body(e1).message("Saved...!!")
				.status(HttpStatus.CREATED.value()).build();
		return response;
	}

	private int calculateAge(LocalDate dob) {
		// TODO Auto-generated method stub
		LocalDate today=LocalDate.now();
		Period p=Period.between(dob, today);
		return p.getYears();
	}

	private String generatedId() {
		// TODO Auto-generated method stub
		IdGenerator i=generatorRepo.save(new IdGenerator());
		int id=i.getId();
		return id<=9?"JSP00"+id:id<=99?"JSP0"+id:"JSP"+id;
	}

	@Override
	public ResponseDto<Employee> getEmpById(String id) {
		Optional<Employee> e = repo.findById(id);
		if (e.isPresent()) {
			ResponseDto<Employee> response = ResponseDto.<Employee>builder().body(e.get()).message("Found...!!")
					.status(HttpStatus.FOUND.value()).build();
			return response;
		} else {
			throw new IdNotFoundException("Id Not Found...!!");
		}
	}

	@Override
	public List<Employee> viewAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee viewEmployee(String id) {
		Optional<Employee> emp = repo.findById(id);
		return emp.orElse(null);
	} 

	@Override
	public ResponseDto<Employee> updateEmployee(Employee enew) {
Optional<Employee> obj=repo.findById(enew.getEid());
		if (obj.isPresent()) {
//			return repo.save(e);
			Employee original=obj.get();
			original.setEname(enew.getEname());
			original.setEmail(enew.getEmail());
			original.setDeptName(enew.getDeptName());
			original.setDesignation(enew.getDesignation());
			original.setSal(enew.getSal());
			ResponseDto<Employee> response=ResponseDto.<Employee>builder().body(original).message("Found").status(HttpStatus.FOUND.value()).build();
			
			return response;
			
		}
		else {
			throw new IdNotFoundException("Id Not Found..........!!");
		}
//		return null;
		
	}

	@Override
	public String deleteEmployee(String id) {

		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "Employee deleted successfully!";
		}
		return "Employee not found!";
	}

}
