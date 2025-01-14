package bank.gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import bank.model.cards.BankCard;
import bank.model.cards.Card;
import bank.model.cards.CreditCard;
import bank.model.user.Customer;

public class MenuCards {

    private JFrame frame;
    private Customer customer;

    public MenuCards(Customer customer) {
        this.customer = customer;
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(205, 171, 143));
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        List<Card> cards = customer.getAccount().getCards();
        String[] columnNames = {"Kart Numarası", "Bakiye/Limit", "CVC", "Tarih"};
        Object[][] data = new Object[cards.size()][4];

        for (int i = 0; i < cards.size(); i++) {
            try {
                BankCard card = (BankCard) cards.get(i);
                data[i][0] = card.getCardNumber();
                data[i][1] = card.getBalance();
                data[i][2] = card.getCvc();
                data[i][3] = card.getLastDate();
            } catch(Exception e) {
            }
            try {
                CreditCard card = (CreditCard) cards.get(i);
                data[i][0] = card.getCardNumber();
                data[i][1] = card.getLimit();
                data[i][2] = card.getCvc();
                data[i][3] = card.getLastDate();
            } catch(Exception e) {
            }
        }

        JTable table = new JTable(data, columnNames);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 580, 350);

        frame.getContentPane().add(scrollPane);
                
        JButton logoutButton = new JButton("Çıkış Yap");
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		new MenuPage(customer);
        	}
        });
        frame.getContentPane().add(logoutButton, "South");
    }
}
