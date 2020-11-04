import java.awt.EventQueue;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CreateUser_View extends JFrame{
	private Color Color_navy = new Color(0,73,118);
	private Color Color_lighterNavy = new Color(26, 88, 134);
	private boolean finalDicision = true;
	private String userNameString;
	private String passwordString;
	private String firstNameString;
	private String lastNameString;
	private String addressString;
	private String creditLineString;
	private String ssnString;
	private String securityCodestring;
	private String monthString;
	private String dayString;
	private String yearString;
	public JFrame frame;
	private String dateOfBirth;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JPasswordField ssn1TF;
	private JPasswordField ssn2TF;
	private JPasswordField ssn3TF;
	private JLabel label;
	private JTextField userNameTF;
	private JPasswordField passwordTF;
	private JTextField addressTF;
	private JTextField creditLineTF;
	private JTextField securityCodeTF;
	private JComboBox<Object> month;
	private JComboBox<Object> day;
	private JComboBox<Object> year;
	String monthList[] = {"Month", "January", "February", "March", 
	        "April", "May", "June", "July", "August",  
	        "September", "October", "Novemeber", "December" }; 
	String dayList[] = {"Day","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21"
			,"22","23","24","25","26","27","28","29","30","31"};
	String yearList[] = {"Year","1940","1941","1942","1943","1944","1945","1946","1947","1948","1949","1950","1951","1952",
			"1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967",
			"1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982",
			"1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997",
			"1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012",
			"2013","2014","2015","2016","2017","2018",};
	private JPanel logoPanel;
	private JLabel lblLogo;
	private JLabel lblCapital;
	private JLabel lblTwo;
	private JPanel creditlinePanel;
	private JLabel label_1;

	/**
	 * Initialize the contents of the frame.
	 */
	public CreateUser_View(String name,Calendar s) {
		frame = new JFrame("Create User");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 100, 113, 25);
		frame.getContentPane().add(lblNewLabel);
		
		firstNameTF = new JTextField();
		firstNameTF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		firstNameTF.setBounds(20, 120, 160, 40);
		frame.getContentPane().add(firstNameTF);
		firstNameTF.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.DARK_GRAY);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblLastName.setBounds(200, 100, 130, 25);
		frame.getContentPane().add(lblLastName);
		
		lastNameTF = new JTextField();
		lastNameTF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lastNameTF.setColumns(10);
		lastNameTF.setBounds(200, 120, 160, 40);
		frame.getContentPane().add(lastNameTF);
		
		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number / ITIN");
		lblSocialSecurityNumber.setForeground(Color.DARK_GRAY);
		lblSocialSecurityNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSocialSecurityNumber.setBounds(20, 169, 255, 20);
		frame.getContentPane().add(lblSocialSecurityNumber);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setBounds(123, 202, 10, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		ssn1TF = new JPasswordField();
		ssn1TF.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {if (ssn1TF.getPassword().length == 3) { ssn2TF.requestFocus(); } }

			@Override
			public void removeUpdate(DocumentEvent e) {}

			@Override
			public void changedUpdate(DocumentEvent e) {	}
		});
		ssn1TF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		ssn1TF.setBounds(20, 190, 100, 40);
		frame.getContentPane().add(ssn1TF);
		
		ssn2TF = new JPasswordField();
		ssn2TF.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if (ssn2TF.getPassword().length == 2) {ssn3TF.requestFocus();}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {	}
			@Override
			public void changedUpdate(DocumentEvent e) {}
		});
		ssn2TF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		ssn2TF.setBounds(135, 190, 80, 40);
		frame.getContentPane().add(ssn2TF);
		
		ssn3TF = new JPasswordField();
		ssn3TF.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if (ssn3TF.getPassword().length == 4) {	}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {}
			@Override
			public void changedUpdate(DocumentEvent e) {}	
		});
		ssn3TF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		ssn3TF.setBounds(230, 190, 130, 40);
		frame.getContentPane().add(ssn3TF);
		
		label = new JLabel("-");
		label.setBounds(217, 202, 10, 15);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Date Of Birth");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(18, 240, 113, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(20, 315, 113, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		userNameTF = new JTextField();
		userNameTF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		userNameTF.setColumns(10);
		userNameTF.setBounds(20, 335, 340, 40);
		frame.getContentPane().add(userNameTF);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(20, 387, 100, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(20, 404, 340, 40);
		frame.getContentPane().add(passwordTF);
		
		JLabel lblNewLabel_5 = new JLabel("Billing Address");
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(20, 455, 130, 25);
		frame.getContentPane().add(lblNewLabel_5);
		
		addressTF = new JTextField();
		addressTF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		addressTF.setColumns(10);
		addressTF.setBounds(20, 475, 340, 40);
		frame.getContentPane().add(addressTF);
		
		JLabel lblCreditLine = new JLabel("Credit Line");
		lblCreditLine.setForeground(Color.DARK_GRAY);
		lblCreditLine.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblCreditLine.setBounds(20, 527, 130, 25);
		frame.getContentPane().add(lblCreditLine);
		
		creditlinePanel = new JPanel();
		creditlinePanel.setBorder(new LineBorder(new Color(128, 128, 128)));
		creditlinePanel.setBackground(Color.WHITE);
		creditlinePanel.setBounds(20, 551, 130, 40);
		frame.getContentPane().add(creditlinePanel);
		creditlinePanel.setLayout(null);
		
		creditLineTF = new JTextField();
		creditLineTF.setBorder(null);
		creditLineTF.setBounds(20, 2, 109, 37);
		creditlinePanel.add(creditLineTF);
		creditLineTF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		creditLineTF.setColumns(10);
		
		label_1 = new JLabel("$");
		label_1.setForeground(Color.GRAY);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial", Font.PLAIN, 28));
		label_1.setBounds(0, 0, 20, 40);
		creditlinePanel.add(label_1);
		
		JButton btnCreateBTN = new JButton("Create");
		btnCreateBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				boolean allCase = true;
				finalDicision = true;
				storeData();
				if(userNameString==null || userNameString.length() == 0) {
					JOptionPane.showMessageDialog(null, "Please enter your username");
					userNameTF.requestFocus();
					allCase = false;
				}
				else if(firstNameString==null || firstNameString.length() == 0) {
					JOptionPane.showMessageDialog(null, "Please enter your first name");
					firstNameTF.requestFocus();	
					allCase = false;
				}
				else if(lastNameString==null || lastNameString.length() == 0) {
					JOptionPane.showMessageDialog(null, "Please enter your last name");
					lastNameTF.requestFocus();
					allCase = false;	
				}
				else if(addressString==null || addressString.length() == 0) {
					JOptionPane.showMessageDialog(null, "Please enter your billing address");
					addressTF.requestFocus();	
					allCase = false;
				}
				else if(creditLineString==null || creditLineString.length() == 0 || !checkIsInteger(creditLineString)) {
					JOptionPane.showMessageDialog(null, "Please enter your credit line");
					creditLineTF.requestFocus();
					allCase = false;	
				}
				else if(ssnString==null || ssnString.length() !=9 || !checkIsInteger(ssnString)) {
					JOptionPane.showMessageDialog(null, "Please enter your society security number correctly");
					ssn1TF.requestFocus();	
					allCase = false;
				}
				else if(securityCodestring==null || securityCodestring.length() != 3 || !checkIsInteger(securityCodestring)) {
					JOptionPane.showMessageDialog(null, "Please enter your security code correctly");
					securityCodeTF.setText("");
					securityCodeTF.requestFocus();
					allCase = false;	
				}
				else if(passwordString == null) {
					JOptionPane.showMessageDialog(null, "Please enter valid password (at least 6 characters)");
					passwordTF.requestFocus();	
					allCase = false;
					return;
				}
				if(allCase) {
					writeDataIntoDatabase();
					clean();
				}
				if(allCase && finalDicision) {
					ViewUser_Home openFrame = new ViewUser_Home(name,s);
					openFrame.setVisible(true);
					frame.dispose();
				}
				btnCreateBTN.setBackground(Color_lighterNavy);
			}
			@Override
			public void mouseReleased(MouseEvent e) {btnCreateBTN.setBackground(Color_navy); }
		});
		btnCreateBTN.setBorderPainted(false);
		btnCreateBTN.setOpaque(true);
		btnCreateBTN.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnCreateBTN.setBounds(75, 610, 204, 40);
		btnCreateBTN.setBackground(Color_navy);
		btnCreateBTN.setForeground(Color.WHITE);
		frame.getContentPane().add(btnCreateBTN);
		
		JButton btnBack = new JButton("< Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clean();
				ViewUser_Home openFrame = new ViewUser_Home(name,s);
				openFrame.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(0, 73, 118), 2, true));
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnBack.setBounds(10, 20, 100, 35);
		btnBack.setForeground(Color_navy);
		btnBack.setContentAreaFilled(false);
		frame.getContentPane().add(btnBack);
		
		JLabel lblSecurityCode = new JLabel("Security Code(CCV)");
		lblSecurityCode.setForeground(Color.DARK_GRAY);
		lblSecurityCode.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSecurityCode.setBounds(200, 527, 160, 25);
		frame.getContentPane().add(lblSecurityCode);
		
		securityCodeTF = new JTextField();
		securityCodeTF.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		securityCodeTF.setColumns(10);
		securityCodeTF.setBounds(200, 551, 121, 40);
		frame.getContentPane().add(securityCodeTF);
	
		
		month = new JComboBox<Object>(monthList);
		month.setBorder(new LineBorder(Color.GRAY, 2, true));
		month.setEditable(true);
		month.setBackground(Color.WHITE);
		month.setFont(new Font("Arial", Font.PLAIN, 15));
		month.setForeground(Color.BLACK);
		month.setBounds(20, 260, 100, 40);
		frame.getContentPane().add(month);
		month.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					String selectedItem = (String)e.getItem();
					if (selectedItem.contains("January") || selectedItem.contains("March") || selectedItem.contains("May") ||
							selectedItem.contains("Junly") || selectedItem.contains("August") || selectedItem.contains("October") || selectedItem.contains("December")) {
						dayList = new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
						day.setModel(new DefaultComboBoxModel<Object>(dayList));
					}
					else if (selectedItem.contains("February")) {
						dayList = new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};
						day.setModel(new DefaultComboBoxModel<Object>(dayList));
					}
					else {
						dayList = new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
						day.setModel(new DefaultComboBoxModel<Object>(dayList));
					}
				}
			}
		});
		
		day = new JComboBox<Object>(dayList);
		day.setForeground(Color.BLACK);
		day.setBorder(new LineBorder(Color.GRAY, 2, true));
		day.setEditable(true);
		day.setBackground(Color.WHITE);
		day.setFont(new Font("Arial", Font.PLAIN, 15));
		day.setBounds(135, 260, 100, 40);
		frame.getContentPane().add(day);
		
		year = new JComboBox<Object>(yearList);
		year.setForeground(Color.BLACK);
		year.setEditable(true);
		year.setBackground(Color.WHITE);
		year.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		year.setBounds(247, 260, 112, 40);
		frame.getContentPane().add(year);
		
		logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(126, 10, 220, 50);
		frame.getContentPane().add(logoPanel);
		
		lblLogo = new JLabel("");
		Image bankLogo = new ImageIcon(Login_View.class.getResource("bankLogo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(bankLogo));
		lblLogo.setAlignmentY(0.0f);
		
		lblCapital = new JLabel("Capital");
		lblCapital.setForeground(new Color(0, 73, 118));
		lblCapital.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		
		lblTwo = new JLabel("Two");
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
	}
	
	
	  public String getMd5(String input)  {
		  	if(input.length() < 6) { return null;}
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5"); 
	            byte[] messageDigest = md.digest(input.getBytes()); 
	            BigInteger no = new BigInteger(1, messageDigest);  
	            String hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	            return hashtext; 
	        }   catch (NoSuchAlgorithmException e) { throw new RuntimeException(e); } 
	    } 
	  
	  public void storeData() {
		    userNameString = userNameTF.getText();
			firstNameString = firstNameTF.getText();
			lastNameString = lastNameTF.getText();
			addressString = addressTF.getText();
			creditLineString = creditLineTF.getText();
			passwordString = "";
			securityCodestring = securityCodeTF.getText();
			char[] tempPassword = passwordTF.getPassword();
			monthString = (String) month.getSelectedItem();
			dayString = (String) day.getSelectedItem();
			yearString = (String) year.getSelectedItem();
			switch(monthString) {
			case "January": 
				monthString = "01";
				break;
			case "February": 
				monthString = "02";
				break;
			case "March": 
				monthString = "03";
				break;
			case "April": 
				monthString = "04";
				break;
			case "May": 
				monthString = "05";
				break;
			case "June": 
				monthString = "06";
				break;
			case "July": 
				monthString = "07";
				break;
			case "August": 
				monthString = "08";
				break;
			case "September": 
				monthString = "09";
				break;
			case "October": 
				monthString = "10";
				break;
			case "Novemeber": 
				monthString = "11";
				break;
			case "December": 
				monthString = "12";
				break;
			}
			dateOfBirth = yearString + "-" + monthString + "-" + dayString;
			for(int i = 0; i < tempPassword.length; i++) {passwordString += tempPassword[i];}
			passwordString = getMd5(passwordString);
			ssnString = "";
			char[] tempSSN1 = ssn1TF.getPassword();
			char[] tempSSN2 = ssn2TF.getPassword();
			char[] tempSSN3 = ssn3TF.getPassword();
			for(int i = 0; i < tempSSN1.length; i++) {ssnString += tempSSN1[i];}
			for(int i = 0; i < tempSSN2.length; i++) {ssnString += tempSSN2[i];}		
			for(int i = 0; i < tempSSN3.length; i++) {ssnString += tempSSN3[i];}
	  }
	  
	  public int writeDataIntoDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC", "root", "wang87067835");
			Statement stmt = con.createStatement();
			String password = this.passwordString;
			String firstName = this.firstNameString;
			String lastName = this.lastNameString;
			String address = this.addressString;
			String securityCode = this.securityCodestring;
			String ssn = this.ssnString;
			String DOB = this.dateOfBirth;
			DOB += " 00:00:00";
			String userName = this.userNameString;
			String creditLine = creditLineString;
			Date date = new Date();
		    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		    String temp = ""+ft.format(date);
		    String tempMonthDay = ft.format(date).substring(4,temp.length());
		    temp = temp.substring(0,4);
		    int a = Integer.parseInt(temp);
		    a = a+5;
		    temp = a + tempMonthDay;
			String expDate = temp;
			String newId = "";
			String prefix = "542418131000";
			stmt.executeUpdate("INSERT INTO `credit_card_system`.`users` (`lastName`, `firstName`, `billAddr`, `accountID`, `password`, `superuser`,`SSN`,`DOB`) VALUES "
					 																+"('"+lastName+"', '"+firstName+"', '"+address+"', '"+userName+"', '"+password+"', '0', '"+ssn+"', '"+DOB+"')");

			ResultSet res = stmt.executeQuery("SELECT id FROM users WHERE SSN ='" +ssn + "'");
			if (res.next()) {newId = res.getString("id");}	
			Statement cardStmt = con.createStatement();
			ResultSet cardRes = cardStmt.executeQuery("SELECT cardNumber FROM credit_cards WHERE cardHolder ='" +newId + "'");
			if (cardRes.next()) {}
			stmt.executeUpdate("INSERT INTO `credit_card_system`.`credit_cards` (`securityCode`, `creditLimit`, `remainCredit`, `expireDate`, `cardHolder`) VALUES "
																							 + "('"+securityCode+"', '"+creditLine+"', '"+creditLine+"', '"+expDate+"', '"+newId+"')");
			Statement newCardStmt = con.createStatement();
			ResultSet newCardRes = cardStmt.executeQuery("SELECT cardNumber FROM credit_cards WHERE cardHolder ='" +newId + "' ORDER BY createDate DESC" );
			String lastId = null;
			if (newCardRes.next()) {
				lastId = newCardRes.getString("cardNumber");
				lastId = String.format("%04d", Integer.parseInt(lastId));
			}
//			cardNumber = String.format("%04d", Integer.parseInt(cardNumber));
//			System.out.println(cardNumber);
			 String answer = "Card Number: "+ prefix+lastId + "\n"
				        + "Exprie Date: "+ expDate.substring(0,7) + "\n"
				        + "Name: "+firstName + " " + lastName + "\n"
				        + "CCV: " + securityCode ;
			 
			 JOptionPane.showMessageDialog(null, answer); 
		} catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Duplicated Info in our record");
			firstNameTF.requestFocus();
			finalDicision = false;
			return 0;
		 } 
		catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Invalide Date of birth");
			finalDicision=false;
					
					return 0;
				       
				       
				       } 
		catch (ClassNotFoundException e) {e.printStackTrace();return 0;}
		  return 0;
	  }
	  public boolean checkIsInteger(String s) {
		  try {
			  Integer.parseInt(s);
			  return true;
		  }
		  catch(NumberFormatException e) { 
			  System.out.println("not integer");return false;
		  }
	  }
	  
	  public void clean() {
		userNameString = "";
		passwordString = "";
		firstNameString = "";
		lastNameString = "";
		addressString = "";
		creditLineString = "";
		ssnString = "";
		securityCodestring = "";
		monthString = "";
		dayString = "";
		yearString = "";
		dateOfBirth = "";
	  }
}
