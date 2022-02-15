package view.admin.gestionUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class choiceModUser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choiceModUser window = new choiceModUser();
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
	public choiceModUser() {
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
		
		JLabel lblNewLabel = new JLabel("Choisir l'utilisateur que vous voulez modifier");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(13, 28, 523, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Choisir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser addUser = new addUser();
				addUser.run();
			}
		});
		btnNewButton.setBounds(216, 293, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			choiceModUser window = new choiceModUser();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

