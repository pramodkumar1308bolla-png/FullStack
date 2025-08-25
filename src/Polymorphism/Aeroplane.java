package Polymorphism;

public class Aeroplane implements Vehicle{
	double delivaryTimeInHours=10.35;

	@Override
	public void deliverytime() {
		System.out.println("The Aeroplane is About to delivary in " + delivaryTimeInHours);
		
	}

	@Override
	public void cost() {
		double TotalCost=260;
		double Total=TotalCost*1.6;
		System.out.println("Total  cost of Aeroplane  is : " + Total);
	}

}
