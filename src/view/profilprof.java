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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.User;

public class profilprof {

	private JFrame frame;
	private Connection connexion;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profilprof window = new profilprof();
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
	public profilprof() {
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
	
		// requete pour recuperer le nom et le prenom du professeur
		ResultSet resultat= stm.executeQuery("SELECT nom,prenom FROM user WHERE mail =('"+u.mail+"')");
		
		if(resultat.next()) {
			JLabel name = new JLabel(""+resultat.getString("nom")+ " "+resultat.getString("prenom"));
			name.setHorizontalAlignment(SwingConstants.CENTER);
			name.setForeground(new Color(255, 99, 71));
			name.setFont(new Font("Heiti SC", Font.BOLD, 23));
			name.setBounds(6, 46, 536, 43);
			panel_1.add(name);
		}
		
	} catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	
	
	try {
		java.sql.Statement stm= connexion.createStatement();
		
		// requete pour recuperer les donnees des films
		ResultSet resultat= stm.executeQuery("SELECT count(*) AS nbrClassePP FROM classe INNER JOIN user ON classe.id_prof_principale = user.idUser WHERE mail = ('"+u.mail+"')");
		if(resultat.next()) {
			int count = resultat.getInt("nbrClassePP");
			if(count > 0) {
				JButton btnRDV = new JButton("RENDEZ-VOUS");
				btnRDV.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						tableRdv tableRdv = new tableRdv();
						tableRdv.run();
					}
				});
				btnRDV.setForeground(new Color(255, 255, 255));
				btnRDV.setFont(new Font("Heiti SC", Font.PLAIN, 13));
				btnRDV.setBackground(new Color(255, 70, 42));
				btnRDV.setBounds(-13, 145, 573, 95);
				frame.getContentPane().add(btnRDV);
			}
		}
		
	} catch(SQLException e1) {
			e1.printStackTrace();
			System.out.println("erreur dans l'ajout");	
	}

	
	JButton btnplanning = new JButton("PLANNING");
	btnplanning.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			planning planning = new planning();
			planning.run();
		}
	});
	btnplanning.setForeground(new Color(255, 255, 255));
	btnplanning.setFont(new Font("Heiti SC", Font.PLAIN, 13));
	btnplanning.setBackground(new Color(255, 99, 71));
	btnplanning.setBounds(-13, 240, 573, 95);
	frame.getContentPane().add(btnplanning);
	
	JButton btngestionclasse = new JButton("GESTION DES CLASSES");
	btngestionclasse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			gestionclasses gestionclasses = new gestionclasses();
			gestionclasses.run();
		}
	});
	btngestionclasse.setForeground(Color.WHITE);
	btngestionclasse.setFont(new Font("Heiti SC", Font.PLAIN, 13));
	btngestionclasse.setBackground(new Color(250, 128, 114));
	btngestionclasse.setBounds(-13, 329, 573, 95);
	frame.getContentPane().add(btngestionclasse);
	
	JButton btnplanning_1 = new JButton("DEMANDE DE FOURNITURES");
	btnplanning_1.setForeground(Color.WHITE);
	btnplanning_1.setFont(new Font("Heiti SC", Font.PLAIN, 13));
	btnplanning_1.setBackground(new Color(255, 153, 153));
	btnplanning_1.setBounds(-13, 417, 573, 111);
	frame.getContentPane().add(btnplanning_1);
	
	frame.setBounds(100, 100, 549, 550);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			profilprof window = new profilprof();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
