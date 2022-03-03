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
import model.Classe;
import model.Eleve;
import model.User;

public class gestionEleveProf {

    private static String[] colMedHdr1 = { "idRetard", "Date", "Justificatif" };
    private static DefaultTableModel tblModelRetard = new DefaultTableModel(colMedHdr1, 0);
    private static String[] colMedHdr2 = { "idAbsence","libelle", "Du", "Au", "Justificatif" };
    private static DefaultTableModel tblModelAbsence = new DefaultTableModel(colMedHdr2, 0);
    private static String[] colMedHdr3 = { "idSanction", "Type","Date", "Commentaires" };
    private static DefaultTableModel tblModelSanction = new DefaultTableModel(colMedHdr3, 0);
    private Manager_prof manprof = new Manager_prof();
	private static JFrame frame;
	private static ArrayList<Eleve> eleves;
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
		frame.setBounds(100, 100, 549, 550);
		frame.getContentPane().setBackground(Color.WHITE);
		ImageIcon monImage = new ImageIcon("C:\\Users\\MADAWALA_Th\\eclipse-workspace\\ProjetLPRSJava\\src\\demo\\logolprsjava.png"); 
		Image image = monImage.getImage(); // transform it 
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ImageIcon monImagetrans = new ImageIcon(newimg);
		frame.getContentPane().setLayout(null);
		JPanel navbar = new JPanel();
		navbar.setBounds(0, -15, 549, 74);
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
		panel_1.setBounds(0, 71, 549, 95);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel bienvenue = new JLabel("Absences, sanctions et retards de ");
		bienvenue.setBounds(6, 6, 537, 43);
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
				nameeleve.setBounds(6, 46, 536, 43);
				panel_1.add(nameeleve);
			}
			
		} catch(SQLException e1) {
	  			e1.printStackTrace();
	  			System.out.println("erreur dans l'ajout");	
	  	}
		
		
		
		JScrollPane scrollPaneRetard = new JScrollPane();
		scrollPaneRetard.setBounds(0, 178, 190, 318);
		frame.getContentPane().add(scrollPaneRetard);

		
		tableRetard = new JTable(tblModelRetard){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	         }
	       };
		tableRetard.setFocusable(false);

		tableRetard.setBounds(0, 0, 286, 219);
		scrollPaneRetard.setViewportView(tableRetard);
		
		JScrollPane scrollPaneRetard_1 = new JScrollPane();
		scrollPaneRetard_1.setBounds(202, 178, 192, 318);
		frame.getContentPane().add(scrollPaneRetard_1);
	
		populateTable();
	}
	
	private void populateTable() {
		tblModelRetard.getDataVector().removeAllElements();
		ArrayList<Retard> retards = manprof.getRetard(idEleve);
		for (Retard retard : retards) {
			Object[] data = {retard.getIdEleve(),retard.getNom(),retard.getPrenom()};
			tblModelRetard.addRow(data);
			
		tblModelRetard.getDataVector().removeAllElements();
		ArrayList<Retard> retards = manprof.getRetard(idEleve);
		for (Retard retard : retards) {
			Object[] data = {retard.getIdEleve(),retard.getNom(),retard.getPrenom()};
			tblModelRetard.addRow(data);
		
		tblModelRetard.getDataVector().removeAllElements();
		ArrayList<Retard> retards = manprof.getRetard(idEleve);
		for (Retard retard : retards) {
			Object[] data = {retard.getIdEleve(),retard.getNom(),retard.getPrenom()};
			tblModelRetard.addRow(data);
				
		}
		
	}
	public void actualiseTableau() {
		tblModelRetard.getDataVector().removeAllElements();
		
		Manager_prof managerProf = new Manager_prof();
		ArrayList<Retard> retards = managerProf.getRetard(idEleve);
		
		for (Retard retard : retards) {
			Object[] data = {retard.getIdEleve(),retard.getNom(),retard.getPrenom()};
			tblModelRetard.addRow(data);
			
		tblModelRetard.fireTableDataChanged();
	}
	}
}
