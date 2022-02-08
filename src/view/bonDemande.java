package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.DemandeStockFournisseur;
import model.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class bonDemande {
	private Connection connexion;
	private JFrame frame;
	private static String stockChoisi, fourniChoisi;
	private  static int nbrDemande;
	private int Idstock = 0;
	private int Idfourni = 0;
	private int Iduser = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bonDemande window = new bonDemande(nbrDemande,stockChoisi, fourniChoisi);
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
	public bonDemande(int nbrDemande, String stockChoisi, String fourniChoisi) {
		this.nbrDemande= nbrDemande;
		this.stockChoisi = stockChoisi;
		this.fourniChoisi = fourniChoisi;
		initialize(nbrDemande,stockChoisi, fourniChoisi);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int nbrDemande,String stockChoisi, String fourniChoisi) {
		manager_thomas a = new manager_thomas();
		connexion =  a.bdd();
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
		navbar.setBounds(0, -15, 700, 74);
		frame.getContentPane().add(navbar);
		navbar.setLayout(null);
		
		JLabel navbarlogo = new JLabel(" Bon de commande ");
		navbarlogo.setForeground(UIManager.getColor("inactiveCaptionBorder"));
		navbarlogo.setFont(new Font("Heiti TC", Font.BOLD, 16));
		navbarlogo.setBounds(23, 11, 234, 63);
		navbar.add(navbarlogo);
		navbarlogo.setIcon(monImagetrans);
		
		JLabel lblNewLabel_1 = new JLabel("Bonjour "+fourniChoisi+",");
		lblNewLabel_1.setBounds(10, 69, 117, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Ci-joint une demande auprès de votre entreprise pour le restock de notre produit avec la quantité suivante:");
		lblNewLabel.setBounds(10, 121, 666, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(""+stockChoisi+" :");
		lblNewLabel_2.setBounds(53, 182, 95, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(""+nbrDemande);
		lblNewLabel_2_1.setBounds(150, 182, 95, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		try {
			java.sql.Statement stm= connexion.createStatement();
  			ResultSet resultat= stm.executeQuery("SELECT idUser FROM user where mail = ('"+u.mail+"')");
  			if(resultat.next()) {
  				 Iduser = Integer.parseInt(resultat.getString("idUser"));
			}
  			ResultSet resultat2= stm.executeQuery("SELECT idFourni FROM fournisseur where nom = ('"+fourniChoisi+"')");
  			if(resultat2.next()) {
  				 Idfourni = Integer.parseInt(resultat2.getString("idFourni"));
			}
  			ResultSet resultat3= stm.executeQuery("SELECT idStock FROM stock where libelle = ('"+stockChoisi+"')");
  			if(resultat3.next()) {
  				 Idstock = Integer.parseInt(resultat3.getString("idStock"));
			}
		}
		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
		JButton btnNewButton = new JButton("Envoyer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DemandeStockFournisseur d = new DemandeStockFournisseur(Idfourni,Iduser,nbrDemande,Idstock);
				a.sendDemande(d);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(364, 215, 129, 20);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionStock actionStock = new actionStock();
				actionStock.run();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(516, 215, 129, 20);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		frame.setBounds(150, 150, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			bonDemande window = new bonDemande(nbrDemande,stockChoisi, fourniChoisi);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
