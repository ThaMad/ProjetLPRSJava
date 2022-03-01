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
			int insert =stm.executeUpdate("INSERT INTO user VALUES('"+id+"','"+a.getNom()+"','"+a.getPrenom()+"','"+a.getMail()+"','"+sb.toString()+"','"+a.getProfil()+"','"+0+"')");
			if(insert == 1) {
				info info = new info();
				info.run();
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
				user = new User(rs.getInt("idUser"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("profil"));
				users.add(user);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
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
				user = new User(rs.getInt("idUser"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("profil"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public User sauvegarder(User user) throws SQLException {
		String sql;
		PreparedStatement pstm;
		//Update
		if(user.getIdUser()>0) {
			sql = "UPDATE `"+table+"` SET `nom`=?,`prenom`=?,`mail`=?, 'profil'=? WHERE idUser=?";
			
			pstm = dbh.prepareStatement(sql);
			pstm.setString(1, user.getNom());
			pstm.setString(2, user.getPrenom());
			pstm.setString(3, user.getMail());
			pstm.setString(4, user.getProfil());
			pstm.setInt(5, user.getIdUser());
			pstm.executeUpdate();
		
		}
		
		else {
			System.out.println("erreur dans la modification");

		}
		
		return user;
	}
	
}
