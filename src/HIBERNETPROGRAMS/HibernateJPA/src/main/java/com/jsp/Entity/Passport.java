package com.jsp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passportNo;
	
	private String issueDate;
	private String expiryDate;
	
	public Passport() {
		super();
	}

	public Passport(String expiryDate, String issueDate) {
		super();
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getPassportNo() {
		return passportNo;
	}
	
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}

	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", issueDate=" + issueDate + ", expiryDate=" + expiryDate + "]";
	}
	
}
