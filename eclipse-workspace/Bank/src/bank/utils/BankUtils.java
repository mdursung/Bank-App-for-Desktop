package bank.utils;

import java.util.Random;

public class BankUtils {

	private static Random random = new Random();

	public static int createCvc() {
		return random.nextInt(100, 999);
	}

	public static String createIban() {
		String IBAN = "TR670001";
		for (int i = 0; i < 5; i++)
			IBAN += String.valueOf(random.nextInt(1000, 9999));
		return IBAN;
	}

	public static String createCardNumber() {
		String cardNumber = "";
		for (int i = 0; i < 4; i++)
			cardNumber += String.valueOf(random.nextInt(1000, 9999));
		return cardNumber;
	}
}
