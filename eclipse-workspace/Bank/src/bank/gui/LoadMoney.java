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

public class LoadMoney {

	private JFrame frame;
	private JTextField paraVeri;
	private Customer customer;


	/**
	 * Create the application.
	 */
	public LoadMoney(Customer customer) {
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
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPara.setBounds(15, 73, 70, 15);
		frame.getContentPane().add(lblPara);
		
		paraVeri = new JTextField();
		paraVeri.setBounds(103, 71, 295, 19);
		frame.getContentPane().add(paraVeri);
		paraVeri.setColumns(10);
		
		JButton btnGnder = new JButton("Yükle");
		btnGnder.setBounds(159, 141, 117, 25);
		frame.getContentPane().add(btnGnder);
		btnGnder.setFocusPainted(false);
		btnGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankCard bankcard = (BankCard) customer.getAccount().getCard();
				try {
					bankcard.setBalance(bankcard.getBalance()+Double.parseDouble(paraVeri.getText()));
					JOptionPane.showMessageDialog(null, "Yükleme Başarılı");
				} catch(Exception eeee) {
					JOptionPane.showMessageDialog(null, "Bir Hata Meydana Geldi!");
				}
				new MenuPage(customer);
				frame.dispose();
			}
		});
	}
}
