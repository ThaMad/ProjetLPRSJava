package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import manager.Manager_prof;
import manager.manager_thomas;
import model.Eleve;
import model.User;

public class ClasseDetail {

    private static String[] colMedHdr = { "id", "Nom", "Prenom" };
    private static DefaultTableModel tblModel = new DefaultTableModel(colMedHdr, 0);
    private Manager_prof manprof = new Manager_prof();
	private JFrame frame;
	private User utilisateurConnecte;
	private static Eleve eleve;
	private JTable table;
	private Connection connexion;


	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
			}
	/**
	 * Create the application.
	 */
	public ClasseDetail(Eleve eleve) {
		ClasseDetail.eleve = eleve;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		manager_thomas a = new manager_thomas();
		Manager_prof manprof = new Manager_prof();
		connexion = (Connection) a.bdd();
		User me = User.getInstanceVide();
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
		
		JLabel bienvenue = new JLabel("Eleve de ");
		bienvenue.setForeground(new Color(255, 127, 80));
		bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenue.setFont(new Font("Heiti SC", Font.BOLD, 27));
		bienvenue.setBounds(129, 18, 284, 43);
		panel_1.add(bienvenue);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 28, 482, 318);
		frame.getContentPane().add(scrollPane);
		
		/*
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(548, 54, 117, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReservationDetail reservationDetail = new ReservationDetail(utilisateurConnecte,reservation);
				ReservationDetailForm reservationDetailForm = new ReservationDetailForm(reservationDetail);
				reservationDetailForm.run();
			}
		});
		
		*/ 
		
		table = new JTable(tblModel){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	         }
	       };
		table.setFocusable(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 2) {     // to detect double click events
	                JTable target = (JTable)me.getSource();
	                int row = target.getSelectedRow(); // select a row
	                int idReservationDetail = (int) target.getValueAt(row, 0); // select a column
	               /*  Eleve Eleve= manprof.getEleveSanctions(idReservationDetail, reservation);
	                ReservationDetailForm reservationDetailForm = new ReservationDetailForm(reservationDetailSel);
	                reservationDetailForm.run(); */
	             }
			}
		});
		table.setBounds(0, 0, 286, 219);
		scrollPane.setViewportView(table);
	
		
		FilmManager filmManager = new FilmManager();
		java.sql.Blob blob = filmManager.getImage(reservation.getFkSalle().getFkFilm().getIdFilm());
		JLabel lblImage = new JLabel(reservation.getFkSalle().getFkFilm().getTitre());
		lblImage.setBounds(566, 128, 120, 120);
		if(blob !=null) {
			InputStream in;
			BufferedImage image = null ;
			try {
				in = blob.getBinaryStream();
				image = ImageIO.read(in);
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Image dimg = image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),
			        Image.SCALE_SMOOTH);
			lblImage.setIcon(new ImageIcon(dimg));
			
		}
		frame.getContentPane().add(lblImage);
		populateTable();
	}
	
	private void populateTable() {
		tblModel.getDataVector().removeAllElements();
		ArrayList<ReservationDetail> reservationDetails = reservationDetailManager.getReservationDetails(reservation);
		for (ReservationDetail reservationDetail : reservationDetails) {
			Object[] data = {reservationDetail.getIdReservationDetail(),reservationDetail.getFkReservation().toString(), reservationDetail.getFkTarif().toString(),reservationDetail.getQuantite(), reservationDetail.getFkUserAjout().toString()};
			tblModel.addRow(data);
		}
		
	}
	public static void actualiseTableau() {
		tblModel.getDataVector().removeAllElements();
		
		ReservationDetailManager reservationDetailManager = new ReservationDetailManager();
		ArrayList<ReservationDetail> reservationDetails = reservationDetailManager.getReservationDetails(reservation);
		
		for (ReservationDetail reservationDetail : reservationDetails) {
			Object[] data = {reservationDetail.getIdReservationDetail(),reservationDetail.getFkReservation().toString(), reservationDetail.getFkTarif().toString(),reservationDetail.getQuantite(), reservationDetail.getFkUserAjout().toString()};
			tblModel.addRow(data);
		}
		tblModel.fireTableDataChanged();
	}
		
	}


}
