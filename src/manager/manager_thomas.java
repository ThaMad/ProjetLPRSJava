package manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import model.user;

public class manager_thomas {
	
	private Connection dbh;
	
	public Connection bdd(){
	 	 this.dbh = null;
	 	     String url="jdbc:mysql://localhost/lprs_java?serverTimezone=UTC";
	 	 	 String user="root";
	 	 	 String password="";
			

	 	 	 try {
			

	 	 	 this.dbh = DriverManager.getConnection(url,user, password);
	 	 	 System.out.println(this.dbh.isClosed()?"ferme":"ouverte");
	 	 	 }
			

	 	 	 catch (SQLException e) {
	 	 	 System.out.println("Une erreur est survenue lors de la connexion la base de donnes");
	 	 	 e.printStackTrace();
	 	 	 }
			

	 	 	 return this.dbh;
}
	
	public void inscription(user a) {
   		this.dbh=  bdd();
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
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			       md.update(mdp.getBytes());
			       byte byteData[] = md.digest();

			        //convertir le tableau de bits en une format hexad�cimal - m�thode 1
			        StringBuffer sb = new StringBuffer();
			        for (int i = 0; i < byteData.length; i++) {
			         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			        }
			int insert =stm.executeUpdate("INSERT INTO user VALUES('"+id+"','"+a.getNom()+"','"+a.getPrenom()+"','"+a.getMail()+"','"+sb.toString()+"','"+a.getProfil()+"','"+0+"')");
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
	}

}
