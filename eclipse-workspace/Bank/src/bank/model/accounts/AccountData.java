package bank.model.accounts;

import java.util.List;

import bank.model.cards.Card;

public interface AccountData {

	Card getCard();

	String getIban();

	String getPassword();
	
	List<Card> getCards();

	void setCard(Card card);

	void setIban(String iban);
	
	void addCards(Card cards);

	void setPassword(String password);

}
