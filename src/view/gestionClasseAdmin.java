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
import model.Classe;
import model.Eleve;
import model.User;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class gestionClasseAdmin {

	private JFrame frame;
	private Connection connexion;
	private JTextField addClasse;
	protected JLabel lblClasse;
	protected JLabel lblPP;
	protected JComboBox addPP;
	protected JButton saveAdd;
	protected JLabel lblClassesupp;
	protected JComboBox suppClasse;
	protected JButton saveSupp;
	protected JButton retour2;
	protected JButton retour;
	protected JComboBox modifClasse;
	protected JButton choixClasse;
	protected JLabel libelleClasse;
	private JTextField newNomClasse;
	protected JLabel newPP;
	protected JComboBox newPPClasse;
	protected JButton saveModif;
	protected JButton retour3;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionClasseAdmin window = new gestionClasseAdmin();
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
	public gestionClasseAdmin() {
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
			ResultSet resultat= stm.executeQuery("SELECT nom,prenom FROM user WHERE mail =('"+u.mail+"')");
			
			if(resultat.next()) {
				JLabel name = new JLabel(""+resultat.getString("nom")+ " "+resultat.getString("prenom"));
				name.setHorizontalAlignment(SwingConstants.CENTER);
				name.setForeground(new Color(255, 99, 71));
				name.setFont(new Font("Heiti TC", Font.BOLD, 23));
				name.setBounds(6, 46, 536, 43);
				panel_1.add(name);
			}
			
		} catch(SQLException e1) {
	  			e1.printStackTrace();
	  			System.out.println("erreur dans l'ajout");	
	  	}
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lblClassesupp != null) {
					lblClassesupp.setVisible(false);
					suppClasse.setVisible(false);
					saveSupp.setVisible(false);
					retour2.setVisible(false);
				}
				if(choixClasse != null) {
					choixClasse.setVisible(false);
					modifClasse.setVisible(false);
				}
				if(libelleClasse != null) {
				libelleClasse.setVisible(false);
				newNomClasse.setVisible(false);
				newPP.setVisible(false);
				newPPClasse.setVisible(false);
				saveModif.setVisible(false);
				retour3.setVisible(false);
				}
				lblClasse = new JLabel("Libelle classe:");
				lblClasse.setBounds(10, 303, 99, 20);
				frame.getContentPane().add(lblClasse);
				frame.repaint();
				
				addClasse = new JTextField();
				addClasse.setBounds(97, 304, 180, 20);
				frame.getContentPane().add(addClasse);
				addClasse.setColumns(10);
				frame.repaint();
				
				lblPP = new JLabel("Professeur principale");
				lblPP.setBounds(10, 343, 130, 20);
				frame.getContentPane().add(lblPP);
				frame.repaint();
				
				addPP = new JComboBox();
				addPP.setBounds(150, 343, 180, 20);
				frame.getContentPane().add(addPP);
				frame.repaint();
				try {
					java.sql.Statement stm= connexion.createStatement();
		  			
		  			ResultSet resultat= stm.executeQuery("SELECT nom FROM user WHERE profil= 'professeur'");
		  			while(resultat.next()) {
		  				 addPP.addItem(resultat.getString("nom"));
					}
				}
				catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
				
				saveAdd = new JButton("Enregistrer");
				saveAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String libelle = addClasse.getText();
						String nomPP = (String) addPP.getSelectedItem();
						
						frame.dispose();
						Classe newClasse = new Classe(libelle,nomPP);
						a.addNewClasse(newClasse);
					}
				});
				saveAdd.setBounds(191, 394, 146, 27);
				frame.getContentPane().add(saveAdd);
				frame.repaint();
				
				retour = new JButton("Retour");
				retour.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.dispose();
						gestionClasseAdmin gestionClasseAdmin = new gestionClasseAdmin();
						gestionClasseAdmin.run();
					}
				});
				retour.setBounds(10, 394, 146, 27);
				frame.getContentPane().add(retour);
				frame.repaint();
			}
		});
		btnNewButton.setBounds(10, 221, 161, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lblClasse != null) {
					lblClasse.setVisible(false);
					addClasse.setVisible(false);
					lblPP.setVisible(false);
					addPP.setVisible(false);
					saveAdd.setVisible(false);
					retour.setVisible(false);
				}
				if(choixClasse != null) {
					choixClasse.setVisible(false);
					modifClasse.setVisible(false);
				}
				if(libelleClasse != null) {
				libelleClasse.setVisible(false);
				newNomClasse.setVisible(false);
				newPP.setVisible(false);
				newPPClasse.setVisible(false);
				saveModif.setVisible(false);
				retour3.setVisible(false);
				}
				lblClassesupp = new JLabel("Classe :");
				lblClassesupp.setBounds(10, 303, 99, 20);
				frame.getContentPane().add(lblClassesupp);
				frame.repaint();
				suppClasse = new JComboBox();
				suppClasse.setBounds(115, 303, 180, 20);
				frame.getContentPane().add(suppClasse);
				frame.repaint();
				try {
					java.sql.Statement stm= connexion.createStatement();
		  			
		  			ResultSet resultat= stm.executeQuery("SELECT libelle FROM classe");
		  			while(resultat.next()) {
		  				 suppClasse.addItem(resultat.getString("libelle"));
					}
				}
				catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
				
				saveSupp = new JButton("Enregistrer");
				saveSupp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String libelle = (String) suppClasse.getSelectedItem();
						Classe classe = new Classe(libelle);
						a.suppClasse(classe);
						frame.dispose();
					}
				});
				saveSupp.setBounds(180, 350, 146, 27);
				frame.getContentPane().add(saveSupp);
				frame.repaint();
				
				retour2 = new JButton("Retour");
				retour2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.dispose();
						gestionClasseAdmin gestionClasseAdmin = new gestionClasseAdmin();
						gestionClasseAdmin.run();
					}
				});
				retour2.setBounds(10, 350, 146, 27);
				frame.getContentPane().add(retour2);
				frame.repaint();
			}
		});
		btnNewButton_1.setBounds(181, 221, 166, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lblClasse != null) {
					lblClasse.setVisible(false);
					addClasse.setVisible(false);
					lblPP.setVisible(false);
					addPP.setVisible(false);
					saveAdd.setVisible(false);
					retour.setVisible(false);
				}
				if(lblClassesupp != null) {
					lblClassesupp.setVisible(false);
					suppClasse.setVisible(false);
					saveSupp.setVisible(false);
					retour2.setVisible(false);
				}
					modifClasse= new JComboBox();
					modifClasse.setBounds(11, 270, 178 , 33);
					frame.getContentPane().add(modifClasse);
					try {
						java.sql.Statement stm= connexion.createStatement();
			  			
			  			ResultSet resultat= stm.executeQuery("SELECT libelle FROM classe");
			  			while(resultat.next()) {
			  				modifClasse.addItem(resultat.getString("libelle"));
						}
					}
					catch(SQLException e1) {
			  			e1.printStackTrace();
			  			System.out.println("erreur dans l'ajout");	
			  	}
					choixClasse = new JButton("Choisir");
					choixClasse.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String choix = (String) modifClasse.getSelectedItem();
							try {
								java.sql.Statement stm= connexion.createStatement();
					  			
					  			ResultSet resultat= stm.executeQuery("SELECT * FROM classe WHERE libelle = ('"+choix+"')");
					  			if(resultat.next()) {
					  				int idClasse = Integer.parseInt(resultat.getString("idClasse"));
					  				libelleClasse = new JLabel("Libelle Classe :");
					  				libelleClasse.setBounds(11, 310, 111, 20);
					  				frame.getContentPane().add(libelleClasse);
									frame.repaint();
					  				
					  				newNomClasse = new JTextField(resultat.getString("libelle"));
					  				newNomClasse.setBounds(159, 310, 206, 19);
					  				frame.getContentPane().add(newNomClasse);
					  				newNomClasse.setColumns(10);
									frame.repaint();
									
									newPP = new JLabel("Prof Principale :");
									newPP.setBounds(11, 355, 111, 20);
					  				frame.getContentPane().add(newPP);
									frame.repaint();
									
									newPPClasse= new JComboBox();
									newPPClasse.setBounds(159, 355, 178 , 33);
									frame.getContentPane().add(newPPClasse);
					  			
									try {
							  			
							  			ResultSet resultat1= stm.executeQuery("SELECT nom FROM user WHERE profil= 'professeur'");
							  			while(resultat1.next()) {
							  				newPPClasse.addItem(resultat1.getString("nom"));
										}
									}
									catch(SQLException e1) {
							  			e1.printStackTrace();
							  			System.out.println("erreur dans l'ajout");	
							  	}
					  				
					  				saveModif = new JButton("Enregistrer");
					  				saveModif.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											String newLbl = newNomClasse.getText();
											String newPPC = (String) newPPClasse.getSelectedItem();
							          		
							          		Classe classe = new Classe(newLbl,newPPC);
							          		a.modifClasse(classe, idClasse);
											frame.dispose();
										}
									});
					  				saveModif.setBounds(66, 395, 132, 33);
					  				frame.getContentPane().add(saveModif);
									frame.repaint();
					  				
					  				retour3 = new JButton("Retour");
					  				retour3.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											actionStock actionStock = new actionStock();
											actionStock.run();
											frame.dispose();
										}
									});
					  				retour3.setBounds(233, 395, 132, 33);
					  				frame.getContentPane().add(retour3);
									frame.repaint();
					  			}
					  			} catch (Exception e) {
					  				e.printStackTrace();
					  			}
					  			}
							});
					        choixClasse.setBounds(220, 270, 178 , 33);
							frame.getContentPane().add(choixClasse);
							frame.repaint();		
			}
		});
		btnNewButton_2.setBounds(357, 221, 155, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				gestionAdministrative gestionAdministrative = new gestionAdministrative();
				gestionAdministrative.run();
			}
		});
		btnNewButton_3.setBounds(357, 469, 155, 34);
		frame.getContentPane().add(btnNewButton_3);
		
		
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			gestionClasseAdmin window = new gestionClasseAdmin();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
