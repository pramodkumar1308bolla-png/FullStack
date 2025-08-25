package reference_variables;

public class GlobalAndLocalExample {
	int a;
	static int c=20;
	
	public void test() {
		double b=19;
		System.out.println("local Var: "+b);
		System.out.println("Global Var : "+a);
	}
	public static void main(String[] args) {
		 
			GlobalAndLocalExample s1=new GlobalAndLocalExample();
			s1.test();
			System.out.println("global Var : "+ s1.a);
			System.out.println("global Static Variable : "+c);
		

	}

}
