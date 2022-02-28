package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.Eleve;
import model.Stock;
import model.User;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionEleveAdmin {

	private JFrame frame;
	private Connection connexion;
	protected JTextField addNom;
	protected JTextField addPrenom;
	protected JTextField newPrenomEleve;
	protected JTextField newNomEleve;
	protected JComboBox addClasse;
	protected JLabel lblNomadd;
	protected JLabel lblPrenomadd;
	protected JLabel lblClasseadd;
	protected JButton saveAdd;
	protected JButton retour1;
	protected JLabel lblNomsupp;
	protected JButton retour2;
	protected JButton saveSupp;
	protected JComboBox suppEleve;
	protected JComboBox modifEleve;
	protected JButton choixEleve;
	protected JLabel nomEleve;
	protected JLabel prenomEleve;
	protected JLabel classeEleve;
	protected JComboBox newClasseEleve;
	protected JButton saveModif;
	protected JButton retour;









	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionEleveAdmin window = new gestionEleveAdmin();
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
	public gestionEleveAdmin() {
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
				if(lblNomsupp != null) {
				lblNomsupp.setVisible(false);
				saveSupp.setVisible(false);
				retour2.setVisible(false);
				suppEleve.setVisible(false);
				}
				if(choixEleve != null) {
					choixEleve.setVisible(false);
					modifEleve.setVisible(false);
				}
				if(nomEleve != null) {
				nomEleve.setVisible(false);
				prenomEleve.setVisible(false);
				classeEleve.setVisible(false);
				newNomEleve.setVisible(false);
				newPrenomEleve.setVisible(false);
				newClasseEleve.setVisible(false);
				saveModif.setVisible(false);
				retour.setVisible(false);
				}
				lblNomadd = new JLabel("Nom Eleve:");
				lblNomadd.setBounds(10, 303, 99, 20);
				frame.getContentPane().add(lblNomadd);
				frame.repaint();
				
				addNom = new JTextField();
				addNom.setBounds(97, 304, 180, 20);
				frame.getContentPane().add(addNom);
				addNom.setColumns(10);
				frame.repaint();
				
				lblPrenomadd = new JLabel("Prenom Eleve:");
				lblPrenomadd.setBounds(10, 343, 99, 20);
				frame.getContentPane().add(lblPrenomadd);
				frame.repaint();
				
				addPrenom = new JTextField();
				addPrenom.setBounds(100, 343, 180, 20);
				frame.getContentPane().add(addPrenom);
				addPrenom.setColumns(10);
				frame.repaint();
				
				lblClasseadd = new JLabel("Classe affecter:");
				lblClasseadd.setBounds(10, 383, 99, 20);
				frame.getContentPane().add(lblClasseadd);
				frame.repaint();
				
				addClasse = new JComboBox();
				addClasse.setBounds(100, 383, 180, 20);
				frame.getContentPane().add(addClasse);
				frame.repaint();
				try {
					java.sql.Statement stm= connexion.createStatement();
		  			
		  			ResultSet resultat= stm.executeQuery("SELECT libelle FROM classe");
		  			while(resultat.next()) {
		  				 addClasse.addItem(resultat.getString("libelle"));
					}
				}
				catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
				
				saveAdd = new JButton("Enregistrer");
				saveAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String prenomEleve = addPrenom.getText();
						String nomEleve = addNom.getText();
						String classe = (String) addClasse.getSelectedItem();
						
						Eleve eleve = new Eleve(nomEleve, prenomEleve, classe);
						a.addEleve(eleve);
						frame.dispose();
					}
				});
				saveAdd.setBounds(191, 410, 146, 27);
				frame.getContentPane().add(saveAdd);
				frame.repaint();
				
				retour1 = new JButton("Retour");
				retour1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.dispose();
						gestionEleveAdmin gestionEleveAdmin = new gestionEleveAdmin();
						gestionEleveAdmin.run();
					}
				});
				retour1.setBounds(10, 410, 146, 27);
				frame.getContentPane().add(retour1);
				frame.repaint();
			}
		});
		btnNewButton.setBounds(10, 221, 161, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(addNom != null) {
				addNom.setVisible(false);
				addPrenom.setVisible(false);
				addClasse.setVisible(false);
				lblNomadd.setVisible(false);
				lblPrenomadd.setVisible(false);
				lblClasseadd.setVisible(false);
				saveAdd.setVisible(false);
				retour1.setVisible(false);
				}
				if(choixEleve != null) {
					choixEleve.setVisible(false);
					modifEleve.setVisible(false);
				}
				if(nomEleve != null) {
				nomEleve.setVisible(false);
				prenomEleve.setVisible(false);
				classeEleve.setVisible(false);
				newNomEleve.setVisible(false);
				newPrenomEleve.setVisible(false);
				newClasseEleve.setVisible(false);
				saveModif.setVisible(false);
				retour.setVisible(false);
				}
				lblNomsupp = new JLabel("Nom Eleve:");
				lblNomsupp.setBounds(10, 303, 99, 20);
				frame.getContentPane().add(lblNomsupp);
				frame.repaint();
				suppEleve = new JComboBox();
				suppEleve.setBounds(115, 303, 180, 20);
				frame.getContentPane().add(suppEleve);
				frame.repaint();
				try {
					java.sql.Statement stm= connexion.createStatement();
		  			
		  			ResultSet resultat= stm.executeQuery("SELECT nom FROM eleve");
		  			while(resultat.next()) {
		  				 suppEleve.addItem(resultat.getString("nom"));
					}
				}
				catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
				
				saveSupp = new JButton("Enregistrer");
				saveSupp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nomEleve = (String) suppEleve.getSelectedItem();
						Eleve eleve = new Eleve(nomEleve);
						a.suppEleve(eleve);
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
						gestionEleveAdmin gestionEleveAdmin = new gestionEleveAdmin();
						gestionEleveAdmin.run();
					}
				});
				retour2.setBounds(10, 350, 146, 27);
				frame.getContentPane().add(retour2);
				frame.repaint();
			}
		});
		btnNewButton_1.setBounds(181, 221, 166, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton modifier = new JButton("Modifier");
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(addNom != null) {
				addNom.setVisible(false);
				addPrenom.setVisible(false);
				addClasse.setVisible(false);
				lblNomadd.setVisible(false);
				lblPrenomadd.setVisible(false);
				lblClasseadd.setVisible(false);
				saveAdd.setVisible(false);
				retour1.setVisible(false);
				}
				if(lblNomsupp != null) {
				lblNomsupp.setVisible(false);
				saveSupp.setVisible(false);
				retour2.setVisible(false);
				suppEleve.setVisible(false);
				}
				modifEleve= new JComboBox();
				modifEleve.setBounds(11, 270, 178 , 33);
				frame.getContentPane().add(modifEleve);
				try {
					java.sql.Statement stm= connexion.createStatement();
		  			
		  			ResultSet resultat= stm.executeQuery("SELECT nom FROM eleve");
		  			while(resultat.next()) {
		  				modifEleve.addItem(resultat.getString("nom"));
					}
				}
				catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
				choixEleve = new JButton("Choisir");
				choixEleve.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String choix = (String) modifEleve.getSelectedItem();
						try {
							java.sql.Statement stm= connexion.createStatement();
				  			
				  			ResultSet resultat= stm.executeQuery("SELECT * FROM eleve WHERE nom = ('"+choix+"')");
				  			if(resultat.next()) {
				  				int idEleve = Integer.parseInt(resultat.getString("idEleve"));
				  				nomEleve = new JLabel("Nom Eleve :");
				  				nomEleve.setBounds(11, 310, 111, 20);
				  				frame.getContentPane().add(nomEleve);
								frame.repaint();
				  				
				  				newNomEleve = new JTextField(resultat.getString("nom"));
				  				newNomEleve.setBounds(159, 310, 206, 19);
				  				frame.getContentPane().add(newNomEleve);
				  				newNomEleve.setColumns(10);
								frame.repaint();
				  				
				  				prenomEleve = new JLabel("Prenom Eleve :");
				  				prenomEleve.setBounds(11, 330, 111, 20);
				  				frame.getContentPane().add(prenomEleve);
								frame.repaint();
				  				
				  				newPrenomEleve = new JTextField(resultat.getString("prenom"));
				  				newPrenomEleve.setColumns(10);
				  				newPrenomEleve.setBounds(159, 330, 206, 19);
				  				frame.getContentPane().add(newPrenomEleve);
								frame.repaint();
								
								classeEleve = new JLabel("Classe Eleve :");
				  				classeEleve.setBounds(11, 355, 111, 20);
				  				frame.getContentPane().add(classeEleve);
								frame.repaint();
								
								newClasseEleve= new JComboBox();
								newClasseEleve.setBounds(159, 355, 178 , 33);
								frame.getContentPane().add(newClasseEleve);
				  			
								try {
						  			
						  			ResultSet resultat1= stm.executeQuery("SELECT libelle FROM classe");
						  			while(resultat1.next()) {
						  				newClasseEleve.addItem(resultat1.getString("libelle"));
									}
								}
								catch(SQLException e1) {
						  			e1.printStackTrace();
						  			System.out.println("erreur dans l'ajout");	
						  	}
				  				
				  				saveModif = new JButton("Enregistrer");
				  				saveModif.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										String newPrenom = newPrenomEleve.getText();
						          		String newNom = newNomEleve.getText();
										String newClasse = (String) newClasseEleve.getSelectedItem();
						          		
						          		Eleve eleve = new Eleve(newNom,newPrenom, newClasse);
						          		a.modifEleve(eleve, idEleve);
										frame.dispose();
									}
								});
				  				saveModif.setBounds(66, 395, 132, 33);
				  				frame.getContentPane().add(saveModif);
								frame.repaint();
				  				
				  				retour = new JButton("Retour");
				  				retour.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										actionStock actionStock = new actionStock();
										actionStock.run();
										frame.dispose();
									}
								});
				  				retour.setBounds(233, 395, 132, 33);
				  				frame.getContentPane().add(retour);
								frame.repaint();
				  			}
				  			} catch (Exception e) {
				  				e.printStackTrace();
				  			}
				  			}
						});
				choixEleve.setBounds(220, 270, 178 , 33);
						frame.getContentPane().add(choixEleve);
						frame.repaint();		
			}
		});
		modifier.setBounds(357, 221, 155, 43);
		frame.getContentPane().add(modifier);
		
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
			gestionEleveAdmin window = new gestionEleveAdmin();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}