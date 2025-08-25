package Polymorphism;

class ElecctonicStore{
	public void Item(String a,double price) {
		System.out.println("Name of the product " + a);
		System.out.println("Price of the product " + price);
	}
	public void item(double price,String a) {
		System.out.println("Name of the product " + a);
		System.out.println("Price of the product " + price);
	}
}

public class Example {

	public static void main(String[] args) {
		ElecctonicStore e1=new ElecctonicStore();
		e1.item(12546.0, "AC");
		System.out.println("================");
		e1.Item("TV", 88999.0);

	}

}
