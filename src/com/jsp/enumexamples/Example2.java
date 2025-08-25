package com.jsp.enumexamples;

enum Days{
	SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
}

public class Example2 {

	public static void main(String[] args) {
		Days day=Days.SUNDAY;
		if(day==Days.SUNDAY) {
			System.out.println("Its a holiday!!!!!");
		}

	}

}
