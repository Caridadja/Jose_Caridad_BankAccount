import java.util.Random;
public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int numberofAccounts = 0;
	private static int totalAmount = 0;
	
	private String getAccountNumber() {
		String x = "";
		for(int n = 0; n < 10; n++) {
			int generator = (int) (Math.random() * 10);
			x += generator;
		}
		return x;
	}
	public BankAccount(){
		this.accountNumber = getAccountNumber();
		numberofAccounts++;
	}
	public double getCheckingBalance(){
		return this.checkingBalance;
	}
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	public void deposit(String accountType, double amount) {
		if(accountType == "Checking") {
			checkingBalance += amount;
		}
		if(accountType == "Savings") {
			savingsBalance += amount;
		}
	}
	public void withdraw(String accountType, double amount) {
		if(accountType == "Checking") {
			if(this.checkingBalance < amount) {
				System.out.println("Insufficient Funds!");
			}
			else {
			checkingBalance -= amount;
			}
		}
		if(accountType == "Savings") {
			if(this.savingsBalance < amount) {
				System.out.println("Insufficient Funds!");
			}
			else {
			savingsBalance -= amount;
			}
		}
	}
	public void totalMoney(String accountType) {
		if(accountType == "Checking") {
			System.out.println("This is your checking balance: $"+this.getCheckingBalance());
		}
		if(accountType == "Savings") {
			System.out.println("This is your savings balance: $"+this.getSavingsBalance());
		}
	}
public static void main(String[] args) {
	BankAccount user1 = new BankAccount();
	user1.deposit("Checking", 1000);
	user1.totalMoney("Checking");
	user1.withdraw("Checking", 2000);
	System.out.println(user1.accountNumber);
	}
}
