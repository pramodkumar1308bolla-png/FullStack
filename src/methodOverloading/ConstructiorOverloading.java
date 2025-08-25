package methodOverloading;
class Demo{
	Demo(){
		System.out.println("this is zero-args costructor");
	}
	Demo(int a){
		System.out.println("the value of a is :"+a);
	}
	Demo(double b,int a){
		System.out.println("the value of b and a is : "+b+","+a);
	}
	Demo(int a,double b){
		System.out.println("the value of a and b is  : "+a+","+b);
	}
}
public class ConstructiorOverloading {

	public static void main(String[] args) {
		Demo d1=new Demo();
		Demo d2=new Demo(10);
		Demo d3=new Demo(10.5,9);
		Demo d4=new Demo(8,9.5);

	}

}
