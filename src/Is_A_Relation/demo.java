package Is_A_Relation;

class NotificationService{
	int n;
	String SMS;
	public void sendSMS(int n,String SMS) {
		System.out.println("User Service SMS : "+SMS);
		System.out.println("number  : " + n);
	}
}
class UserService extends NotificationService {
	String name;
	
	public void registerUser(String name,int n) {
		System.out.println("User name : " + name + " mobile number " + n);
	}
	
}


public class demo {

	public static void main(String[] args) {
		UserService n1=new UserService();
		n1.sendSMS(5, "Hello Moto");
		n1.registerUser("Pramod", 1231223125);
	}

}
