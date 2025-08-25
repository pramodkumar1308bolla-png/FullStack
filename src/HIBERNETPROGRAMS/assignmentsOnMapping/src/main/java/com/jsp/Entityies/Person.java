package com.jsp.Entityies;

import javax.persistence.*;

@Entity

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_id")
	private int id;
	private String name;
	private String city;
	private int pincode;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Passport_Id")
	private Passport passport;
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public Person(int id, String name, String city, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.pincode = pincode;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", city=" + city + ", pincode=" + pincode + "]";
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
