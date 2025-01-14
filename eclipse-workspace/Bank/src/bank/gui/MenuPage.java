package bank.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import bank.data.Data;
import bank.model.cards.*;
import bank.model.user.Customer;

public class MenuPage {

	private JFrame frame;
	private Customer customer;

	public MenuPage(Customer customer) {
		this.customer = customer;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 171, 143));
		frame.getContentPane().setLayout(null);

		JLabel menuName = new JLabel(customer.getName() + " " + customer.getLastName());
		menuName.setFont(new Font("Dialog", Font.BOLD, 12));
		menuName.setHorizontalAlignment(SwingConstants.CENTER);
		menuName.setBounds(12, 30, 551, 15);
		frame.getContentPane().add(menuName);

		BankCard bankcard = (BankCard) customer.getAccount().getCard(); // Bankcardı tekrar dönüştürüyoruz

		JLabel lblBakiye = new JLabel("KART 1");
		lblBakiye.setBounds(33, 156, 83, 24);
		frame.getContentPane().add(lblBakiye);

		JLabel bakiyeData = new JLabel(" " + bankcard.getBalance());
		bakiyeData.setBounds(153, 192, 331, 24);
		frame.getContentPane().add(bakiyeData);

		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setBounds(33, 90, 46, 15);
		frame.getContentPane().add(lblIban);

		JLabel ibanData = new JLabel(" " + customer.getAccount().getIban());
		ibanData.setBounds(153, 85, 331, 24);
		frame.getContentPane().add(ibanData);

		JLabel lblBakiye_1 = new JLabel("Bakiye:");
		lblBakiye_1.setBounds(33, 192, 83, 24);
		frame.getContentPane().add(lblBakiye_1);

		JLabel lblBakiye_1_1 = new JLabel("Kart Numarası:");
		lblBakiye_1_1.setBounds(33, 225, 106, 24);
		frame.getContentPane().add(lblBakiye_1_1);

		JLabel lblBakiye_1_1_1 = new JLabel("CVC:");
		lblBakiye_1_1_1.setBounds(33, 261, 46, 24);
		frame.getContentPane().add(lblBakiye_1_1_1);

		JLabel lblBakiye_1_1_1_1 = new JLabel("Tarih:");
		lblBakiye_1_1_1_1.setBounds(317, 261, 46, 24);
		frame.getContentPane().add(lblBakiye_1_1_1_1);

		JLabel CVCData = new JLabel(" " + bankcard.getCvc());
		CVCData.setBounds(153, 261, 106, 24);
		frame.getContentPane().add(CVCData);

		JLabel kartNumarasıData = new JLabel(bankcard.getCardNumber());
		kartNumarasıData.setBounds(153, 225, 331, 24);
		frame.getContentPane().add(kartNumarasıData);

		JLabel tarihData = new JLabel(" " + bankcard.getLastDate());
		tarihData.setBounds(375, 261, 106, 24);
		frame.getContentPane().add(tarihData);

		JButton btnNewButton = new JButton("Para Gönder");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 11));
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SendMoney(customer);
			}
		});
		btnNewButton.setBounds(33, 332, 129, 25);
		frame.getContentPane().add(btnNewButton);

		JButton btnYeniKart = new JButton("Yeni Banka Kartı");
		btnYeniKart.setFont(new Font("Dialog", Font.BOLD, 12));
		btnYeniKart.setBounds(213, 332, 150, 25);
		btnYeniKart.setFocusPainted(false);
		btnYeniKart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card card = new BankCard();
				customer.getAccount().addCards(card);
				JOptionPane.showMessageDialog(null, "Banka Kartı Eklendi");
			}
		});

		frame.getContentPane().add(btnYeniKart);
		

		JButton btnNewButton_1_1 = new JButton("Kartları Göster");
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD, 11));
		btnNewButton_1_1.setBounds(33, 393, 129, 25);
		btnNewButton_1_1.setFocusPainted(false);
		frame.getContentPane().add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MenuCards(customer);
			}
		});

		JButton btnNewButton_1_1_1 = new JButton("Yeni Kredi Kartı");
		btnNewButton_1_1_1.setBounds(213, 393, 150, 25);
		btnNewButton_1_1_1.setFocusPainted(false);
		frame.getContentPane().add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card card = new CreditCard();
				customer.getAccount().addCards(card);
				JOptionPane.showMessageDialog(null, "Kredi Kartı Eklendi");
				Data.creditCards.put(card.getCardNumber(), card);
			}
		});

		JButton btnNewButton_1_1_1_1 = new JButton("Kredi Kart Limiti");
		btnNewButton_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_1_1_1_1.setBounds(33, 459, 129, 25);
		btnNewButton_1_1_1_1.setFocusPainted(false);
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LimitCard(customer);
			}
		});
		frame.getContentPane().add(btnNewButton_1_1_1_1);

		JButton btnNewButton_1_1_1_1_1 = new JButton("Para Yükle");
		btnNewButton_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1_1_1_1_1.setBounds(213, 459, 150, 25);
		btnNewButton_1_1_1_1_1.setFocusPainted(false);
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoadMoney(customer);
			}
		});
		frame.getContentPane().add(btnNewButton_1_1_1_1_1);

		JButton btnNewButton_1_1_1_1_1_1 = new JButton("Ödeme Yap");
		btnNewButton_1_1_1_1_1_1.setBounds(417, 332, 129, 25);
		btnNewButton_1_1_1_1_1_1.setFocusPainted(false);
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new payBillPage(customer);
			}
		});
		frame.getContentPane().add(btnNewButton_1_1_1_1_1_1);


		JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("Çıkış Yap");
		btnNewButton_1_1_1_1_1_1_1.setBounds(417, 393, 129, 25);
		btnNewButton_1_1_1_1_1_1_1.setFocusPainted(false);
		btnNewButton_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginPage();
			}
		});
		frame.getContentPane().add(btnNewButton_1_1_1_1_1_1_1);

		JButton btnNewButton_1_1_1_1_1_1_1_1 = new JButton("Hesap Hareketi");
		btnNewButton_1_1_1_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_1_1_1_1_1_1_1_1.setBounds(417, 459, 129, 25);
		btnNewButton_1_1_1_1_1_1_1_1.setFocusPainted(false);
		
		frame.getContentPane().add(btnNewButton_1_1_1_1_1_1_1_1);
		frame.setBounds(100, 100, 585, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
