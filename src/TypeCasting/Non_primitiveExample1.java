package TypeCasting;

class Sample{
	public void test() {
		System.out.println("this is test()");
	}
}
class demo extends Sample{
	public void show() {
		
	}
	
}
class demo2 extends Sample{
	
}

public class Non_primitiveExample1 {

	public static void main(String[] args) {
		Sample s1= new demo();//Up Casting
		s1.test();
//		s1.show();//throws an error due to UPCASTING
		demo d1=(demo)s1;//DownCasting
		d1.show();
		d1.test();
		demo2 d2=(demo2)s1;//ClassCastException2
		
		

	}

}
