import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shops_View extends JFrame {

	private Color Color_marsh = new Color(155, 146, 60);
	private Color Color_green = new Color(0, 188, 65);
	private Color Color_navy = new Color(0,73,118);
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Shops_View frame = new Shops_View();
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
	public Shops_View(Calendar s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setLayout(null);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(274, 10, 246, 55);
		contentPane.add(logoPanel);
		Image logo = new ImageIcon(Login_View.class.getResource("shoank_logo.png")).getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT);
		
		JLabel lblShoank = new JLabel("R I K I B U Y");
		lblShoank.setVerticalAlignment(SwingConstants.TOP);
		lblShoank.setHorizontalAlignment(SwingConstants.CENTER);
		lblShoank.setForeground(Color_green);
		lblShoank.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		lblShoank.setBounds(53, 0, 183, 24);
		logoPanel.add(lblShoank);
		
		JLabel lblSlogan = new JLabel("BUY All You Wanna Buy");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setForeground(Color_green);
		lblSlogan.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 15));
		lblSlogan.setBounds(60, 30, 176, 25);
		logoPanel.add(lblSlogan);
		
		JLabel lblR = new JLabel("R");
		lblR.setOpaque(true);
		lblR.setBackground(Color_green);
		lblR.setForeground(Color.WHITE);
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setFont(new Font("Arial Black", Font.BOLD, 45));
		lblR.setAlignmentY(0.0f);
		lblR.setBounds(0, 0, 55, 55);
		logoPanel.add(lblR);
		
		JPanel shopsPanel = new JPanel();
		shopsPanel.setBackground(Color.WHITE);
		shopsPanel.setBounds(39, 109, 688, 294);
		contentPane.add(shopsPanel);
		shopsPanel.setLayout(new GridLayout(2, 1, 10, 10));
		
		JPanel valmartPanel = new JPanel();
		valmartPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				valmart next = new valmart(s);
				next.frame.setVisible(true);
				dispose();
			}
		});
		valmartPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		valmartPanel.setBackground(Color.WHITE);
		shopsPanel.add(valmartPanel);
		valmartPanel.setLayout(null);
		
		JLabel lblValmart = new JLabel();
		Image valmart_logo = new ImageIcon(Login_View.class.getResource("valmart_logo.png")).getImage().getScaledInstance(231, 46, Image.SCALE_SMOOTH);
		lblValmart.setIcon(new ImageIcon(valmart_logo));
		lblValmart.setBounds(60, 52, 231, 46);
		valmartPanel.add(lblValmart);
		
		JPanel housedepotPanel = new JPanel();
		housedepotPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				housedepot next = new housedepot(s);
				next.frame.setVisible(true);
				dispose();
			}
		});
		housedepotPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		housedepotPanel.setBackground(Color.WHITE);
		shopsPanel.add(housedepotPanel);
		housedepotPanel.setLayout(null);
		
		JLabel lblHousedepot = new JLabel();
		Image housedepot_logo = new ImageIcon(Login_View.class.getResource("houseDepot_logo.png")).getImage().getScaledInstance(142, 142, Image.SCALE_SMOOTH);
		lblHousedepot.setIcon(new ImageIcon(housedepot_logo));
		lblHousedepot.setBounds(95, 0, 142, 142);
		housedepotPanel.add(lblHousedepot);
		
		JPanel bananaBeesPanel = new JPanel();
		bananaBeesPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bananabee next = new bananabee(s);
				next.frame.setVisible(true);
				dispose();
			}
		});
		bananaBeesPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bananaBeesPanel.setBackground(Color.WHITE);
		shopsPanel.add(bananaBeesPanel);
		bananaBeesPanel.setLayout(null);
		
		JLabel lblBananaBees = new JLabel();
		Image banbee_logo = new ImageIcon(Login_View.class.getResource("bananaBees_logo.png")).getImage().getScaledInstance(231, 88, Image.SCALE_SMOOTH);
		lblBananaBees.setIcon(new ImageIcon(banbee_logo));
		lblBananaBees.setBounds(64, 24, 231, 90);
		bananaBeesPanel.add(lblBananaBees);
		
		JPanel groundFoodPanel = new JPanel();
		groundFoodPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		groundFoodPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				groundfood newF = new groundfood(s);
				newF.frame.setVisible(true);
				dispose();
			}
		});
		groundFoodPanel.setBackground(Color.WHITE);
		shopsPanel.add(groundFoodPanel);
		groundFoodPanel.setLayout(null);
		
		JLabel lblGround = new JLabel("ground");
		lblGround.setForeground(new Color(113, 62, 45));
		lblGround.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGround.setFont(new Font("Arial", Font.PLAIN, 35));
		lblGround.setBounds(78, 37, 108, 68);
		groundFoodPanel.add(lblGround);
		
		JLabel lblFood = new JLabel("F   od");
		lblFood.setForeground(new Color(0, 143, 67));
		lblFood.setFont(new Font("Arial", Font.BOLD, 35));
		lblFood.setBounds(189, 37, 95, 68);
		groundFoodPanel.add(lblFood);
		
		JLabel lblImg = new JLabel();
		Image groundFood_logo = new ImageIcon(Login_View.class.getResource("groundfood_logo.png")).getImage().getScaledInstance(29, 30, Image.SCALE_SMOOTH);
		lblImg.setIcon(new ImageIcon(groundFood_logo));
		lblImg.setBounds(209, 52, 30, 37);
		groundFoodPanel.add(lblImg);

		
		JButton btnBack = new JButton("< Home");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Index_View back = new Index_View(s);
				back.frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFocusable(false);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(Color_green, 2, true));
		btnBack.setBackground(Color.WHITE);
		btnBack.setForeground(Color_green);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBack.setBounds(15, 20, 100, 35);
		contentPane.add(btnBack);
		
		JButton btnBank = new JButton("Bank");
		btnBank.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBank.setFocusable(false);
		btnBank.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Login_View login = new Login_View(s);
				login.setVisible(true);
				dispose();
			}
		});
		btnBank.setContentAreaFilled(false);
		btnBank.setBorder(new LineBorder(Color_navy, 2, true));
		btnBank.setForeground(Color_navy);
		btnBank.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBank.setBounds(129, 20, 100, 35);
		contentPane.add(btnBank);
	}
}
