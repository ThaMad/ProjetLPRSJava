package view.admin.general;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import manager.Manager_prof;
import manager.manager_ryan;
import manager.manager_thomas;
import model.Classe;
import model.User;
import view.admin.gestionUser.addUser;
import view.admin.gestionUser.modUser;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class info {

	private static String[] colMedHdr = {"id", "Classe", "Nom", "Prenom"};
	private static DefaultTableModel tblModel = new DefaultTableModel(colMedHdr, 0);
	DefaultTableModel model;
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
		
		/* Debut code table modèle de M. Lemoine */
		
		
	    /*private ReservationManager reservationManager = new ReservationManager();*/
	    
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 83, 482, 318);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tblModel){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	         }
	       };
		table.setFocusable(false);
		System.out.println("je test");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				System.out.println("hello !");
				manager_ryan manRyan = new manager_ryan();
	            if (me.getClickCount() == 2) {     // to detect double click events
	                JTable target = (JTable)me.getSource();
	                int row = target.getSelectedRow(); // select a row
	                int idUser = (int) target.getValueAt(row, 0); // select a column
	                User userSel = manRyan.getUser(idUser);
	                modUser modUser = new modUser(userSel);
	                modUser.run();
	             }
			}
		});
		table.setBounds(0, 0, 286, 219);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Reservation reservation = new Reservation(utilisateurConnecte);
				ReservationForm reservationForm = new ReservationForm(reservation);
				reservationForm.run();*/
			}
		});
		btnNewButton.setBounds(88, 413, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnResume = new JButton("Resume");
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*ResumeView resumeView = new ResumeView();
				resumeView.run();*/
			}
		});
		btnResume.setBounds(295, 413, 117, 25);
		frame.getContentPane().add(btnResume);
		populateTable();
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
	private void populateTable() {
		manager_ryan manRyan = new manager_ryan();
		ArrayList<User> users = manRyan.getUsers();
		System.out.println(users.size());
		for (User user : users) {
			Object[] data = {user.getIdUser(),user.getNom(),user.getPrenom(),user.getMail(),user.getPrenom()};
			tblModel.addRow(data);
		}
		
	}
	public static void actualiseTableau(User userSel) {
		tblModel.getDataVector().removeAllElements();
		
		manager_ryan manRyan = new manager_ryan();
		ArrayList<User> users = manRyan.getUsers();
		
		for (User user : users) {
			Object[] data = {user.getIdUser(),user.getNom(),user.getPrenom(),user.getMail(),user.getPrenom()};
			tblModel.addRow(data);
		}
		tblModel.fireTableDataChanged();
        /*ReservationDetailView reservationDetailView = new ReservationDetailView(reservationSel,utilisateurConnecte);
        reservationDetailView.run();*/
	}
		
		/*
		try {
			java.sql.Statement stm= connexion.createStatement();
            Vector data = new Vector();
            Vector columnsNames = new Vector();
			// requete pour recuperer les donnees des eleves
			ResultSet resultat= stm.executeQuery("SELECT idClasse, idEleve, libelle, nom, prenom FROM classe INNER JOIN eleve ON classe.idClasse = eleve.classe");
		    // Recuperer le titre des colonnes
            ResultSetMetaData md = (ResultSetMetaData) resultat.getMetaData();
           
            // Recuperer le nombre de colonnes
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
                 columnsNames.addElement("Classe");
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
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				java.sql.Statement stm= connexion.createStatement();
				stm.execute("DELETE classe FROM classe INNER JOIN eleve ON classe.idClasse = eleve.classe WHERE libelle = libelle");
				
				}catch(SQLException e1) {
					e1.printStackTrace();
					System.out.println("erreur dans la suppression");
				}
			}
		});
		
		btnNewButton_3.setBounds(436, 454, 108, 29);
		frame.getContentPane().add(btnNewButton_3);
	}catch(SQLException e1) {
			e1.printStackTrace();
			System.out.println("erreur dans l'ajout");
		}
	}*/


	public void run() {
		try {
			info window = new info();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
