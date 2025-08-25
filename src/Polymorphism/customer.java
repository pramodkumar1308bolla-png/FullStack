package Polymorphism;

public class customer implements User{

	@Override
	public void login() {
		System.out.println("Customer login Successfullt!!!!!");
		
	}

	@Override
	public void logout() {
		System.out.println("Customer logout Sucessfully!!!!!");
		
	}

}
