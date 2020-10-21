package gui;

import java.io.FileReader;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;

public class InterfaceGui extends javax.swing.JFrame {

	public InterfaceGui() {
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); 
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("JSON Login");

		jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); 
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Username");

		jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); 
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Password");

		jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); 
		jButton1.setText("Login");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); 
		jButton2.setText("Register");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); 
		jButton3.setText("Delete");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

		jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(155, 155, 155).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(30, 30, 30)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 223,
												Short.MAX_VALUE)
										.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(66, 66, 66)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jTextField1).addComponent(jTextField2,
												javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
						.addGroup(layout.createSequentialGroup().addGap(85, 85, 85)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(45, 45, 45)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(50, 50, 50).addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(100, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(35, 35, 35)
				.addComponent(
						jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(50, 50, 50)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
						.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(33, 33, 33)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(58, 58, 58)));

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// botão de registrar
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		JSONParser jp = new JSONParser();
		try {
			FileReader file = new FileReader("repositorioLogins.json");
			jrr = (JSONArray) jp.parse(file);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error occured");
		}

		obj.put("Username", jTextField1.getText());
		obj.put("Password", jTextField2.getText());
		jrr.add(obj);
		try {
			FileWriter file = new FileWriter("repositorioLogins.json");
			file.write(jrr.toJSONString());
			file.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error occured");
		}
		JOptionPane.showMessageDialog(null, "Data Saved");
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { // botão de login
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser Jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("repositorioLogins.json");
			ob = Jp.parse(file);
			jrr = (JSONArray) ob;
			file.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Occured While fetching");
		}

		JSONObject obj = new JSONObject();
		int size = jrr.size();
		obj.put("Username", jTextField1.getText());
		obj.put("Password", jTextField2.getText());

		for (int i = 0; i < size; i++) {
			if (obj.equals(jrr.get(i))) {
				JOptionPane.showMessageDialog(null, "Password matched");
				break;
			} else if (i == size - 1) {
				JOptionPane.showMessageDialog(null, "Incorrect User/Password!");
			}
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { // botão de delet
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser Jp = new JSONParser();
		try {
			FileReader file = new FileReader("repositorioLogins.json");
			ob = Jp.parse(file);
			jrr = (JSONArray) ob;
			file.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Occured While fetching");
		}

		JSONObject obj = new JSONObject();
		int size = jrr.size();
		obj.put("Username", jTextField1.getText());
		obj.put("Password", jTextField2.getText());

		for (int i = 0; i < size; i++) {
			if (obj.equals(jrr.get(i))) {
				try {
					FileWriter file = new FileWriter("repositorioLogins.json");
					jrr.remove(i);
					file.write(jrr.toJSONString());
					file.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error occured");
				}
				JOptionPane.showMessageDialog(null, "Data Removed");
				break;
			} else if (i == size - 1) {
				JOptionPane.showMessageDialog(null, "Incorrect User/Password!");
			}
		}
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(InterfaceGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(InterfaceGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(InterfaceGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(InterfaceGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InterfaceGui().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;

}