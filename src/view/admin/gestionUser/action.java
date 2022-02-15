package view.admin.gestionUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class action {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					action window = new action();
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
	public action() {
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
		
		JLabel lblNewLabel = new JLabel("Que voulez-vous faire?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(140, 27, 269, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton ajout_user = new JButton("Ajouter un utilisateur");
		ajout_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceModUser choiceModUser = new choiceModUser();
				choiceModUser.run();
			}
		});
		ajout_user.setBounds(186, 168, 178, 29);
		frame.getContentPane().add(ajout_user);
		
		JButton mod_user = new JButton("Modifier un utilisateur");
		mod_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modUser modUser = new modUser();
				modUser.run();
			}
		});
		mod_user.setBounds(183, 241, 184, 29);
		frame.getContentPane().add(mod_user);
		
		JButton del_user = new JButton("Supprimer un utilisateur");
		del_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delUser delUser = new delUser();
				delUser.run();
			}
		});
		del_user.setBounds(177, 312, 196, 29);
		frame.getContentPane().add(del_user);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			action window = new action();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
