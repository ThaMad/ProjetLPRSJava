package model;

public class Rdv {
	
	public int idRdv, id_prof_principale, idParent, idHoraire;
	public String libelle, prof_principale, parent, horaire, date;
	
	public Rdv(String libelle, String parent, String horaire, String date, String prof_principale) {
		this.libelle = libelle;
		this.parent = parent;
		this.horaire = horaire;
		this.date = date;
		this.prof_principale = prof_principale;

	}
	
	
	public int getIdRdv() {
		return idRdv;
	}
	public void setIdRdv(int idRdv) {
		this.idRdv = idRdv;
	}
	public int getId_prof_principale() {
		return id_prof_principale;
	}
	public void setId_prof_principale(int id_prof_principale) {
		this.id_prof_principale = id_prof_principale;
	}
	public int getIdParent() {
		return idParent;
	}
	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}
	public int getIdHoraire() {
		return idHoraire;
	}
	public void setIdHoraire(int idHoraire) {
		this.idHoraire = idHoraire;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getProf_principale() {
		return prof_principale;
	}
	public void setProf_principale(String prof_principale) {
		this.prof_principale = prof_principale;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	} 
	

}
