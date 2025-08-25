package Interface_examples;

public class example2 implements interfacedemo {
	@Override
	public void test() {
		System.out.println("this is test()");
	}
	@Override
	public void show() {
		System.out.println("this is show()");
	}

	public static void main(String[] args) {
		example2 exam=new example2();
		exam.test();
		exam.show();
		System.out.println(interfacedemo.a);
		interfacedemo.display();
	}

}
