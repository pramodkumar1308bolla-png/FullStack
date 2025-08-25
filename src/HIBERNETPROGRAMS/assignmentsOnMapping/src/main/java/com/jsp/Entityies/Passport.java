package com.jsp.Entityies;

import javax.persistence.*;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Passport_Id")
	private int passportId;
	private int numberOfCountriesElibile;
	private String passportType;
	@OneToOne(mappedBy = "passport")
	private Person person;
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Passport(int passportId, int numberOfCountriesElibile, String passportType) {
		super();
		this.passportId = passportId;
		this.numberOfCountriesElibile = numberOfCountriesElibile;
		this.passportType = passportType;
	}
	public int getPassportId() {
		return passportId;
	}
	public int getNumberOfCountriesElibile() {
		return numberOfCountriesElibile;
	}
	public void setNumberOfCountriesElibile(int numberOfCountriesElibile) {
		this.numberOfCountriesElibile = numberOfCountriesElibile;
	}
	public String getPassportType() {
		return passportType;
	}
	public void setPassportType(String passportType) {
		this.passportType = passportType;
	}
	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", numberOfCountriesElibile=" + numberOfCountriesElibile
				+ ", passportType=" + passportType + "]";
	}
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
