package view.admin.gestionUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import manager.manager_ryan;
import manager.manager_thomas;
import model.User;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addUser {

	private JFrame frame;
	private JTextField nom;
	private JTextField mail;
	private JTextField prenom;
	private JTextField mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addUser window = new addUser();
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
	public addUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un utilisateur");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(150, 40, 249, 30);
		frame.getContentPane().add(lblNewLabel);
		
		nom = new JTextField();
		nom.setBounds(70, 157, 130, 26);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(67, 129, 30, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		mail = new JTextField();
		mail.setBounds(70, 240, 130, 26);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mail");
		lblNewLabel_2.setBounds(70, 212, 26, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		prenom = new JTextField();
		prenom.setBounds(346, 157, 130, 26);
		frame.getContentPane().add(prenom);
		prenom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Prenom");
		lblNewLabel_3.setBounds(346, 129, 47, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		mdp = new JTextField();
		mdp.setBounds(346, 240, 130, 26);
		frame.getContentPane().add(mdp);
		mdp.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		lblNewLabel_4.setBounds(346, 212, 83, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JRadioButton prof = new JRadioButton("Professeur");
		prof.setBounds(70, 345, 98, 23);
		frame.getContentPane().add(prof);
		
		JLabel lblNewLabel_5 = new JLabel("Profil");
		lblNewLabel_5.setBounds(70, 317, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JRadioButton profP = new JRadioButton("Professeur principal");
		profP.setBounds(180, 345, 157, 23);
		frame.getContentPane().add(profP);
		
		JRadioButton administratif = new JRadioButton("Administratif");
		administratif.setBounds(355, 345, 115, 23);
		frame.getContentPane().add(administratif);
		
		ButtonGroup group = new ButtonGroup();
        group.add(profP);
        group.add(prof);
        group.add(administratif);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prenomUser = prenom.getText();
          		String nomUser = nom.getText();
          		String mailUser = mail.getText();
          		String mdpUser = mdp.getText();
          		String profilUser = "";
          		if(profP.isSelected()) {
          			profilUser = profP.getText();
          		}
          		if(prof.isSelected()) {
          			profilUser = prof.getText();
          		}
          		if(administratif.isSelected()) {
          			profilUser = administratif.getText();
          		}
          		
          		if(prenomUser !="" && nomUser != "" && mailUser != "" && mdpUser != "" && profilUser != "") {
          			User user = User.getInstance(prenomUser, nomUser, mailUser, mdpUser, profilUser);
          			manager_ryan b = new manager_ryan();
          			b.ajoutUser(user);
    				frame.dispose();
          		}
			}
		});
		btnNewButton.setBounds(352, 422, 90, 29);
		frame.getContentPane().add(btnNewButton);
		
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			addUser window = new addUser();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
