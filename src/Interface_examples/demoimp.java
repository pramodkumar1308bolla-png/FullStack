package Interface_examples;

public class demoimp implements Demo2 {
	@Override
	public void test() {
		System.out.println("this is test()");
		
		
	}
	@Override
	public void display() {
		System.out.println("this is display()");
		
		
	}
	

	public static void main(String[] args) {
		demoimp Demo=new demoimp();
		Demo.test();
		Demo.display();
		Demo.show();
		System.out.println(interfacedemo.a);
		System.out.println(Demo2.str);
		

	}

}
