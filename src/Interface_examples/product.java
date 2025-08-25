package Interface_examples;

public interface product {
    public  void displaydetails(); 
		
	default public void showMessage() {
		System.out.println("Welcome to Flipkart Application");
	}
	public static void termsAndConditions() {
		System.out.println("Note: 10% GST will be addeed on product and can be changed");
	}

}

