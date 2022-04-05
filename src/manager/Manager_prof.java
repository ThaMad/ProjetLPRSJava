package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Absence;
import model.Classe;
import model.Eleve;
import model.Retard;
import model.Sanction;
import model.User;
import view.gestionAdministrative;
import view.gestionEleveAdmin;
import view.gestionEleveProf;

public class Manager_prof {
	private Connection dbh;
	private manager_thomas managerthomas = new manager_thomas();
	private String table = "Classe";
	
	
	public ArrayList<Classe> getClasses() {
		ArrayList<Classe> classes = new ArrayList<Classe>();
		Classe classe;
		this.dbh= managerthomas.bdd();
		String sql = "SELECT * FROM "+table+"";
		PreparedStatement pstm;
		try {
			pstm = this.dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				classe = new Classe(rs.getInt("idClasse"),rs.getString("libelle"), rs.getInt("id_prof_principale"));
				classes.add(classe);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classes;
	}
	
	
	public ArrayList<Eleve> getElevesFromClasse(int idClasse) {
		ArrayList<Eleve> eleves = new ArrayList<Eleve>();
		Eleve eleve;
		this.dbh= managerthomas.bdd();
		String sql = "SELECT * FROM eleve WHERE classe="+idClasse+"";
		PreparedStatement pstm;
		try {
			pstm = this.dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				eleve = new Eleve(rs.getInt("idEleve"),rs.getString("nom"),rs.getString("prenom"));
				eleves.add(eleve);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eleves;
	}

	
	public ArrayList<Retard> getRetards(int idEleve) {
		ArrayList<Retard> retards = new ArrayList<Retard>();
		Retard retard;
		this.dbh= managerthomas.bdd();
		String sql = "SELECT * FROM retard WHERE idEleve="+idEleve+"";
		PreparedStatement pstm;
		try {
			pstm = this.dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				retard = new Retard(rs.getInt("idRetard"),rs.getInt("idEleve"),rs.getInt("idProf"), rs.getString("justificatif"), rs.getString("date"));
				retards.add(retard);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retards;
	}
	
	public ArrayList<Absence> getAbsences(int idEleve) {
		ArrayList<Absence> absences = new ArrayList<Absence>();
		Absence absence;
		this.dbh= managerthomas.bdd();
		String sql = "SELECT * FROM absence WHERE id_eleve="+idEleve+"";
		PreparedStatement pstm;
		try {
			pstm = this.dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				absence = new Absence(rs.getInt("idAbsence"),rs.getInt("id_eleve"),rs.getInt("id_prof"),rs.getString("libelle"), rs.getString("justificatif"),rs.getString("dateD"),rs.getString("dateF"));
				absences.add(absence);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return absences;
	}
	
	public ArrayList<Sanction> getSanctions(int idEleve) {
		ArrayList<Sanction> sanctions = new ArrayList<Sanction>();
		Sanction sanction;
		this.dbh= managerthomas.bdd();
		String sql = "SELECT * FROM sanction WHERE idEleve="+idEleve+"";
		PreparedStatement pstm;
		try {
			pstm = this.dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				sanction = new Sanction(rs.getInt("idSanction"),rs.getInt("idType"),rs.getInt("idEleve"),rs.getInt("idProf"),rs.getString("commentaire"), rs.getString("date"));
				sanctions.add(sanction);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sanctions;
	}
	
	public Retard getRetard(int idRetard) {
		this.dbh= managerthomas.bdd();
		Retard retard = null;
		String sql = "SELECT * FROM retard WHERE idRetard="+idRetard+"";
		PreparedStatement pstm;
		try {
			pstm = dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				retard = new Retard(rs.getInt("idRetard"),rs.getInt("idEleve"),rs.getInt("idProf"), rs.getString("justificatif"), rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retard;
	}

	
	public Absence getAbsence(int idAbsence) {
		this.dbh= managerthomas.bdd();
		Absence absence = null;
		String sql = "SELECT * FROM absence WHERE idAbsence="+idAbsence+"";
		PreparedStatement pstm;
		try {
			pstm = dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				absence = new Absence(rs.getInt("idAbsence"),rs.getInt("id_eleve"),rs.getInt("id_prof"),rs.getString("libelle"), rs.getString("justificatif"),rs.getString("dateD"),rs.getString("dateF"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return absence;
	}
	
	
	public Sanction getSanction(int idSanction) {
		this.dbh= managerthomas.bdd();
		Sanction sanction = null;
		String sql = "SELECT * FROM sanction WHERE idSanction="+idSanction+"";
		PreparedStatement pstm;
		try {
			pstm = dbh.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				sanction = new Sanction(rs.getInt("idSanction"),rs.getInt("idType"),rs.getInt("idEleve"),rs.getInt("idProf"),rs.getString("commentaire"), rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sanction;
	}


	public Retard sauvegarderRetard(Retard retard) throws SQLException {
		String sql;
		this.dbh= managerthomas.bdd();
		PreparedStatement pstm;

		//Update
		try {
		if(retard.getIdRetard() > 0) {
			sql = "UPDATE `retard` SET `justificatif`=?,`date`=? WHERE idRetard=?";
			
			pstm = dbh.prepareStatement(sql);
			pstm.setString(1, retard.getJustificatif());
			pstm.setString(2, retard.getDate());
			pstm.setInt(3, retard.getIdRetard());
		
			pstm.executeUpdate();
		
		}
		
		else {
			System.out.println("Erreur dans la modification");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return retard;
	}
		
	public Absence sauvegarderAbsence(Absence absence) throws SQLException {
		String sql;
		this.dbh= managerthomas.bdd();
		PreparedStatement pstm;

		//Update
		try {
		if(absence.getIdAbsence() > 0) {
			sql = "UPDATE `absence` SET `libelle`=?,`dateD`=?,`dateF`=?,`justificatif`=?, WHERE idAbsence=?";
			
			pstm = dbh.prepareStatement(sql);
			pstm.setString(1, absence.getLibelle());
			pstm.setString(2, absence.getDateD());
			pstm.setString(3, absence.getDateF());
			pstm.setString(4, absence.getJustificatif());
			pstm.setInt(5, absence.getIdAbsence());
		
			pstm.executeUpdate();
		
		}
		
		else {
			System.out.println("Erreur dans la modification");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return absence;
	}
	
	public Sanction sauvegarderSanction(Sanction sanction) throws SQLException {
		String sql;
		this.dbh= managerthomas.bdd();
		PreparedStatement pstm;

		//Update
		try {
		if(sanction.getIdSanction() > 0) {
			sql = "UPDATE `sanction` SET `commentaire`=?,date`=?, WHERE idSanction=?";
			
			pstm = dbh.prepareStatement(sql);
			pstm.setString(1, sanction.getCommentaire());
			pstm.setString(2, sanction.getDate());
			pstm.setInt(3, sanction.getIdSanction());
			
		
			pstm.executeUpdate();
		
		}
		
		else {
			System.out.println("Erreur dans la modification");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sanction;
	}
	
	
	
	public Retard deleteRetard(Retard retard) throws SQLException {
		String sql;
		this.dbh= managerthomas.bdd();
		PreparedStatement pstm;

		//Update
		try {
		if(retard.getIdRetard() > 0) {
			sql = "DELETE FROM `retard` WHERE idRetard=?";
			
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, retard.getIdRetard());

		
			pstm.executeUpdate();
		
		}
		
		else {
			System.out.println("Erreur dans la suppression");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return retard;
	}
	
	
	public Absence deleteAbsence(Absence absence) throws SQLException {
		String sql;
		this.dbh= managerthomas.bdd();
		PreparedStatement pstm;

		//Update
		try {
		if(absence.getIdAbsence() > 0) {
			sql = "DELETE FROM `absence` WHERE idAbsence=?";
			
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, absence.getIdAbsence());

		
			pstm.executeUpdate();
		
		}
		
		else {
			System.out.println("Erreur dans la suppression");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return absence;
	}
	
	public Sanction deleteSanction(Sanction sanction) throws SQLException {
		String sql;
		this.dbh= managerthomas.bdd();
		PreparedStatement pstm;

		//Update
		try {
		if(sanction.getIdSanction() > 0) {
			sql = "DELETE FROM `sanction` WHERE idSanction=?";
			
			pstm = dbh.prepareStatement(sql);
			pstm.setInt(1, sanction.getIdSanction());

		
			pstm.executeUpdate();
		
		}
		
		else {
			System.out.println("Erreur dans la suppression");

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sanction;
	}
	
	public void addRetard(Retard retard,String prof) {
		String sql;
		this.dbh= managerthomas.bdd();
		int idProf = 0;
		try {
			java.sql.Statement stm= this.dbh.createStatement();

			ResultSet resultat= stm.executeQuery("SELECT idRetard FROM retard ORDER BY idRetard ASC");
			int id = 0;
			while(resultat.next()) {
				id=resultat.getInt("idRetard");
				id++;
			}
			try {
				java.sql.Statement stm2= this.dbh.createStatement();

				ResultSet resultat2= stm.executeQuery("SELECT idUser FROM user WHERE mail=('"+prof+"')");
				while (resultat2.next()) {
					idProf = resultat2.getInt("idUser");
				}
				
				}
			
	  		catch(SQLException e1) {
	  			e1.printStackTrace();
	  			System.out.println("erreur dans l'ajout");	
	  	}

					System.out.println(retard.getDate());
			int insert =stm.executeUpdate("INSERT INTO retard VALUES('"+id+"','"+retard.getIdEleve()+"','"+idProf+"','"+retard.getJustificatif()+"','"+retard.getDate()+"')");

			int passagepage = retard.getIdEleve();
			if(insert == 1) {
				gestionEleveProf gestionEleveProf = new gestionEleveProf(passagepage);
				gestionEleveProf.run();
			}
			else {
				gestionEleveProf gestionEleveProf = new gestionEleveProf(passagepage);
				gestionEleveProf.run();
			}
		    
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
		
	}
	public void addAbsence(Absence absence,String prof) {
		String sql;
		this.dbh= managerthomas.bdd();
		int idProf = 0;
		try {
			java.sql.Statement stm= this.dbh.createStatement();

			ResultSet resultat= stm.executeQuery("SELECT idAbsence FROM absence ORDER BY idAbsence ASC");
			int id = 0;
			while(resultat.next()) {
				id=resultat.getInt("idAbsence");
				id++;
			}
			try {
				java.sql.Statement stm2= this.dbh.createStatement();

				ResultSet resultat2= stm.executeQuery("SELECT idUser FROM user WHERE mail=('"+prof+"')");
				while (resultat2.next()) {
					idProf = resultat2.getInt("idUser");
				}
				
				}
			
	  		catch(SQLException e1) {
	  			e1.printStackTrace();
	  			System.out.println("erreur dans l'ajout");	
	  	}

			
			int insert =stm.executeUpdate("INSERT INTO absence VALUES('"+id+"','"+absence.getLibelle()+"','"+absence.getJustificatif()+"','"+absence.getId_eleve()+"','"+idProf+"','"+absence.getDateF()+"','"+absence.getDateD()+"')");

			int passagepage = absence.getId_eleve();
			if(insert == 1) {
				gestionEleveProf gestionEleveProf = new gestionEleveProf(passagepage);
				gestionEleveProf.run();
			}
			else {
				gestionEleveProf gestionEleveProf = new gestionEleveProf(passagepage);
				gestionEleveProf.run();
			}
		    
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
		
	}
	
	public void addSanction(Sanction sanction,String prof) {
		String sql;
		this.dbh= managerthomas.bdd();
		int idProf = 0;
		try {
			java.sql.Statement stm= this.dbh.createStatement();

			ResultSet resultat= stm.executeQuery("SELECT idSanction FROM sanction ORDER BY idSanction ASC");
			int id = 0;
			while(resultat.next()) {
				id=resultat.getInt("idSanction");
				id++;
			}
			try {
				java.sql.Statement stm2= this.dbh.createStatement();

				ResultSet resultat2= stm.executeQuery("SELECT idUser FROM user WHERE mail=('"+prof+"')");
				while (resultat2.next()) {
					idProf = resultat2.getInt("idUser");
				}
				
				}
			
	  		catch(SQLException e1) {
	  			e1.printStackTrace();
	  			System.out.println("erreur dans l'ajout");	
	  	}

			
			int insert =stm.executeUpdate("INSERT INTO sanction VALUES('"+id+"','"+sanction.getIdType()+"','"+sanction.getCommentaire()+"','"+sanction.getIdEleve()+"','"+idProf+"','"+sanction.getDate()+"')");

			int passagepage = sanction.getIdEleve();
			if(insert == 1) {
				gestionEleveProf gestionEleveProf = new gestionEleveProf(passagepage);
				gestionEleveProf.run();
			}
			else {
				gestionEleveProf gestionEleveProf = new gestionEleveProf(passagepage);
				gestionEleveProf.run();
			}
		    
  		  }
  		catch(SQLException e1) {
  			e1.printStackTrace();
  			System.out.println("erreur dans l'ajout");	
  	}
		
	}
	
}
