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

	
	public ArrayList<Retard> getRetard(int idEleve) {
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
	
	public ArrayList<Absence> getAbsence(int idEleve) {
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
	
	public ArrayList<Sanction> getSanction(int idEleve) {
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
	
		
	
}
