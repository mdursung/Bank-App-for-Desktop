package bank.model.user;

import bank.model.accounts.Account;

public class Employee extends User {

	protected String rank;
	protected Account account;

	public Employee(String tc, String name, String lastName, String gender, int age, String rank, String password) {
		super(tc, name, lastName, gender, age);
		this.rank = rank;
		this.account = new Account(password);
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	// gelen istekler için kabul ve ret fonksiyonları
	public boolean accept() {
		return true;
	}

	public boolean refuse() {
		return false;
	}
}
