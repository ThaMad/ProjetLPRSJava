package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class gestionprofil {

	private JFrame frame;
	private Connection connexion;
	private JTextField nomUser;
	private JTextField prenomUser;
	private JTextField mailuser;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionprofil window = new gestionprofil();
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
	public gestionprofil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		manager_thomas a = new manager_thomas();
		connexion =  (Connection) a.bdd();
		User u = User.getInstanceVide();
		frame = new JFrame();
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
		
		JLabel navbarlogo = new JLabel(" Robert Schuman ");
		navbarlogo.setForeground(UIManager.getColor("inactiveCaptionBorder"));
		navbarlogo.setFont(new Font("Heiti TC", Font.BOLD, 16));
		navbarlogo.setBounds(23, 11, 234, 63);
		navbar.add(navbarlogo);
		navbarlogo.setIcon(monImagetrans);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 71, 560, 95);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel bienvenue = new JLabel("Bienvenue");
		bienvenue.setForeground(new Color(255, 127, 80));
		bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenue.setFont(new Font("Heiti SC", Font.BOLD, 27));
		bienvenue.setBounds(129, 0, 284, 43);
		panel_1.add(bienvenue);
		
		try {
			java.sql.Statement stm= connexion.createStatement();
		
			// requete pour recuperer les donnees des films
			ResultSet resultat= stm.executeQuery("SELECT nom,prenom,mail FROM user WHERE mail =('"+u.mail+"')");
			
			if(resultat.next()) {
				JLabel name = new JLabel(""+resultat.getString("nom")+ " "+resultat.getString("prenom"));
				name.setHorizontalAlignment(SwingConstants.CENTER);
				name.setForeground(new Color(255, 99, 71));
				name.setFont(new Font("Heiti TC", Font.BOLD, 23));
				name.setBounds(6, 46, 536, 43);
				panel_1.add(name);
				
				JLabel lblNewLabel = new JLabel("NOM :");
				lblNewLabel.setBounds(47, 245, 81, 19);
				frame.getContentPane().add(lblNewLabel);
				
				nomUser = new JTextField(resultat.getString("nom"));
				nomUser.setBounds(160, 245, 207, 19);
				frame.getContentPane().add(nomUser);
				nomUser.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("PRENOM :");
				lblNewLabel_1.setBounds(47, 287, 81, 19);
				frame.getContentPane().add(lblNewLabel_1);
				
				prenomUser = new JTextField(resultat.getString("prenom"));
				prenomUser.setColumns(10);
				prenomUser.setBounds(160, 287, 207, 19);
				frame.getContentPane().add(prenomUser);
				
				JLabel lblNewLabel_2 = new JLabel("MAIL :");
				lblNewLabel_2.setBounds(47, 331, 81, 19);
				frame.getContentPane().add(lblNewLabel_2);
				
				mailuser = new JTextField(resultat.getString("mail"));
				mailuser.setColumns(10);
				mailuser.setBounds(160, 331, 207, 19);
				frame.getContentPane().add(mailuser);
				
				JButton btnNewButton = new JButton("ENREGISTRER");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String oldMail = u.mail;
						String newprenom = prenomUser.getText();
		          		String newnom = nomUser.getText();
		          		String newmail = mailuser.getText();

		          		if(newprenom !="" && newnom != "" && newmail != "") {
		          			User user = new User(newnom,newprenom,newmail);
		          			manager_thomas b = new manager_thomas();
		          			b.modifProfil(user,oldMail);
		    				frame.dispose();
		          		}
					}
				});
				btnNewButton.setBounds(60, 403, 171, 43);
				frame.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("RETOUR");
				btnNewButton_1.setBounds(276, 403, 171, 43);
				frame.getContentPane().add(btnNewButton_1);
				
				
			}
			
		} catch(SQLException e1) {
	  			e1.printStackTrace();
	  			System.out.println("erreur dans l'ajout");	
	  	}

		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			gestionprofil window = new gestionprofil();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
