package Class_and_object;
class DemoStatic{
	static int b=20;
	public static void display() {//Business Class
		System.out.println("this is display");
		
	}
}


public class Static_in_different { //Utilization Class
	public static void main(String[] args) {
		DemoStatic.display();
		System.out.println(DemoStatic.b);
	}

}
