package Constructor;

class Demmo{
	Demmo(){
		System.out.println("this is zero-args costructor");
	}
	Demmo(int a){
		System.out.println("the value of a is :"+a);
	}
	Demmo(double b,int a){
		System.out.println("the value of b and a is : "+b+","+a);
	}
	Demmo(int a,double b){
		System.out.println("the value of a and b is  : "+a+","+b);
	}
}
public class ConstructiorOverloading {

	public static void main(String[] args) {
		Demmo d1=new Demmo();
		Demmo d2=new Demmo(10);
		Demmo d3=new Demmo(10.5,9);
		Demmo d4=new Demmo(8,9.5);

	}

}
