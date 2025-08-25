package Class_and_object;

public class nonStatic {
	int a=20;
	public void test(){
		System.out.println("this is test()");
	}
	public void display() {
		System.out.println("this s display().....");
	}

	public static void main(String[] args) {
		new nonStatic().display();
		System.out.println(new nonStatic().a);

	}

}
