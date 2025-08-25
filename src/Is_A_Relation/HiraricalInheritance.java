package Is_A_Relation;

class A{
	public void test() {
		System.out.println("this is test()");
	}
}
class B extends A{
	public void display() {
		System.out.println("this is display()");
	}
}
class C extends A{
	public void Show() {
		System.out.println("this is Show()");
	}
}


public class HiraricalInheritance {

	public static void main(String[] args) {
		B b=new B();
		b.test();
		b.display();
		C c=new C();
		c.test();
		c.Show();


	}

}
