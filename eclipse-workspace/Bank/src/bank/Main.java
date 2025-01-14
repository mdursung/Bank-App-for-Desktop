package bank;

import bank.data.Data;
import bank.gui.LoginPage;
import bank.model.cards.BankCard;
import bank.model.user.Customer;
import bank.model.user.Employee;

public class Main {

	public static void main(String[] args) {
		String job1 = "Bilgisayar Mühendisi";
		String name1 = "Muhammet";
		String lastName1 = "Gönültaş";
		String TC1 = "15174304221";
		String Erkek = "Erkek";
		int age1 = 19;
		String password1 = "1234";
		Customer customer1 = new Customer(TC1, name1, lastName1, Erkek, age1, job1, password1);

		String job3 = "Memati";
		String name3 = "Ölüm";
		String lastName3 = "Baş";
		String TC3 = "15006705538";
		int age3 = 19;
		String password3 = "123";
		Customer customer3 = new Customer(TC3, name3, lastName3, Erkek, age3, job3, password3);

		String rank = "Müdür";
		String name2 = "Arda";
		String lastName2 = "Güler";
		String TC2 = "17594360021";
		int age2 = 18;
		String password2 = "RealMadrid";
		Employee employee = new Employee(TC2, name2, lastName2, Erkek, age2, rank, password2);

		BankCard bankcard = (BankCard) customer1.getAccount().getCard();
		bankcard.setBalance(100000);
		bankcard = (BankCard) employee.getAccount().getCard();
		bankcard.setBalance(676575750);

		Data.users.put(customer1.getTc(), customer1);
		Data.users.put(customer3.getTc(), customer3);
		Data.employees.put(employee.getTc(), employee);
		
		Data.ibanDatas.put(customer1.getAccount().getIban(), customer1);
		Data.ibanDatas.put(customer3.getAccount().getIban(), customer3);

		new LoginPage();
	}
}
