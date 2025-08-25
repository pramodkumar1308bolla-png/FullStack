package methodOverloading;

class withdraw{
	int pin;
	double amount;
	long accNo;
	int checkNo;
	long cardNumber;
	
	public void withdraww(int pin,double amount) {
		System.out.println("withdraw $= "+ amount);
	}
	public void withdraww(long cardNumber,double amount) {
		System.out.println("withdraw $= "+amount);
	}
	public void deposite(double amount,long accNo) {
		System.out.println("deposite $: "+amount);
	}
	public void deposite(int checkNo,double amount) {
		System.out.println("deposite $: "+amount);
		
	}
}

public class ATM {

	public static void main(String[] args) {
		withdraw w1=new withdraw();
		w1.withdraww(1234,55000.0);
		w1.withdraww(1234666444644l, 57778979.0);
		w1.deposite(1111111111, 3232323.0);
		w1.deposite(22222222, 222222.0);
		

	}

}
