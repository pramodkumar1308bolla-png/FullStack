 package com.jsp.ListSenerioBased;


import java.util.LinkedHashSet;

class Travel{
	private LinkedHashSet<String> visited;

	public Travel() {
		visited=new LinkedHashSet<String>();
		
	}
	public void addCity(String city) {
		visited.add(city);
	}
	public void displayCities() {
		System.out.println("The unique order of cities visited while travelling in Order are : ");
		for(String city:visited) {
			System.out.println(city);
		}
	}
}



public class LinkedHashSetExample1 {

	public static void main(String[] args) {
		Travel travel=new Travel();
		travel.addCity("Banglore");
		travel.addCity("Delhi");
		travel.addCity("Mumbai");
		travel.addCity("Banglore");
		travel.displayCities();
		
		

	}

}
