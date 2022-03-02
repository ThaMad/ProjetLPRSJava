package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import manager.Manager_prof;
import manager.manager_thomas;
import model.Classe;
import model.Eleve;
import model.User;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class gestionclasses {
	private static String[] colMedHdr = { "id", "Libelle"};
    private static DefaultTableModel tblModel = new DefaultTableModel(colMedHdr, 0);
    private JTable table;
    
    
	private Connection connexion;

	private JFrame frame;
	DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionclasses window = new gestionclasses();
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
	public gestionclasses() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		manager_thomas a = new manager_thomas();
		Manager_prof manprof = new Manager_prof();
		connexion =  (Connection) a.bdd();
		User me = User.getInstanceVide();
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
			
			JLabel bienvenue = new JLabel("Classes");
			bienvenue.setForeground(new Color(255, 127, 80));
			bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
			bienvenue.setFont(new Font("Heiti SC", Font.BOLD, 27));
			bienvenue.setBounds(129, 18, 284, 43);
			panel_1.add(bienvenue);
			
			/* Debut code table modèle de M. Lemoine */
			
		
		    /*private ReservationManager reservationManager = new ReservationManager();*/
		    
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(37, 181, 482, 318);
			frame.getContentPane().add(scrollPane);
			
			table = new JTable(tblModel){
		         public boolean editCellAt(int row, int column, java.util.EventObject e) {
		             return false;
		         }
		       };
			table.setFocusable(false);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent me) {
		            if (me.getClickCount() == 2) {     // to detect double click events
		                JTable target = (JTable)me.getSource();
		                int row = target.getSelectedRow(); // select a row
		                int idClasse = (int) target.getValueAt(row, 0); // select a column
		                String libelleClasse = (String) target.getValueAt(row, 1);
		                ClasseDetail classeDetail = new ClasseDetail(idClasse, libelleClasse);
		                ClasseDetail.run();
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
			btnNewButton.setBounds(529, 81, 117, 25);
			frame.getContentPane().add(btnNewButton);
			
			populateTable();
			frame.setBounds(100, 100, 549, 550);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
		private void populateTable() {
			Manager_prof managerProf = new Manager_prof();
			ArrayList<Classe> classes = managerProf.getClasses();
			System.out.println(classes.size());
			for (Classe classe : classes) {
				Object[] data = {classe.getIdClasse(),classe.getLibelle(),};
				tblModel.addRow(data);
			}
			
		}
		public static void actualiseTableau(Classe classeSel) {
			tblModel.getDataVector().removeAllElements();
			
			Manager_prof managerProf = new Manager_prof();
			ArrayList<Classe> classes = managerProf.getClasses();
			
			for (Classe classe : classes) {
				Object[] data = {classe.getIdClasse(),classe.getLibelle()};
				tblModel.addRow(data);
			}
			tblModel.fireTableDataChanged();
	        /*ReservationDetailView reservationDetailView = new ReservationDetailView(reservationSel,utilisateurConnecte);
	        reservationDetailView.run();*/
		}
		  
		    
		    
			/*
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(35, 408, 479, -205);
			frame.getContentPane().add(scrollPane);
			
			try {
				java.sql.Statement stm= connexion.createStatement();
				ResultSet meid = stm.executeQuery("SELECT idUser FROM user WHERE mail = ('"+me.mail+"')");
				meid.next();
				int id = meid.getInt("idUser");
				
	            Vector data = new Vector();
	            Vector columnsNames = new Vector();
				// requete pour recuperer les classes dans lequelles on enseigne
				ResultSet resultat= stm.executeQuery("SELECT libelle FROM classe INNER JOIN profclasse ON classe.idClasse = profclasse.Classe WHERE Prof=('"+meid.getInt("idUser")+"')");
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
	                             row.addElement( resultat.getString("libelle"));
	                             
	                     }
	                     data.addElement( row );
						 }
	                 // Tout fermer
	                 columnsNames.addElement("libelle");

	                JScrollPane scrollPane1 = new JScrollPane();
	 				scrollPane1.setBounds(42, 173, 453, 163);
	 				frame.getContentPane().add(scrollPane1);
	 				table = new JTable(data,columnsNames);
	 				scrollPane1.setViewportView(table);
	 				
	 				
	 					  

				} catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
			
			
			int x = 0;
			*/
			
			/* try {
				java.sql.Statement stm = connexion.createStatement();
				ResultSet meid = stm.executeQuery("SELECT idUser FROM user WHERE mail = ('"+me.mail+"')");
				meid.next();
				int id = meid.getInt("idUser");
				ResultSet resultclassename = stm.executeQuery("SELECT libelle FROM classe INNER JOIN profclasse ON classe.idClasse = profclasse.Classe WHERE Prof=('"+meid.getInt("idUser")+"')");
				while(resultclassename.next()) {
					x = x+120;
					JButton classename = new JButton(""+resultclassename.getString("libelle"));
					classename.setFont(new Font("Heiti SC", Font.PLAIN, 13));
					classename.setForeground(new Color(255, 99, 71));
					classename.setBounds(x, 230, 117, 29);
					frame.getContentPane().add(classename);
					
				}
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			*/
			
			
			
	public void run() {
		try {
			//gestionclasses window = new gestionclasses();
			this.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
