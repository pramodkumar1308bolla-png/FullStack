package com.jsp.enumexamples;

enum Fruits{
	APPLE("RED"),BANANA("YELLOW"),MANGO("GREEN");
	

	private String color;
	Fruits(String color) {
		this.color=color;
		
	}
	public String getcolor() {
		return color;
		
	}
	 
}

public class Example5Fruits {

	public static void main(String[] args) {
		Fruits[] fruits=Fruits.values();
		for(int i=0;i<fruits.length;i++) {
			System.out.println(fruits[i] + " " + fruits[i].getcolor());
		}
	}

}
