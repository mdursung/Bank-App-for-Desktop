package bank.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
import javax.swing.JCheckBox;
import java.awt.Font;

public class payBillPage {

	private JFrame frame;
	private Customer customer;
	static double x = 0;


	/**
	 * Create the application.
	 */
	public payBillPage(Customer customer) {
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

		
		JButton btnGnder = new JButton("Ödemeyi Yap");
		btnGnder.setBounds(143, 213, 126, 25);
		frame.getContentPane().add(btnGnder);
		btnGnder.setFocusPainted(false);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Su - 450 tl");
		chckbxNewCheckBox.setBounds(8, 42, 166, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                	x += 450;
 
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {

                    x -= 450;
 
                }
            }
        });
		
		JCheckBox chckbxDoalgaz = new JCheckBox("Doğalgaz - 700 tl");
		chckbxDoalgaz.setBounds(8, 81, 166, 23);
		frame.getContentPane().add(chckbxDoalgaz);
		chckbxDoalgaz.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                	x += 700;

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {

                    x -= 700;
 
                }
            }
        });
		
		
		JCheckBox chckbxKrediBorcu = new JCheckBox("Kredi Borcu - 350 tl");
		chckbxKrediBorcu.setBounds(8, 122, 166, 23);
		frame.getContentPane().add(chckbxKrediBorcu);
		chckbxKrediBorcu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                	x += 350;

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {

                    x -= 350;
 
                }
            }
        });
		
		JCheckBox chckbxElektrik = new JCheckBox("Elektrik - 790 tl");
		chckbxElektrik.setBounds(8, 162, 166, 23);
		frame.getContentPane().add(chckbxElektrik);
		chckbxElektrik.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                	x += 790;

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {

                    x -= 790;
 
                }
            }
        });
		
		JCheckBox chckbxTelefon = new JCheckBox("Telefon - 33 tl");
		chckbxTelefon.setBounds(235, 42, 172, 23);
		frame.getContentPane().add(chckbxTelefon);
		chckbxTelefon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                	x += 33;

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {

                    x -= 33;
 
                }
            }
        });
		
		JCheckBox chckbxArabaTaksidi = new JCheckBox(" Araba Taksidi - 71 tl");
		chckbxArabaTaksidi.setBounds(235, 81, 172, 23);
		frame.getContentPane().add(chckbxArabaTaksidi);
		chckbxArabaTaksidi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                	x += 71;

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {

                    x -= 71;
 
                }
            }
        });
		
		JCheckBox chckbxNewCheeckBox = new JCheckBox("Ev Kirası - 400 tl");
		chckbxNewCheeckBox.setToolTipText("");
		chckbxNewCheeckBox.setBounds(235, 122, 172, 23);
		frame.getContentPane().add(chckbxNewCheeckBox);
		chckbxNewCheeckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                	x += 400;

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {

                    x -= 400;
 
                }
            }
        });
		
		JCheckBox chckbxEclipseAbonelii = new JCheckBox("Eclipse Aboneliği - 80$");
		chckbxEclipseAbonelii.setFont(new Font("Dialog", Font.BOLD, 11));
		chckbxEclipseAbonelii.setBounds(235, 163, 172, 23);
		frame.getContentPane().add(chckbxEclipseAbonelii);
		chckbxEclipseAbonelii.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                	x += 80*30;


                } else if (e.getStateChange() == ItemEvent.DESELECTED) {

                    x -= 80*30;
 
                }
            }
        });
		
		JLabel lblHangisinideyeceksiniz = new JLabel("Hangilerini Ödeyeceksiniz?");
		lblHangisinideyeceksiniz.setHorizontalAlignment(SwingConstants.CENTER);
		lblHangisinideyeceksiniz.setBounds(111, 12, 197, 15);
		frame.getContentPane().add(lblHangisinideyeceksiniz);
		
		btnGnder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BankCard bankcard = (BankCard) customer.getAccount().getCard();
				if(bankcard.getBalance() >= x) {
					bankcard.setBalance(bankcard.getBalance() - x);
				}
				else {
					JOptionPane.showMessageDialog(null, "Paranız yetersiz!");
				}
				
				x = 0;

				new MenuPage(customer);
				frame.dispose();
			}
		});
	}
}
