package com.Jspiders.Employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jspiders.Employee.entity.IdGenerator;

public interface IdGeneratorRepo extends JpaRepository<IdGenerator, Integer>{

}
