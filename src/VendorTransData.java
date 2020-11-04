
import java.awt.BorderLayout;
import java.awt.Color;
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;

public class VendorTransData extends JFrame {

	private Color Color_navy = new Color(0,73,118);
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public VendorTransData(String shopName,Calendar s,String loginUser) throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 423);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(6, 74, 531, 302);
		contentPane.add(scrollPane);
		ArrayList<String> temp = new ArrayList<>();
		String[][] ACdata;
		String [] header= {"transactionID","cost","DATE","cardNumber"};
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_card_system?userTimezone=true&serverTimezone=UTC","root","wang87067835");
		  Statement statement =con.createStatement();
		  ResultSet data=statement.executeQuery("SELECT * FROM transactions WHERE paidTo ='"+ shopName +"' ");
		  while(data.next()) {
			  temp.add(data.getString("paidTo"));
		  }
		  ACdata=new String[temp.size()][4];
		  int i=0;
		  data=statement.executeQuery("SELECT * FROM transactions WHERE paidTo ='"+ shopName +"' ");
		  while(data.next()) {
			  ACdata[i][0]=data.getString("transactionID");
			  ACdata[i][1]="$ "+data.getString("cost");
			  ACdata[i][2]=data.getString("DATE").substring(0,10);
			  ACdata[i][3]=String.format("%04d", Integer.parseInt(data.getString("cardNumber")));
			  i++;
		  }
		  	table = new AlterColor_JTable(ACdata, header);
			table.setGridColor(Color.WHITE);
			table.setColumnSelectionAllowed(true);
			table.setBorder(null);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			table.setEnabled(false);
			table.setFocusable(false);
			table.setRowSelectionAllowed(false);
			scrollPane.setViewportView(table);
			table.setFont(new Font("Arial", Font.PLAIN, 17));
			
			JButton btnNewButton = new JButton("< Back");
			btnNewButton.setForeground(Color_navy);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
			btnNewButton.setBorder(new LineBorder(Color_navy, 2, true));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VendorTransMenu next = new VendorTransMenu(loginUser,s);
					next.setVisible(true);
					dispose();
				}
			});
			btnNewButton.setBounds(20, 10, 100, 30);
			contentPane.add(btnNewButton);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(174, 10, 220, 50);
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
			// table header styling
			JTableHeader headerStyle = table.getTableHeader();
			headerStyle.setFont(new Font("Arial", Font.BOLD, 20));
			headerStyle.setForeground(Color_navy);
			DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
		    renderer.setHorizontalAlignment(JLabel.LEFT);		// header alignment left
			for (int j=0; j<ACdata.length; j++) {
				table.setRowHeight(j, 30);
			}
	}
}
