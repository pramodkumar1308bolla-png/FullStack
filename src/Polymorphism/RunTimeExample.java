package Polymorphism;

class ElectronicStore{
	public void details(String name,double price) {
		System.out.println("Name of the Product " + name);
		System.out.println("Price of the gadget " + price);
		
	}
}
class TV extends ElectronicStore{
	@Override
	public void details(String name,double price) {
		System.out.println("Brand of Tv " + name);
		System.out.println("Price of Tv " + price);
	}
}
class AC extends ElectronicStore{
	@Override
	public void details(String name,double price) {
		System.out.println("Brand of AC" + name);
		System.out.println("Price of AC" + price);
	}
	
	
}


public class RunTimeExample {

	public static void main(String[] args) {
		ElectronicStore a1=new TV();
		if(a1 instanceof ElectronicStore) {
		a1.details(null, 0);
		}
		

	}

}
