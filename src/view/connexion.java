package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.User;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class connexion {

	private JFrame frame;
	private JTextField mail;
	private JTextField mdp;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion window = new connexion();
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
	public connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		ImageIcon monImage = new ImageIcon("C:\\Users\\MADAWALA_Th\\eclipse-workspace\\ProjetLPRSJava\\src\\demo\\logolprsjava.png"); 
		Image image = monImage.getImage(); // transform it 
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ImageIcon monImagetrans = new ImageIcon(newimg);  // transform it back
		JPanel navbar = new JPanel();
		navbar.setBackground(new Color(51, 153, 204));
		navbar.setBounds(0, 0, 549, 74);
		frame.getContentPane().add(navbar);
		navbar.setLayout(null);
		
		JLabel navbarlogo = new JLabel(" CONNEXION ");
		navbarlogo.setForeground(UIManager.getColor("inactiveCaptionBorder"));
		navbarlogo.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
		navbarlogo.setBounds(23, 11, 234, 63);
		navbar.add(navbarlogo);
		navbarlogo.setIcon(monImagetrans);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 75, 558, 95);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel L = new JLabel("L");
		L.setForeground(new Color(255, 204, 255));
		L.setHorizontalAlignment(SwingConstants.CENTER);
		L.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
		L.setBounds(197, 0, 27, 64);
		panel_1.add(L);
		
		JLabel P = new JLabel("P");
		P.setHorizontalAlignment(SwingConstants.CENTER);
		P.setForeground(new Color(204, 255, 153));
		P.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
		P.setBounds(220, 0, 27, 64);
		panel_1.add(P);
		
		JLabel R = new JLabel("R");
		R.setHorizontalAlignment(SwingConstants.CENTER);
		R.setForeground(new Color(204, 204, 255));
		R.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
		R.setBounds(245, 0, 27, 64);
		panel_1.add(R);
		
		JLabel S = new JLabel("S");
		S.setHorizontalAlignment(SwingConstants.CENTER);
		S.setForeground(new Color(230, 230, 250));
		S.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
		S.setBounds(271, 0, 27, 64);
		panel_1.add(S);
		
		JLabel lblNewLabel_1 = new JLabel("MAIL :");
		lblNewLabel_1.setBounds(20, 246, 83, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		mail = new JTextField();
		mail.setBounds(169, 251, 231, 19);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("MOT DE PASSE :");
		lblNewLabel_1_1.setBounds(20, 282, 142, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		mdp = new JTextField();
		mdp.setColumns(10);
		mdp.setBounds(169, 291, 231, 19);
		frame.getContentPane().add(mdp);
		
		btnNewButton = new JButton("CONNEXION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mailUser = mail.getText();
          		String mdpUser = mdp.getText();
          		
          		//user a = new user(mailUser,mdpUser);
          		User u = User.getInstance1(mailUser,mdpUser);
        		manager_thomas b = new manager_thomas();
        		b.connexion(u);
        		frame.dispose();
			}
		});
		btnNewButton.setBounds(69, 329, 164, 45);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("RETOUR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				accueil accueil = new accueil();
				accueil.run();
			}
		});
		btnNewButton_1.setBounds(284, 329, 154, 45);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			connexion window = new connexion();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
