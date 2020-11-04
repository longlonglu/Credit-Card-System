
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class CheckUser_Card_View extends JFrame {

	private Color Color_navy = new Color(0,73,118);
	
	private JPanel contentPane;

	private ResultSet loginRes;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Home_View frame = new Home_View();
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
	public CheckUser_Card_View(ResultSet customer, String loginUser,Calendar s) {
		contentPane = new JPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(null);
		
		JPanel brandPanel = new JPanel();
		brandPanel.setBounds(280, 0, 226, 50);
		brandPanel.setBackground(Color.WHITE);
		contentPane.add(brandPanel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setAlignmentY(Component.TOP_ALIGNMENT);
		Image logo = new ImageIcon(Login_View.class.getResource("bankLogo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logo));
		
		JLabel lblCapital = new JLabel("Capital");
		lblCapital.setForeground(Color_navy);
		springLayout.putConstraint(SpringLayout.EAST, lblCapital, 183, SpringLayout.WEST, brandPanel);
		lblCapital.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTwo = new JLabel("Two");
		lblTwo.setForeground(Color_navy);
		lblTwo.setVerticalAlignment(SwingConstants.TOP);
		lblTwo.setFont(new Font("Gabriola", Font.ITALIC, 30));
		GroupLayout gl_brandPanel = new GroupLayout(brandPanel);
		gl_brandPanel.setHorizontalGroup(
			gl_brandPanel.createParallelGroup(Alignment.LEADING)
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
		infoPanel.setBounds(50, 66, 686, 100);
		infoPanel.setBackground(Color.WHITE);
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		String firstName = null;
		String lastName = null;
		String dob = null;
		String addr = null;
		String custUsername = null;
		String userID = null;
				
		try {
			firstName = customer.getString("firstName");
			lastName = customer.getString("lastName");
			dob = customer.getString("DOB").substring(0,10);
			addr = customer.getString("billAddr");
			custUsername = customer.getString("accountID");
			userID = customer.getString("id");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblUserName = new JLabel("Username: ");
		lblUserName.setBounds(0, 0, 111, 29);
		lblUserName.setForeground(Color_navy);
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 20));
		infoPanel.add(lblUserName);
		
		JLabel lblUsername = new JLabel(custUsername);
		lblUsername.setBounds(121, 0, 219, 29);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		infoPanel.add(lblUsername);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUserId.setBounds(350, 0, 88, 29);
		lblUserId.setForeground(Color_navy);
		infoPanel.add(lblUserId);
		
		JLabel valUserid = new JLabel(userID);
		valUserid.setFont(new Font("Arial", Font.PLAIN, 20));
		valUserid.setBounds(440, 0, 111, 29);
		infoPanel.add(valUserid);
		
		JLabel lblDOB = new JLabel("Date of Birth:");
		lblDOB.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDOB.setBounds(0, 71, 125, 29);
		lblDOB.setForeground(Color_navy);
		infoPanel.add(lblDOB);
		
		JLabel lblDateofBirth = new JLabel(dob);
		lblDateofBirth.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDateofBirth.setBounds(121, 71, 170, 29);
		infoPanel.add(lblDateofBirth);
		
		JLabel lblAddr = new JLabel("Address:");
		lblAddr.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAddr.setBounds(350, 71, 105, 29);
		lblAddr.setForeground(Color_navy);
		infoPanel.add(lblAddr);
		
		JLabel lblAddress = new JLabel(addr);
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAddress.setBounds(450, 71, 236, 29);
		infoPanel.add(lblAddress);
		
		JLabel lblLN = new JLabel("Last Name:");
		lblLN.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLN.setBounds(0, 35, 111, 29);
		lblLN.setForeground(Color_navy);;
		infoPanel.add(lblLN);
		
		JLabel lblLastname = new JLabel(lastName);
		lblLastname.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLastname.setBounds(121, 35, 125, 32);
		infoPanel.add(lblLastname);
		
		JLabel lblFN = new JLabel("First Name:");
		lblFN.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFN.setBounds(350, 35, 111, 29);
		lblFN.setForeground(Color_navy);
		infoPanel.add(lblFN);
		
		JLabel lblLastname_1 = new JLabel(firstName);
		lblLastname_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLastname_1.setBounds(465, 35, 125, 29);
		infoPanel.add(lblLastname_1);
		
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(50, 183, 686, 370);
		cardPanel.setBackground(Color.WHITE);
		cardPanel.setLayout(new GridLayout(2, 2, 10, 10));
		Image greetingImg = new ImageIcon(Login_View.class.getResource("greeting_background.png")).getImage().getScaledInstance(776, 100, Image.SCALE_SMOOTH);
		contentPane.add(cardPanel);
		
		// drop down menu
		Object choice[] = {
				loginUser,
				new JSeparator(JSeparator.HORIZONTAL),
				"<html><strong>Sign Out<strong></html>"};
		JComboBox comboBox = new JComboBox(choice);
		comboBox.setBounds(583, 20, 193, 34);
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setBackground(new Color(29, 132, 199));
		ComboBoxRenderer renderer= new ComboBoxRenderer();
	    renderer.setPreferredSize(new Dimension(125, 30));
	    comboBox.setRenderer(renderer);
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
		
		JButton btnBack = new JButton("< Back");
		btnBack.setBounds(24, 8, 131, 32);
		btnBack.setForeground(Color_navy);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchUser_View back = new SearchUser_View(loginUser,s);
				back.setVisible(true);
				dispose();
			}
		});
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBack.setFocusable(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(Color_navy, 2, true));
		btnBack.setBackground(Color.WHITE);
		contentPane.add(btnBack);
		
		JButton btnNewCard = new JButton("New Card");
		btnNewCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				NewCard_View newCard = new NewCard_View(customer, loginUser,s);
				newCard.setVisible(true);
				dispose();
			}
		});
		btnNewCard.setOpaque(true);
		btnNewCard.setBackground(Color_navy);
		btnNewCard.setForeground(Color.WHITE);
		btnNewCard.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewCard.setBounds(309, 563, 152, 40);
		btnNewCard.setFocusable(false);
		contentPane.add(btnNewCard);
		
		// display all credit card on cardPanel (dynamically)
		ArrayList<JPanel> cardList = new ArrayList<>();
		try {
			// DataBase connect
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC","root","wang87067835");  
			Statement cardStmt = con.createStatement();
			Statement loginStmt = con.createStatement();
			ResultSet cardRes = cardStmt.executeQuery("SELECT * FROM credit_cards WHERE cardHolder = "+userID);
			loginRes = loginStmt.executeQuery("SELECT * FROM users WHERE accountID = '"+loginUser+"'");
			while (cardRes.next()) {
				int cardNum = Integer.parseInt(cardRes.getString("cardNumber"));
				String lastNum = String.format("%04d", cardNum);
				String balanceStr = String.format("%.2f", Double.parseDouble(cardRes.getString("creditLimit")) - Double.parseDouble(cardRes.getString("remainCredit")));
				JPanel panel_1 = new JPanel();
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						CheckDetail_View acc_view = new CheckDetail_View(loginRes, customer, cardNum,s);
						acc_view.setVisible(true);
						dispose();
					}
				});
				cardPanel.add(panel_1);
				
				JLabel lblBg = new JLabel("");
				lblBg.setBounds(0, 0, 676, 175);
				Image wave_background = new ImageIcon(Account_View.class.getResource("navy_background.png")).getImage().getScaledInstance(776, 175, Image.SCALE_SMOOTH);
				lblBg.setIcon(new ImageIcon(wave_background));
				panel_1.setLayout(null);
				
				
				JLabel lblCreditCard = new JLabel("Credit Card");
				lblCreditCard.setFont(new Font("Arial", Font.PLAIN, 30));
				lblCreditCard.setForeground(Color.WHITE);
				
				lblCreditCard.setBounds(10, 22, 155, 45);
				panel_1.add(lblCreditCard);
				
				JLabel lblCardNum = new JLabel("..."+lastNum);
				lblCardNum.setFont(new Font("Arial", Font.PLAIN, 20));
				lblCardNum.setForeground(Color.WHITE);
				lblCardNum.setBounds(174, 24, 62, 24);
				panel_1.add(lblCardNum);
				
				JLabel lbl$sign = new JLabel("$");
				lbl$sign.setFont(new Font("Arial", Font.BOLD, 30));
				lbl$sign.setForeground(Color.WHITE);
				lbl$sign.setBounds(28, 60, 17, 36);
				panel_1.add(lbl$sign);
				
				JLabel lblBalance = new JLabel(balanceStr);
				lblBalance.setFont(new Font("Arial", Font.BOLD, 50));
				lblBalance.setForeground(Color.WHITE);
				lblBalance.setBounds(50, 59, 250, 59);
				panel_1.add(lblBalance);
				
				JLabel lblCurrentBalance = new JLabel("Current Blanace");
				lblCurrentBalance.setFont(new Font("Arial", Font.PLAIN, 20));
				lblCurrentBalance.setBounds(30, 111, 146, 24);
				lblCurrentBalance.setForeground(Color.WHITE);
				panel_1.add(lblCurrentBalance);
				
				panel_1.add(lblBg);
				
			}
			for (int i=0; i<cardList.size(); i++) {
				cardPanel.add(cardList.get(i));
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
	}
}
