package Interface_examples;

public interface interfacedemo {
	int a=10;
	public void test();
	
	public static void display() {
		System.out.println("this is display()");
	}
	default public void show() {
		System.out.println("this is show()");
	}

}
interface Demo2 extends interfacedemo{
	String str="Hello";
	public void test();
	void display();
}

