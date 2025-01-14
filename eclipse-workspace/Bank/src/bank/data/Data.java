package bank.data;

import java.util.HashMap;

import bank.model.cards.Card;
import bank.model.user.Customer;
import bank.model.user.Employee;

public abstract class Data {
	
	//Verilerin saklanacağı kısım
	public static HashMap<String, Customer> users = new HashMap<>(); // LOGIN VE REGİSTER PAGE İÇİN
    public static HashMap<String, Customer> ibanDatas = new HashMap<>(); // PARA AKTARIMI İÇİN IBAN TUTULACAK
    public static HashMap<String, Employee> employees = new HashMap<>(); // LOGİN PAGE İÇİN
    public static HashMap<String, Card> creditCards = new HashMap<>(); // KART LİMİTİ İÇİN
}
