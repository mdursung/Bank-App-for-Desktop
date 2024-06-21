package bank.model.cards;

public interface CardData {

	int getCvc();

	String getLastDate();

	String getCardNumber();

	void setCvc(int CVC);

	void setLastDate(String lastDate);

	void setCardNumber(String cardNumber);
}
