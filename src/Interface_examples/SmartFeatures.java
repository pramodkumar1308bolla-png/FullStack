package Interface_examples;

public interface SmartFeatures {
	public  void ConnectToInternet();
	
	default public void reset() {
		System.out.println("the mobile is reseted Successfully You can turn on the device now");
	

}
}
