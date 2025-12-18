package com.paarctice.programming;

class watsapp {// super class
	String name;
	int version;// data members

	public watsapp(String name, int version) {// constructor
		this.name = name;
		this.version = version;
	}

	void display() {// function member
		System.out.println("watsapp : " + name);
		System.out.println("version : " + version);
	}
}

class subclass extends watsapp {
	String year;

	public subclass(String name, int version, String year) {// constructor
		super(name, version);

		this.year = year;
	}
//	void met() {
//		System.out.println("this is smrithi");
//	}

	void mani() {// method
		System.out.println("year : " + year);
	}

}

class subclass2 extends watsapp {
	String bluetick;

	public subclass2(String name, int version, String bluetick) {
		super(name, version);
		this.bluetick = bluetick;
	}

//	void met() {
//		System.out.println("this is me");
//	}
	void blutick() {
		System.out.println("blutick : " + bluetick);
	}

}

class multi extends subclass2 {
	String tick;

	multi(String name, int version, String bluetick, String tick) {
		super(name, version, bluetick);
		this.tick = tick;

	}

	void tick() {
		System.out.println("tick : " + bluetick);
	}

}

public class pramod {
	public static void main(String[] args) {

		System.out.println("This is Single Inheritance && part1 of hyrarical");
		subclass s1 = new subclass("watsappv2", 2, "01-01-2002");
		s1.mani();
		s1.display();// super class properties
		System.out.println("======================");
		
		
		System.out.println("This is Multilevel Inheritance");
		multi s2 = new multi("watsappv2", 2, "01-01-2002", "yes");

		s2.display();// super class properties
		s2.blutick();
		s2.tick();
		
		System.out.println("======================");
		System.out.println("This is Single Inheritance && part2 of hyrarical");
		subclass2 s3 = new subclass2("watsappv2", 2, "Yes");
		s3.blutick();
		
		s3.display();// super class properties
		

	}

}
