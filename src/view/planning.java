package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.toedter.components.JLocaleChooser;

import manager.manager_thomas;
import model.User;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class planning {

	private JFrame frame;
	private JTable table;
	private Connection connexion;

	/**
	 * @wbp.nonvisual location=81,404
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planning window = new planning();
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
	public planning() {
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
            Vector data = new Vector();
            Vector columnsNames = new Vector();
			// requete pour recuperer les donnees des films
			ResultSet resultat= stm.executeQuery("SELECT matiere, classe.libelle, heureDebut.heure,heureFin.heure, semaine.libelle FROM profclasse INNER JOIN classe ON classe.idClasse = profclasse.Classe INNER JOIN user ON user.idUser = profclasse.idProf "
					+ "INNER JOIN horaire AS heureDebut ON heureDebut.idHoraire = profclasse.heureD  INNER JOIN horaire AS heureFin ON heureFin.idHoraire = profclasse.heureF  INNER JOIN semaine ON semaine.idJour = profclasse.jour WHERE user.mail = ('"+u.mail+"') ");
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
                             row.addElement(resultat.getString("classe.libelle"));
                             row.addElement(resultat.getString("matiere"));
							row.addElement(resultat.getString("semaine.libelle") );
                             row.addElement(resultat.getString("heureDebut.heure"));
                             row.addElement(resultat.getString("heureFin.heure"));
                     }
                     data.addElement( row );
					 }
                 // Tout fermer
                 columnsNames.addElement("Classe");
                 columnsNames.addElement("Matiere");
                 columnsNames.addElement("Jour");
                 columnsNames.addElement("Heure Debut");
                 columnsNames.addElement("Heure Fin");


                JScrollPane scrollPane = new JScrollPane();
 				scrollPane.setBounds(42, 173, 453, 163);
 				frame.getContentPane().add(scrollPane);
 				JTable table = new JTable(data,columnsNames);
 				scrollPane.setViewportView(table);
		} catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
 				
 				JButton btnNewButton = new JButton("Retour");
 				btnNewButton.addActionListener(new ActionListener() {
 					public void actionPerformed(ActionEvent arg0) {
 						profilprof profilprof = new profilprof();
 						profilprof.run();
 					}
 				});
 				btnNewButton.setBounds(58, 386, 156, 34);
 				frame.getContentPane().add(btnNewButton);
 				
 				try {
 					java.sql.Statement stm1= connexion.createStatement();
 					
 					// requete pour recuperer les donnees des films
 					ResultSet resultat1= stm1.executeQuery("SELECT count(*) AS nbrClassePP FROM classe INNER JOIN user ON classe.id_prof_principale = user.idUser WHERE mail = ('"+u.mail+"')");
 					if(resultat1.next()) {
 						int count = resultat1.getInt("nbrClassePP");
 						if(count > 0) {
 							JButton btnNewButton_1 = new JButton("Planning Equipe");
 							btnNewButton_1.addActionListener(new ActionListener() {
 			 					public void actionPerformed(ActionEvent arg0) {
 			 						frame.dispose();
 			 						planningEquipe planningEquipe = new planningEquipe();
 			 						planningEquipe.run();
 			 					}
 			 				});

 			 				btnNewButton_1.setBounds(242, 386, 195, 34);
 			 				frame.getContentPane().add(btnNewButton_1);
 						}
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
			planning window = new planning();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
