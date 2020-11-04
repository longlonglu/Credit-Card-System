import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class bananabee extends vendor{
   double cost[]= {20.99,18.99,20.99,14.99,12.99,11.79};
   int    amount[]= {0,0,0,0,0,0};
   String ItemsName[]= {
		   "<html>Loaded Shrimp<br>Fajitas<br></html>",
		   "<html>Chicken Quesadilla</html>",
		   "<html>Loaded Chicken<br>Fajitas</html>",
		   "<html>The Classic<br>Combo</html>",
		   "<html>Taco Topped<br>Queso & Chips</html>",
		   "<html>Neighborhood Nachos<br>Beef</html>" 
   };
   double total=0.0;
   String shopName="bananabees";
   Calendar s;
   public JFrame frame;
	JLabel ti84lable;
		JLabel tabslable ;
		JLabel presharpenedlable ;
		JLabel drylable ;
		JLabel collegelable ;
		JLabel fileFolderlable ;
		JLabel lbti84 ;
		JLabel lbdry ;
		JLabel lbpresharpened ;
		JLabel lbFileFolder ;
		JLabel lbcollege ;
		JLabel lbtabs ;
		JLabel ti84costlb ;
		JLabel tabscostlb ;
		JLabel presharcostlb ;
		JLabel fileFoldercostlb ;
		JLabel collegecostlb ;
		JLabel drycostlb ;	
		JLabel totalCost;
     	JLabel lblTotal;
     	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bananabee window = new bananabee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bananabee(Calendar x) {
		s=x;
		initialize();
	}
    public bananabee(int [] amount,Calendar x) {
    	this.amount=amount;
    	s=x;
    	initialize();
    }
	public bananabee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 685, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		for(int i=0;i<cost.length;i++) {
			total+=cost[i]*amount[i];
		}
		
		JButton btnNewButton_1 = new JButton("Check Out");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(total>1) {
				CheckOut temp = new CheckOut(cost,amount,shopName,s);
				temp.frame.setVisible(true);
				frame.dispose();
				}
			}
		});
		btnNewButton_1.setBounds(539, 450, 120, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("reset");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton_2.setBounds(429, 450, 100, 50);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(20, 70, 166, 143);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("<html>Loaded Shrimp<br>Fajitas<br></html>\n\n");
		label.setBounds(18, 6, 130, 70);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton ti84BTNjian = new JButton("-");
		ti84BTNjian.setContentAreaFilled(false);
		ti84BTNjian.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		ti84BTNjian.setFont(new Font("Arial", Font.BOLD, 20));
		ti84BTNjian.setBounds(6, 87, 50, 50);
		panel.add(ti84BTNjian);
		
		JButton ti84BTN = new JButton("+");
		ti84BTN.setContentAreaFilled(false);
		ti84BTN.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		ti84BTN.setFont(new Font("Arial", Font.BOLD, 20));
		ti84BTN.setBounds(110, 87, 50, 50);
		panel.add(ti84BTN);
		
		ti84lable = new JLabel(""+amount[0]);
		ti84lable.setFont(new Font("Cambria Math", Font.BOLD, 20));
		ti84lable.setBounds(58, 86, 50, 50);
		panel.add(ti84lable);
		ti84lable.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("$ "+cost[0]);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(110, 70, 61, 16);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(20, 370, 166, 143);
		frame.getContentPane().add(panel_1);
		
		JLabel lblpostitTabsWith = new JLabel("<html>The Classic<br>Combo</html>");
		lblpostitTabsWith.setHorizontalAlignment(SwingConstants.LEFT);
		lblpostitTabsWith.setBounds(6, 6, 130, 81);
		panel_1.add(lblpostitTabsWith);
		
		JButton tabsBTN = new JButton("+");
		tabsBTN.setContentAreaFilled(false);
		tabsBTN.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		tabsBTN.setFont(new Font("Arial", Font.BOLD, 20));
		tabsBTN.setBounds(110, 87, 50, 50);
		panel_1.add(tabsBTN);
		
		JButton tabsBTNjian = new JButton("-");
		tabsBTNjian.setContentAreaFilled(false);
		tabsBTNjian.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		tabsBTNjian.setFont(new Font("Arial", Font.BOLD, 20));
		tabsBTNjian.setBounds(6, 87, 50, 50);
		panel_1.add(tabsBTNjian);
		
		JLabel label_5 = new JLabel("$ "+cost[4]);
		label_5.setFont(new Font("Arial", Font.BOLD, 15));
		label_5.setBounds(105, 71, 61, 16);
		panel_1.add(label_5);
		
		collegelable = new JLabel(""+amount[4]);
		collegelable.setFont(new Font("Cambria Math", Font.BOLD, 20));
		collegelable.setBounds(56, 86, 50, 50);
		panel_1.add(collegelable);
		collegelable.setHorizontalAlignment(SwingConstants.CENTER);
		tabsBTNjian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amount[4]>0)
					amount[4]--;
				    refresh();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(198, 370, 166, 143);
		frame.getContentPane().add(panel_2);
		
		JLabel lblexpoLowOdor = new JLabel("<html>Neighborhood Nachos<br>Beef</html>");
		lblexpoLowOdor.setHorizontalAlignment(SwingConstants.LEFT);
		lblexpoLowOdor.setBounds(6, 6, 130, 70);
		panel_2.add(lblexpoLowOdor);
		
		JButton dryBTNjian = new JButton("-");
		dryBTNjian.setContentAreaFilled(false);
		dryBTNjian.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		dryBTNjian.setFont(new Font("Arial", Font.BOLD, 20));
		dryBTNjian.setBounds(6, 87, 50, 50);
		panel_2.add(dryBTNjian);
		
		drylable = new JLabel(""+amount[5]);
		drylable.setFont(new Font("Cambria Math", Font.BOLD, 20));
		drylable.setHorizontalAlignment(SwingConstants.CENTER);
		drylable.setBounds(57, 86, 50, 50);
		panel_2.add(drylable);
		drylable.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JButton dryBTN = new JButton("+");
		dryBTN.setContentAreaFilled(false);
		dryBTN.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		dryBTN.setFont(new Font("Arial", Font.BOLD, 20));
		dryBTN.setBounds(110, 87, 50, 50);
		panel_2.add(dryBTN);
		
		JLabel label_4 = new JLabel("$ "+cost[5]);
		label_4.setFont(new Font("Arial", Font.BOLD, 15));
		label_4.setBounds(110, 72, 61, 16);
		panel_2.add(label_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.setBounds(20, 220, 166, 143);
		frame.getContentPane().add(panel_3);
		
		JLabel lblstudentsGuideTo = new JLabel("<html>Loaded Chicken<br>Fajitas</html>");
		lblstudentsGuideTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblstudentsGuideTo.setBounds(6, 6, 130, 67);
		panel_3.add(lblstudentsGuideTo);
		
		JButton collegeBTNjian = new JButton("-");
		collegeBTNjian.setContentAreaFilled(false);
		collegeBTNjian.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		collegeBTNjian.setFont(new Font("Arial", Font.BOLD, 20));
		collegeBTNjian.setBounds(6, 87, 50, 50);
		panel_3.add(collegeBTNjian);
		
		JButton collegeBNT = new JButton("+");
		collegeBNT.setContentAreaFilled(false);
		collegeBNT.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		collegeBNT.setFont(new Font("Arial", Font.BOLD, 20));
		collegeBNT.setBounds(110, 87, 50, 50);
		panel_3.add(collegeBNT);
		
		JLabel label_2 = new JLabel("$ "+cost[2]);
		label_2.setFont(new Font("Arial", Font.BOLD, 15));
		label_2.setBounds(105, 70, 61, 16);
		panel_3.add(label_2);
		
		tabslable = new JLabel(""+amount[2]);
		tabslable.setFont(new Font("Cambria Math", Font.BOLD, 20));
		tabslable.setBounds(60, 86, 50, 50);
		panel_3.add(tabslable);
		tabslable.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4.setBounds(198, 70, 166, 143);
		frame.getContentPane().add(panel_4);
		
		JLabel lblSoftyellow = new JLabel("<html>Chicken Quesadilla</html>");
		lblSoftyellow.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoftyellow.setBounds(6, 6, 130, 81);
		panel_4.add(lblSoftyellow);
		
		JButton presharpenedBTNjian = new JButton("-");
		presharpenedBTNjian.setContentAreaFilled(false);
		presharpenedBTNjian.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		presharpenedBTNjian.setFont(new Font("Arial", Font.BOLD, 20));
		presharpenedBTNjian.setBounds(6, 87, 50, 50);
		panel_4.add(presharpenedBTNjian);
		
		JButton presharpenedBNT = new JButton("+");
		presharpenedBNT.setContentAreaFilled(false);
		presharpenedBNT.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		presharpenedBNT.setFont(new Font("Arial", Font.BOLD, 20));
		presharpenedBNT.setBounds(110, 87, 50, 50);
		panel_4.add(presharpenedBNT);
		
		JLabel label_1 = new JLabel("$ "+cost[1]);
		label_1.setFont(new Font("Arial", Font.BOLD, 15));
		label_1.setBounds(105, 71, 61, 16);
		panel_4.add(label_1);
		
		fileFolderlable = new JLabel(""+amount[1]);
		fileFolderlable.setFont(new Font("Cambria Math", Font.BOLD, 20));
		fileFolderlable.setBounds(57, 86, 50, 50);
		panel_4.add(fileFolderlable);
		fileFolderlable.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_5.setBounds(198, 220, 166, 143);
		frame.getContentPane().add(panel_5);
		
		JLabel lblsmeadManilaFile = new JLabel("<html>Taco Topped<br>Queso & Chips<br></html>");
		lblsmeadManilaFile.setHorizontalAlignment(SwingConstants.LEFT);
		lblsmeadManilaFile.setBounds(6, 6, 130, 60);
		panel_5.add(lblsmeadManilaFile);
		
		JButton fileFolderBTN = new JButton("+");
		fileFolderBTN.setContentAreaFilled(false);
		fileFolderBTN.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		fileFolderBTN.setFont(new Font("Arial", Font.BOLD, 20));
		fileFolderBTN.setBounds(111, 87, 49, 50);
		panel_5.add(fileFolderBTN);
		
		JButton fileFolderBTNjian = new JButton("-");
		fileFolderBTNjian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amount[3]>0) {
					amount[3]--;
					refresh();
				}
			}
		});
		fileFolderBTNjian.setContentAreaFilled(false);
		fileFolderBTNjian.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		fileFolderBTNjian.setFont(new Font("Arial", Font.BOLD, 20));
		fileFolderBTNjian.setBounds(6, 87, 50, 50);
		panel_5.add(fileFolderBTNjian);
		
		JLabel label_3 = new JLabel("$ "+cost[3]);
		label_3.setFont(new Font("Arial", Font.BOLD, 15));
		label_3.setBounds(115, 72, 61, 16);
		panel_5.add(label_3);
		
		presharpenedlable = new JLabel(""+amount[3]);
		presharpenedlable.setFont(new Font("Cambria Math", Font.BOLD, 20));
		presharpenedlable.setBounds(60, 86, 50, 50);
		panel_5.add(presharpenedlable);
		presharpenedlable.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(380, 70, 285, 367);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Shopping cart");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_6.setBounds(10, 6, 269, 25);
		panel_6.add(lblNewLabel_6);
		
		lbti84 = new JLabel("Shrimp Fajitas x "+amount[0]);
		lbti84.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbti84.setHorizontalAlignment(SwingConstants.RIGHT);
		lbti84.setBounds(6, 37, 171, 35);
		panel_6.add(lbti84);
		
		lbFileFolder = new JLabel("Taco Queso&Chips x "+amount[3]);
		lbFileFolder.setBackground(Color.WHITE);
		lbFileFolder.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbFileFolder.setHorizontalAlignment(SwingConstants.RIGHT);
		lbFileFolder.setBounds(6, 178, 171, 35);
		panel_6.add(lbFileFolder);
		
		lbcollege = new JLabel("Chicken Fajitas x "+amount[2]);
		lbcollege.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbcollege.setHorizontalAlignment(SwingConstants.RIGHT);
		lbcollege.setBounds(6, 131, 171, 35);
		panel_6.add(lbcollege);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(47, 320, 130, 35);
		panel_6.add(lblTotal);
		
		ti84costlb = new JLabel("$ "+(cost[0]*amount[0]));
		ti84costlb.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		ti84costlb.setHorizontalAlignment(SwingConstants.CENTER);
		ti84costlb.setBounds(183, 38, 96, 35);
		panel_6.add(ti84costlb);
		
		fileFoldercostlb = new JLabel("$ "+(cost[4]*amount[4]));
		fileFoldercostlb.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		fileFoldercostlb.setHorizontalAlignment(SwingConstants.CENTER);
		fileFoldercostlb.setBounds(183, 225, 96, 35);
		panel_6.add(fileFoldercostlb);
		
		collegecostlb = new JLabel("$ "+(cost[1]*amount[1]));
		collegecostlb.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		collegecostlb.setHorizontalAlignment(SwingConstants.CENTER);
		collegecostlb.setBounds(183, 84, 96, 35);
		panel_6.add(collegecostlb);
		
		totalCost = new JLabel("$ "+String.format("%.2f",total));
		totalCost.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		totalCost.setHorizontalAlignment(SwingConstants.CENTER);
		totalCost.setBounds(183, 322, 96, 35);
		panel_6.add(totalCost);
		
		lbpresharpened = new JLabel("Chicken Quesadilla x "+amount[1]);
		lbpresharpened.setBounds(6, 84, 171, 35);
		panel_6.add(lbpresharpened);
		lbpresharpened.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbpresharpened.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lbdry = new JLabel("Nachos Beef x "+amount[5]);
		lbdry.setBounds(6, 272, 171, 35);
		panel_6.add(lbdry);
		lbdry.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbdry.setHorizontalTextPosition(SwingConstants.CENTER);
		lbdry.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lbtabs = new JLabel("Classic Combo x "+amount[4]);
		lbtabs.setBounds(6, 225, 171, 35);
		panel_6.add(lbtabs);
		lbtabs.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lbtabs.setHorizontalAlignment(SwingConstants.RIGHT);
		
		presharcostlb = new JLabel("$ "+(cost[3]*amount[3]));
		presharcostlb.setBounds(183, 178, 96, 35);
		panel_6.add(presharcostlb);
		presharcostlb.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		presharcostlb.setHorizontalAlignment(SwingConstants.CENTER);
		
		drycostlb = new JLabel("$ "+(cost[5]*amount[5]));
		drycostlb.setBounds(183, 275, 96, 35);
		panel_6.add(drycostlb);
		drycostlb.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		drycostlb.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabscostlb = new JLabel("$ "+(cost[2]*amount[2]));
		tabscostlb.setBounds(183, 131, 96, 35);
		panel_6.add(tabscostlb);
		tabscostlb.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tabscostlb.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 0, 651, 70);
		frame.getContentPane().add(panel_7);
		
		JButton btnBack = new JButton("< Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shops_View next= new Shops_View(s);
				next.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnBack.setBounds(0, 10, 100, 40);
		panel_7.add(btnBack);
		
		JLabel label_6 = new JLabel();
		label_6.setBounds(205, 0, 180, 65);
		Image banbee_logo = new ImageIcon(Login_View.class.getResource("bananaBees_logo.png")).getImage().getScaledInstance(180, 70, Image.SCALE_SMOOTH);
		label_6.setIcon(new ImageIcon(banbee_logo));
		panel_7.add(label_6);
		fileFolderBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount[3]++;
				refresh();
			}
		});
		presharpenedBNT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount[1]++;
				refresh();
			}
		});
		presharpenedBTNjian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amount[1]>0)
					amount[1]--;
				    refresh();
			}
		});
		collegeBNT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount[2]++;
				refresh();
			}
		});
		collegeBTNjian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amount[2]>0)
					amount[2]--;
				    refresh();
			}
		});
		dryBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount[5]++;
				refresh();
			}
		});
		dryBTNjian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amount[5]>0)
					amount[5]--;
				    refresh();
			}
		});
		tabsBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount[4]++;
				refresh();
			}
		});
		ti84BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount[0]++;
				refresh();
			}
		});
		ti84BTNjian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amount[0]>0)
					amount[0]--;
				refresh();
			}
		});
		
	}
	
	
	//refresh
	public  void refresh() {
	ti84lable.setText(""+amount[0]);
		
		presharpenedlable.setText(""+amount[3]);
	
		collegelable.setText(""+amount[4]) ;
		
		fileFolderlable.setText(""+amount[1]) ;
		
		tabslable.setText(""+amount[2]);
		
		drylable.setText(""+amount[5]);
		

		
	
		
		lbti84.setText("Shrimp Fajitas x "+amount[0]);
		
		lbdry.setText("Nachos Beef x "+amount[5]) ;
		
	    lbpresharpened.setText("Chicken Quesadilla x "+amount[1]) ;
		
		lbFileFolder.setText("Taco Queso&Chips x "+amount[3]) ;
		
		lbcollege.setText("Chicken Fajitas x "+amount[2]) ;
		
		lbtabs.setText("Classic Combo x "+amount[4]) ;
		
		
	     ti84costlb.setText("$ "+((double)Math.round(amount[0]*cost[0]*100)/100));
			
			tabscostlb.setText("$ "+((double)Math.round(amount[2]*cost[2]*100)/100));
			
			presharcostlb.setText("$ "+((double)Math.round(amount[3]*cost[3]*100)/100));
			
			drycostlb.setText("$ "+((double)Math.round(amount[5]*cost[5]*100)/100));
			
			collegecostlb.setText("$ "+((double)Math.round(amount[1]*cost[1]*100)/100)) ;
			
			fileFoldercostlb.setText("$ "+((double)Math.round(amount[4]*cost[4]*100)/100)) ;
			
		

			total = (double)Math.round(((amount[0]*cost[0])+(amount[3]*cost[3])+(amount[1]*cost[1])+(amount[4]*cost[4])+(amount[2]*cost[2])+(amount[5]*cost[5]))*100)/100;
			totalCost.setText("$ "+ total);
	}
	public void reset(){
		for(int i=0;i<cost.length;i++)
		   amount[i]=0;
		refresh();
	}
}