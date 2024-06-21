package bank.model.cards;

import bank.utils.BankUtils;

public abstract class Card implements CardData {

	protected int cvc;
	protected String lastDate;
	protected String cardNumber;

	public Card() {
		this("30.01.2034");
	}

	public Card(String lastDate) {
		this.lastDate = lastDate;
		this.cvc = BankUtils.createCvc();
		this.cardNumber = BankUtils.createCardNumber();
	}

	@Override
	public int getCvc() {
		return this.cvc;
	}

	@Override
	public String getLastDate() {
		return this.lastDate;
	}

	@Override
	public String getCardNumber() {
		return this.cardNumber;
	}

	@Override
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	@Override
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	@Override
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
