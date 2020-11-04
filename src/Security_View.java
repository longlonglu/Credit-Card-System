import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Security_View extends JFrame {

	private Color Color_navy = new Color(0,73,118);
	
	private JPanel contentPane;
	private JTextField lastnameTextField;
	private JTextField firstnameTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	
	private String[] dayList = null;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Security_View frame = new Security_View();
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
	public Security_View(Calendar s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 524);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(182, 10, 226, 50);
		contentPane.add(logoPanel);
		
		JLabel lblLogo = new JLabel("");
		Image logo = new ImageIcon(Login_View.class.getResource("bankLogo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logo));
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
				.addGap(0, 226, Short.MAX_VALUE)
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
		
		JLabel lblLetsVeriyIts = new JLabel("Let's verify it's you!");
		lblLetsVeriyIts.setForeground(Color.GRAY);
		lblLetsVeriyIts.setFont(new Font("Arial", Font.BOLD, 25));
		lblLetsVeriyIts.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetsVeriyIts.setBounds(140, 87, 300, 37);
		contentPane.add(lblLetsVeriyIts);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(null);
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBounds(10, 141, 566, 277);
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.GRAY);
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLastName.setBounds(30, 10, 133, 28);
		infoPanel.add(lblLastName);
		
		lastnameTextField = new JTextField();
		lastnameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLastName.setLabelFor(lastnameTextField);
		lastnameTextField.setBounds(30, 41, 224, 40);
		infoPanel.add(lastnameTextField);
		lastnameTextField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.GRAY);
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFirstName.setBounds(282, 10, 133, 28);
		infoPanel.add(lblFirstName);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		firstnameTextField.setColumns(10);
		firstnameTextField.setBounds(282, 41, 224, 40);
		infoPanel.add(firstnameTextField);
		
		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number");
		lblSocialSecurityNumber.setForeground(Color.GRAY);
		lblSocialSecurityNumber.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSocialSecurityNumber.setBounds(30, 93, 224, 28);
		infoPanel.add(lblSocialSecurityNumber);
		
		JLabel label = new JLabel("\u2500");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(145, 143, 35, 15);
		infoPanel.add(label);
		
		JLabel label_1 = new JLabel("\u2500");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial", Font.BOLD, 20));
		label_1.setBounds(265, 143, 35, 15);
		infoPanel.add(label_1);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.GRAY);
		lblDateOfBirth.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(30, 180, 133, 28);
		infoPanel.add(lblDateOfBirth);
		
		String[] monthList = new String[] {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		dayList = new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
		ArrayList<String> yearList = new ArrayList<>(Arrays.asList("Year"));
		for (int i=1899; i<=2019; i++) {
			yearList.add(String.valueOf(i));
		}
		
		JComboBox<String> monthComboBox = new JComboBox<String>();

		monthComboBox.setEditable(true);
		monthComboBox.setFocusable(false);
		monthComboBox.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		monthComboBox.setBackground(Color.WHITE);
		monthComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		monthComboBox.setModel(new DefaultComboBoxModel<String>(monthList));
		monthComboBox.setBounds(30, 218, 114, 49);
		infoPanel.add(monthComboBox);
		
		JComboBox<String> dayComboBox = new JComboBox<String>();
		dayComboBox.setEditable(true);
		dayComboBox.setBackground(Color.WHITE);
		dayComboBox.setModel(new DefaultComboBoxModel<String>(dayList));
		dayComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		dayComboBox.setBounds(185, 218, 114, 49);
		infoPanel.add(dayComboBox);
		
		JComboBox<String> yearComboBox = new JComboBox<String>();
		yearComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		yearComboBox.setEditable(true);
		yearComboBox.setModel(new DefaultComboBoxModel(yearList.toArray()));
		yearComboBox.setBackground(Color.WHITE);
		yearComboBox.setBounds(340, 218, 142, 49);
		infoPanel.add(yearComboBox);
		
		monthComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					String selectedItem = (String)e.getItem();
					if (selectedItem.contains("January") || selectedItem.contains("March") || selectedItem.contains("May") ||
							selectedItem.contains("Junly") || selectedItem.contains("August") || selectedItem.contains("October") || selectedItem.contains("December")) {
						dayList = new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
						dayComboBox.setModel(new DefaultComboBoxModel<String>(dayList));
					}
					else if (selectedItem.contains("February")) {
						dayList = new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};
						dayComboBox.setModel(new DefaultComboBoxModel<String>(dayList));
					}
					else {
						dayList = new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
						dayComboBox.setModel(new DefaultComboBoxModel<String>(dayList));
					}
				}
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(45, 131, 100, 40);
		infoPanel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(180, 131, 80, 40);
		infoPanel.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(300, 131, 150, 40);
		infoPanel.add(passwordField_2);
		
		JButton btnFindMe = new JButton("Find Me");
		btnFindMe.setFocusable(false);
		btnFindMe.setBackground(Color_navy);
		btnFindMe.setForeground(Color.WHITE);
		btnFindMe.setFont(new Font("Arial", Font.PLAIN, 25));
		btnFindMe.setBounds(192, 428, 204, 36);
		contentPane.add(btnFindMe);
		
		JButton btnBack = new JButton("< Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_View back = new Login_View(s);
				back.setVisible(true);
				dispose();
			}
		});
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setForeground(new Color(0, 73, 118));
		btnBack.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBack.setFocusable(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(Color_navy, 2, true));
		btnBack.setBounds(10, 10, 119, 35);
		contentPane.add(btnBack);
	}
}
