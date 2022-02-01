package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import manager.manager_thomas;
import model.user;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class inscription {

	private JFrame frame;
	private JTextField nom;
	private JTextField prenom;
	private JTextField mail;
	private JTextField mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscription window = new inscription();
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
	public inscription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSCRIPTION");
		lblNewLabel.setBounds(35, 10, 362, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOM :");
		lblNewLabel_1.setBounds(10, 50, 61, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		nom = new JTextField();
		nom.setBounds(107, 54, 96, 19);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRENOM :");
		lblNewLabel_1_1.setBounds(10, 86, 61, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(107, 86, 96, 19);
		frame.getContentPane().add(prenom);
		
		JLabel lblNewLabel_1_2 = new JLabel("MAIL :");
		lblNewLabel_1_2.setBounds(10, 118, 61, 19);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(107, 115, 96, 19);
		frame.getContentPane().add(mail);
		
		JLabel lblNewLabel_1_3 = new JLabel("MOT DE PASSE :");
		lblNewLabel_1_3.setBounds(10, 147, 61, 19);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		mdp = new JTextField();
		mdp.setColumns(10);
		mdp.setBounds(107, 144, 96, 19);
		frame.getContentPane().add(mdp);
		
		JLabel lblNewLabel_1_4 = new JLabel("Profil");
		lblNewLabel_1_4.setBounds(10, 176, 61, 19);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JRadioButton profil = new JRadioButton("Professeur");
		profil.setBounds(100, 175, 103, 21);
		frame.getContentPane().add(profil);
		
		JRadioButton profil1 = new JRadioButton("Administrateur");
		profil1.setBounds(213, 175, 103, 21);
		frame.getContentPane().add(profil1);
		
		ButtonGroup group = new ButtonGroup();
        group.add(profil);
        group.add(profil1);
		
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String prenomUser = prenom.getText();
          		String nomUser = nom.getText();
          		String mailUser = mail.getText();
          		String mdpUser = mdp.getText();
          		String profilUser = "";
          		if(profil.isSelected()) {
          			profilUser = profil.getText();
          		}
          		if(profil1.isSelected()) {
          			profilUser = profil1.getText();
          		}
          		
          		if(prenomUser !="" && nomUser != "" && mailUser != "" && mdpUser != "" && profilUser != "") {
          		user a = new user(nomUser, prenomUser, mailUser,mdpUser,profilUser);
        		manager_thomas b = new manager_thomas();
        		b.inscription(a);
          		}
          		
			}
		});
		btnNewButton.setBounds(249, 216, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				accueil accueil = new accueil();
				accueil.run();
			}
		});
		btnNewButton_1.setBounds(344, 216, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			inscription window = new inscription();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
