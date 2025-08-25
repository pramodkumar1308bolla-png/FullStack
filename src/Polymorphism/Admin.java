package Polymorphism;

public class Admin implements User{

	@Override
	public void login() {
		System.out.println("Admin login Sucessfully!!!!!!!");
		
	}

	@Override
	public void logout() {
		System.out.println("admin logout Sucessfully!!!!!!!");
		
	}

}
