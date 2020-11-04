

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.Cursor;

public class VendorTransMenu extends JFrame {
	private Color Color_navy = new Color(0,73,118);
	private Color Color_green = new Color(0, 143, 67);
	private Color Color_brown = new Color(113, 62, 45);
	private Color Color_orange = new Color(255, 151, 0);
	private Color Color_blue = new Color(70, 77, 255);
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VendorTransMenu(String loginUser,Calendar s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("< Back");
		btnBack.setFocusable(false);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(Color_navy, 2, true));
		btnBack.setForeground(Color_navy);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuperHome_View next= new SuperHome_View(loginUser, s);
				next.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 10, 100, 40);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(160, 10, 220, 50);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(Login_View.class.getResource("bankLogo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(logo));
		label.setAlignmentY(0.0f);
		
		JLabel label_1 = new JLabel("Capital");
		label_1.setForeground(new Color(0, 73, 118));
		label_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		
		JLabel label_2 = new JLabel("Two");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setForeground(new Color(0, 73, 118));
		label_2.setFont(new Font("Gabriola", Font.ITALIC, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 220, Short.MAX_VALUE)
				.addComponent(label)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(47)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(153)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addComponent(label)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		JPanel shopListPanel = new JPanel();
		shopListPanel.setBackground(Color.WHITE);
		shopListPanel.setBounds(48, 87, 389, 234);
		contentPane.add(shopListPanel);
		shopListPanel.setLayout(new GridLayout(4, 1, 5, 5));
		
		JButton btnNewButton = new JButton("BananaBee's");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(Color_green);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButton.setContentAreaFilled(false);
		shopListPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Groundfood");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setForeground(Color_brown);
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		shopListPanel.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("HouseDepot");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setForeground(Color_orange);
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButton_2.setContentAreaFilled(false);
		shopListPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 =new JButton("Valmart");
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setForeground(Color_blue);
		btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		shopListPanel.add(btnNewButton_3);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				VendorTransData next;
				try {
					next = new VendorTransData("valmart",s,loginUser);
					next.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				VendorTransData next;
				try {
					next = new VendorTransData("thehousedepot",s,loginUser);
					next.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				VendorTransData next;
				try {
					next = new VendorTransData("groundfood",s,loginUser);
					next.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendorTransData next;
				try {
					next = new VendorTransData("bananabees",s,loginUser);
					next.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
