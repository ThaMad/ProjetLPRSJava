package view.admin.general;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import manager.manager_thomas;
import view.admin.gestionUser.addUser;
import view.admin.gestionUser.modUser;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class info {

	private JFrame frame;
	private JTable table;
	private Connection connexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					info window = new info();
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
	public info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		manager_thomas a = new manager_thomas();
		connexion =  (Connection) a.bdd();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informations générales");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(141, 31, 268, 30);
		frame.getContentPane().add(lblNewLabel);
		
		try {
			java.sql.Statement stm= connexion.createStatement();
            Vector data = new Vector();
            Vector columnsNames = new Vector();
			// requete pour recuperer les donnees des films
			ResultSet resultat= stm.executeQuery("SELECT libelle, nom, prenom FROM classe INNER JOIN eleve ON classe.idClasse = eleve.classe");
		    // Recuperer le titre des colonnes
            ResultSetMetaData md = (ResultSetMetaData) resultat.getMetaData();
           
            // Recuperer le nombre de colonne
            int columns = md.getColumnCount();
				 while (resultat.next())
                 {
                     Object nb = resultat.getRow();
                     Vector row = new Vector(columns);
                     for (int i = 1; i <= columns; i++)
                     {
                             row.addElement( resultat.getString("libelle"));
                             row.addElement( resultat.getString("nom"));
                             row.addElement( resultat.getString("prenom"));
                     }
                     data.addElement( row );
					 }
                 // Tout fermer
                 columnsNames.addElement("classe");
                 columnsNames.addElement("Nom");
                 columnsNames.addElement("Prenom");
                 
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(70, 91, 410, 323);
        frame.getContentPane().add(scrollPane);
                 
		table = new JTable(data, columnsNames);
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(67, 454, 82, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser addUser = new addUser();
				addUser.run();
			}
		});
		btnNewButton_1.setBounds(250, 454, 90, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modUser modUser = new modUser();
				modUser.run();
			}
		});
		btnNewButton_2.setBounds(341, 454, 96, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Supprimer");
		btnNewButton_3.setBounds(436, 454, 108, 29);
		frame.getContentPane().add(btnNewButton_3);
	}catch(SQLException e1) {
			e1.printStackTrace();
			System.out.println("erreur dans l'ajout");
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			info window = new info();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
