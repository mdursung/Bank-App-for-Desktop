package bank.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bank.data.Data;
import bank.utils.ImageUtils;

public class LoginPage {

	private JFrame frame;
	private JTextField loginTC;
	private JTextField loginPassword;
	private JTextField a;
	private JTextField txtTc;
	private JTextField hasbank;
	private JTextField txtSektrnEnHas;

	public LoginPage() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 817, 775);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		loginTC = new JTextField();
		loginTC.setBounds(300, 176, 180, 34);
		frame.getContentPane().add(loginTC);
		loginTC.setColumns(10);

		loginPassword = new JTextField();
		loginPassword.setColumns(10);
		loginPassword.setBounds(300, 248, 180, 34);
		frame.getContentPane().add(loginPassword);

		JButton loginButton = new JButton("Giriş Yap");
		loginButton.setFont(new Font("Dialog", Font.BOLD, 12));
		loginButton.setForeground(new Color(143, 240, 164));
		loginButton.setBackground(new Color(145, 65, 172));
		loginButton.setFocusPainted(false);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (Data.users.get(loginTC.getText()).getAccount().getPassword().equals(loginPassword.getText())) {
						new MenuPage(Data.users.get(loginTC.getText()));
						frame.setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null, "Şifre Hatalı!");
					}

				} catch (Exception eeee) {
					JOptionPane.showMessageDialog(null, "Kullanıcı Bulunamadı!");
				}
			}
		});
		loginButton.setBounds(327, 307, 129, 25);
		frame.getContentPane().add(loginButton);

		JButton yeniHesapButton = new JButton("Yeni Hesap");
		yeniHesapButton.setForeground(new Color(143, 240, 164));
		yeniHesapButton.setBackground(new Color(145, 65, 172));
		yeniHesapButton.setFocusPainted(false);
		yeniHesapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterPage();
				frame.setVisible(false);
			}
		});
		yeniHesapButton.setBounds(327, 377, 129, 25);
		frame.getContentPane().add(yeniHesapButton);

		JButton yetkiliGirisButton = new JButton("Yetkili Girişi");
		yetkiliGirisButton.setForeground(new Color(143, 240, 164));
		yetkiliGirisButton.setBackground(new Color(145, 65, 172));
		yetkiliGirisButton.setBounds(327, 436, 129, 25);
		yetkiliGirisButton.setFocusPainted(false);
		yetkiliGirisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (Data.employees.get(loginTC.getText()).getAccount().getPassword().equals(loginPassword.getText())) {
						JOptionPane.showMessageDialog(null, "Şifre doğru ancak şu an yetkili girişi yapılamıyor!");

					} else {
						JOptionPane.showMessageDialog(null, "Şifre Hatalı!");
					}

				} catch (Exception eeee) {
					JOptionPane.showMessageDialog(null, "Kullanıcı Bulunamadı!");
				}
			}
		});
		frame.getContentPane().add(yetkiliGirisButton);

		a = new JTextField();
		a.setEditable(false);
		a.setFont(new Font("Dialog", Font.BOLD, 12));
		a.setHorizontalAlignment(SwingConstants.RIGHT);
		a.setText("Şifre:");
		a.setBackground(new Color(38, 162, 105));
		a.setBounds(237, 255, 51, 19);
		frame.getContentPane().add(a);
		a.setColumns(10);

		txtTc = new JTextField();
		txtTc.setEditable(false);
		txtTc.setFont(new Font("Dialog", Font.BOLD, 12));
		txtTc.setText("TC:");
		txtTc.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTc.setColumns(10);
		txtTc.setBackground(new Color(38, 162, 105));
		txtTc.setBounds(255, 183, 33, 19);
		frame.getContentPane().add(txtTc);

		hasbank = new JTextField();
		hasbank.setFont(new Font("Dialog", Font.BOLD, 17));
		hasbank.setText("HASÇİFTLİK BANK");
		hasbank.setHorizontalAlignment(SwingConstants.CENTER);
		hasbank.setColumns(10);
		hasbank.setBackground(new Color(28, 113, 216));
		hasbank.setBounds(300, 75, 180, 42);
		frame.getContentPane().add(hasbank);

		txtSektrnEnHas = new JTextField();
		txtSektrnEnHas.setText("Sektörün En Hası");
		txtSektrnEnHas.setHorizontalAlignment(SwingConstants.CENTER);
		txtSektrnEnHas.setFont(new Font("Dialog", Font.ITALIC, 11));
		txtSektrnEnHas.setColumns(10);
		txtSektrnEnHas.setBackground(new Color(28, 113, 216));
		txtSektrnEnHas.setBounds(389, 129, 158, 19);
		frame.getContentPane().add(txtSektrnEnHas);

		JButton sifreYenile = new JButton("Yeni Şifre");
		sifreYenile.setForeground(new Color(143, 240, 164));
		sifreYenile.setFont(new Font("Dialog", Font.BOLD, 12));
		sifreYenile.setFocusPainted(false);
		sifreYenile.setBackground(new Color(145, 65, 172));
		sifreYenile.setBounds(327, 486, 129, 25);
		frame.getContentPane().add(sifreYenile);
		sifreYenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = 0;

				try {
					try {
						Data.users.get(loginTC.getText()).getAccount().setPassword(loginPassword.getText());
						JOptionPane.showMessageDialog(null, "Şifre Başarıyla Değiştirildi");
					} catch(Exception eeee){
						i++;
					}
					
					try {
						Data.employees.get(loginTC.getText()).getAccount().setPassword(loginPassword.getText());
						JOptionPane.showMessageDialog(null, "Şifre Başarıyla Değiştirildi");
					} catch(Exception eeee) {
						i++;
					}

				} catch (Exception eeeee) {
				}
				
				if (i==2) {
					JOptionPane.showMessageDialog(null, "Kullanıcı Bulunamadı!");
				}
			}
		});

		JPanel imagePanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				BufferedImage image = ImageUtils.read("hasbank.jpg");
				image = ImageUtils.resize(image, 817, 775);

				g.drawImage(image, 0, 0, this);
			}
		};
		imagePanel.setBounds(0, 0, 817, 775);
		imagePanel.setLayout(null);
		imagePanel.setVisible(true);

		frame.getContentPane().add(imagePanel);

	}
}
