package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import manager.Manager_prof;
import manager.manager_thomas;
import model.Absence;
import model.Classe;
import model.Eleve;
import model.Retard;
import model.Sanction;
import model.User;

public class gestionEleveProf {

    private static String[] colMedHdr1 = { "id", "Date", "Justificatif" };
    private static DefaultTableModel tblModelRetard = new DefaultTableModel(colMedHdr1, 0);
    private static String[] colMedHdr2 = { "id","libelle", "Du", "Au", "Justificatif" };
    private static DefaultTableModel tblModelAbsence = new DefaultTableModel(colMedHdr2, 0);
    private static String[] colMedHdr3 = { "id", "Type","Date", "Commentaires" };
    private static DefaultTableModel tblModelSanction = new DefaultTableModel(colMedHdr3, 0);
    private Manager_prof manprof = new Manager_prof();
	private static JFrame frame;
	private JTable tableRetard, tableAbsence, tableSanction;
	private Connection connexion;
	private int idEleve;


	/**
	 * Launch the application.
	 */
	public static void run() {
		try {
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
			}
	/**
	 * Create the application.
	 */
	public gestionEleveProf(int idEleve) {
		this.idEleve = idEleve;
		initialize(idEleve);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idEleve) {
		manager_thomas a = new manager_thomas();
		Manager_prof manprof = new Manager_prof();
		connexion = (Connection) a.bdd();
		User me = User.getInstanceVide();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 550);
		frame.getContentPane().setBackground(Color.WHITE);
		
		// Debut NAV BAR 
		ImageIcon monImage = new ImageIcon("C:\\Users\\MADAWALA_Th\\eclipse-workspace\\ProjetLPRSJava\\src\\demo\\logolprsjava.png"); 
		Image image = monImage.getImage(); // transform it 
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ImageIcon monImagetrans = new ImageIcon(newimg);
		frame.getContentPane().setLayout(null);
		JPanel navbar = new JPanel();
		navbar.setBounds(0, -18, 729, 68);
		navbar.setBackground(new Color(51, 153, 204));
		frame.getContentPane().add(navbar);
		navbar.setLayout(null);
		
		
		JLabel navbarlogo = new JLabel(" Robert Schuman ");
		navbarlogo.setBounds(23, 11, 234, 63);
		navbarlogo.setForeground(UIManager.getColor("inactiveCaptionBorder"));
		navbarlogo.setFont(new Font("Heiti TC", Font.BOLD, 16));
		navbar.add(navbarlogo);
		navbarlogo.setIcon(monImagetrans);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 49, 729, 95);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel bienvenue = new JLabel("Absences, sanctions et retards de ");
		bienvenue.setBounds(104, 6, 537, 43);
		bienvenue.setForeground(new Color(255, 127, 80));
		bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenue.setFont(new Font("Heiti SC", Font.BOLD, 27));
		panel_1.add(bienvenue);
		


		try {
			java.sql.Statement stm= connexion.createStatement();
		
			// requete pour recuperer le nom et le prenom de l'eleve
			ResultSet resultat= stm.executeQuery("SELECT nom,prenom FROM eleve WHERE idEleve =('"+idEleve+"')");
			
			if(resultat.next()) {
				JLabel nameeleve = new JLabel(""+resultat.getString("nom")+ " "+resultat.getString("prenom"));
				nameeleve.setHorizontalAlignment(SwingConstants.CENTER);
				nameeleve.setForeground(new Color(255, 127, 80));
				nameeleve.setFont(new Font("Heiti SC", Font.BOLD, 23));
				nameeleve.setBounds(114, 44, 513, 43);
				panel_1.add(nameeleve);
				
			}
			
		} catch(SQLException e1) {
	  			e1.printStackTrace();
	  			System.out.println("erreur dans l'ajout");	
	  	}
		/// FIN NAV BAR & HEADER TITLE.
		
		/// Debut scrollpane et jTable Retard
		
		JScrollPane scrollPaneRetard = new JScrollPane();
		scrollPaneRetard.setBounds(0, 178, 243, 285);
		frame.getContentPane().add(scrollPaneRetard);

		
		tableRetard = new JTable(tblModelRetard){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	         }
	       };
		tableRetard.setFocusable(false);

		tableRetard.setBounds(0, 0, 286, 219);
		scrollPaneRetard.setViewportView(tableRetard);
		
		/// Debut scrollpane et jTable Absence
		
		JScrollPane scrollPaneAbsence = new JScrollPane();
		scrollPaneAbsence.setBounds(242, 178, 243, 285);
		frame.getContentPane().add(scrollPaneAbsence);
		
		tableAbsence = new JTable(tblModelAbsence){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	         }
	       };
		tableAbsence.setFocusable(false);

		tableAbsence.setBounds(0, 0, 286, 219);
		scrollPaneAbsence.setViewportView(tableAbsence);
		
		
		// Debut ScrollPane et JTable Sanction
		
		JScrollPane scrollPaneSanction = new JScrollPane();
		scrollPaneSanction.setBounds(486, 178, 243, 285);
		frame.getContentPane().add(scrollPaneSanction);
		

		tableSanction= new JTable(tblModelSanction){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	         }
	       };
		tableSanction.setFocusable(false);

		tableSanction.setBounds(0, 0, 286, 219);
		scrollPaneSanction.setViewportView(tableSanction);
		
		JLabel lblRetards = new JLabel("Retards");
		lblRetards.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetards.setForeground(new Color(255, 127, 80));
		lblRetards.setFont(new Font("Heiti SC", Font.BOLD, 14));
		lblRetards.setBounds(0, 143, 243, 36);
		frame.getContentPane().add(lblRetards);
		
		JLabel lblAbsence = new JLabel("Absences");
		lblAbsence.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbsence.setForeground(new Color(255, 127, 80));
		lblAbsence.setFont(new Font("Heiti SC", Font.BOLD, 14));
		lblAbsence.setBounds(242, 143, 243, 36);
		frame.getContentPane().add(lblAbsence);
		
		JLabel lblSanctions = new JLabel("Sanctions");
		lblSanctions.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanctions.setForeground(new Color(255, 127, 80));
		lblSanctions.setFont(new Font("Heiti SC", Font.BOLD, 14));
		lblSanctions.setBounds(486, 143, 243, 36);
		frame.getContentPane().add(lblSanctions);
		
		JButton addRetard = new JButton("Ajouter un retard");
		addRetard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addRetard.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		addRetard.setForeground(UIManager.getColor("CheckBox.select"));
		addRetard.setBackground(new Color(255, 255, 255));
		addRetard.setBounds(43, 464, 160, 29);
		frame.getContentPane().add(addRetard);
		
		JButton addAbsence = new JButton("Ajouter une absence");
		addAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addAbsence.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		addAbsence.setForeground(UIManager.getColor("Button.select"));
		addAbsence.setBackground(Color.WHITE);
		addAbsence.setBounds(297, 464, 160, 29);
		frame.getContentPane().add(addAbsence);
		
		JButton addSanction = new JButton("Ajouter une sanction");
		addSanction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addSanction.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		addSanction.setForeground(UIManager.getColor("Button.select"));
		addSanction.setBackground(Color.WHITE);
		addSanction.setBounds(540, 464, 160, 29);
		frame.getContentPane().add(addSanction);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		btnRetour.setFont(new Font("Heiti SC", Font.PLAIN, 10));
		btnRetour.setBackground(Color.WHITE);
		btnRetour.setBounds(0, 493, 70, 29);
		frame.getContentPane().add(btnRetour);
		
		
		
		// On remplit les trois table avec la fonction populateTable definie après. 
	
		populateTable();
	}
	
	private void populateTable() {
		
	// On recupere les données en arraylist et on affiche dans la table les retards 
		tblModelRetard.getDataVector().removeAllElements();
		ArrayList<Retard> retards = manprof.getRetard(idEleve);
		for (Retard retard : retards) {
			Object[] data = {retard.getIdRetard(),retard.getDate(),retard.getJustificatif(),};
			tblModelRetard.addRow(data);
		}
	// On recupere les données en arraylist et on affiche dans la table les absences
		tblModelAbsence.getDataVector().removeAllElements();
		ArrayList<Absence> absences = manprof.getAbsence(idEleve);
		for (Absence absence : absences) {
			Object[] data = {absence.getIdAbsence(),absence.getLibelle(),absence.getDateD(),absence.getDateF(),absence.getJustificatif()};
			tblModelAbsence.addRow(data);
		}
	// On recupere les données en arraylist et on affiche dans la table les sanctions
		tblModelSanction.getDataVector().removeAllElements();
		ArrayList<Sanction> sanctions = manprof.getSanction(idEleve);
		for (Sanction sanction : sanctions) {
			Object[] data = {sanction.getIdEleve(),sanction.getIdType(),sanction.getDate(),sanction.getCommentaire()};
			tblModelSanction.addRow(data);
				
		}
		
	}
	
	public void actualiseTableau() {
		
// On actualise les données du tableau Retard
		tblModelRetard.getDataVector().removeAllElements();
		
		Manager_prof managerProf = new Manager_prof();
		ArrayList<Retard> retards = managerProf.getRetard(idEleve);
		
		for (Retard retard : retards) {
			Object[] data = {retard.getIdRetard(),retard.getJustificatif(),retard.getDate()};
			tblModelRetard.addRow(data);}
			
		tblModelRetard.fireTableDataChanged();
		
		// On actualise les données du tableau Absence
		
		tblModelAbsence.getDataVector().removeAllElements();
		ArrayList<Absence> absences = managerProf.getAbsence(idEleve);
		
		for (Absence absence : absences) {
			Object[] data = {absence.getIdAbsence(),absence.getLibelle(),absence.getDateD(),absence.getDateF(),absence.getJustificatif()};
			tblModelAbsence.addRow(data);}
			
		tblModelAbsence.fireTableDataChanged();
		
		// On actualise les données du tableau Sanction
		
		tblModelSanction.getDataVector().removeAllElements();
		ArrayList<Sanction> sanctions = managerProf.getSanction(idEleve);
		
		for (Sanction sanction : sanctions) {
			Object[] data = {sanction.getIdEleve(),sanction.getIdType(),sanction.getDate(),sanction.getCommentaire()};
			tblModelSanction.addRow(data);}
			
		tblModelSanction.fireTableDataChanged();
		
	}
	}
