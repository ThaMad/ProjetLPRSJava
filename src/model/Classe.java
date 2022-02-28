package model;

public class Classe {
	
	public String libelle;
	public String prof_principale;
	
	public Classe(String libelle,String prof_principale) {
		this.libelle = libelle;
		this.prof_principale = prof_principale;

		}
	
	public Classe(String libelle) {
		this.libelle = libelle;
		}
	
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getProfPrincipale() {
		return prof_principale;
	}
	public void setIdProfPrincipale(String prof_principale) {
		this.prof_principale = prof_principale;
	}

}
