package threads;

import java.util.ArrayList;

 class Fruit {
	String name;
	double price;

	public Fruit(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + "]";
	}

}

public class demo {
	public static void main(String[] args) {

		ArrayList<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(new Fruit("pine", 23.0));
		fruits.add(new Fruit("apple", 26.0));
		fruits.add(new Fruit("banana", 29.9));

		System.out.println(fruits);
		fruits.sort((a, b) -> a.name.compareTo(b.name));

		System.out.println("Sort by name" + fruits);

		fruits.sort((a, b) -> Double.compare(b.price, a.price));
		System.out.println("Sort by price " + fruits);

	}

}
