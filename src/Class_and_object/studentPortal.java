package Class_and_object;

class student {
	static void studentLogin(String userName,int Password) {
		System.out.println("student login Successfully!!");
		System.out.println("student Name :"+userName);
		System.out.println("student Password: "+Password);
		System.out.println("------------------------------");
	}
}
public class studentPortal{
	public static void main(String[] args) {
		student.studentLogin("Sumaiya",123);
		student.studentLogin("Riya",456);
		student.studentLogin("Sreeja",161);
		student.studentLogin("pramod",100);
		

	}

}
