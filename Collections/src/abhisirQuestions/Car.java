package abhisirQuestions;

public class Car {
	

	int id;
	String name;
	double price;

	Car(int id, String name, double price) {

		this.id = id;
		this.name = name;
		this.price = price;
	}

	

	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Car car = (Car) obj;
		return name.equals(car.name);

	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	

}
