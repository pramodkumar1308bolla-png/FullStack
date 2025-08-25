package Polymorphism;

public class VehicleService {
	public static Vehicle delivary(String VehicleName) {
		Vehicle vehicle = null;
		if(VehicleName == "Truck") {
			vehicle=new Truck();
		}
		else if(VehicleName=="Ship"){
			vehicle=new ship();
		}
		else if(VehicleName=="Aeroplane") {
			vehicle=new Aeroplane();
		}
		return vehicle;
		
		
		
		
	}

}
