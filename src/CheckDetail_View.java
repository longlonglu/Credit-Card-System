import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckDetail_View extends JFrame {

	private Color Color_navy = new Color(0,73,118);
	
	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Account_View frame = new Account_View();
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
	public CheckDetail_View(ResultSet loginUser, ResultSet customer, int cardNumber,Calendar s) {
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel brandPanel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, brandPanel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, brandPanel, 274, SpringLayout.WEST, contentPane);
		brandPanel.setBackground(Color.WHITE);
		contentPane.add(brandPanel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setAlignmentY(Component.TOP_ALIGNMENT);
		Image logo = new ImageIcon(Login_View.class.getResource("bankLogo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logo));
		
		JLabel lblCapital = new JLabel("Capital");
		lblCapital.setForeground(new Color(0, 73, 118));
		lblCapital.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTwo = new JLabel("Two");
		lblTwo.setVerticalAlignment(SwingConstants.TOP);
		lblTwo.setForeground(new Color(0, 73, 118));
		lblTwo.setFont(new Font("Gabriola", Font.ITALIC, 30));
		GroupLayout gl_brandPanel = new GroupLayout(brandPanel);
		gl_brandPanel.setHorizontalGroup(
			gl_brandPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
				.addComponent(lblLogo)
				.addGroup(gl_brandPanel.createSequentialGroup()
					.addGap(47)
					.addComponent(lblCapital, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_brandPanel.createSequentialGroup()
					.addGap(153)
					.addComponent(lblTwo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
		);
		gl_brandPanel.setVerticalGroup(
			gl_brandPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addComponent(lblLogo)
				.addGroup(gl_brandPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCapital, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_brandPanel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblTwo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		brandPanel.setLayout(gl_brandPanel);
	
		
		JPanel infoPanel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, infoPanel, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, infoPanel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, infoPanel, 223, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, infoPanel, 0, SpringLayout.EAST, contentPane);
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel lblCurrent = new JLabel("Current Balance");
		lblCurrent.setBounds(312, 16, 162, 15);
		lblCurrent.setForeground(Color.WHITE);
		lblCurrent.setFont(new Font("Arial", Font.BOLD, 18));
		infoPanel.add(lblCurrent);
		
		JLabel lblCreditCard = new JLabel("Credit Card");
		lblCreditCard.setBounds(10, 10, 190, 41);
		lblCreditCard.setForeground(Color.WHITE);
		infoPanel.add(lblCreditCard);
		lblCreditCard.setFont(new Font("Arial", Font.PLAIN, 35));
		
		JLabel lblBackgroundImg = new JLabel("");
		lblBackgroundImg.setBounds(0, 0, 776, 157);
		Image wave_background = new ImageIcon(CheckDetail_View.class.getResource("navy_background.png")).getImage().getScaledInstance(776, 157, Image.SCALE_SMOOTH);
		lblBackgroundImg.setIcon(new ImageIcon(wave_background));
		
		JLabel lblCardnumber = new JLabel("cardNumber");
		lblCardnumber.setAlignmentY(15.0f);
		lblCardnumber.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCardnumber.setForeground(Color.WHITE);
		lblCardnumber.setBounds(20, 55, 117, 15);
		infoPanel.add(lblCardnumber);
		
		JLabel lblBalance = new JLabel("balance");
		lblBalance.setForeground(new Color(255, 255, 255));
		lblBalance.setFont(new Font("Arial", Font.BOLD, 35));
		lblBalance.setBounds(325, 35, 142, 41);
		infoPanel.add(lblBalance);
		
		JLabel lblDollarSign = new JLabel("$");
		lblDollarSign.setForeground(Color.WHITE);
		lblDollarSign.setFont(new Font("Arial", Font.PLAIN, 25));
		lblDollarSign.setBounds(310, 30, 15, 41);
		infoPanel.add(lblDollarSign);
		
		JLabel lblAvaliableBalance = new JLabel("Available  Credit");
		lblAvaliableBalance.setForeground(Color.WHITE);
		lblAvaliableBalance.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAvaliableBalance.setBounds(318, 135, 142, 15);
		infoPanel.add(lblAvaliableBalance);
		
		JLabel lblDollarSign_2 = new JLabel("$");
		lblDollarSign_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDollarSign_2.setForeground(Color.WHITE);
		lblDollarSign_2.setFont(new Font("Arial", Font.PLAIN, 25));
		lblDollarSign_2.setBounds(320, 110, 15, 23);
		infoPanel.add(lblDollarSign_2);
		
		JLabel lblCredit = new JLabel("remain");
		lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredit.setForeground(Color.WHITE);
		lblCredit.setFont(new Font("Arial", Font.PLAIN, 25));
		lblCredit.setBounds(325, 110, 129, 23);
		infoPanel.add(lblCredit);
		
		JButton btnIncrease = new JButton("Change Line");
		btnIncrease.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newLimit = JOptionPane.showInputDialog(
						contentPane,
				        "Enter new Credit Limit"
				);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC", "root", "wang87067835");
					Statement getStmt = con.createStatement();
					Statement InsertStmt = con.createStatement();
					Statement userStmt = con.createStatement();
					ResultSet getRes = getStmt.executeQuery("SELECT * FROM credit_cards WHERE cardNumber = '"+cardNumber+"'");
					String loginUserStr = null;
					int success = 0;
					double curLimit = 0;
					double curRemain = 0;
					double newRemain = 0;
					loginUserStr = loginUser.getString("accountID");
					if (getRes.next()) {
						try {
							curLimit = Double.parseDouble(getRes.getString("creditLimit"));
							curRemain = Double.parseDouble(getRes.getString("remainCredit"));
							newRemain = Double.parseDouble(newLimit)-curLimit+curRemain;
						} 
						catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Invalid credit limit");
							return;
						}
					}
					if (Double.parseDouble(newLimit) < curLimit-curRemain ) {
						JOptionPane.showMessageDialog(null, "Can't change line to $"+newLimit+" \nDue to unpaid balance $ "+(curLimit-curRemain));
					}
					else {
						success += InsertStmt.executeUpdate("UPDATE `credit_card_system`.`credit_cards` SET `creditLimit` = '"+newLimit+"', `remainCredit` = '"+newRemain+"' WHERE (`cardNumber` = '"+cardNumber+"');");
					}
					if (success == 1) {
						JOptionPane.showMessageDialog(null, "Credit Line is changed to $"+newLimit+"\nRemaining credit is $"+newRemain);
						CheckUser_Card_View back = new CheckUser_Card_View(customer, loginUserStr,s);
						back.setVisible(true);
						dispose();
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnIncrease.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIncrease.setForeground(Color.WHITE);
		btnIncrease.setBounds(582, 16, 170, 48);
		infoPanel.add(btnIncrease);
		btnIncrease.setBackground(Color.BLACK);
		btnIncrease.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		btnIncrease.setFont(new Font("Arial", Font.BOLD, 18));
		btnIncrease.setFocusable(false);
		btnIncrease.setContentAreaFilled(false);
		
		JButton btnClose = new JButton("Close Account");
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Closing the account");
				if (input == 0) {
					String loginStr;
					try {
						// System.out.println("Connect");
						Class.forName("com.mysql.cj.jdbc.Driver"); 
						Connection con=DriverManager.getConnection(  
								"jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC","root","wang87067835");  
						Statement checkStmt = con.createStatement();
						ResultSet res = checkStmt.executeQuery("SELECT * FROM credit_cards WHERE cardNumber = '"+cardNumber+"'");
						if(res.next()) {
							String remain = res.getString("remainCredit");
							String limit = res.getString("creditLimit");
							double own = Double.parseDouble(limit)-Double.parseDouble(remain);
							if (own>0) {
								JOptionPane.showMessageDialog(null,"Can't close credit card \nDue to: unpaid Blance: $ "+own); 
							}
							else {
								Statement stmt = con.createStatement();
								int success = stmt.executeUpdate("UPDATE `credit_card_system`.`credit_cards` SET `cardHolder` = '0' WHERE (`cardNumber` = '"+cardNumber+"');");
								loginStr = loginUser.getString("accountID");
								CheckUser_Card_View back = new CheckUser_Card_View(customer, loginStr, s);
								back.setVisible(true);
								dispose();
							}
						}
						
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					
					
				}
				
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Arial", Font.BOLD, 18));
		btnClose.setFocusable(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		btnClose.setBackground(Color.BLACK);
		btnClose.setBounds(582, 74, 170, 48);
		infoPanel.add(btnClose);
		
		JLabel lblCreditLine = new JLabel("Credit Line");
		lblCreditLine.setForeground(Color.WHITE);
		lblCreditLine.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCreditLine.setBounds(600, 130, 74, 15);
		infoPanel.add(lblCreditLine);
		
		JLabel lblCreditAmt = new JLabel("$creditline");
		lblCreditAmt.setForeground(Color.WHITE);
		lblCreditAmt.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCreditAmt.setBounds(680, 130, 74, 15);
		infoPanel.add(lblCreditAmt);
		
		
		infoPanel.add(lblBackgroundImg);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.SOUTH, infoPanel);
		
		
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 776, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		
		JLabel lblTransactions = new JLabel("Transactions");
		lblTransactions.setFont(new Font("Arial", Font.BOLD, 25));
		lblTransactions.setBounds(10, 5, 176, 30);
		lblTransactions.setForeground(Color.BLACK);
		panel.add(lblTransactions);
		

		ArrayList<String[]> transData = new ArrayList<>();
		String username = null;
		// DataBase connect
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC","root","wang87067835");  
			Statement transStmt = con.createStatement();
			Statement cardStmt = con.createStatement();
			Statement userStmt = con.createStatement();
			ResultSet transRes = transStmt.executeQuery("SELECT * FROM transactions WHERE cardNumber = "+ cardNumber + " ORDER BY date");
			ResultSet cardRes = cardStmt.executeQuery("SELECT * FROM credit_cards WHERE cardNumber = "+ cardNumber);
			ResultSet userRes = userStmt.executeQuery("SELECT * FROM users \r\n" + 
														"WHERE users.id = (SELECT cardHolder FROM credit_cards\r\n" + 
														"WHERE credit_cards.cardNumber=" + cardNumber+")");
			if (loginUser.next()) {
				username = loginUser.getString("accountID");
			}
			// update credit card info
			if (cardRes.next()) {	
				lblCardnumber.setText("..."+String.format("%04d", Integer.parseInt(cardRes.getString("cardNumber"))));
				double remainCredit = Double.parseDouble(cardRes.getString("remainCredit"));
				double creditLmt = Double.parseDouble(cardRes.getString("creditLimit"));
				double balance = creditLmt - remainCredit;
				lblBalance.setText(String.format("%.2f", balance));
				lblCredit.setText(String.format("%.2f", remainCredit));
				lblCreditAmt.setText("$"+String.format("%.2f", creditLmt));;
				
			}
			// create transaction array
			if (transRes.next()) {
				do {
					String transRow[] = new String[3];
					transRow[0] = transRes.getString("date");
					transRow[1] = transRes.getString("paidTo");
					transRow[2] = "$"+transRes.getString("cost");
					transData.add(transRow);
				} while (transRes.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// drop down menu
		String choice[] = {
				username,
				"<html><strong>Profile</strong><br>Edit Info</html>", 
				"<html><strong>Security</strong><br>Login Setting</html>", 
				"<html><strong>Sign Out<strong></html>"};
		JComboBox comboBox = new JComboBox(choice);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 21, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, -204, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox, -5, SpringLayout.SOUTH, brandPanel);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, panel);
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setBackground(Color_navy);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					if (((String)e.getItem()).contains("Profile")) {
						//System.out.println("Go to Profile");
					}
					else if (((String)e.getItem()).contains("Security")) {
						//System.out.println("Go to Security");
					}
					else if (((String)e.getItem()).contains("Sign Out")) {
						Login_View back = new Login_View(s);
						back.setVisible(true);
						dispose();
						
					}
				}
			}
		});
		contentPane.add(comboBox);
		
		String columns[] = {"Date", "Description", "Amount"};
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setFocusable(false);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setFont(new Font("Arial", Font.BOLD, 20));
		scrollPane.setBounds(10, 40, 756, 280);
		
		panel.add(scrollPane);
		
		String[][] arrData = new String[transData.size()][];
		for (int i=0; i<transData.size(); i ++) {
			arrData[i] = transData.get(i);
		}

		table = new AlterColor_JTable(arrData, columns);
		table.setGridColor(Color.WHITE);
		table.setColumnSelectionAllowed(true);
		table.setBorder(null);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setEnabled(false);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 17));
		
		JButton btnBack = new JButton("< Back");
		btnBack.setForeground(Color_navy);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String loginStr = null;
				try {
					loginStr = loginUser.getString("accountId");
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				CheckUser_Card_View back = new CheckUser_Card_View(customer, loginStr, s);
				back.setVisible(true);
				dispose();
			}
		});
		btnBack.setOpaque(false);
		btnBack.setBorder(new LineBorder(Color_navy, 2, true));
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBack, 8, SpringLayout.NORTH, brandPanel);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBack, 24, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, brandPanel);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, -125, SpringLayout.WEST, brandPanel);
		contentPane.add(btnBack);
		
		// table header styling
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 20));
		header.setForeground(Color_navy);
		DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
	    renderer.setHorizontalAlignment(JLabel.LEFT);		// header alignment left
		
		for (int i=0; i<transData.size(); i++) {
			table.setRowHeight(i, 30);
		}
		
		
	}
}
