package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;


import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class accueil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accueil window = new accueil();
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
	public accueil() {
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
		
		JButton btnconnexion = new JButton("CONNEXION");
		btnconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				connexion connexion = new connexion();
				connexion.run();
			}
		});
		btnconnexion.setBackground(new Color(153, 153, 255));
		btnconnexion.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		btnconnexion.setForeground(Color.WHITE);
		btnconnexion.setBounds(0, 189, 535, 90);
		frame.getContentPane().add(btnconnexion);
		
		JButton btninscription = new JButton("INSCRIPTION");
		btninscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				inscription inscription = new inscription();
				inscription.run();
			}
		});
		btninscription.setForeground(Color.WHITE);
		btninscription.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		btninscription.setBackground(new Color(184, 184, 255));
		btninscription.setBounds(0, 276, 535, 95);
		frame.getContentPane().add(btninscription);
		
		JButton btnmdpoubli = new JButton("MOT DE PASSE OUBLIE");
		btnmdpoubli.setForeground(Color.WHITE);
		btnmdpoubli.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		btnmdpoubli.setBackground(new Color(204, 204, 255));
		btnmdpoubli.setBounds(0, 365, 535, 95);
		frame.getContentPane().add(btnmdpoubli);
		
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
