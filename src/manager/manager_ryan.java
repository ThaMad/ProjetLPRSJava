package manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Classe;
import model.Stock;
import model.User;
import view.accueil;
import view.inscription;
import view.admin.general.info;
import view.admin.gestionUser.addUser;
import manager.manager_thomas;

public class manager_ryan {
	
	private Connection dbh;
	private manager_thomas manThoms = new manager_thomas();
	private String table = "user";

	public void ajoutUser(User a) {
   		this.dbh= manThoms.bdd();
   		StringBuffer sb = null;
		try {
  			java.sql.Statement stm= this.dbh.createStatement();
  			
  			ResultSet resultat= stm.executeQuery("SELECT idUser FROM user");
  			     int id = 0;
				   while(resultat.next()) {
  				       id=resultat.getInt("idUser");
  					   id++;
  			   }
				   String mdp = a.getMdp();
				   MessageDigest md = null;
				try {
				md = MessageDigest.getInstance("MD5");
			       md.update(mdp.getBytes());
			       byte byteData[] = md.digest();

			        //convertir le tableau de bits en une format hexad�cimal - m�thode 1
			        sb = new StringBuffer();
			        for (int i = 0; i < byteData.length; i++) {
			         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			        }
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			int insert =stm.executeUpdate("INSERT INTO user VALUES('"+id+"','"+a.getNom()+"','"+a.getPrenom()+"','"+a.getMail()+"','"+sb.toString()+"','"+a.getProfil()+"','"+1+"')");
			if(insert == 1) {
				info info = new info();
				info.run();
				info.actualiseTableau(a);
			}
			else {
				addUser addUser = new addUser();
				addUser.run();
			}
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}
	
	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		User user;
		this.dbh= manThoms.bdd();
		String sql = "SELECT * FROM "+table+"";
		PreparedStatement pstm;
		try {
			pstm = this.dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt("idUser"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("profil"), rs.getInt("active"));
				users.add(user);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public ArrayList<Stock> getStocks() {
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		Stock stock;
		this.dbh= manThoms.bdd();
		String sql = "SELECT * FROM stock";
		PreparedStatement pstm;
		try {
			pstm = this.dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				stock = new Stock(rs.getInt("idStock"), rs.getString("libelle"), rs.getInt("nbrStock"));
				stocks.add(stock);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Echec récupération stock");
			e.printStackTrace();
		}
		
		return stocks;
	}
	
	public User getUser(int idUser) {
		this.dbh= manThoms.bdd();
		User user = null;
		String sql = "SELECT * FROM "+table+ " WHERE idUser="+idUser+"";
		PreparedStatement pstm;
		try {
			pstm = dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("idUser"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("profil"),rs.getInt("active"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	/*
	public Stock getStock(int idStock) {
		this.dbh= manThoms.bdd();
		Stock stock = null;
		String sql = "SELECT * FROM stock WHERE idStock="+idStock+"";
		PreparedStatement pstm;
		try {
			pstm = dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				stock = new Stock(rs.getInt("idStock"),rs.getString("libelle"),rs.getInt("nbrStock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stock;
	}
	*/

	public User sauvegarder(User user) throws SQLException {
		String sql;
		this.dbh= manThoms.bdd();
		PreparedStatement pstm;

		//Update
		try {
		if(user.getIdUser() > 0) {
			sql = "UPDATE `"+table+"` SET `nom`=?,`prenom`=?,`mail`=?, profil=?, active=? WHERE idUser=?";
			
			pstm = dbh.prepareStatement(sql);
			pstm.setString(1, user.getNom());
			pstm.setString(2, user.getPrenom());
			pstm.setString(3, user.getMail());
			pstm.setString(4, user.getProfil());
			pstm.setInt(5, user.getActive());
			pstm.setInt(6, user.getIdUser());
			pstm.executeUpdate();
		
		}
		
		else {
			System.out.println("erreur dans la modification");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	
	public User supprimer(User user) throws SQLException {
		String sql;
		this.dbh= manThoms.bdd();
		PreparedStatement pstm;

		//Update
		try {
		if(user.getIdUser() > 0) {
			
			//System.out.println(user.getIdUser());
			
			sql = "DELETE FROM demande_fournisseur WHERE idUser=?";
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, user.getIdUser());
			pstm.executeUpdate();
			sql = "DELETE FROM profclasse WHERE idProf=?";
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, user.getIdUser());
			pstm.executeUpdate();
			sql = "DELETE FROM retard WHERE idProf=?";
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, user.getIdUser());
			pstm.executeUpdate();
			sql = "DELETE FROM absence WHERE id_prof=?";
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, user.getIdUser());
			pstm.executeUpdate();
			sql = "DELETE FROM sanction WHERE idProf=?";
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, user.getIdUser());
			pstm.executeUpdate();
			sql = "DELETE FROM rdv WHERE id_prof_principale=?";
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, user.getIdUser());
			pstm.executeUpdate();
			sql = "DELETE FROM classe WHERE id_prof_principale=?";
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, user.getIdUser());
			pstm.executeUpdate();
			sql = "DELETE FROM demande_stock WHERE id_prof=?";
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, user.getIdUser());
			pstm.executeUpdate();

			sql = "DELETE FROM`"+table+"` WHERE idUser=?";
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, user.getIdUser());
			pstm.executeUpdate();
		
		}
		
		else {
			System.out.println("erreur dans la suppression");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;


	}
}
