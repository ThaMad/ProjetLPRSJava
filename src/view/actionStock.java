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
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.Stock;
import model.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class actionStock {
	private Connection connexion;
	private JFrame frame;
	private JTextField newLibelle;
	private JTextField newNbrStock;
	private JTextField addLibelle;
	private JTextField addNbrStock;
	private JTextField demandeStock;
	protected JLabel libelStock;
	protected JLabel nbrStock;
	protected JButton addStock;
	protected JButton retour;
	protected JComboBox<String> stockLibel;
	protected JButton choixStock;
	protected JLabel libelleStock;
	protected JLabel nbreStock;
	protected JButton saveModif;
	protected JButton retour1;
	protected JComboBox<String> fournisseur;
	protected JButton choixFourni;
	protected JComboBox<String> stockFourni;
	protected JButton choixStock2;
	protected JLabel demandeVoulu;
	protected JButton saveDemande;
	protected JButton retour3;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actionStock window = new actionStock();
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
	public actionStock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		navbar.setBounds(0, -15, 600, 74);
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
		panel_1.setBounds(0, 71, 600, 95);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel bienvenue = new JLabel("Bienvenue");
		bienvenue.setForeground(new Color(255, 127, 80));
		bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenue.setFont(new Font("Heiti SC", Font.BOLD, 27));
		bienvenue.setBounds(129, 0, 284, 43);
		panel_1.add(bienvenue);
		
		JButton btnNewButton = new JButton("Nouveau");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(stockLibel != null) {
				 stockLibel.setVisible(false);
				 choixStock.setVisible(false);
				 if(libelleStock != null) {
					 newLibelle.setVisible(false);
					 newNbrStock.setVisible(false);
					 libelleStock.setVisible(false);
					 nbreStock.setVisible(false);
					 saveModif.setVisible(false);
					 retour1.setVisible(false);
				 }
				}
			if(fournisseur != null) {
				fournisseur.setVisible(false);
				choixFourni.setVisible(false);
				if(stockFourni != null) {
					stockFourni.setVisible(false);
				    choixStock2.setVisible(false);
				    if(demandeVoulu != null) {
				    	demandeVoulu.setVisible(false);
				    	demandeStock.setVisible(false);
				        saveDemande.setVisible(false);
				        retour3.setVisible(false);
				        }
				    }
				}
				
				libelStock = new JLabel("Libelle du stock :");
  				libelStock.setBounds(11, 307, 111, 20);
  				frame.getContentPane().add(libelStock);
				frame.repaint();
  				
  				addLibelle = new JTextField();
  				addLibelle.setBounds(159, 308, 206, 19);
  				frame.getContentPane().add(addLibelle);
  				addLibelle.setColumns(10);
				frame.repaint();
  				
  				nbrStock = new JLabel("Nombre en stock");
  				nbrStock.setBounds(11, 354, 111, 20);
  				frame.getContentPane().add(nbrStock);
				frame.repaint();
  				
  				addNbrStock = new JTextField();
  				addNbrStock.setColumns(10);
  				addNbrStock.setBounds(159, 355, 206, 19);
  				frame.getContentPane().add(addNbrStock);
				frame.repaint();
				
				addStock = new JButton("Enregistrer");
				addStock.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String addLibel = addLibelle.getText();
		          		int addNbr = Integer.parseInt(addNbrStock.getText());
		          		
		          		Stock stock = new Stock(addLibel,addNbr);
		          		a.addStock(stock);
		          		frame.dispose();
		          		
					}
				});
				addStock.setBounds(66, 429, 132, 33);
  				frame.getContentPane().add(addStock);
				frame.repaint();
  				
  				retour = new JButton("Retour");
  				retour.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						actionStock actionStock = new actionStock();
						actionStock.run();
						frame.dispose();
					}
				});
  				retour.setBounds(233, 429, 132, 33);
  				frame.getContentPane().add(retour);
				frame.repaint();
				
			}
		});
		btnNewButton.setBounds(11, 197, 142, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifié");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(libelStock != null) {
				 libelStock.setVisible(false);
				 addLibelle.setVisible(false);
				 addNbrStock.setVisible(false);
				 nbrStock.setVisible(false);
				 addStock.setVisible(false);
				 retour.setVisible(false);
				}
				if(fournisseur != null) {
					fournisseur.setVisible(false);
					choixFourni.setVisible(false);
					if(stockFourni != null) {
						stockFourni.setVisible(false);
					    choixStock2.setVisible(false);
					    if(demandeVoulu != null) {
					    	demandeVoulu.setVisible(false);
					    	demandeStock.setVisible(false);
					        saveDemande.setVisible(false);
					        retour3.setVisible(false);
					        }
					    }
					}
				stockLibel= new JComboBox();
				stockLibel.setBounds(11, 250, 178 , 33);
				frame.getContentPane().add(stockLibel);
				try {
					java.sql.Statement stm= connexion.createStatement();
		  			
		  			ResultSet resultat= stm.executeQuery("SELECT libelle FROM stock");
		  			while(resultat.next()) {
		  				 stockLibel.addItem(resultat.getString("libelle"));
					}
				}
				catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
				choixStock = new JButton("Choisir");
				choixStock.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String choix = (String) stockLibel.getSelectedItem();
						try {
							java.sql.Statement stm= connexion.createStatement();
				  			
				  			ResultSet resultat= stm.executeQuery("SELECT * FROM stock WHERE libelle = ('"+choix+"')");
				  			if(resultat.next()) {
				  				libelleStock = new JLabel("Libelle du stock :");
				  				libelleStock.setBounds(11, 307, 111, 20);
				  				frame.getContentPane().add(libelleStock);
								frame.repaint();
				  				
				  				newLibelle = new JTextField(resultat.getString("libelle"));
				  				newLibelle.setBounds(159, 308, 206, 19);
				  				frame.getContentPane().add(newLibelle);
				  				newLibelle.setColumns(10);
								frame.repaint();
				  				
				  				nbreStock = new JLabel("Nombre en stock");
				  				nbreStock.setBounds(11, 354, 111, 20);
				  				frame.getContentPane().add(nbreStock);
								frame.repaint();
				  				
				  				newNbrStock = new JTextField(resultat.getString("nbrStock"));
				  				newNbrStock.setColumns(10);
				  				newNbrStock.setBounds(159, 355, 206, 19);
				  				frame.getContentPane().add(newNbrStock);
								frame.repaint();
				  				
				  				saveModif = new JButton("Enregistrer");
				  				saveModif.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										int idstock = 0;
										try {
											idstock = Integer.parseInt(resultat.getString("idStock"));
										} catch (NumberFormatException | SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										String newLibel = newLibelle.getText();
						          		int newNbr = Integer.parseInt(newNbrStock.getText());
						          								          		
						          		Stock stock = new Stock(newLibel,newNbr);
						          		a.modifStock(stock, idstock);
						          		frame.dispose();
									}
								});
				  				saveModif.setBounds(66, 429, 132, 33);
				  				frame.getContentPane().add(saveModif);
								frame.repaint();
				  				
				  				retour1 = new JButton("Retour");
				  				retour1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										actionStock actionStock = new actionStock();
										actionStock.run();
										frame.dispose();
									}
								});
				  				retour1.setBounds(233, 429, 132, 33);
				  				frame.getContentPane().add(retour1);
								frame.repaint();
							}
						}
						catch(SQLException e1) {
				  			e1.printStackTrace();
				  			System.out.println("erreur dans l'ajout");	
				  	}

						
					}
				});
				choixStock.setBounds(200, 250, 178 , 33);
				frame.getContentPane().add(choixStock);
				frame.repaint();
			}
		});
		btnNewButton_1.setBounds(187, 197, 178, 33);
		frame.getContentPane().add(btnNewButton_1);
				
		
		JButton btnNewButton_2_1 = new JButton("Demande fournisseur");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(libelStock != null) {
					 libelStock.setVisible(false);
					 addLibelle.setVisible(false);
					 addNbrStock.setVisible(false);
					 nbrStock.setVisible(false);
					 addStock.setVisible(false);
					 retour.setVisible(false);
					}
				if(stockLibel != null) {
					 stockLibel.setVisible(false);
					 choixStock.setVisible(false);
					 if(libelleStock != null) {
						 newLibelle.setVisible(false);
						 newNbrStock.setVisible(false);
						 libelleStock.setVisible(false);
						 nbreStock.setVisible(false);
						 saveModif.setVisible(false);
						 retour1.setVisible(false);
					 }
					}
				fournisseur = new JComboBox();
				fournisseur.setBounds(11, 250, 178 , 33);
				frame.getContentPane().add(fournisseur);
				try {
					java.sql.Statement stm= connexion.createStatement();
		  			
		  			ResultSet resultat= stm.executeQuery("SELECT nom FROM fournisseur");
		  			while(resultat.next()) {
		  				fournisseur.addItem(resultat.getString("nom"));
					}
				}
				catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
				choixFourni = new JButton("Choisir");
				choixFourni.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String fourniChoisi = (String) fournisseur.getSelectedItem();
						stockFourni = new JComboBox();
						stockFourni.setBounds(11, 285, 178 , 33);
						frame.getContentPane().add(stockFourni);
						frame.repaint();
						try {
							java.sql.Statement stm= connexion.createStatement();
				  			
				  			ResultSet resultatFourni= stm.executeQuery("SELECT libelle FROM stock INNER JOIN stock_fournisseur ON stock_fournisseur.idStock = stock.idStock INNER JOIN fournisseur ON stock_fournisseur.idFourni = fournisseur.idFourni WHERE nom = ('"+fourniChoisi+"')");
				  			while(resultatFourni.next()) {
				  				stockFourni.addItem(resultatFourni.getString("libelle"));
							}
						}
						catch(SQLException e1) {
				  			e1.printStackTrace();
				  			System.out.println("erreur dans l'ajout");	
				  	}
				  			choixStock2 = new JButton("Choisir");
				  			choixStock2.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
								String stockChoisi = (String) stockFourni.getSelectedItem();
				  				demandeVoulu = new JLabel("Nombre voulu :");
				  				demandeVoulu.setBounds(11, 330, 111, 20);
				  				frame.getContentPane().add(demandeVoulu);
								frame.repaint();
				  				
				  				demandeStock = new JTextField();
				  				demandeStock.setBounds(159, 330, 206, 19);
				  				frame.getContentPane().add(demandeStock);
				  				demandeStock.setColumns(10);
								frame.repaint();
				  				
				  				saveDemande = new JButton("Enregistrer");
				  				saveDemande.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {	
										
						          		int nbrDemande = Integer.parseInt(demandeStock.getText());
						          		bonDemande bonDemande = new bonDemande(nbrDemande, stockChoisi, fourniChoisi);
						          		bonDemande.run();
						          		frame.dispose();
									}
								});
				  				saveDemande.setBounds(66, 429, 132, 33);
				  				frame.getContentPane().add(saveDemande);
								frame.repaint();
				  				
				  				retour3 = new JButton("Retour");
				  				retour3.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										actionStock actionStock = new actionStock();
										actionStock.run();
										frame.dispose();
									}
								});
				  				retour3.setBounds(233, 429, 132, 33);
				  				frame.getContentPane().add(retour3);
								frame.repaint();
						
						}
					});
					choixStock2.setBounds(200, 285, 178 , 33);
					frame.getContentPane().add(choixStock2);
					frame.repaint();	
					}
				});
				choixFourni.setBounds(200, 250, 178 , 33);
				frame.getContentPane().add(choixFourni);
				frame.repaint();
			}
		});
		btnNewButton_2_1.setBounds(398, 197, 178, 33);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				gestionstock gestionstock = new gestionstock();
				gestionstock.run();
			}
		});
		btnNewButton_2.setBounds(398, 510, 178, 33);
		frame.getContentPane().add(btnNewButton_2);
		
		
		frame.setBounds(150, 150, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			actionStock window = new actionStock();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
