package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Classe;
import model.Eleve;
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

	public Eleve getEleveSanctions(int idEleve) {
		// TODO Auto-generated method stub
		return null;
	}

}
