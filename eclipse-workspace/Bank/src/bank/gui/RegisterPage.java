package bank.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bank.data.Data;
import bank.model.user.Customer;
import bank.utils.ImageUtils;

public class RegisterPage {

	private JFrame frame;
	private JTextField registerTC;
	private JTextField registerIsim;
	private JTextField registerSoyisim;
	private JTextField registerSifre;
	private JTextField registerCinsiyet;
	private JTextField registerYas;
	private JTextField registerMeslek;
	private JButton kayitButton;
	private JTextField textField;
	private JTextField txtIsim;
	private JTextField txtMeslek;
	private JTextField txtSoyisim;
	private JTextField txtifre;
	private JTextField txtCinsiyet;
	private JTextField txtYa;

	public RegisterPage() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 616, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		registerTC = new JTextField();
		registerTC.setBounds(231, 87, 129, 29);
		frame.getContentPane().add(registerTC);
		registerTC.setColumns(10);

		registerIsim = new JTextField();
		registerIsim.setColumns(10);
		registerIsim.setBounds(231, 144, 129, 29);
		frame.getContentPane().add(registerIsim);

		registerSoyisim = new JTextField();
		registerSoyisim.setColumns(10);
		registerSoyisim.setBounds(231, 201, 129, 29);
		frame.getContentPane().add(registerSoyisim);

		registerSifre = new JTextField();
		registerSifre.setColumns(10);
		registerSifre.setBounds(231, 261, 129, 29);
		frame.getContentPane().add(registerSifre);

		registerCinsiyet = new JTextField();
		registerCinsiyet.setColumns(10);
		registerCinsiyet.setBounds(231, 322, 129, 29);
		frame.getContentPane().add(registerCinsiyet);

		registerYas = new JTextField();
		registerYas.setColumns(10);
		registerYas.setBounds(231, 369, 129, 29);
		frame.getContentPane().add(registerYas);

		registerMeslek = new JTextField();
		registerMeslek.setColumns(10);
		registerMeslek.setBounds(231, 36, 129, 29);
		frame.getContentPane().add(registerMeslek);

		kayitButton = new JButton("Bankamıza Hoşgeldiniz");
		kayitButton.setForeground(new Color(143, 240, 164));
		kayitButton.setFocusPainted(false);
		kayitButton.setBackground(new Color(145, 65, 172));
		kayitButton.setBounds(169, 432, 254, 25);
		frame.getContentPane().add(kayitButton);
		kayitButton.setFocusPainted(false);
		kayitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Customer customer1 = new Customer(registerTC.getText(), registerIsim.getText(),
							registerSoyisim.getText(), registerCinsiyet.getText(),
							Integer.valueOf(registerYas.getText()), registerMeslek.getText(), registerSifre.getText());

					
					Data.users.put(customer1.getTc(), customer1); // Kullanıcı hashmape kaydedildi
					Data.ibanDatas.put(customer1.getAccount().getIban(), customer1); // Ibanlar hashmape kaydedildi
					new LoginPage();
					frame.setVisible(false);

				} catch (Exception eeee) {
					JOptionPane.showMessageDialog(null, "Hatalı bir bilgi girdiniz!");
				}

			}
		});

		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Dialog", Font.BOLD, 12));
		textField.setText("TC:");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		textField.setBackground(new Color(38, 162, 105));
		textField.setBounds(170, 92, 33, 19);
		frame.getContentPane().add(textField);

		txtIsim = new JTextField();
		txtIsim.setEditable(false);
		txtIsim.setFont(new Font("Dialog", Font.BOLD, 12));
		txtIsim.setText("İsim:");
		txtIsim.setHorizontalAlignment(SwingConstants.RIGHT);
		txtIsim.setColumns(10);
		txtIsim.setBackground(new Color(38, 162, 105));
		txtIsim.setBounds(157, 149, 46, 19);
		frame.getContentPane().add(txtIsim);

		txtMeslek = new JTextField();
		txtMeslek.setEditable(false);
		txtMeslek.setFont(new Font("Dialog", Font.BOLD, 12));
		txtMeslek.setText("Meslek");
		txtMeslek.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMeslek.setColumns(10);
		txtMeslek.setBackground(new Color(38, 162, 105));
		txtMeslek.setBounds(143, 41, 60, 19);
		frame.getContentPane().add(txtMeslek);

		txtSoyisim = new JTextField();
		txtSoyisim.setEditable(false);
		txtSoyisim.setFont(new Font("Dialog", Font.BOLD, 12));
		txtSoyisim.setText("Soyisim:");
		txtSoyisim.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSoyisim.setColumns(10);
		txtSoyisim.setBackground(new Color(38, 162, 105));
		txtSoyisim.setBounds(133, 206, 70, 19);
		frame.getContentPane().add(txtSoyisim);

		txtifre = new JTextField();
		txtifre.setEditable(false);
		txtifre.setFont(new Font("Dialog", Font.BOLD, 12));
		txtifre.setText("Şifre:");
		txtifre.setHorizontalAlignment(SwingConstants.RIGHT);
		txtifre.setColumns(10);
		txtifre.setBackground(new Color(38, 162, 105));
		txtifre.setBounds(150, 266, 53, 19);
		frame.getContentPane().add(txtifre);

		txtCinsiyet = new JTextField();
		txtCinsiyet.setEditable(false);
		txtCinsiyet.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCinsiyet.setText("Cinsiyet");
		txtCinsiyet.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCinsiyet.setColumns(10);
		txtCinsiyet.setBackground(new Color(38, 162, 105));
		txtCinsiyet.setBounds(133, 327, 70, 19);
		frame.getContentPane().add(txtCinsiyet);

		txtYa = new JTextField();
		txtYa.setEditable(false);
		txtYa.setFont(new Font("Dialog", Font.BOLD, 12));
		txtYa.setText("Yaş");
		txtYa.setHorizontalAlignment(SwingConstants.RIGHT);
		txtYa.setColumns(10);
		txtYa.setBackground(new Color(38, 162, 105));
		txtYa.setBounds(170, 374, 33, 19);
		frame.getContentPane().add(txtYa);

		JPanel imagePanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				BufferedImage image = ImageUtils.read("hasbank.jpg");
				image = ImageUtils.resize(image, 606, 507);

				g.drawImage(image, 0, 0, this);
			}
		};
		imagePanel.setBounds(0, -16, 606, 523);
		imagePanel.setLayout(null);

		frame.getContentPane().add(imagePanel);
		imagePanel.setVisible(true);

	}
}
