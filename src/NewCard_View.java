import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class NewCard_View extends JFrame {
	private Color Color_navy = new Color(0,73,118);
	private Calendar s;
	private JPanel contentPane;
	private JTextField creditLineTF;
	private JTextField securityCodeTF;
	private String securityCodeString;
	private String creditLineString;
	private ResultSet res;
	private String loginUser;

	/**
	 * Create the frame.
	 */
	public NewCard_View(ResultSet res, String loginUser,Calendar s) {
		this.loginUser = loginUser;
		this.res = res;
		this.s=s;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 395);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 72, 402, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCreditLine = new JLabel("Credit Line:");
		lblCreditLine.setBounds(10, 20, 120, 30);
		lblCreditLine.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		panel.add(lblCreditLine);
		
		creditLineTF = new JTextField();
		creditLineTF.setBounds(10, 52, 372, 45);
		creditLineTF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		creditLineTF.setColumns(10);
		panel.add(creditLineTF);
		
		JButton createBTN = new JButton("Create");
		createBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				boolean allCase = true;
				creditLineString = creditLineTF.getText();
				securityCodeString = securityCodeTF.getText();	
				if(!checkCreditLine(creditLineString)) { allCase = false; }
				if(!checkSecurityCode(securityCodeString)) { allCase = false; }
				if(allCase) { storeData(); }
				else {
					System.out.println("SFASFASDF");
				}
			}
		});
		createBTN.setBounds(124, 226, 200, 40);
		createBTN.setOpaque(true);
		createBTN.setForeground(Color.WHITE);
		createBTN.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		createBTN.setBorderPainted(false);
		createBTN.setBackground(Color_navy);
		panel.add(createBTN);
		
		JLabel lblSecurityCode = new JLabel("Security Code:");
		lblSecurityCode.setBounds(10, 109, 120, 30);
		lblSecurityCode.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		panel.add(lblSecurityCode);
		
		securityCodeTF = new JTextField();
		securityCodeTF.setBounds(10, 140, 372, 45);
		securityCodeTF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		securityCodeTF.setColumns(10);
		panel.add(securityCodeTF);
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.setForeground(Color_navy);
		btnNewButton.setBorder(new LineBorder(Color_navy, 2, true));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CheckUser_Card_View back = new CheckUser_Card_View(res, loginUser,s);
				back.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 20, 100, 35);
		contentPane.add(btnNewButton);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(126, 10, 220, 50);
		contentPane.add(logoPanel);
		
		JLabel label = new JLabel("");
		label.setAlignmentY(0.0f);
		Image bankLogo = new ImageIcon(Login_View.class.getResource("bankLogo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(bankLogo));
		
		JLabel label_1 = new JLabel("Capital");
		label_1.setForeground(new Color(0, 73, 118));
		label_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		
		JLabel label_2 = new JLabel("Two");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setForeground(new Color(0, 73, 118));
		label_2.setFont(new Font("Gabriola", Font.ITALIC, 30));
		GroupLayout gl_logoPanel = new GroupLayout(logoPanel);
		gl_logoPanel.setHorizontalGroup(
			gl_logoPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 220, Short.MAX_VALUE)
				.addComponent(label)
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGap(47)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGap(153)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
		);
		gl_logoPanel.setVerticalGroup(
			gl_logoPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addComponent(label)
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGap(21)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		logoPanel.setLayout(gl_logoPanel);
	}
	
	public boolean checkSecurityCode(String s) {
		if(s.length() != 3) { 
			JOptionPane.showMessageDialog(null,"Please enter your security code correctly"); 
			securityCodeTF.requestFocus();
			return false; 
		}
		try {int temp = Integer.parseInt(s); return true; }
		catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(null,"Please enter your security code correctly"); 
			securityCodeTF.requestFocus();
			return false; 
		}
	}
	public boolean checkCreditLine(String s) {
		try { int temp = Integer.parseInt(s); return true; }
		catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(null, "Please enter your credit line correctly");
			creditLineTF.requestFocus();
			return false; 
		}
	}
	
	public void storeData() {
		try {
			String userId = "";
			String lastID = "";
			String expDate = getDate();
			String cardNumber = "542418131000";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC", "root", "wang87067835");
			Statement stmt = con.createStatement();
			if (res != null) { userId = res.getString("id"); }
			
			
			int caredit_card = stmt.executeUpdate("INSERT INTO `credit_card_system`.`credit_cards` (`securityCode`, `creditLimit`, `remainCredit`, `expireDate`, `cardHolder`) VALUES "
					 																			+ "('"+securityCodeString+"', '"+creditLineString+"', '"+creditLineString+"', '"+expDate+"', '"+userId+"')");

			ResultSet resCardNumber = stmt.executeQuery("SELECT cardNumber FROM credit_cards WHERE cardHolder ='" +userId + "' ORDER BY createDate DESC");
			if(resCardNumber.next()) {
				lastID = resCardNumber.getString("cardNumber");
			}
			cardNumber += String.format("%04d", Integer.parseInt(lastID));
			
			String information = "Card Number: "+ cardNumber + "\n"
								+"Expire Date:    " + expDate.substring(0,7)+"    "+"\n";
			JOptionPane.showMessageDialog(null, information);
			CheckUser_Card_View back = new CheckUser_Card_View(res, loginUser,s);
			back.setVisible(true);
			dispose();
		} 
		catch (ClassNotFoundException e) {e.printStackTrace(); } 
		catch (SQLException e) {e.printStackTrace(); }	
	}
	
	public String getDate() {
		Date date = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	    String temp = ""+ft.format(date);
	    String tempMonthDay = ft.format(date).substring(4,temp.length());
	    temp = temp.substring(0,4);
	    int a = Integer.parseInt(temp);
	    a = a+5;
	    temp = a + tempMonthDay;
	    return temp;
	}
	
}
