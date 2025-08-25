package com.jsp.enumexamples;

enum Planet{
	MERCURY(1),EARTH(2),VENUS(3);
	private int orderFromSun;
	Planet(int order) {
		this.orderFromSun=order;
	}
	public int getOrder() {
		return orderFromSun;
		
	}
}

public class Example4Planets {

	public static void main(String[] args) {
		for(Planet planet:Planet.values()) {
			System.out.println(planet.getOrder() + " " + planet.name());
		}
		

	}

}
