package Class_and_object;

class register {
	static int Count=0;
	static void studentLogin(String userName,int Password) {
		System.out.println("student Login successfully!!");
		Count++;
		System.out.println("student name:"+userName);
		System.out.println("student Password: "+Password);
		System.out.println("------------------------------");
	}
	static void registerCount() {
		System.out.println("students Total:"+Count);
		
	}
}
public class studentCount{
	
	public static void main(String[] args) {
		register.studentLogin("Sumaiya",123);
		register.studentLogin("Riya",456);
		register.studentLogin("Sreeja",161);
		register.studentLogin("pramod",100);
		register.registerCount();

	}
}

