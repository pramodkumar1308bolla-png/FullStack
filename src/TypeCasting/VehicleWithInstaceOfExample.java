package TypeCasting;

class Vehicle{
	public void start() {
		System.out.println("vehicle starts!!!!!!!!!!!!!!");
	}
}
class bike extends Vehicle{
	public void test() {
		System.out.println("bike required are checked");
	}
}
class bus extends Vehicle{
	public void announceRoute() {
		System.out.println("bus announces the route");
	}
}

public class VehicleWithInstaceOfExample {

	public static void main(String[] args) {
		Vehicle v1=new bike();//Upcasting
		v1.start();
		System.out.println(v1 instanceof bike);
		bike b1=(bike)v1;//DownCasting
		b1.test();

	}

}
