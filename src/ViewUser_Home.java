import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ViewUser_Home extends JFrame {
	
	private JPanel contentPane;
	
	private Color Color_navy = new Color(0,73,118);
	/**
	 * Create the frame.
	 */
	public ViewUser_Home(String loginUser,Calendar s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel greetingPanel = new JPanel();
		greetingPanel.setBackground(Color.WHITE);
		greetingPanel.setBounds(10, 81, 566, 70);
		contentPane.add(greetingPanel);
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
		
		JLabel lblGreetings = new JLabel("View existing account or Create new account");
		lblGreetings.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreetings.setFont(new Font("Candara", Font.ITALIC, 25));
		lblGreetings.setForeground(Color.BLACK);
		lblGreetings.setBounds(0, 20, 566, 35);
		greetingPanel.add(lblGreetings);
		Image greetingImg = new ImageIcon(Login_View.class.getResource("greeting_background.png")).getImage().getScaledInstance(566, 70, Image.SCALE_SMOOTH);
		
		JPanel selectPanel = new JPanel();
		selectPanel.setBackground(Color.WHITE);
		selectPanel.setBounds(10, 161, 566, 192);
		contentPane.add(selectPanel);
		selectPanel.setLayout(null);
		
		JPanel modifyBtnPanel = new JPanel();
		modifyBtnPanel.setBackground(Color.WHITE);
		modifyBtnPanel.setBorder(new LineBorder(Color_navy, 4, true));
		modifyBtnPanel.setBounds(61, 40, 190, 87);
		selectPanel.add(modifyBtnPanel);
		modifyBtnPanel.setLayout(null);
		
		JButton btnModify = new JButton("Edit Account");
		btnModify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModify.setBackground(Color_navy);
				btnModify.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnModify.setBackground(Color.white);
				btnModify.setForeground(Color_navy);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchUser_View shop = new SearchUser_View(loginUser,s);
				shop.setVisible(true);
				dispose();
			}
		});
		btnModify.setBorderPainted(false);
		btnModify.setBackground(Color.WHITE);
		btnModify.setFont(new Font("Courier New", Font.BOLD, 16));
		btnModify.setForeground(Color_navy);
		btnModify.setFocusable(false);
		btnModify.setBounds(5, 6, 180, 75);
		modifyBtnPanel.add(btnModify);
		
		JPanel bankBtnPanel = new JPanel();
		bankBtnPanel.setLayout(null);
		bankBtnPanel.setBorder(new LineBorder(Color_navy, 4, true));
		bankBtnPanel.setBackground(Color.WHITE);
		bankBtnPanel.setBounds(314, 40, 190, 87);
		selectPanel.add(bankBtnPanel);
		
		JButton btnBanking = new JButton("Create Account");
		btnBanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanking.setBounds(6, 6, 178, 75);
		bankBtnPanel.add(btnBanking);
		btnBanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBanking.setBackground(Color_navy);
				btnBanking.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBanking.setBackground(Color.white);
				btnBanking.setForeground(Color_navy);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateUser_View openFrame = new CreateUser_View(loginUser,s);
				openFrame.frame.setVisible(true);
				dispose();
			}
		});
		btnBanking.setForeground(Color_navy);
		btnBanking.setFont(new Font("Courier New", Font.BOLD, 16));
		btnBanking.setFocusable(false);
		btnBanking.setBorderPainted(false);
		btnBanking.setBackground(Color.WHITE);
		
		
		String username = null;
		try {
			username = loginUser;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Object choice[] = {
				loginUser,
				new JSeparator(JSeparator.HORIZONTAL),
				"<html><strong>Sign Out<strong></html>"};
		JComboBox<Object> comboBox = new JComboBox<Object>(choice);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		ComboBoxRenderer renderer= new ComboBoxRenderer();
	    renderer.setPreferredSize(new Dimension(125, 30));
	    comboBox.setRenderer(renderer);
	    
		comboBox.setLocation(424, 10);
		comboBox.setSize(152, 30);
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		comboBox.setBackground(new Color(29,132,199));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					if (((String)e.getItem()).contains("Profile")) {
						System.out.println("Go to Profile");
					}
					else if (((String)e.getItem()).contains("Security")) {
						System.out.println("Go to Security");
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
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(166, 10, 220, 50);
		contentPane.add(logoPanel);
		
		JLabel lblLogo = new JLabel("");
		Image bankLogo = new ImageIcon(Login_View.class.getResource("bankLogo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(bankLogo));
		lblLogo.setAlignmentY(0.0f);
		
		JLabel lblCapital = new JLabel("Capital");
		lblCapital.setForeground(Color_navy);
		lblCapital.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTwo = new JLabel("Two");
		lblTwo.setVerticalAlignment(SwingConstants.TOP);
		lblTwo.setForeground(Color_navy);
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
		
		JButton button = new JButton("< Back");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SuperHome_View back = new SuperHome_View(loginUser,s);
				back.setVisible(true);
				dispose();
			}
		});
		button.setBorder(new LineBorder(new Color(0, 73, 118), 2, true));
		button.setForeground(Color_navy);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setFont(new Font("Arial", Font.PLAIN, 20));
		button.setBounds(10, 10, 107, 30);
		contentPane.add(button);
	}
}
