package bank.model.accounts;

import java.util.ArrayList;
import java.util.List;

import bank.model.cards.BankCard;
import bank.model.cards.Card;
import bank.utils.BankUtils;

public class Account implements AccountData {

	protected Card card;
	protected String iban;
	protected String password;
	protected List<Card> cards;

	public Account(String password) {
		this.password = password;
		this.card = new BankCard();
		this.iban = BankUtils.createIban();
		this.cards = new ArrayList<Card>();
		cards.add(card);
	}

	@Override
	public Card getCard() {
		return card;
	}

	@Override
	public String getIban() {
		return iban;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void addCards(Card cards) {
		this.cards.add(cards);
	}
	
}