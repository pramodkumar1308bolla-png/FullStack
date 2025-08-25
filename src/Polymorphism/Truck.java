package Polymorphism;

public class Truck implements Vehicle{
	double delivaryTimeInHours=10.35;

	@Override
	public void deliverytime() {
		double delivaryTime=delivaryTimeInHours;
		System.out.println("The Truck is About to delivary in " + delivaryTime);
		
	}

	@Override
	public void cost() {
		double TotalCost=260;
		double Total=TotalCost+TotalCost*0.2;
		System.out.println("Total cost  of Truck is : " + Total);
	}
	

}
