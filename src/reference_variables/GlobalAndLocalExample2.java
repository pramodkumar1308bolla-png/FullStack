package reference_variables;

public class GlobalAndLocalExample2 {
	int globalCounter=20;
	public void displayCounter() {
		int LocalCounter=10;
		System.out.println("GlobalAndLocal:"+globalCounter);
		System.out.println("Local Counter: "+LocalCounter);
		
		
	}
	public void incrementVale() {
		globalCounter++;
		System.out.println("global Counter:"+globalCounter);
	}

	public static void main(String[] args) {
		GlobalAndLocalExample2 s2=new GlobalAndLocalExample2();
		s2.displayCounter();
		s2.incrementVale();
		System.out.println("global Counter Increment:" +s2.globalCounter);

	}

}
