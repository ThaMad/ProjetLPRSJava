package view.admin.general;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manager.manager_ryan;
import manager.manager_thomas;
import model.Stock;
import model.User;
import view.admin.gestionUser.modUser;

public class stock {

	private static String[] colMedHdr = {"Id", "Produit", "Quantité"};
	private static DefaultTableModel tblModel = new DefaultTableModel(colMedHdr, 0);
	DefaultTableModel model;
	private JFrame frame;
	private JTable table;
	private Connection connexion;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock window = new stock();
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
	public stock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		manager_thomas a = new manager_thomas();
		connexion =  (Connection) a.bdd();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informations des stocks");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(135, 31, 279, 30);
		populateTable();
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 83, 482, 318);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tblModel){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	         }
	       };
		table.setFocusable(false);
		table.setBounds(0, 0, 286, 219);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(33, 442, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
}
	private void populateTable() {
		tblModel.getDataVector().removeAllElements();
		manager_ryan manRyan = new manager_ryan();
		ArrayList<Stock> stocks = manRyan.getStocks();
		System.out.println(stocks.size());
		for (Stock stock : stocks) {
			Object[] data = {stock.getIdStock(),stock.getLibelle(),stock.getNbrStock()};
			tblModel.addRow(data);
		}		
	}
	public static void actualiseTableau(Stock stockSel) {
		tblModel.getDataVector().removeAllElements();
		
		manager_ryan manRyan = new manager_ryan();
		ArrayList<Stock> stocks = manRyan.getStocks();
		
		for (Stock stock : stocks) {
			Object[] data = {stock.getIdStock(),stock.getLibelle(),stock.getNbrStock()};
			tblModel.addRow(data);
		}
		tblModel.fireTableDataChanged();
	}
	
	public void run() {
		try {
			stock window = new stock();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
