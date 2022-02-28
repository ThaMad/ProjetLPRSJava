package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.components.JLocaleChooser;
import java.awt.BorderLayout;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;

public class planning {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=81,404
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planning window = new planning();
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
	public planning() {
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
		

	}
}
