package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import negocios.ControladorProdutos;
import negocios.beans.Produto;

import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class GuiProdutos extends JFrame {
	private ArrayList<Produto> produtosArray = new ArrayList<Produto>();
	private ControladorProdutos cp = new ControladorProdutos();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private int linha;
	private int coluna;

	String aux[] = new String[] { "Produto", "Valor" };
	DefaultTableModel dtm;

	public GuiProdutos() {
		GuiProdutosIniciar();
		produtosArray = new ArrayList<>();
		dtm = new DefaultTableModel(aux, 0);
		table.setModel(dtm);
		atualizarJTable();
		this.setLocationRelativeTo(null);
	}

	public void atualizarJTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		Object rowData[] = new Object[2];
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser Jp = new JSONParser();
		try {
			FileReader file = new FileReader("repositorioProdutos.json");
			ob = Jp.parse(file);
			jrr = (JSONArray) ob;
			file.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro.");

		}

		JSONObject jsonProdutos = new JSONObject();
		jsonProdutos.put("Produtos", jrr);
		JSONParser produtosParser = new JSONParser();

		try {

			JSONObject objProdutos = (JSONObject) produtosParser.parse(jsonProdutos.toJSONString());
			JSONArray arrayProdutos = (JSONArray) objProdutos.get("Produtos");

			for (int i = 0; i < jrr.size(); i++) {

				JSONObject products = (JSONObject) arrayProdutos.get(i);
				rowData[0] = products.get("nomeProduto").toString();
				rowData[1] = products.get("preco").toString();
				dtm.addRow(rowData);

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProdutos frame = new GuiProdutos();
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
	@SuppressWarnings("serial")
	public void GuiProdutosIniciar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Principal");
		btnNewButton.setBounds(10, 122, 95, 70);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));

		JButton btnCardpio = new JButton("Cardapio");
		btnCardpio.setBounds(10, 222, 95, 70);
		btnCardpio.setForeground(Color.WHITE);
		btnCardpio.setBackground(Color.BLACK);

		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(10, 324, 95, 70);
		btnPedidos.setForeground(Color.WHITE);
		btnPedidos.setBackground(Color.BLACK);

		JPanel panel = new JPanel();
		panel.setBounds(127, 84, 644, 139);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome Produto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(32, 16, 144, 46);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Preco Produto:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(32, 63, 144, 46);
		panel.add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setBounds(125, 25, 487, 31);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 72, 487, 31);
		panel.add(textField_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GuiProdutos.class.getResource("/Images/menor 2.png")));
		lblNewLabel.setBounds(10, 13, 123, 96);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));

		JButton btnGerenciador = new JButton("Produtos");
		btnGerenciador.setBounds(10, 443, 95, 70);
		btnGerenciador.setForeground(Color.WHITE);
		btnGerenciador.setBackground(Color.BLACK);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(127, 222, 644, 108);
		panel_1.setLayout(null);

		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Produto p = new Produto(Double.parseDouble(textField_1.getText()), textField.getText());
				produtosArray.add(p);
				cp.cadastrar(p);
				JSONObject obj = new JSONObject();
				JSONArray jrr = new JSONArray();
				JSONParser jp = new JSONParser();

				try {
					FileReader file = new FileReader("repositorioProdutos.json");
					jrr = (JSONArray) jp.parse(file);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
				}
				obj.put("nomeProduto", textField.getText());
				obj.put("preco", textField_1.getText());
				jrr.add(obj);
				dtm.setRowCount(0);
				int f = 0;
				for (int i = 0; i < produtosArray.size(); i++) {

					Object[] objs = { produtosArray.get(i).getNomeProduto(), produtosArray.get(i).getPreco() };
					dtm.addRow(objs);
					f++;
					if (f > 1) {
						dtm.removeRow(0);
					}
				}
				// Resetando textos.
				textField.setText("");
				textField_1.setText("");
				atualizarJTable();
				try {

					FileWriter file = new FileWriter("repositorioProdutos.json");
					file.write(jrr.toJSONString());
					file.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
				}
				JOptionPane.showMessageDialog(null, "Produto adicionado.");

			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(10, 34, 115, 32);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Deletar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int res = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(getParent(), "Deletar Produto?", "Deletar", res);
				if (dialogResult == 0) {
					JSONArray jrr = new JSONArray();
					Object ob = null;
					JSONParser Jp = new JSONParser();
					try {
						FileReader file = new FileReader("repositorioProdutos.json");
						ob = Jp.parse(file);
						jrr = (JSONArray) ob;
						file.close();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro ao buscar no repositorio.");
					}

					JSONObject obj = new JSONObject();
					int size = jrr.size();
					obj.put("nomeProduto", textField.getText());
					obj.put("preco", textField_1.getText());

					for (int i = 0; i < jrr.size(); i++) {
						if (obj.equals(jrr.get(i))) {

							try {
								FileWriter file = new FileWriter("repositorioProdutos.json");
								jrr.remove(i);
								file.write(jrr.toJSONString());
								file.close();
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
							}
							JOptionPane.showMessageDialog(null, "Produto Removido.");

						}
					}
					dtm.removeRow(linha);
				}

			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(Color.BLACK);
		btnNewButton_1_1.setBounds(180, 34, 115, 32);
		panel_1.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Atualizar");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String updatednomeProduto = textField.getText();
				String updatedprecoProduto = textField_1.getText();
				

			}
		});
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setBackground(Color.BLACK);
		btnNewButton_1_2.setBounds(345, 34, 115, 32);
		panel_1.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("Procurar");
		btnNewButton_1_3.setBackground(Color.BLACK);
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setBounds(510, 34, 115, 32);
		panel_1.add(btnNewButton_1_3);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton);
		contentPane.add(btnCardpio);
		contentPane.add(btnPedidos);
		contentPane.add(btnGerenciador);
		contentPane.add(panel_1);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 340, 644, 218);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				linha = table.getSelectedRow();
				coluna = table.getColumnCount();
				textField.setText(dtm.getValueAt(linha, 0).toString());
				textField_1.setText(dtm.getValueAt(linha, 1).toString());

			}
		});
		table.setShowGrid(false);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Produto", "Valor" }) {
			Class[] columnTypes = new Class[] { String.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}
}
