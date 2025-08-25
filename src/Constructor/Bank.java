package Constructor;


class BankApp {
	String AccountHolderName;
	long AccountNumber;
	String BankName;
	double balance;
	
	public BankApp(String name,long num,String bName,double bal) {
		AccountHolderName=name;
		AccountNumber=num;
		BankName=bName;
		balance=bal;
	}
	public void showDetails() {
		System.out.println("Account holder name : "+ AccountHolderName);
		System.out.println("Account number:"+ AccountNumber);
		System.out.println("Bank Name :" + BankName);
		System.out.println("Balance:"+balance);
	}
}

public class Bank{
	
	public static void main(String[] args) {
		BankApp User1=new BankApp("Pramod", 1366554428, "Axis", 1215415151);
		User1.showDetails();
	
		
		

	}

}

