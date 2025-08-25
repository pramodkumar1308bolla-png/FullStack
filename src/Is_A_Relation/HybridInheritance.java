package Is_A_Relation;

class A1{
	public void test() {
		System.out.println("this is test()");
	}
	
}
class B1 extends A1{
	public void test1() {
		System.out.println("this is test1()");
	}
	
}
class C1 extends B1{
	public void test2() {
		System.out.println("this is test2()");
	}
	
}
class D extends C1{
	public void test3() {
		System.out.println("this is test3()");
	}
	
}
class E extends C1{
	public void test4() {
		System.out.println("This is test4()");
	}
	
}

public class HybridInheritance {

	public static void main(String[] args) {
		E e=new E();
		e.test();
		e.test1();
		e.test2();
		e.test4();
		System.out.println("-----------------------------");
		D d=new D();
		d.test();
		d.test1();
		d.test2();
		d.test3();

		
		
	}

}
