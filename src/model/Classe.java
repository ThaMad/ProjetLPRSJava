package model;

public class Classe {
	
	public int idClasse;
	public String libelle;
	public int id_prof_principale;
	
	
	public Classe(int idClasse, String libelle, int id_prof_principale) {
		this.idClasse = idClasse;
		this.libelle = libelle;
		this.id_prof_principale = id_prof_principale;
		
	}
	public int getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getIdProfPrincipale() {
		return id_prof_principale;
	}
	public void setIdProfPrincipale(int id_prof_principale) {
		this.id_prof_principale = id_prof_principale;
	}

}
