package Interface_examples;

public class SmartPhone implements Device,SmartFeatures {
	
	
	@Override
	public void ConnectToInternet() {
		System.out.println("Device connected to Internet");
		
	}

	@Override
	public void turnOn() {
		System.out.println("device turned on sucessfully");
		System.out.println("Welcome !!!!");
	}

	@Override
	public void reset() {
		Device.super.reset();
		SmartFeatures.super.reset();
	}

	public static void main(String[] args) {
		SmartPhone s=new SmartPhone();
		s.turnOn();
		s.ConnectToInternet();
		Device.ShowDetailsInfo();
		s.reset();
		
		

	}

	

}
