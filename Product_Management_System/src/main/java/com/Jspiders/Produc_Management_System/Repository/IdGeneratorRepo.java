package com.Jspiders.Produc_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jspiders.Produc_Management_System.entity.IdGenerator;


public interface IdGeneratorRepo extends JpaRepository<IdGenerator, Integer>{

}
