package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.Manager_prof;
import manager.manager_ryan;
import manager.manager_thomas;
import model.Absence;
import model.Retard;
import model.User;
import view.admin.general.info;
import com.toedter.calendar.JDateChooser;

public class addAbsence{

	private static JFrame frame;
	private JTextField justificatif;
	private JTextField libelle;
	private int idEleve;
	private Connection connexion;
	private Absence absence;
	private User me;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
			public void run() {
					frame.setVisible(true);
			}
	/**
	 * Create the application.
	 */
	public addAbsence(int idEleve) {
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
		me = User.getInstanceVide();
		
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
		panel_1.setBounds(0, 59, 560, 65);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel addlbl = new JLabel("Ajout d'une absence");
		addlbl.setForeground(new Color(255, 127, 80));
		addlbl.setHorizontalAlignment(SwingConstants.CENTER);
		addlbl.setFont(new Font("Heiti SC", Font.BOLD, 27));
		addlbl.setBounds(78, 6, 391, 43);
		panel_1.add(addlbl);
		
		
		justificatif = new JTextField();
		justificatif.setBounds(55, 198, 191, 42);
		frame.getContentPane().add(justificatif);
		justificatif.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Justificatif");
		lblNewLabel_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(338, 153, 83, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date de début");
		lblNewLabel_2.setForeground(new Color(255, 99, 71));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(55, 290, 95, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JDateChooser dateD = new JDateChooser();
		dateD.setBounds(55, 322, 95, 26);
		frame.getContentPane().add(dateD);
		
		JLabel lblNewLabel_1_1 = new JLabel("Libelle");
		lblNewLabel_1_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1_1.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(55, 153, 83, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(338, 198, 191, 42);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date de fin");
		lblNewLabel_2_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_2_1.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(338, 290, 95, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JDateChooser dateF = new JDateChooser();
		dateF.setBounds(338, 322, 95, 26);
		frame.getContentPane().add(dateF);
		
		
		JButton btnSave = new JButton("Ajouter");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager_prof manprof = new Manager_prof();
				String justificatifAbsence = justificatif.getText();
				String libelleAbsence = libelle.getText();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date DateDformaté=dateD.getDate();
				String dateDAbsence = sdf.format(DateDformaté);
				
				Date DateFformaté=dateF.getDate();
				String dateFAbsence = sdf.format(DateFformaté);
			
          		///Timestamp dateRetardf = Timestamp.valueOf(dateRetard);
				
          		
          		String prof= me.mail;
          		System.out.println(prof);
         
          		
          		if(justificatifAbsence !="" && libelleAbsence !="" && dateDAbsence != "" && dateFAbsence != "") {
          			
          			absence = new Absence(idEleve,libelleAbsence,justificatifAbsence,dateDAbsence, dateFAbsence);
          			manprof.addAbsence(absence,prof);
    				frame.dispose();
    				
    				
			}
			}
		});
		btnSave.setBackground(Color.WHITE);
		btnSave.setForeground(new Color(255, 69, 0));
		btnSave.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		btnSave.setBounds(221, 412, 117, 29);
		frame.getContentPane().add(btnSave);
		
		
		
		frame.setBounds(100, 100, 549, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

}
}