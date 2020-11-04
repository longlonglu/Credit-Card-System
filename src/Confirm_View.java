import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Confirm_View extends JFrame {
 
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Confirm_View(Calendar s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Thank you, <br>Your order has been placed!</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 102, 316, 54);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Continue Shopping");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(0, 188, 65));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shops_View next=new Shops_View(s);
				next.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(83, 192, 170, 40);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 336, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(45, 10, 246, 55);
		panel.add(panel_1);
		
		JLabel label = new JLabel("R I K I B U Y");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 188, 65));
		label.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		label.setBounds(53, 0, 183, 24);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("BUY All You Wanna Buy");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 188, 65));
		label_1.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 15));
		label_1.setBounds(60, 30, 176, 25);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("R");
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial Black", Font.BOLD, 45));
		label_2.setBackground(new Color(0, 188, 65));
		label_2.setAlignmentY(0.0f);
		label_2.setBounds(0, 0, 55, 55);
		panel_1.add(label_2);
	}

}
