package Polymorphism;

public class MainUtilization {

	public static void main(String[] args) {
		User user1=UserService.creatPassword(123);
		user1.login();
		user1.logout();

	}

}
