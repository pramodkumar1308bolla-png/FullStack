package Polymorphism;

public class ship implements Vehicle{
	double delivaryTimeInHours=48.00;

	@Override
	public void deliverytime() {
		double delivaryTime=delivaryTimeInHours;
		System.out.println("The Ship is About to delivary in " + delivaryTime);
		
	}

	@Override
	public void cost() {
		double TotalCost=1600;
		double Total=TotalCost*0.4;
		System.out.println("Total cost of ship  is : " + Total);
	}

}
