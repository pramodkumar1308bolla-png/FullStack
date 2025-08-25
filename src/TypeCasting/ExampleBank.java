package TypeCasting;

class Account {
    String accountNumber;
    double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void display() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance : " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void calculateIntrest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest earned : " + interest);
    }
}

class CurrentAccount extends Account {
    double OverdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double OverdraftLimit) {
        super(accountNumber, balance);
        this.OverdraftLimit = OverdraftLimit;
    }

    void ShowOverDraftLimit() {
        System.out.println("Overdraft limit: " + OverdraftLimit);
    }
}

class FixedDepositeAccount extends Account {

    public FixedDepositeAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void calculateMaturityAccount() {
        double maturityAmount = balance * 1.10;
        System.out.println("Maturity Amount: " + maturityAmount);
    }
}

public class ExampleBank {

    public static void main(String[] args) {

        Account accounts = new SavingsAccount("SA001", 5000, 4.5);
        accounts.display();
        if(accounts instanceof SavingsAccount) {
        	SavingsAccount s1=(SavingsAccount) accounts;
        	s1.calculateIntrest();
        }
        System.out.println("===================================");
        Account accounts1 = new CurrentAccount("CA001", 2000, 1000);
        accounts1.display();
        if(accounts1 instanceof CurrentAccount) {
        	CurrentAccount s2=(CurrentAccount)accounts1;
        	s2.ShowOverDraftLimit();
        }
        System.out.println("=====================================");
        Account accounts2 = new FixedDepositeAccount("FDA001", 10000);
        accounts2.display();
        if(accounts2 instanceof FixedDepositeAccount) {
        	FixedDepositeAccount s3=(FixedDepositeAccount)accounts2;
        	s3.calculateMaturityAccount();
        }
       
    }
}


