package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import manager.manager_thomas;
import model.user;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class connexion {

	private JFrame frame;
	private JTextField mail;
	private JTextField mdp;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion window = new connexion();
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
	public connexion() {
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
		
		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setBounds(20, 10, 371, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MAIL :");
		lblNewLabel_1.setBounds(20, 62, 61, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		mail = new JTextField();
		mail.setBounds(97, 59, 154, 19);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("MOT DE PASSE :");
		lblNewLabel_1_1.setBounds(20, 111, 61, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		mdp = new JTextField();
		mdp.setColumns(10);
		mdp.setBounds(97, 108, 154, 19);
		frame.getContentPane().add(mdp);
		
		btnNewButton = new JButton("CONNEXION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mailUser = mail.getText();
          		String mdpUser = mdp.getText();
          		
          		user a = new user(mailUser,mdpUser);
        		manager_thomas b = new manager_thomas();
        		b.connexion(a);
			}
		});
		btnNewButton.setBounds(214, 196, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("RETOUR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				accueil accueil = new accueil();
				accueil.run();
			}
		});
		btnNewButton_1.setBounds(309, 196, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			connexion window = new connexion();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
