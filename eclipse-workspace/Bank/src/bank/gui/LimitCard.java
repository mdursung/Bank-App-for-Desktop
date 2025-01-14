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
import java.awt.Font;

public class LimitCard {

	private JFrame frame;
	private JTextField kartNo;
	private JTextField paraVeri;
	private Customer customer;


	/**
	 * Create the application.
	 */
	public LimitCard(Customer customer) {
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
		
		kartNo = new JTextField();
		kartNo.setBounds(119, 54, 295, 19);
		frame.getContentPane().add(kartNo);
		kartNo.setColumns(10);
		
		JLabel lblIban = new JLabel("Kart Numarası:");
		lblIban.setFont(new Font("Dialog", Font.BOLD, 11));
		lblIban.setHorizontalAlignment(SwingConstants.LEFT);
		lblIban.setBounds(12, 57, 96, 15);
		frame.getContentPane().add(lblIban);
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setHorizontalAlignment(SwingConstants.LEFT);
		lblPara.setBounds(12, 104, 45, 15);
		frame.getContentPane().add(lblPara);
		
		paraVeri = new JTextField();
		paraVeri.setBounds(119, 102, 295, 19);
		frame.getContentPane().add(paraVeri);
		paraVeri.setColumns(10);
		
		JButton btnGnder = new JButton("Limiti Değiştir");
		btnGnder.setBounds(182, 168, 117, 25);
		frame.getContentPane().add(btnGnder);
		btnGnder.setFocusPainted(false);
		btnGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					CreditCard creditcard = (CreditCard) Data.creditCards.get(kartNo.getText());
					creditcard.setLimit(Double.parseDouble(paraVeri.getText()));
					JOptionPane.showMessageDialog(null, "Limit Düzenleme Başarılı");
					
				} catch(Exception eeee) {
					JOptionPane.showMessageDialog(null, "Hatalı bir bilgi girdiniz!");
				}

				new MenuPage(customer);
				frame.dispose();
			}
		});
	}
}
