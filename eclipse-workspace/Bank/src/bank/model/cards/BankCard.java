package bank.model.cards;

public class BankCard extends Card {

	protected double balance;

	public BankCard() {
		this.balance = 0;
	}

	public BankCard(String lastDate, double balance) { // overload
		super(lastDate);
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
