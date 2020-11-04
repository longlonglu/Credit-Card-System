import java.awt.EventQueue;

// database import
import java.sql.*;			

// hash function imports
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Cursor;

public class Login_View extends JFrame {
	private Color Color_navy = new Color(0,73,118);
	private Color Color_darkGreen = new Color(18, 128, 32);
	private Color Color_marsh = new Color(155, 146, 60);
	
	private JPanel contentPane;
	Calendar s;
	// interactive components
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	
	// indicative components
	private JLabel lblUsernameErr;
	private JLabel lblPasswordErr;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login_View window = new Login_View();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Helper functions
	 */
	private String hashMD5(String input) 
    { 
        try { 
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
	
	private void login() {
		// Get user inputs
		String username = usernameTextField.getText();
		String password = new String(passwordTextField.getPassword());
		String hashedPW = hashMD5(password);
		String superUser = null;
		
		try {
			// System.out.println("Connect");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC","root","wang87067835");
			Statement stmt = con.createStatement();
			// Query get result
			ResultSet res = stmt.executeQuery("SELECT * FROM users WHERE accountID = '"+username+"'");
			
			// get DB password
			String dbPW = null;
			if (res.next()) {
				dbPW = res.getString("password");
				superUser = res.getString("superuser");
			}
			if (dbPW != null) {
				if (hashedPW.equals(dbPW)) {
					// qualified
					if(superUser.equals("1")){
						// super user
						lblUsernameErr.setVisible(false);
						lblPasswordErr.setVisible(false);
						// System.out.println("Qualified");
						SuperHome_View openFrame = new SuperHome_View(username,s);
						openFrame.setVisible(true);
						dispose();
					}
					else {
						// normal user
						lblUsernameErr.setVisible(false);
						lblPasswordErr.setVisible(false);
						// System.out.println("Qualified");
						Bank_View openFrame = new Bank_View(res,s);
						openFrame.setVisible(true);
						dispose();
					}
				}
				else {
					// incorrect password
					lblUsernameErr.setVisible(false);
					lblPasswordErr.setVisible(true);
				}
			}
			else {
				// user not found
				lblPasswordErr.setVisible(false);
				lblUsernameErr.setVisible(true);
			}
				
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Login_View(Calendar s) {
		this.s=s;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		Image logo = new ImageIcon(Login_View.class.getResource("shoank_logo.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		
		JPanel loginPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, loginPanel, 71, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, loginPanel, -10, SpringLayout.SOUTH, contentPane);
		loginPanel.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, loginPanel, 50, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, loginPanel, -50, SpringLayout.EAST, contentPane);
		contentPane.add(loginPanel);
		SpringLayout sl_loginPanel = new SpringLayout();
		loginPanel.setLayout(sl_loginPanel);
		
		JLabel lblUsername = new JLabel("Username");
		sl_loginPanel.putConstraint(SpringLayout.SOUTH, lblUsername, 70, SpringLayout.NORTH, loginPanel);
		lblUsername.setForeground(Color.GRAY);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		sl_loginPanel.putConstraint(SpringLayout.WEST, lblUsername, 51, SpringLayout.WEST, loginPanel);
		loginPanel.add(lblUsername);
		
		JPanel usernamePanel = new JPanel();
		usernamePanel.setBorder(new LineBorder(Color.GRAY, 1, true));
		usernamePanel.setBackground(Color.WHITE);
		sl_loginPanel.putConstraint(SpringLayout.NORTH, usernamePanel, 6, SpringLayout.SOUTH, lblUsername);
		sl_loginPanel.putConstraint(SpringLayout.WEST, usernamePanel, 50, SpringLayout.WEST, loginPanel);
		sl_loginPanel.putConstraint(SpringLayout.SOUTH, usernamePanel, 49, SpringLayout.SOUTH, lblUsername);
		sl_loginPanel.putConstraint(SpringLayout.EAST, usernamePanel, 436, SpringLayout.WEST, loginPanel);
		loginPanel.add(usernamePanel);
		SpringLayout sl_usernamePanel = new SpringLayout();
		usernamePanel.setLayout(sl_usernamePanel);
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setBackground(Color.WHITE);
		sl_usernamePanel.putConstraint(SpringLayout.NORTH, lblUserIcon, 3, SpringLayout.NORTH, usernamePanel);
		sl_usernamePanel.putConstraint(SpringLayout.WEST, lblUserIcon, 10, SpringLayout.WEST, usernamePanel);
		usernamePanel.add(lblUserIcon);
		Image userIcon = new ImageIcon(Login_View.class.getResource("userIcon.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		lblUserIcon.setIcon(new ImageIcon(userIcon));
		
		usernameTextField = new JTextField();
		usernameTextField.setForeground(Color.GRAY);
		usernameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		usernameTextField.setBorder(null);
		sl_usernamePanel.putConstraint(SpringLayout.WEST, usernameTextField, 30, SpringLayout.EAST, lblUserIcon);
		sl_usernamePanel.putConstraint(SpringLayout.NORTH, usernameTextField, 0, SpringLayout.NORTH, lblUserIcon);
		sl_usernamePanel.putConstraint(SpringLayout.SOUTH, usernameTextField, 0, SpringLayout.SOUTH, lblUserIcon);
		sl_usernamePanel.putConstraint(SpringLayout.EAST, usernameTextField, 330, SpringLayout.EAST, lblUserIcon);
		usernameTextField.setBounds(new Rectangle(0, 0, 300, 0));
		usernamePanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		sl_loginPanel.putConstraint(SpringLayout.WEST, lblPassword, 50, SpringLayout.WEST, loginPanel);
		sl_loginPanel.putConstraint(SpringLayout.SOUTH, lblPassword, -205, SpringLayout.SOUTH, loginPanel);
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		loginPanel.add(lblPassword);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBorder(new LineBorder(Color.GRAY, 1, true));
		passwordPanel.setBackground(Color.WHITE);
		sl_loginPanel.putConstraint(SpringLayout.NORTH, passwordPanel, 6, SpringLayout.SOUTH, lblPassword);
		sl_loginPanel.putConstraint(SpringLayout.WEST, passwordPanel, 0, SpringLayout.WEST, lblUsername);
		sl_loginPanel.putConstraint(SpringLayout.SOUTH, passwordPanel, 49, SpringLayout.SOUTH, lblPassword);
		sl_loginPanel.putConstraint(SpringLayout.EAST, passwordPanel, 436, SpringLayout.WEST, loginPanel);
		loginPanel.add(passwordPanel);
		SpringLayout sl_passwordPanel = new SpringLayout();
		passwordPanel.setLayout(sl_passwordPanel);
		
		JLabel lblPasswordIcon = new JLabel("");
		lblPasswordIcon.setBackground(Color.WHITE);
		sl_passwordPanel.putConstraint(SpringLayout.NORTH, lblPasswordIcon, 2, SpringLayout.NORTH, passwordPanel);
		sl_passwordPanel.putConstraint(SpringLayout.WEST, lblPasswordIcon, 10, SpringLayout.WEST, passwordPanel);
		passwordPanel.add(lblPasswordIcon);
		Image passIcon = new ImageIcon(Login_View.class.getResource("pwIcon.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		lblPasswordIcon.setIcon(new ImageIcon(passIcon));
		
		passwordTextField = new JPasswordField();
		sl_passwordPanel.putConstraint(SpringLayout.WEST, passwordTextField, 30, SpringLayout.EAST, lblPasswordIcon);
		sl_passwordPanel.putConstraint(SpringLayout.EAST, passwordTextField, -9, SpringLayout.EAST, passwordPanel);
		passwordTextField.setForeground(Color.BLACK);
		passwordTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordTextField.setBounds(new Rectangle(0, 0, 300, 0));
		passwordTextField.setBorder(null);
		sl_passwordPanel.putConstraint(SpringLayout.NORTH, passwordTextField, 0, SpringLayout.NORTH, passwordPanel);
		sl_passwordPanel.putConstraint(SpringLayout.SOUTH, passwordTextField, 41, SpringLayout.NORTH, passwordPanel);
		passwordPanel.add(passwordTextField);
		
		JButton btnSignin = new JButton("Sign In");
		sl_loginPanel.putConstraint(SpringLayout.WEST, btnSignin, 0, SpringLayout.WEST, lblUsername);
		sl_loginPanel.putConstraint(SpringLayout.SOUTH, btnSignin, -41, SpringLayout.SOUTH, loginPanel);
		sl_loginPanel.putConstraint(SpringLayout.EAST, btnSignin, -49, SpringLayout.EAST, loginPanel);
		btnSignin.setBackground(Color_navy);
		btnSignin.setOpaque(true);
		btnSignin.setForeground(Color.WHITE);
		btnSignin.setFocusable(false);
		btnSignin.setFont(new Font("Arial", Font.BOLD, 20));
		loginPanel.add(btnSignin);
		
		btnSignin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				login();
			}
		});
		usernameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					login();
			    }
			}
		});
		passwordTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					login();
			    }
			}
		});
		
		
		JLabel lblForgetPassword = new JLabel("<html><U>Forgot Username or Password?</U></html>");
		sl_loginPanel.putConstraint(SpringLayout.NORTH, btnSignin, 36, SpringLayout.SOUTH, lblForgetPassword);
		sl_loginPanel.putConstraint(SpringLayout.EAST, lblForgetPassword, 231, SpringLayout.WEST, lblUsername);
		lblForgetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblForgetPassword.setVisible(false);
		lblForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Security_View account_reset = new Security_View(s);
				account_reset.setVisible(true);
				dispose();
			}
		});
		sl_loginPanel.putConstraint(SpringLayout.NORTH, lblForgetPassword, 6, SpringLayout.SOUTH, passwordPanel);
		sl_loginPanel.putConstraint(SpringLayout.WEST, lblForgetPassword, 0, SpringLayout.WEST, lblUsername);
		sl_loginPanel.putConstraint(SpringLayout.SOUTH, lblForgetPassword, 38, SpringLayout.SOUTH, passwordPanel);
		lblForgetPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblForgetPassword.setForeground(Color.BLUE);
		lblForgetPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		loginPanel.add(lblForgetPassword);
		
		lblUsernameErr = new JLabel("Username doesn't exist");
		sl_loginPanel.putConstraint(SpringLayout.NORTH, lblUsernameErr, 7, SpringLayout.NORTH, lblUsername);
		sl_loginPanel.putConstraint(SpringLayout.WEST, lblUsernameErr, 16, SpringLayout.EAST, lblUsername);
		sl_loginPanel.putConstraint(SpringLayout.SOUTH, lblUsernameErr, -2, SpringLayout.SOUTH, lblUsername);
		sl_loginPanel.putConstraint(SpringLayout.EAST, lblUsernameErr, 228, SpringLayout.EAST, lblUsername);
		lblUsernameErr.setForeground(Color.RED);
		lblUsernameErr.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsernameErr.setVisible(false);
		loginPanel.add(lblUsernameErr);
		
		lblPasswordErr = new JLabel("Incorrect password");
		lblPasswordErr.setForeground(Color.RED);
		lblPasswordErr.setFont(new Font("Arial", Font.BOLD, 15));
		sl_loginPanel.putConstraint(SpringLayout.NORTH, lblPasswordErr, 8, SpringLayout.NORTH, lblPassword);
		sl_loginPanel.putConstraint(SpringLayout.WEST, lblPasswordErr, 0, SpringLayout.WEST, lblUsernameErr);
		sl_loginPanel.putConstraint(SpringLayout.EAST, lblPasswordErr, -15, SpringLayout.EAST, lblUsernameErr);
		lblPasswordErr.setVisible(false);
		loginPanel.add(lblPasswordErr);
		
		JPanel logoPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, logoPanel, 185, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, logoPanel, -1, SpringLayout.NORTH, loginPanel);
		springLayout.putConstraint(SpringLayout.EAST, logoPanel, 386, SpringLayout.WEST, contentPane);
		contentPane.add(logoPanel);
		logoPanel.setBackground(Color.WHITE);
		
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
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGroup(gl_logoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogo)
						.addGroup(gl_logoPanel.createSequentialGroup()
							.addGap(47)
							.addComponent(lblCapital, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_logoPanel.createSequentialGroup()
							.addGap(153)
							.addComponent(lblTwo, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_logoPanel.setVerticalGroup(
			gl_logoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_logoPanel.createSequentialGroup()
					.addGroup(gl_logoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogo)
						.addGroup(gl_logoPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCapital, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_logoPanel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblTwo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		logoPanel.setLayout(gl_logoPanel);
		
		JButton btnBack = new JButton("< Home");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Index_View back = new Index_View(s);
				back.frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFocusable(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(Color_navy, 2, true));
		btnBack.setForeground(Color_navy);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 12, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, 47, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, btnBack, 129, SpringLayout.WEST, contentPane);
		contentPane.add(btnBack);
	}
}
