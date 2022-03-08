package model;

public class Absence {
	
	public int idAbsence, id_eleve, id_prof;
	public String libelle, justificatif, dateD, dateF;
	
	
	public Absence(int idAbsence, int id_eleve, int id_prof, String libelle, String justificatif, String dateD, String dateF) {
		
		this.idAbsence = idAbsence;
		this.id_eleve = id_eleve;
		this.id_prof=id_prof;
		this.libelle=libelle;
		this.justificatif=justificatif;
		this.dateD=dateD;
		this.dateF=dateF;
	}
	
	public int getIdAbsence() {
		return idAbsence;
	}
	public void setIdAbsence(int idAbsence) {
		this.idAbsence = idAbsence;
	}
	public int getId_eleve() {
		return id_eleve;
	}
	public void setId_eleve(int id_eleve) {
		this.id_eleve = id_eleve;
	}
	public int getId_prof() {
		return id_prof;
	}
	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getJustificatif() {
		return justificatif;
	}
	public void setJustificatif(String justificatif) {
		this.justificatif = justificatif;
	}
	public String getDateD() {
		return dateD;
	}
	public void setDateD(String dateD) {
		this.dateD = dateD;
	}
	public String getDateF() {
		return dateF;
	}
	public void setDateF(String dateF) {
		this.dateF = dateF;
	}

}
