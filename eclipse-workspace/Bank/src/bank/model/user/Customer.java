package bank.model.user;

import bank.model.accounts.Account;

public class Customer extends User {

	protected String job;
	protected Account account;

	public Customer(String tc, String name, String lastName, String gender, int age, String job, String password) {
		super(tc, name, lastName, gender, age);
		this.job = job;
		this.account = new Account(password);
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}