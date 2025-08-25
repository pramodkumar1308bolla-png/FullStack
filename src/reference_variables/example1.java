package reference_variables;

public class example1 {
	int a=10;
	
	public void display() {
		System.out.println("this is display()");
	}
	
	public static void main(String[] args) {
		example1 reference_Variable=new example1();
		reference_Variable.display();
		System.out.println(reference_Variable.a);
		System.out.println(reference_Variable);
		example1 reference_Variable1=new example1();
		System.out.println(reference_Variable1);
//		example1 ref=10;
//		int b=new example1();

	}

}
