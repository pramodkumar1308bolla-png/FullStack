package Polymorphism;

public class UserService {
	public static User creatPassword(int password){
		User user;
		if(password==123) {
			user=new Admin();
		}
		else {
			user=new customer();
		}
		return user;
		
	}

}
