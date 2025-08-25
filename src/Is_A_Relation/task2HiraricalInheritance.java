package Is_A_Relation;

class Device{
	String brand;

	public Device(String brand) {
		super();
		this.brand = brand;
	}
	public void powerOn() {
		System.out.println("turned on");
	}
	public void displayDevicedetails() {
		System.out.println("name of the brand " + brand);
	}
	
}
class Mobile extends Device{

	public Mobile(String brand) {
		super(brand);
		
	}
	public void makeCall(long num) {
		System.out.println("the number " + num);
	}
	
	
}
class Laptop extends Device{

	public Laptop(String brand) {
		super(brand);

	}
	public void run() {
		System.out.println("installed");
	}
	
}

public class task2HiraricalInheritance {

	public static void main(String[] args) {
		Mobile m=new Mobile("APP");
		m.displayDevicedetails();
		m.powerOn();
		m.makeCall(12345678900l);
		Laptop l=new Laptop("Mac");
		l.displayDevicedetails();
		l.powerOn();
		l.run();
		

	}

}
