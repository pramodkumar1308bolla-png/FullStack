package com.paarctice.programming;

class Engine{//composition
	String enginetype;
	int hp;
	public Engine(String enginetype,int hp) {
		this.enginetype=enginetype;
		this.hp=hp;
	}
	public void displayEngineDetails() {
		System.out.println("Engine Type : " + enginetype);
		System.out.println("Hp : "+ hp);
	}
}
class car{
	String name;
	double price;
	Engine engine;
	public car(String name, double price,Engine engine) {
		this.name = name;
		this.price = price;
		this.engine = engine;
	}
	public void displayCarDetails() {
		System.out.println("Name : " + name);
		System.out.println("price : "+ price);
	}
	
}


public class hasARelation {
	public static void main(String[] args) {
		Engine e=new Engine("petrol", 200);
		car c=new car("BMW", 100.0,e);
		e.displayEngineDetails();
		c.displayCarDetails();
		
	}

}
