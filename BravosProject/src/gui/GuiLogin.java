package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import negocios.ControladorClientes;
import negocios.beans.Cliente;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class GuiLogin extends JFrame {
	ControladorClientes cc = new ControladorClientes();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public void ControladorClientes() {

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLogin frame = new GuiLogin();

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
	public GuiLogin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 402);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 177, 365);
		contentPane.add(panel);

		textField = new JTextField();
		textField.setBounds(309, 66, 143, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setBounds(309, 142, 143, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel.setBounds(309, 43, 45, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1.setBounds(309, 119, 45, 13);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JSONArray jrr = new JSONArray();
				Object ob = null;
				JSONParser Jp = new JSONParser();

				try {
					FileReader file = new FileReader("repositorioLogins.json");
					ob = Jp.parse(file);
					jrr = (JSONArray) ob;
					file.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar repositorio");
				}

				JSONObject obj = new JSONObject();
				int size = jrr.size();
				obj.put("Username", textField.getText());
				obj.put("Password", textField_1.getText());

				for (int i = 0; i < size; i++) {
					if (obj.equals(jrr.get(i))) {
						JOptionPane.showMessageDialog(null, "Logado com sucesso.");
						GuiProdutos guip = new GuiProdutos();
						guip.setVisible(true);

					} else if (i == size) {
						JOptionPane.showMessageDialog(null, "Dados incorretos.");
					}
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(340, 196, 85, 21);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente c = new Cliente();
				c.setNome("name");
				c.setEndereco("adress");
				c.setLogin(textField.getText());
				c.setSenha(textField_1.getText());
				cc.cadastrar(c);

				JSONObject obj = new JSONObject();
				JSONArray jrr = new JSONArray();
				JSONParser jp = new JSONParser();
				try {
					FileReader file = new FileReader("repositorioLogins.json");
					jrr = (JSONArray) jp.parse(file);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
				}
				int size = jrr.size();
				if (size == 0) {
					obj.put("Username", cc.procurar(c).getLogin());
					obj.put("Password", cc.procurar(c).getSenha());
					jrr.add(obj);
					JOptionPane.showMessageDialog(null, "Conta adicionada.");
				} else {
					obj.put("Username", cc.procurar(c).getLogin());
					obj.put("Password", cc.procurar(c).getSenha());
					for (int i = 0; i < size; i++) {
						if (jrr.get(i).equals(obj)) {
							JOptionPane.showMessageDialog(null, "Conta já existe.");
						} else if (i == size - 1) {
							JOptionPane.showMessageDialog(null, "Conta adicionada.");
							jrr.add(obj);
						}
					}
				}

				try {
					FileWriter file = new FileWriter("repositorioLogins.json");
					file.write(jrr.toJSONString());
					file.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
				}
				if (size == 0) {

				} else {
					for (int i = 0; i < size; i++) {
						if (jrr.get(i).equals(obj)) {

						} else if (i == size - 1) {
							JOptionPane.showMessageDialog(null, "Salvo no repositório.");

						}
					}

				}

			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(340, 239, 85, 21);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JSONArray jrr = new JSONArray();
				Object ob = null;
				JSONParser Jp = new JSONParser();
				try {
					FileReader file = new FileReader("repositorioLogins.json");
					ob = Jp.parse(file);
					jrr = (JSONArray) ob;
					file.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar no repositorio.");
				}

				JSONObject obj = new JSONObject();
				int size = jrr.size();
				obj.put("Username", textField.getText());
				obj.put("Password", textField_1.getText());
				for (int i = 0; i < size; i++) {
					if (obj.equals(jrr.get(i))) {
						System.out.println("1");
						try {
							FileWriter file = new FileWriter("repositorioLogins.json");
							jrr.remove(i);
							file.write(jrr.toJSONString());
							file.close();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
						}
						JOptionPane.showMessageDialog(null, "Usuario removido.");
						break;
					} else if (i == size - 1) {
						JOptionPane.showMessageDialog(null, "Dados incorretos.");
					}
				}
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(340, 278, 85, 21);
		contentPane.add(btnNewButton_2);
	}
}
