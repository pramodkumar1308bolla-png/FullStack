package Polymorphism;

public class LogisticsSystem {

	public static void main(String[] args) {
		Vehicle vehicle = VehicleService.delivary("Truck");
		vehicle.deliverytime();
		vehicle.cost();
	}

}
