package com.jsp.pkg1;

import com.jsp.pkg2.Demo2;

class Demo1{
	public static void test() {
		System.out.println("this is the test() in Demo1");
	}
	protected static void display() {
		System.out.println("this is the display() in Demo1");
	}
	public static void show() {
		System.out.println("this is the show() in Demo1");
	}
	public static void view() {
		System.out.println("this is the view() in Demo1");
	}
}
public class Sample extends Demo2{

	public static void main(String[] args) {
		Demo1.test();
		Demo1.display();
		Demo1.show();
		Demo2.test1();
		Sample s=new Sample();
		s.display1();
//		Demo2.show1();
		

	}

}
