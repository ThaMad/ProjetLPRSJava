package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import manager.manager_thomas;
import model.User;
import com.toedter.calendar.JDayChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class rendezvous {

	private JFrame frame;
	private Connection connexion;
	private JTextField raison;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rendezvous window = new rendezvous();
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
	public rendezvous() {
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
		
		JLabel name = new JLabel("S");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(new Color(255, 99, 71));
		name.setFont(new Font("Heiti TC", Font.BOLD, 23));
		name.setBounds(6, 42, 536, 43);
		panel_1.add(name);
		
		JLabel lblNewLabel = new JLabel("Date : ");
		lblNewLabel.setBounds(10, 363, 134, 26);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nom du Parent :");
		lblNewLabel_1.setBounds(10, 205, 134, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox nomParent = new JComboBox();
		nomParent.setBounds(161, 208, 205, 21);
		frame.getContentPane().add(nomParent);
		try {
			java.sql.Statement stm= connexion.createStatement();
  			
  			ResultSet resultat= stm.executeQuery("SELECT nom FROM parent");
  			while(resultat.next()) {
  				 nomParent.addItem(resultat.getString("nom"));
			}
		}
		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
		
		
		JLabel lblNewLabel_2 = new JLabel("Raison : ");
		lblNewLabel_2.setBounds(10, 289, 134, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		raison = new JTextField();
		raison.setBounds(161, 293, 215, 19);
		frame.getContentPane().add(raison);
		raison.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(161, 363, 215, 26);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("Horaire : ");
		lblNewLabel_3.setBounds(10, 429, 134, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox horaire = new JComboBox();
		horaire.setBounds(161, 432, 205, 21);
		frame.getContentPane().add(horaire);
		try {
			java.sql.Statement stm= connexion.createStatement();
  			
  			ResultSet resultat= stm.executeQuery("SELECT heure FROM horaire ORDER BY heure ASC");
  			while(resultat.next()) {
  				horaire.addItem(resultat.getString("heure"));
			}
		}
		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				String date = sdf.format(dateChooser.getDate());
				String nomDaron = (String) nomParent.getSelectedItem();
				String lblRaison = raison.getText();
				String heure = (String) horaire.getSelectedItem();
				
				
			
			}
		});
		btnNewButton_1.setBounds(308, 644, 196, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profilprof profilprof = new profilprof();
				profilprof.run();
			}
		});
		btnNewButton.setBounds(86, 644, 186, 37);
		frame.getContentPane().add(btnNewButton);
		
		
		frame.setBounds(100, 100, 549, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			rendezvous window = new rendezvous();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
