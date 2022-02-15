package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import manager.manager_thomas;
import model.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionDemandeFourni {

	private JFrame frame;
	private Connection connexion;
	JButton button = new JButton();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionDemandeFourni window = new gestionDemandeFourni();
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
	public gestionDemandeFourni() {
		initialize();
	}
	public class ButtonRenderer extends JButton implements TableCellRenderer{

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
	      //On écrit dans le bouton ce que contient la cellule
	      setText("Valider");
	      //On retourne notre bouton
	      return this;

	    }
	  }
	
	class ButtonEditor extends DefaultCellEditor 
	  {
	    
	    public ButtonEditor(JCheckBox checkBox)
	    {
	      super(checkBox);
	    }
	    public Component getTableCellEditorComponent(JTable table, Object value,
	    boolean isSelected, int row, int column) 
	    {
	    	try {
				java.sql.Statement stm= connexion.createStatement();
			
				// requete pour recuperer les donnees des films
				ResultSet resultat= stm.executeQuery("SELECT demande_fournisseur.nbrStock, stock.nbrStock, libelle FROM demande_fournisseur INNER JOIN stock ON stock.idStock = demande_fournisseur.idStock WHERE idDemande = ('"+value+"')");
				if(resultat.next()) {
					String libelleStock = resultat.getString("libelle");
					int stockDemande = Integer.parseInt(resultat.getString("demande_fournisseur.nbrStock"));
					int stockActuel = Integer.parseInt(resultat.getString("stock.nbrStock"));
					int newStock = stockDemande + stockActuel;
			  		int update1 =stm.executeUpdate("UPDATE stock SET nbrStock='"+newStock+"' WHERE libelle=('"+libelleStock+"')");
				}
		  		int update =stm.executeUpdate("UPDATE demande_fournisseur SET valide='"+1+"' WHERE idDemande=('"+value+"')");
				
				if(update == 1 ) {
					frame.dispose();
					gestionDemandeFourni gestionDemandeFourni = new gestionDemandeFourni();
					gestionDemandeFourni.run();
				}
				
			} catch(SQLException e1) {
		  			e1.printStackTrace();
		  			System.out.println("erreur dans l'ajout");	
		  	}
			return button;
	    }
	   
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
			ResultSet resultat= stm.executeQuery("SELECT idDemande, demande_fournisseur.nbrStock, nom, libelle FROM demande_fournisseur INNER JOIN fournisseur ON demande_fournisseur.idFourni = fournisseur.idFourni INNER JOIN stock ON stock.idStock = demande_fournisseur.idStock WHERE valide = ('"+0+"')");
		    // Rï¿½cupï¿½rer le titre des colonnes
            ResultSetMetaData md = (ResultSetMetaData) resultat.getMetaData();
           
            // Rï¿½cupï¿½rer le nombre de colonne
            int columns = md.getColumnCount();
				 while (resultat.next())
                 {
                     Object nb = resultat.getRow();
                     Vector row = new Vector(columns);
                     for (int i = 1; i <= columns; i++)
                     {
                             row.addElement( resultat.getString("idDemande"));
                             row.addElement( resultat.getString("nom"));
                             row.addElement( resultat.getString("libelle"));
                             row.addElement( resultat.getString("demande_fournisseur.nbrStock"));
                     }
                     data.addElement( row );
					 }
                 // Tout fermer
                 columnsNames.addElement("ID");
                 columnsNames.addElement("Nom Fournisseur");
                 columnsNames.addElement("Libelle du produit");
                 columnsNames.addElement("Nombre demande");
                 columnsNames.addElement("Action");

                JScrollPane scrollPane = new JScrollPane();
 				scrollPane.setBounds(42, 173, 453, 163);
 				frame.getContentPane().add(scrollPane);
 				JTable table = new JTable(data,columnsNames);
 				scrollPane.setViewportView(table);
 				
 				JButton btnNewButton = new JButton("Retour");
 				btnNewButton.addActionListener(new ActionListener() {
 					public void actionPerformed(ActionEvent arg0) {
 						frame.dispose();
 						gestionstock gestionstock = new gestionstock();
 						gestionstock.run();
 					}
 				});
 				btnNewButton.setBounds(296, 397, 172, 32);
 				frame.getContentPane().add(btnNewButton);
 				table.getColumn("Action").setCellRenderer(new ButtonRenderer());
 			    table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
 			    TableColumnModel columnModel = table.getColumnModel();
 			    columnModel.getColumn(0).setPreferredWidth(10);
 			    columnModel.getColumn(1).setPreferredWidth(100);
 			    columnModel.getColumn(2).setPreferredWidth(100);
 			    columnModel.getColumn(3).setPreferredWidth(100);
 			    columnModel.getColumn(4).setPreferredWidth(75);
 			    DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
 			    custom.setHorizontalAlignment(JLabel.CENTER); 
 			    columnModel.getColumn(0).setCellRenderer(custom);
 			    columnModel.getColumn(1).setCellRenderer(custom);
			    columnModel.getColumn(2).setCellRenderer(custom);
			    columnModel.getColumn(3).setCellRenderer(custom);

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
			gestionDemandeFourni window = new gestionDemandeFourni();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
