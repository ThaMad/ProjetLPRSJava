package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mdpOublier {

	private JFrame frame;
	private JTextField mail;
	private JTextField mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mdpOublier window = new mdpOublier();
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
	public mdpOublier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		ImageIcon monImage = new ImageIcon("C:\\Users\\MADAWALA_Th\\eclipse-workspace\\ProjetLPRSJava\\src\\demo\\logolprsjava.png"); 
		Image image = monImage.getImage(); // transform it 
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ImageIcon monImagetrans = new ImageIcon(newimg);  // transform it back
		JPanel navbar = new JPanel();
		navbar.setBackground(new Color(51, 153, 204));
		navbar.setBounds(0, -15, 535, 74);
		frame.getContentPane().add(navbar);
		navbar.setLayout(null);
		
		JLabel navbarlogo = new JLabel(" Robert Schuman ");
		navbarlogo.setForeground(UIManager.getColor("inactiveCaptionBorder"));
		navbarlogo.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
		navbarlogo.setBounds(23, 11, 234, 63);
		navbar.add(navbarlogo);
		navbarlogo.setIcon(monImagetrans);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(20, 70, 558, 95);
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
		S.setBounds(269, 0, 27, 64);
		panel_1.add(S);
		
		JLabel lblNewLabel = new JLabel("Votre mail :");
		lblNewLabel.setBounds(20, 212, 131, 21);
		frame.getContentPane().add(lblNewLabel);
		
		mail = new JTextField();
		mail.setBounds(169, 213, 272, 20);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nouveau mot de passe :");
		lblNewLabel_1.setBounds(20, 269, 171, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		mdp = new JTextField();
		mdp.setBounds(201, 266, 272, 19);
		frame.getContentPane().add(mdp);
		mdp.setColumns(10);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				accueil accueil = new accueil();
				accueil.run();
			}
		});
		btnNewButton.setBounds(67, 322, 146, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Mail = mail.getText();
				String Mdp = mdp.getText();
				
				User u = User.getInstance1(Mail, Mdp);
				manager_thomas m = new manager_thomas();
				try {
					frame.dispose();
					m.newMdp(u);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(265, 322, 146, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			mdpOublier window = new mdpOublier();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
