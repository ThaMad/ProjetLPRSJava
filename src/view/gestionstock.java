package view;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.User;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionstock {

	private Connection connexion;
	private JFrame frame;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionstock window = new gestionstock();
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
	public gestionstock() {
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
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		try {
			java.sql.Statement stm= connexion.createStatement();
            Vector data = new Vector();
            Vector columnsNames = new Vector();
			// requete pour recuperer les donnees des films
			ResultSet resultat= stm.executeQuery("SELECT idStock,libelle,nbrStock FROM stock");
		    // Récupérer le titre des colonnes
            ResultSetMetaData md = (ResultSetMetaData) resultat.getMetaData();
           
            // Récupérer le nombre de colonne
            int columns = md.getColumnCount();
				 while (resultat.next())
                 {
                     Object nb = resultat.getRow();
                     Vector row = new Vector(columns);
                     for (int i = 1; i <= columns; i++)
                     {
                             row.addElement( resultat.getString("idStock"));
                             row.addElement( resultat.getString("libelle"));
                             row.addElement( resultat.getString("nbrStock"));
                     }
					data.addElement( row );
                 }
                 // Tout fermer
				 columnsNames.addElement("ID");
                 columnsNames.addElement("libelle");
                 columnsNames.addElement("Nombre en stock");
                 resultat.close();
                 

                JScrollPane scrollPane = new JScrollPane();
 				scrollPane.setBounds(42, 173, 453, 163);
 				frame.getContentPane().add(scrollPane);
 				table = new JTable(data,columnsNames);
 				scrollPane.setViewportView(table);

 				frame.getContentPane().add(btnNewButton);
 				table.getColumnModel().getColumn(0).setPreferredWidth(30);
			} catch(SQLException e1) {
	  			e1.printStackTrace();
	  			System.out.println("erreur dans l'ajout");	
	  	}
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			gestionstock window = new gestionstock();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
