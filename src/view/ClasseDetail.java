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

public class ClasseDetail {

    private static String[] colMedHdr = { "id", "Nom", "Prenom" };
    private static DefaultTableModel tblModel = new DefaultTableModel(colMedHdr, 0);
    private Manager_prof manprof = new Manager_prof();
	private static JFrame frame;
	private User utilisateurConnecte;
	private static ArrayList<Eleve> eleves;
	private JTable table;
	private Connection connexion;
	private String libelleClasse;
	private int idClasse;


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
	public ClasseDetail(int idClasse, String libelleClasse) {
		this.idClasse = idClasse;
		this.libelleClasse = libelleClasse;
		initialize(idClasse, libelleClasse);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idClasse, String libelleClasse) {
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
		
		JLabel bienvenue = new JLabel("Eleve de ");
		bienvenue.setBounds(166, 21, 120, 43);
		bienvenue.setForeground(new Color(255, 127, 80));
		bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenue.setFont(new Font("Heiti SC", Font.BOLD, 27));
		panel_1.add(bienvenue);
		
		JLabel nameclasse = new JLabel(""+libelleClasse+"");
		nameclasse.setHorizontalAlignment(SwingConstants.CENTER);
		nameclasse.setForeground(new Color(255, 127, 80));
		nameclasse.setFont(new Font("Heiti SC", Font.BOLD, 27));
		nameclasse.setBounds(285, 21, 120, 43);
		panel_1.add(nameclasse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 175, 482, 318);
		frame.getContentPane().add(scrollPane);
		
		/*
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(548, 54, 117, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReservationDetail reservationDetail = new ReservationDetail(utilisateurConnecte,reservation);
				ReservationDetailForm reservationDetailForm = new ReservationDetailForm(reservationDetail);
				reservationDetailForm.run();
			}
		});
		
		*/ 
		
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
	                int idEleve = (int) target.getValueAt(row, 0); // select a column
	                /*Eleve eleve= manprof.getEleveSanctions(idEleve);
	                ReservationDetailForm reservationDetailForm = new ReservationDetailForm(eleve);
	                reservationDetailForm.run();*/
	             }
			}
		});
		table.setBounds(0, 0, 286, 219);
		scrollPane.setViewportView(table);
	
		populateTable();
	}
	
	private void populateTable() {
		tblModel.getDataVector().removeAllElements();
		ArrayList<Eleve> eleves = manprof.getElevesFromClasse(idClasse);
		for (Eleve eleve : eleves) {
			Object[] data = {eleve.getIdEleve(),eleve.getNom(),eleve.getPrenom()};
			tblModel.addRow(data);
		}
		
	}
	public void actualiseTableau() {
		tblModel.getDataVector().removeAllElements();
		
		Manager_prof managerProf = new Manager_prof();
		ArrayList<Eleve> eleves = managerProf.getElevesFromClasse(idClasse);
		
		for (Eleve eleve : eleves) {
			Object[] data = {eleve.getIdEleve(),eleve.getNom(),eleve.getPrenom()};
			tblModel.addRow(data);
			
		tblModel.fireTableDataChanged();
	}
	}


}
