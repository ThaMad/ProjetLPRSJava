package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class addRetard {

	private static JFrame frame;
	private JTextField ideleve;
	private JTextField idProf;
	private JTextField justificatif;
	private JTextField date;
	private int idEleve;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param idEleve2 
	 */
	public addRetard(int idEleve) {
		this.idEleve = idEleve;
		initialize(idEleve);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idEleve) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

}
