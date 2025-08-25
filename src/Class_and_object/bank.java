package Class_and_object;

class simple{
	public static void message(String bankName) {
		System.out.println("welcome to "+bankName);
		}
	public void simpleIntrest(double principle,double rate,double time) {
		double intrest=(principle*rate*time)/100;
		System.out.println("principle = "+principle);
		System.out.println("rate = "+rate);
		System.out.println("time = "+time);
		System.out.println("------------------");
		System.out.println("Simple Intrest = "+intrest);
	}
}
public class bank {

	public static void main(String[] args) {
		simple.message("ABC");
		new simple().simpleIntrest(1000, 5.5, 2.0);

	}

}
