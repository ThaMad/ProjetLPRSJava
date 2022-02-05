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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class inscription {

	private JFrame frame;
	private JTextField nom;
	private JTextField prenom;
	private JTextField mail;
	private JTextField mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscription window = new inscription();
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
	public inscription() {
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
		navbar.setBounds(0, -15, 549, 74);
		frame.getContentPane().add(navbar);
		navbar.setLayout(null);
		
		JLabel navbarlogo = new JLabel(" INSCRIPTION ");
		navbarlogo.setForeground(UIManager.getColor("inactiveCaptionBorder"));
		navbarlogo.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
		navbarlogo.setBounds(23, 11, 234, 63);
		navbar.add(navbarlogo);
		navbarlogo.setIcon(monImagetrans);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 58, 558, 95);
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
		
		
		JLabel lblNewLabel_1 = new JLabel("NOM :");
		lblNewLabel_1.setBounds(10, 184, 61, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		nom = new JTextField();
		nom.setBounds(107, 184, 235, 19);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRENOM :");
		lblNewLabel_1_1.setBounds(10, 213, 61, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(107, 213, 235, 19);
		frame.getContentPane().add(prenom);
		
		JLabel lblNewLabel_1_2 = new JLabel("MAIL :");
		lblNewLabel_1_2.setBounds(10, 242, 61, 19);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(107, 242, 235, 19);
		frame.getContentPane().add(mail);
		
		JLabel lblNewLabel_1_3 = new JLabel("MOT DE PASSE :");
		lblNewLabel_1_3.setBounds(10, 271, 94, 19);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		mdp = new JTextField();
		mdp.setColumns(10);
		mdp.setBounds(107, 271, 235, 19);
		frame.getContentPane().add(mdp);
		
		JLabel lblNewLabel_1_4 = new JLabel("Profil");
		lblNewLabel_1_4.setBounds(10, 310, 61, 19);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JRadioButton profil = new JRadioButton("Professeur");
		profil.setBounds(129, 309, 103, 21);
		frame.getContentPane().add(profil);
		
		JRadioButton profil1 = new JRadioButton("Administratif");
		profil1.setBounds(263, 309, 103, 21);
		frame.getContentPane().add(profil1);
		
		ButtonGroup group = new ButtonGroup();
        group.add(profil);
        group.add(profil1);
		
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String prenomUser = prenom.getText();
          		String nomUser = nom.getText();
          		String mailUser = mail.getText();
          		String mdpUser = mdp.getText();
          		String profilUser = "";
          		if(profil.isSelected()) {
          			profilUser = profil.getText();
          		}
          		if(profil1.isSelected()) {
          			profilUser = profil1.getText();
          		}
          		
          		if(prenomUser !="" && nomUser != "" && mailUser != "" && mdpUser != "" && profilUser != "") {
          			User user = User.getInstance(prenomUser, nomUser, mailUser, mdpUser, profilUser);
          			manager_thomas b = new manager_thomas();
          			b.inscription(user);
    				frame.dispose();
          		}
          		
			}
		});
		btnNewButton.setBounds(36, 354, 181, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				accueil accueil = new accueil();
				accueil.run();
			}
		});
		btnNewButton_1.setBounds(263, 354, 181, 35);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public void run() {
		// TODO Auto-generated method stub
		try {
			inscription window = new inscription();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
