package com.jsp.test;

abstract class PaymentMethods{
	abstract void processPayment();
}

class CreditCard extends PaymentMethods{
	
	@Override
	void processPayment() {
		System.out.println("Payment done by using Creditcard");
	}
}

class DebitCard extends PaymentMethods{
	
	@Override
	void processPayment() {
		System.out.println("Payment done by using Debitcard");
	}
}
class UPI extends PaymentMethods{
	
	@Override
	void processPayment() {
		System.out.println("Payment done by using UPI");
	}
}
class Payment{
	public static PaymentMethods paymentWay(String way) {
		PaymentMethods payment = null;
		if(way=="creditcard") {
			payment = new CreditCard();
			return payment;
		} else if(way=="debitcard") {
			payment = new DebitCard();
			return payment;
		}
		else if(way=="upi"){
			payment = new UPI();
			return payment;
		}
		else {
			System.out.println("Give Correct pathway");
			return payment;
		}
	}
}
public class FirtsQuestion {

	public static void main(String[] args) {
		// creditcard, debitcard, upi
		
		PaymentMethods payment = Payment.paymentWay("upi");
		payment.processPayment();
	}

}
