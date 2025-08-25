package AbstractClassMethod;

abstract class Payment{
	long transactionId;
	double amount;
	
	public Payment(long transactionId, double amount) {
		this.transactionId = transactionId;
		this.amount = amount;
	}

	abstract public void processpayment();
	public void generateRecipt() {
		System.out.println("Transaction Successfully done through : " + transactionId + " Rs." + amount);
	}
}
class upi extends Payment{
	String upiid;

	public upi(long transactionId, double amount, String upiid) {
		super(transactionId, amount);
		this.upiid = upiid;
	}

	@Override
	public void processpayment() {
		System.out.println("transaction done using upi " + upiid );
		
	}
}
class Card extends Payment{
	String cardno;

	public Card(long transactionId, double amount, String cardno) {
		super(transactionId, amount);
		this.cardno = cardno;
	}

	@Override
	public void processpayment() {
		System.out.println("transaction compltede through card " + cardno);
		
	}

}
	

public class ddemo1 {

	public static void main(String[] args) {
		upi Upi= new upi(15151518188l, 65648418541851.0, "vctgdviytf@upi");
		Upi.processpayment();
		Upi.generateRecipt();
		System.out.println("---------------------------------------");
		Card c=new Card(151616516516856l, 1518814.0, 5+"41985618651651");
		c.processpayment();
		c.generateRecipt();

	}

}
