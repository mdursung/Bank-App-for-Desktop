package bank.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import bank.model.user.Customer;

import java.awt.Color;
import javax.swing.JButton;

import bank.data.Data;
import bank.model.cards.*;

public class SendMoney {

	private JFrame frame;
	private JTextField ibanVeri;
	private JTextField paraVeri;
	private Customer customer;


	/**
	 * Create the application.
	 */
	public SendMoney(Customer customer) {
		this.customer = customer;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 171, 143));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		ibanVeri = new JTextField();
		ibanVeri.setBounds(107, 54, 295, 19);
		frame.getContentPane().add(ibanVeri);
		ibanVeri.setColumns(10);
		
		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIban.setBounds(19, 56, 70, 15);
		frame.getContentPane().add(lblIban);
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPara.setBounds(19, 104, 70, 15);
		frame.getContentPane().add(lblPara);
		
		paraVeri = new JTextField();
		paraVeri.setBounds(107, 102, 295, 19);
		frame.getContentPane().add(paraVeri);
		paraVeri.setColumns(10);
		
		JButton btnGnder = new JButton("Gönder");
		btnGnder.setBounds(182, 168, 117, 25);
		frame.getContentPane().add(btnGnder);
		btnGnder.setFocusPainted(false);
		btnGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankCard bankcard = (BankCard) customer.getAccount().getCard();
				
				if(bankcard.getBalance()-Double.parseDouble(paraVeri.getText()) >= 0) {
					try {
						BankCard bankcard2 = (BankCard)Data.ibanDatas.get(ibanVeri.getText()).getAccount().getCard();
						bankcard.setBalance(bankcard.getBalance()-Double.parseDouble(paraVeri.getText()));
						bankcard2.setBalance(bankcard2.getBalance()+Double.parseDouble(paraVeri.getText()));
						JOptionPane.showMessageDialog(null, "Gönderim Başarılı");
					} catch(Exception eeee) {
						JOptionPane.showMessageDialog(null, "Hatalı bir bilgi girdiniz!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Paranız Yetmemektedir!");
				}
				new MenuPage(customer);
				frame.dispose();
			}
		});
	}
}
