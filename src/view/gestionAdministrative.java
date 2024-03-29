package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionAdministrative {

	private JFrame frame;
	private Connection connexion;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionAdministrative window = new gestionAdministrative();
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
	public gestionAdministrative() {
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
		
		try {
			java.sql.Statement stm= connexion.createStatement();
            Vector data = new Vector();
            Vector columnsNames = new Vector();
			// requete pour recuperer les donnees des films
			ResultSet resultat= stm.executeQuery("SELECT nom,prenom,libelle FROM eleve INNER JOIN classe ON eleve.classe = classe.idClasse ORDER BY libelle ");
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
                             row.addElement( resultat.getString("nom"));
                             row.addElement( resultat.getString("prenom"));
                             row.addElement( resultat.getString("libelle"));
                     }
                     data.addElement( row );
					 }
                 // Tout fermer
                 columnsNames.addElement("Nom");
                 columnsNames.addElement("prenom");
                 columnsNames.addElement("Classe");

                JScrollPane scrollPane = new JScrollPane();
 				scrollPane.setBounds(42, 173, 453, 163);
 				frame.getContentPane().add(scrollPane);
 				JTable table = new JTable(data,columnsNames);
 				scrollPane.setViewportView(table);
 					
 				} catch(SQLException e1) {
 			  			e1.printStackTrace();
 			  			System.out.println("erreur dans l'ajout");	
 			  	}
 				
 				
		JButton btnNewButton = new JButton("Classes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				gestionClasseAdmin gestionClasseAdmin = new gestionClasseAdmin();
				gestionClasseAdmin.run();
			}
		});
		btnNewButton.setBounds(21, 347, 221, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eleves");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				gestionEleveAdmin gestionEleveAdmin = new gestionEleveAdmin();
				gestionEleveAdmin.run();
			}
		});
		btnNewButton_1.setBounds(267, 347, 228, 46);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				profiladministratif profiladministratif = new profiladministratif();
				profiladministratif.run();	
			}
		});
		btnNewButton_2.setBounds(274, 400, 221, 36);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			gestionAdministrative window = new gestionAdministrative();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
