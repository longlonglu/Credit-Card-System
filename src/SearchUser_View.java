import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchUser_View extends JFrame {

	private JPanel contentPane;
	private JTextField firstnameTextField;
	private JTextField lastnameTextField;
	private JPasswordField ssn1TextField;
	private JPasswordField ssn2TextField;
	private JPasswordField ssn3TextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Modify_User_View frame = new Modify_User_View();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SearchUser_View(String loginUser,Calendar s) {
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 453);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(164, 10, 220, 50);
		contentPane.add(logoPanel);
		
		JLabel lblLogo = new JLabel("");
		Image bankLogo = new ImageIcon(Login_View.class.getResource("bankLogo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(bankLogo));
		lblLogo.setAlignmentY(0.0f);
		
		JLabel lblCapital = new JLabel("Capital");
		lblCapital.setForeground(new Color(0, 73, 118));
		lblCapital.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTwo = new JLabel("Two");
		lblTwo.setVerticalAlignment(SwingConstants.TOP);
		lblTwo.setForeground(new Color(0, 73, 118));
		lblTwo.setFont(new Font("Gabriola", Font.ITALIC, 30));
		GroupLayout gl_logoPanel = new GroupLayout(logoPanel);
		gl_logoPanel.setHorizontalGroup(
			gl_logoPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 220, Short.MAX_VALUE)
				.addComponent(lblLogo)
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGap(47)
					.addComponent(lblCapital, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGap(153)
					.addComponent(lblTwo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
		);
		gl_logoPanel.setVerticalGroup(
			gl_logoPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addComponent(lblLogo)
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCapital, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblTwo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		logoPanel.setLayout(gl_logoPanel);
		
		JLabel lblLetsFindOur = new JLabel("Let's find our customer");
		lblLetsFindOur.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetsFindOur.setForeground(Color.GRAY);
		lblLetsFindOur.setFont(new Font("Arial", Font.BOLD, 25));
		lblLetsFindOur.setBounds(112, 70, 300, 37);
		contentPane.add(lblLetsFindOur);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(90, 129, 363, 196);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setForeground(Color.DARK_GRAY);
		lblFirstname.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblFirstname.setBounds(10, 10, 113, 25);
		panel.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Last Name");
		lblLastname.setForeground(Color.DARK_GRAY);
		lblLastname.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblLastname.setBounds(190, 10, 130, 25);
		panel.add(lblLastname);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		firstnameTextField.setColumns(10);
		firstnameTextField.setBounds(10, 41, 160, 40);
		panel.add(firstnameTextField);
		
		lastnameTextField = new JTextField();
		lastnameTextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		lastnameTextField.setColumns(10);
		lastnameTextField.setBounds(190, 41, 160, 40);
		panel.add(lastnameTextField);
		
		JLabel lblSSN = new JLabel("Social Security Number / ITIN");
		lblSSN.setForeground(Color.DARK_GRAY);
		lblSSN.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblSSN.setBounds(10, 100, 255, 20);
		panel.add(lblSSN);
		
		ssn1TextField = new JPasswordField();
		ssn1TextField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {if (ssn1TextField.getPassword().length == 3) { ssn2TextField.requestFocus(); } }

			@Override
			public void removeUpdate(DocumentEvent e) {}

			@Override
			public void changedUpdate(DocumentEvent e) {	}
		});
		ssn1TextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		ssn1TextField.setBounds(10, 128, 100, 40);
		panel.add(ssn1TextField);
		
		JLabel label_3 = new JLabel("-");
		label_3.setBounds(113, 140, 10, 15);
		panel.add(label_3);
		
		ssn2TextField = new JPasswordField();
		ssn2TextField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {if (ssn2TextField.getPassword().length == 2) { ssn3TextField.requestFocus(); } }

			@Override
			public void removeUpdate(DocumentEvent e) {}

			@Override
			public void changedUpdate(DocumentEvent e) {	}
		});
		ssn2TextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		ssn2TextField.setBounds(125, 128, 80, 40);
		panel.add(ssn2TextField);
		
		JLabel label_4 = new JLabel("-");
		label_4.setBounds(207, 140, 10, 15);
		panel.add(label_4);
		
		ssn3TextField = new JPasswordField();
		ssn3TextField.setFont(new Font("Dialog", Font.PLAIN, 17));
		ssn3TextField.setBounds(220, 128, 130, 40);
		panel.add(ssn3TextField);
		
		JButton btnBack = new JButton("< Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ViewUser_Home back = new ViewUser_Home(loginUser,s);
				back.setVisible(true);
				dispose();
			}
		});
		btnBack.setOpaque(false);
		btnBack.setForeground(new Color(0, 73, 118));
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnBack.setFocusable(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(new Color(0, 73, 118), 2, true));
		btnBack.setBounds(10, 10, 100, 40);
		contentPane.add(btnBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {	
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC", "root", "wang87067835");
					char[] ssn1 = ssn1TextField.getPassword();
					char[] ssn2 = ssn2TextField.getPassword();
					char[] ssn3 = ssn3TextField.getPassword();
					StringBuilder ssn = new StringBuilder();
					String firstName = firstnameTextField.getText();
					String lastName = lastnameTextField.getText();
					for (int i=0; i<ssn1.length; i++) {
						ssn.append(ssn1[i]);
					}
					for (int i=0; i<ssn2.length; i++) {
						ssn.append(ssn2[i]);
					}
					for (int i=0; i<ssn3.length; i++) {
						ssn.append(ssn3[i]);
					}
					//System.out.println(ssn.toString()+" "+firstName + " " + lastName);
					Statement custStmt = con.createStatement();
					ResultSet custRes = custStmt.executeQuery("SELECT * FROM users WHERE SSN ='" +ssn + "' AND firstName = '"+firstName+"' AND lastName = '"+lastName+"'");
					if (custRes.next()) {
						System.out.println(loginUser);
						CheckUser_Card_View newFrame = new CheckUser_Card_View(custRes, loginUser,s);
						newFrame.setVisible(true);
						dispose();
					}
					else {
						showMessage("Sorry, we can not find this customer"); 
						ssn1TextField.setText("");
						ssn2TextField.setText("");
						ssn3TextField.setText("");
						ssn1TextField.requestFocus();
					}
					//System.out.println("ends");
				}
				catch (SQLException e1) { 
					showMessage("Sorry, we can not find this customer"); 
					ssn1TextField.setText("");
					ssn2TextField.setText("");
					ssn3TextField.setText("");
					ssn1TextField.requestFocus();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnSearch.setOpaque(true);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnSearch.setBorderPainted(false);
		btnSearch.setBackground(new Color(0, 73, 118));
		btnSearch.setBounds(164, 341, 204, 40);
		contentPane.add(btnSearch);
	}	

//	public ResultSet data() {
//		try {	
//			String SSN = "";
//			if(checkSSN(textField.getText())) { SSN = textField.getText(); }
//			else {return null;}
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC", "root", "19990520vA");
//			Statement stmt = con.createStatement();
//			ResultSet res = stmt.executeQuery("SELECT * FROM users WHERE SSN ='" +SSN + "'");
//			if(res.next()) { return res; }
//			else { return null; }	
//		} 
//		catch (ClassNotFoundException e) {} 
//	    catch (SQLException e) { showMessage("Sorry, we can not find this society security number"); }
//		return null;
//	}
//	
//	public boolean checkSSN(String s) {
//		if(s.length() != 9) { showMessage("Please enter your society security number correctly"); return false; }
//		try { int temp = Integer.parseInt(s); return true; }
//		catch(NumberFormatException e) { showMessage("Please enter your society security number correctly"); return false; }
//	}
//	
	public void showMessage(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
}
