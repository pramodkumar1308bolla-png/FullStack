package Class_and_object;

class car{
	public void carDetails(String name,String Color,double price) {
		System.out.println("car name: "+name);
		System.out.println("car color:"+Color);
		System.out.println("car price:"+price);
		System.out.println("------------------------");
	}
}
public class demo {

	public static void main(String[] args) {
		new car().carDetails("Audi", null, 400000.0);
		new car().carDetails("BMW", "Red", 1000000000000.0);
		new car().carDetails("BENZ", "Blue", 4000000.0);

	}

}
