package view.admin.gestionUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class delUser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delUser window = new delUser();
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
	public delUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(183, 171, 183, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Supprimer un utilisateur");
		lblNewLabel.setBounds(133, 40, 283, 30);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel);
		
		JButton del = new JButton("Supprimer l'utilisateur");
		del.setBounds(183, 273, 183, 29);
		frame.getContentPane().add(del);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			delUser window = new delUser();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
