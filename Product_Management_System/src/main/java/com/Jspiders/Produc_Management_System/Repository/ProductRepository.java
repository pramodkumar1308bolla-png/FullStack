package com.Jspiders.Produc_Management_System.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jspiders.Produc_Management_System.entity.Owner;
import com.Jspiders.Produc_Management_System.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByOwnerOwnerId(String ownerId);
    List<Product> findByCompanyName(String companyName);
    List<Product> findByExpDateBefore(LocalDate date);
    List<Product> findByPriceBetween(Double min, Double max);
	List<Product> findByColorContainingIgnoreCase(String color);
	
}
