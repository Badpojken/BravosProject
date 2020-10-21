package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginScreen extends JFrame {
	// Consegui desbugar!

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(2, 10, 217, 700);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(364, 138, 92, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(350, 241, 92, 28);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField(); // texto de login
		textField_1.setColumns(10);
		textField_1.setBounds(270, 189, 227, 42);
		contentPane.add(textField_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(270, 279, 227, 42);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				String uname = textField_1.getText();
				String psd = passwordField.getText();

				if (uname.equals("name") && psd.equals("password")) {

					JOptionPane.showMessageDialog(contentPane, "logou corretamente.");
					

				} else {
					JOptionPane.showMessageDialog(contentPane, "dados incorretos.");
				}

			}
		});
		btnNewButton.setBounds(327, 331, 129, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBounds(327, 399, 129, 42);
		contentPane.add(btnNewButton_1);

	}
}
