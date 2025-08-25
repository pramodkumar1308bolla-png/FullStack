package MethodOverRiding;

class payment{
	public void processPayment(double amount) {
		System.out.println("payment done : "+amount);
	}
}
class PayPal extends payment{
	@Override
	public void processPayment(double amount) {
		System.out.println("payment done through PayPal : " + amount);
	}
}

class Phonepay extends payment{
	@Override
	public void processPayment(double amount) {
		System.out.println("payment done through PhonePay : " + amount);
	}
}


public class MethodOverRiding {

	public static void main(String[] args) {
		PayPal paypal=new PayPal();
		paypal.processPayment(1000);
		Phonepay phone=new Phonepay();
		phone.processPayment(20000);
	}

}
