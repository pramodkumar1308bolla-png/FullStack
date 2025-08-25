package com.jsp.ExceptionExamples;

class Sample{
	public static void div(int num) {
		try {
			int res=100/num;
			System.out.println("the res is : " + res);
		}
		catch(ArithmeticException e) {
			System.out.println("Exception Caught!!!");
		}
		try {
			int[] arr=new int[5];
			System.out.println(arr[5]);
		}
		catch(ArrayIndexOutOfBoundsException a1) {
			System.out.println("ARRAY INDEX OF BOUNDS");
		}
		finally {
			System.out.println("finaly");
		}
		
		
	}
}

public class ExceptionDemo {

	public static void main(String[] args) {
		Sample.div(10);
		Sample.div(0);
		Sample.div(20);

	}

}
