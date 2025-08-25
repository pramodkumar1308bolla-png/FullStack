package Interface_examples;

class Laptop implements product,discountable{
	String brand;
	double price;
	public Laptop(String brand, double price) {
		
		this.brand = brand;
		this.price = price;
	}
	@Override
	public void displaydetails() {
		System.out.println("---------------Product details---------------");
		System.out.println("Welcome to " + brand + " series ");
		System.out.println("the total price of the mobile = " +price);
		
		
	}
	@Override
	
	public void applydiscount(double discount) {
		System.out.println("the total after discount applied for the Laptop = " + discount*price);
		
		
	}
	
}

public class Mobile implements product,discountable {
	String brand;
	double price;

	public Mobile(String brand, double price) {
		this.brand = brand;
		this.price = price;
		
	}

	@Override
	public void displaydetails() {
		System.out.println("---------------Product details---------------");
		System.out.println("Welcome to mobile = " + brand );
		System.out.println("the total price of the mobile " + price);
	}

	@Override
	public void applydiscount(double discount) {
		double totalAmount=price*discount;
		totalAmount= price-discount;
		System.out.println("the total  After discount for the mobile " + totalAmount);
		
		
	}
public static void main(String[] args) {
	product.termsAndConditions();
	System.out.println("----------------------------------------");
	Mobile m=new Mobile("Apple", 1000.0);
	m.showMessage();
	m.displaydetails();
	m.applydiscount(100);
	System.out.println("=========================================");
	product.termsAndConditions();
	System.out.println("-----------------------------------------");
	Laptop l=new Laptop("Mac", 100000.0);
	l.showMessage();
	l.displaydetails();
	l.applydiscount(100);
	
		

	}



}
