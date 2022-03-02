package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.User;
import javax.swing.JComboBox;

public class planningEquipe {

	private JFrame frame;
	private Connection connexion;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planningEquipe window = new planningEquipe();
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
	public planningEquipe() {
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
		
		
		JLabel lblNewLabel = new JLabel("Classe : ");
		lblNewLabel.setBounds(10, 189, 111, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 189, 173, 21);
		frame.getContentPane().add(comboBox);
		
		try {
				java.sql.Statement stm1= connexion.createStatement();
				
				// requete pour recuperer les donnees des films
				ResultSet resultat1= stm1.executeQuery("SELECT classe.libelle FROM classe INNER JOIN user ON classe.id_prof_principale = user.idUser WHERE mail = ('"+u.mail+"')");
				while(resultat1.next()) {
					comboBox.addItem(resultat1.getString("classe.libelle"));
				}
				
			} catch(SQLException e1) {
					e1.printStackTrace();
					System.out.println("erreur dans l'ajout");	
			}
		JButton btnNewButton = new JButton("Choisir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String choixClasse = (String) comboBox.getSelectedItem();
				try {
					java.sql.Statement stm= connexion.createStatement();
		            Vector data = new Vector();
		            Vector columnsNames = new Vector();
					// requete pour recuperer les donnees des films
					ResultSet resultat= stm.executeQuery("SELECT matiere, classe.libelle, heureDebut.heure,heureFin.heure, semaine.libelle, user.nom FROM profclasse INNER JOIN classe ON classe.idClasse = profclasse.Classe INNER JOIN user ON user.idUser = profclasse.idProf "
							+ "INNER JOIN horaire AS heureDebut ON heureDebut.idHoraire = profclasse.heureD  INNER JOIN horaire AS heureFin ON heureFin.idHoraire = profclasse.heureF  INNER JOIN semaine ON semaine.idJour = profclasse.jour WHERE classe.libelle = ('"+choixClasse+"') ");
				    // R�cup�rer le titre des colonnes
		            ResultSetMetaData md = (ResultSetMetaData) resultat.getMetaData();
		           
		            // R�cup�rer le nombre de colonne
		            int columns = md.getColumnCount();
						 while (resultat.next())
		                 {
					
		                     Object nb = resultat.getRow();
		                     Vector row = new Vector(columns);
		                     for (int i = 1; i <= columns; i++)
		                     {
	                             	row.addElement(resultat.getString("user.nom"));
		                            row.addElement(resultat.getString("classe.libelle"));
		                            row.addElement(resultat.getString("matiere"));
									row.addElement(resultat.getString("semaine.libelle") );
		                            row.addElement(resultat.getString("heureDebut.heure"));
		                            row.addElement(resultat.getString("heureFin.heure"));
		                     }
		                     data.addElement( row );
							 }
		                 // Tout fermer
		                 columnsNames.addElement("Professeur");
		                 columnsNames.addElement("Classe");
		                 columnsNames.addElement("Matiere");
		                 columnsNames.addElement("Jour");
		                 columnsNames.addElement("Heure Debut");
		                 columnsNames.addElement("Heure Fin");


		                JScrollPane scrollPane = new JScrollPane();
		 				scrollPane.setBounds(42, 250, 453, 163);
		 				frame.getContentPane().add(scrollPane);
		 				JTable table = new JTable(data,columnsNames);
		 				scrollPane.setViewportView(table);
				} catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
			}
		});
		btnNewButton.setBounds(314, 189, 144, 21);
		frame.getContentPane().add(btnNewButton);
		
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			planningEquipe window = new planningEquipe();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
