import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Index_View{

	public JFrame frame;
	
	private Color Color_marsh = new Color(155, 146, 60);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index_View window = new Index_View(Calendar.getInstance());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Index_View(Calendar s) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel logoPanel = new JPanel();
		logoPanel.setLayout(null);
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(174, 10, 246, 55);
		frame.getContentPane().add(logoPanel);
		
		JLabel lblLogo = new JLabel("");
		Image logo = new ImageIcon(Login_View.class.getResource("shoank_logo.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logo));
		lblLogo.setAlignmentY(0.0f);
		lblLogo.setBounds(0, 0, 55, 55);
		logoPanel.add(lblLogo);
		
		JLabel lblShoank = new JLabel("S H O A N K");
		lblShoank.setVerticalAlignment(SwingConstants.TOP);
		lblShoank.setHorizontalAlignment(SwingConstants.CENTER);
		lblShoank.setForeground(new Color(155, 146, 60));
		lblShoank.setFont(new Font("Ink Free", Font.PLAIN, 25));
		lblShoank.setBounds(53, 0, 183, 24);
		logoPanel.add(lblShoank);
		
		JLabel lblSlogan = new JLabel("Shop & Bank Two in One");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setForeground(new Color(155, 146, 60));
		lblSlogan.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSlogan.setBounds(60, 30, 186, 25);
		logoPanel.add(lblSlogan);
		
		JPanel greetingPanel = new JPanel();
		greetingPanel.setBackground(Color.WHITE);
		greetingPanel.setBounds(10, 96, 566, 81);
		frame.getContentPane().add(greetingPanel);
		greetingPanel.setLayout(null);
		
		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
		String greetingStr = null;
		if(timeOfDay >= 3 && timeOfDay < 12){
		    greetingStr = "Good Morning";      
		}else if(timeOfDay >= 12 && timeOfDay < 17){
			greetingStr = "Good Afternoon";
		}else{
			greetingStr =  "Good Evening";
		}
		
		JLabel lblGreetings = new JLabel(greetingStr);
		lblGreetings.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGreetings.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreetings.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 25));
		lblGreetings.setForeground(new Color(47, 77, 45));
		lblGreetings.setBounds(165, 10, 247, 33);
		greetingPanel.add(lblGreetings);
		
		JLabel lblThankYouFor = new JLabel("Thank you for choosing SHOANK");
		lblThankYouFor.setVerticalAlignment(SwingConstants.TOP);
		lblThankYouFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYouFor.setFont(new Font("Candara", Font.ITALIC, 20));
		lblThankYouFor.setBounds(144, 45, 290, 26);
		lblThankYouFor.setForeground(new Color(47, 77, 45));
		greetingPanel.add(lblThankYouFor);

		
		JPanel selectPanel = new JPanel();
		selectPanel.setBackground(Color.WHITE);
		selectPanel.setBounds(10, 198, 566, 155);
		frame.getContentPane().add(selectPanel);
		selectPanel.setLayout(null);
		
		JPanel shopBtnPanel = new JPanel();
		shopBtnPanel.setBackground(Color.WHITE);
		shopBtnPanel.setBorder(new LineBorder(new Color(155, 146, 60), 4, true));
		shopBtnPanel.setBounds(10, 25, 257, 87);
		selectPanel.add(shopBtnPanel);
		shopBtnPanel.setLayout(null);
		
		JButton btnShopping = new JButton("Shopping");
		btnShopping.setBorderPainted(false);
		btnShopping.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnShopping.setBackground(Color_marsh);
				btnShopping.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnShopping.setBackground(Color.white);
				btnShopping.setForeground(Color_marsh);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Shops_View shop = new Shops_View(s);
				shop.setVisible(true);
				frame.dispose();
			}
		});
		btnShopping.setBackground(Color.WHITE);
		btnShopping.setFont(new Font("Courier New", Font.BOLD, 30));
		btnShopping.setForeground(Color_marsh);
		btnShopping.setFocusable(false);
		btnShopping.setBounds(5, 6, 246, 75);
		shopBtnPanel.add(btnShopping);
		
		JPanel bankBtnPanel = new JPanel();
		bankBtnPanel.setLayout(null);
		bankBtnPanel.setBorder(new LineBorder(new Color(155, 146, 60), 4, true));
		bankBtnPanel.setBackground(Color.WHITE);
		bankBtnPanel.setBounds(299, 25, 257, 87);
		selectPanel.add(bankBtnPanel);
		
		JButton btnBanking = new JButton("Banking");
		btnBanking.setBorderPainted(false);
		btnBanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBanking.setBackground(Color_marsh);
				btnBanking.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBanking.setBackground(Color.white);
				btnBanking.setForeground(Color_marsh);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_View openFrame = new Login_View(s);
				openFrame.setVisible(true);
				frame.dispose();
			}
		});
		btnBanking.setForeground(new Color(155, 146, 60));
		btnBanking.setFont(new Font("Courier New", Font.BOLD, 30));
		btnBanking.setFocusable(false);
		btnBanking.setBackground(Color.WHITE);
		btnBanking.setBounds(5, 6, 246, 75);
		bankBtnPanel.add(btnBanking);
		
	}
}
