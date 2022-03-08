package model;

public class Retard {
	public int idRetard, idEleve, idProf;
	public String justificatif, date;
	

	public Retard(int idRetard, int idEleve, int idProf, String justificatif, String date) {
		this.idRetard = idRetard;
		this.idEleve = idEleve;
		this.idProf = idProf;
		this.justificatif = justificatif;
		this.date = date;
	}
	
	public int getIdRetard() {
		return idRetard;
	}
	public void setIdRetard(int idRetard) {
		this.idRetard = idRetard;
	}
	public int getIdEleve() {
		return idEleve;
	}
	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}
	public int getIdProf() {
		return idProf;
	}
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	public String getJustificatif() {
		return justificatif;
	}
	public void setJustificatif(String justificatif) {
		this.justificatif = justificatif;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
