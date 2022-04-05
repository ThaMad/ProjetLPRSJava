package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.Manager_prof;
import manager.manager_thomas;
import model.Absence;
import model.User;

public class modsuppAbsence {

	private JFrame frame;
	private int idAbsence;
	private Absence absence;
	private Connection connexion;
	private JTextField libelle;
	private JTextField justificatif;
	private JTextField dateF;
	private JTextField dateD;
	

	/**
	 * Launch the application.
	 */
	public void run() {
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public modsuppAbsence(Absence absenceSel) {
		initialize();
		this.absence = absenceSel;
		this.libelle.setText(absence.getLibelle());
		this.justificatif.setText(absence.getJustificatif());
		this.dateD.setText(absence.getDateD());
		this.dateF.setText(absence.getDateF());
		
		JLabel lblNewLabel_1_1 = new JLabel("Libellé");
		lblNewLabel_1_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1_1.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(56, 178, 181, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Justificatif");
		lblNewLabel_1_1_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1_1_1.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(335, 178, 181, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		manager_thomas a = new manager_thomas();
		Manager_prof manprof = new Manager_prof();
		Connection connexion = (Connection) a.bdd();
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

		JLabel addlbl = new JLabel("Modification ou suppression");
		addlbl.setForeground(new Color(255, 127, 80));
		addlbl.setHorizontalAlignment(SwingConstants.CENTER);
		addlbl.setFont(new Font("Heiti SC", Font.BOLD, 27));
		addlbl.setBounds(78, 6, 391, 43);
		panel_1.add(addlbl);

		JLabel lblDuneAbsence = new JLabel("d'une absence");
		lblDuneAbsence.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneAbsence.setForeground(new Color(255, 127, 80));
		lblDuneAbsence.setFont(new Font("Heiti SC", Font.BOLD, 27));
		lblDuneAbsence.setBounds(161, 46, 224, 43);
		panel_1.add(lblDuneAbsence);
		
		libelle = new JTextField();
		libelle.setBounds(56, 216, 190, 42);
		frame.getContentPane().add(libelle);
		libelle.setColumns(10);
		
		justificatif = new JTextField();
		justificatif.setBounds(335, 216, 181, 42);
		frame.getContentPane().add(justificatif);
		justificatif.setColumns(10);
		
		dateD = new JTextField();
		dateD.setBounds(56, 329, 181, 42);
		frame.getContentPane().add(dateD);
		dateD.setColumns(10);
		
		dateF = new JTextField();
		dateF.setBounds(335, 329, 181, 42);
		frame.getContentPane().add(dateF);
		dateF.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Justificatif");
		
		JLabel lblNewLabel_1_1 = new JLabel("Date de début");
		lblNewLabel_1_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1_1.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(56, 291, 181, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		this.dateF.setText(absence.getDateF());
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date de fin");
		lblNewLabel_1_1_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1_1_1.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(335, 291, 181, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("Date de début");
		
		JButton btnSave = new JButton("Sauvegarder");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager_prof manprof = new Manager_prof();
				try {
					absence.setLibelle(libelle.getText());
					absence.setJustificatif(justificatif.getText());
					absence.setDateD(dateD.getText());
					absence.setDateF(dateF.getText());
					manprof.sauvegarderAbsence(absence);
					gestionEleveProf.actualiseTableaua(absence);
					frame.setVisible(false);
				} catch (SQLException ex) {
					System.out.println("Erreur");
					//e.printStackTrace();
				} 
				
				
			}
		});
		btnSave.setBackground(Color.WHITE);
		btnSave.setForeground(new Color(255, 69, 0));
		btnSave.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		btnSave.setBounds(221, 412, 117, 29);
		frame.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Supprimer");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager_prof manprof = new Manager_prof();
				try {
					manprof.deleteAbsence(absence);
					gestionEleveProf.actualiseTableaua(absence);
					frame.setVisible(false);
				} catch (SQLException ex) {
					System.out.println("Erreur");
					//e.printStackTrace();
				} 
			}
			
		});
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Heiti SC", Font.BOLD | Font.ITALIC, 13));
		btnDelete.setBounds(221, 459, 117, 36);
		frame.getContentPane().add(btnDelete);

		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
