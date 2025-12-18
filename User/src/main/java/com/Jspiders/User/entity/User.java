package com.Jspiders.User.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userid;
	String name;
	@Column(unique = true, nullable = false)
	String username;
	long phno;
	@Column(unique = true, nullable = false)
	String email;
	@OneToOne(cascade=CascadeType.ALL)
//	@Embedded
	Address address;
	String password;
	String dob;

}
