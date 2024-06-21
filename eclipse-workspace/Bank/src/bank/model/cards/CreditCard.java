package bank.model.cards;

import bank.data.Data;

public class CreditCard extends Card {

	protected double limit;
	
	public CreditCard() {
		this.limit = 0;
	}

	public CreditCard(String lastDate, int limit) {
		super(lastDate);
		this.limit = limit;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}
}
