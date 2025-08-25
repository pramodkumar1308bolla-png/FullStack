package AbstractClassMethod;

abstract class Vehicle{
	long vehicleNumber;
	int days;
	public Vehicle(long vehicleNumber, int days) {
		this.vehicleNumber = vehicleNumber;
		this.days = days;
	}
	abstract public double claculaterent();
	
	void showdetails() {
		System.out.println("vehicle number : " + vehicleNumber);
		System.out.println("rent days : " + days);
	}
	
}
class car extends Vehicle{
	double rate;
	public car(long vehicleNumber, int days,double rate) {
		super(vehicleNumber, days);
		this.rate=rate;
		
	}

	@Override
	public double claculaterent() {
		double total=rate*rate;
//		if(days>5) { this is also currect but usng return statement
//			System.out.println("Total amount is : " + 0.9*rate*days);
//		}
//		else {
//			System.out.println("Total amount is : " + rate*1.1*days + " For Vehicle " + vehicleNumber);
//		}
		if(days>5) {
			total =total -(total*0.10);
		}
		return total;
	}
	
}
class bike extends Vehicle{
	double rate;
	public bike(long vehicleNumber, int days,double rate) {
		super(vehicleNumber, days);
		this.rate=rate;
	}

	@Override
	public double claculaterent() {
		double total =days*rate;
		if(rate>3) {
			total = total - (total*0.05);
		}
//		System.out.println("The total amount is : " + rate*days + " For Vehicle " + vehicleNumber);
		return total;
		
	}
	
}
class truck extends Vehicle{
	double charge=500;
	public truck(long vehicleNumber, int days) {
		super(vehicleNumber, days);
		
	}

	@Override
	public double claculaterent() {
		double total = days*charge;
		if(days>7) {
			total = total -(total*0.15);
		}
		return total;
//		if(days>7) {
//			System.out.println("with discount Truck of number " + vehicleNumber + " after discount Rs :" + 0.85*charge*days);
//			
//		}
//		
//			System.out.println("Truck of number " + vehicleNumber + " Original cost -Rs :" + charge*days);
		
		
	}
	
}

public class rentalsAbstractClassMethod {

	public static void main(String[] args) {
		truck t=new truck(258797, 8);
		t.showdetails();
		t.claculaterent();
		System.out.println("=============================");
		bike b=new bike(258797, 5, 1000);
		b.showdetails();
		b.claculaterent();
		System.out.println("=============================");
		car c=new car(258797, 6, 2000);
		c.showdetails();
		c.claculaterent();
	}

}
