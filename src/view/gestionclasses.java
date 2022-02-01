package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class gestionclasses {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionclasses window = new gestionclasses();
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
	public gestionclasses() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
			
			JLabel bienvenue = new JLabel("Classes");
			bienvenue.setForeground(new Color(255, 127, 80));
			bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
			bienvenue.setFont(new Font("Heiti SC", Font.BOLD, 27));
			bienvenue.setBounds(129, 18, 284, 43);
			panel_1.add(bienvenue);
			
			JButton classename = new JButton("nomclasse");
			classename.setFont(new Font("Heiti SC", Font.PLAIN, 13));
			classename.setForeground(new Color(255, 99, 71));
			classename.setBounds(6, 230, 117, 29);
			frame.getContentPane().add(classename);
			
			
			

			frame.setBounds(100, 100, 549, 550);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		try {
			gestionclasses window = new gestionclasses();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
