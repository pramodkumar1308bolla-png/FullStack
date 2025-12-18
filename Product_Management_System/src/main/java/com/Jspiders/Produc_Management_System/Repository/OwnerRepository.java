package com.Jspiders.Produc_Management_System.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jspiders.Produc_Management_System.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, String> {
    Optional<Owner> findByEmail(String email);
    Optional<Owner> findByPhno(String phno);
}
