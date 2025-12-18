package com.jsp.Arrays2D;


	class Student {
	    String name;
	    int age;

	    
	    Student() {
	        this("name",0);
	        
	    }

	    
	    Student(String name, int age) {
	        this.name = name;
	        this.age = age;
	       
	    }

	    void display() {
	        System.out.println("Name: " + name + ", Age: " + age);
	    }
	}


	public class ConstructorChainning {
	    public static void main(String[] args) {

	        Student s1 = new Student();
	        s1.display();

	        System.out.println("-------------------");

	        Student s2 = new Student("Pramod", 22);
	        s2.display();
	    }
	}
	    

