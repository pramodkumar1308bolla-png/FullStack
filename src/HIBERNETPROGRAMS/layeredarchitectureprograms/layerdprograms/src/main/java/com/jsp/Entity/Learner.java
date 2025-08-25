package com.jsp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaners")
public class Learner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String course;
	private int marks;

	public Learner(String name, String course, int marks) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.marks = marks;
	}
	
	//Getter for ID (no Settere ID is auto-generated)
	public int getId() {
		return id;
	}

	// Getter & Setter for name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	Getter&Setter for Course

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

}
