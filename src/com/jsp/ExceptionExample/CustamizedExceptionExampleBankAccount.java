package com.jsp.ExceptionExample;

class InSufficientFundsException extends Exception{
	public InSufficientFundsException(String message) {
		super(message);
	}
}
class BankAccount{
	double amount;
	double balance;
	double TotalBalance=balance-amount;
	public BankAccount(double balance) {
		this.balance=balance;
	}

	public void withdraw(double amount) throws InSufficientFundsException {
		if(amount>balance || balance==0) {
			throw new InSufficientFundsException("Enter the amount less than or equal to your current balance");
			
		}
//		this.TotalBalance=TotalBalance;

		System.out.println("Total balance : " + TotalBalance);
	}
	
	
	
}
public class CustamizedExceptionExampleBankAccount {

	public static void main(String[] args) {
		BankAccount ba=new BankAccount(123456.2);
		try {
			ba.withdraw(123456.2);
		}
		catch(InSufficientFundsException e) {
			System.out.println("Exception Caught: " + e.getMessage());
		}
		

	}

}
