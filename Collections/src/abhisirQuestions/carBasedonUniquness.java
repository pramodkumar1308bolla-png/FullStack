package abhisirQuestions;

import java.util.HashSet;

public class carBasedonUniquness {
	public static void main(String[] args) {
		HashSet<Car> cs = new HashSet<>();
		cs.add(new Car(1, "BMW", 5000000));
		cs.add(new Car(2, "Audi", 5500000));
		cs.add(new Car(3, "BMW", 6000000)); 
		cs.add(new Car(4, "Benz", 6500000));
		
		for (Car car : cs) {
			System.out.println(car);
		}
	}

}
