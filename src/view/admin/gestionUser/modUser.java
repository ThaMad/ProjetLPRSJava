package view.admin.gestionUser;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import view.admin.general.info;

import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modUser {
	
	private JFrame frame;
	private JTextField nom;
	private JTextField mail;
	private JTextField prenom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modUser window = new modUser();
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
	public modUser() {
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
		
		JLabel lblNewLabel = new JLabel("Modifier un utilisateur");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(145, 40, 260, 30);
		frame.getContentPane().add(lblNewLabel);
		
		nom = new JTextField();
		nom.setBounds(70, 157, 130, 26);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(67, 129, 30, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		mail = new JTextField();
		mail.setBounds(70, 240, 395, 26);
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
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(375, 422, 90, 29);
		frame.getContentPane().add(btnNewButton);
		
		JRadioButton prof = new JRadioButton("Professeur");
		prof.setBounds(70, 317, 98, 23);
		frame.getContentPane().add(prof);
		
		JLabel lblNewLabel_5 = new JLabel("Profil");
		lblNewLabel_5.setBounds(70, 289, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JRadioButton profP = new JRadioButton("Professeur principal");
		profP.setBounds(180, 317, 157, 23);
		frame.getContentPane().add(profP);
		
		JRadioButton administratif = new JRadioButton("Administratif");
		administratif.setBounds(355, 317, 115, 23);
		frame.getContentPane().add(administratif);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Activé le compte");
		chckbxNewCheckBox.setBounds(70, 380, 137, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_4 = new JLabel("Activation compte");
		lblNewLabel_4.setBounds(70, 352, 115, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton Return = new JButton("Retour");
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info info = new info();
				info.run();
			}
		});
		Return.setBounds(70, 422, 85, 29);
		frame.getContentPane().add(Return);
	
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			modUser window = new modUser();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
