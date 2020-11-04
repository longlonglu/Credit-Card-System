
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

public class Payment_View extends JFrame {
	private Color Color_darkGreen = new Color(18, 128, 32);
	
	private double balance = 0;
	double remainCredit = 0;
	double creditLmt = 0;
	Connection con = null;
	Statement cardStmt = null;
	
	private JPanel contentPane;
	private JTextField custAmtTextField;
	private JLabel lblInvalidAmount;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Payment_View frame = new Payment_View(1);
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
	public Payment_View(ResultSet loginUser, int cardNumber, Calendar s) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaybill = new JLabel("Pay a Bill");
		lblPaybill.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaybill.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPaybill.setBounds(120, 10, 146, 49);
		contentPane.add(lblPaybill);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 66, 366, 289);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnCurrentBal = new JRadioButton("Current Balance");
		rdbtnCurrentBal.setBackground(Color.WHITE);
		rdbtnCurrentBal.setFont(new Font("Arial", Font.PLAIN, 20));
		rdbtnCurrentBal.setBounds(6, 44, 180, 23);
		rdbtnCurrentBal.setFocusable(false);
		panel.add(rdbtnCurrentBal);
		
		JLabel lblYourCurr = new JLabel("Your current balance is  $");
		lblYourCurr.setFont(new Font("Arial", Font.PLAIN, 16));
		lblYourCurr.setBounds(53, 75, 188, 15);
		panel.add(lblYourCurr);
		
		JRadioButton rdbtnCustomAmt = new JRadioButton("Custom Amout");
		rdbtnCustomAmt.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
			        custAmtTextField.setEditable(true);
			        custAmtTextField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			    }
				else if (e.getStateChange() == ItemEvent.DESELECTED) {
			        custAmtTextField.setEditable(false);
			    }
			}
		});
		rdbtnCustomAmt.setBackground(Color.WHITE);
		rdbtnCustomAmt.setFont(new Font("Arial", Font.PLAIN, 20));
		rdbtnCustomAmt.setBounds(6, 96, 159, 23);
		rdbtnCustomAmt.setFocusable(false);
		panel.add(rdbtnCustomAmt);
		
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnCurrentBal);
		rdbtnGroup.add(rdbtnCustomAmt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(53, 128, 249, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("$");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setBounds(0, 0, 44, 38);
		panel_1.add(label);
		
		custAmtTextField = new JTextField();
		custAmtTextField.setFont(new Font("Arial", Font.PLAIN, 25));
		custAmtTextField.setEditable(false);
		custAmtTextField.setBounds(45, 0, 194, 38);
		panel_1.add(custAmtTextField);
		custAmtTextField.setColumns(10);
		
		JButton btnPayNow = new JButton("Pay Now");
		btnPayNow.setBorderPainted(false);
		btnPayNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// process payment amount
				boolean validAmt = false;
				double payAmt = 0;
				if (rdbtnCurrentBal.isSelected() && balance > 0) {
					payAmt = balance;
					validAmt = true;
				}
				else if (rdbtnCustomAmt.isSelected()) {
					String payStr = custAmtTextField.getText();
					if (!payStr.matches("[0-9.]+")) {
						
					}
					else {
						payAmt = Double.parseDouble(custAmtTextField.getText());
						if (!payStr.contains(".")) {
							payStr += ".00";
						}
						int integerPlaces = payStr.indexOf('.');
						int decimalPlaces = payStr.length() - integerPlaces - 1;
						if (decimalPlaces>2) {
							
						}
						else if (payAmt <= 0 || payAmt > balance) {
							
						}
						else {
							validAmt = true;
						}
					}
				}
				// pay successfully, update remainCredit, add new transaction
				if (validAmt) {
//					System.out.println("Valid input amount");
					Calendar today = Calendar.getInstance();
					String month;
					String date;
					String year = ""+today.get(today.YEAR);
					if(today.get(today.MONTH)+1<=10)
						month="0"+(today.get(today.MONTH)+1);
					else
						month=""+(today.get(today.MONTH)+1); 
					  
					if(today.get(today.DATE)+Math.abs(today.get(today.MINUTE)-s.get(s.MINUTE))+1<=10)
						date="0"+(today.get(today.DATE)+Math.abs(today.get(today.MINUTE)-s.get(s.MINUTE))/+1);
					else {
						date=""+(today.get(today.DATE)+Math.abs(today.get(today.MINUTE)-s.get(s.MINUTE))/+1);
					}
					String inputDate=year+"-"+month+"-"+date+" 00:00:00";
					System.out.println(inputDate);
					// 2019-08-03 19:42:57
					try {
						int dbSuccess = 0;
						dbSuccess += cardStmt.executeUpdate("UPDATE credit_cards SET remainCredit = "+(remainCredit+payAmt)+"WHERE cardNumber = "+cardNumber);
						Statement transStmt = con.createStatement();
						if (dbSuccess==1)
							dbSuccess += transStmt.executeUpdate("INSERT INTO transactions (`cost`, `date`, `cardNumber`, `paidTo`) VALUES ('"+(-1*payAmt)+"', '" +inputDate+"', '"+cardNumber+"', 'Payment')");
						if (dbSuccess == 2) {
//							System.out.println("db update successfully");
							dispose();
							JOptionPane.showMessageDialog(null, "Thank you for your payment!");
							Bank_View paid = new Bank_View(loginUser, s);
							paid.setVisible(true);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					lblInvalidAmount.setVisible(true);
				}
				
			}
		});
		btnPayNow.setBackground(Color_darkGreen);
		btnPayNow.setForeground(Color.WHITE);
		btnPayNow.setFocusable(false);
		btnPayNow.setFont(new Font("Arial", Font.BOLD, 20));
		btnPayNow.setBounds(53, 205, 249, 50);
		panel.add(btnPayNow);
		
		JLabel lblBalance = new JLabel("balance");
		lblBalance.setFont(new Font("Arial", Font.BOLD, 20));
		lblBalance.setBounds(240, 70, 85, 24);
		panel.add(lblBalance);
		
		lblInvalidAmount = new JLabel("Invalid Amount");
		lblInvalidAmount.setForeground(Color.RED);
		lblInvalidAmount.setFont(new Font("Arial", Font.PLAIN, 20));
		lblInvalidAmount.setBounds(110, 10, 139, 28);
		lblInvalidAmount.setVisible(false);
		panel.add(lblInvalidAmount);
		
		JButton button = new JButton("< Back");
		button.setFocusable(false);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Account_View back = new Account_View(loginUser, cardNumber, s);
				back.setVisible(true);
				dispose();
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setContentAreaFilled(false);
		button.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		button.setFont(new Font("Arial", Font.BOLD, 15));
		button.setBounds(10, 15, 80, 35);
		contentPane.add(button);
		
		// connect db
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC","root","wang87067835");  
			cardStmt = con.createStatement();
			ResultSet cardRes = cardStmt.executeQuery("SELECT * FROM credit_cards WHERE cardNumber = "+ cardNumber);

			// update balance info
			if (cardRes.next()) {	
				remainCredit = Double.parseDouble(cardRes.getString("remainCredit"));
				creditLmt = Double.parseDouble(cardRes.getString("creditLimit"));
				balance = creditLmt - remainCredit;
				lblBalance.setText(String.format("%.2f", balance));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
