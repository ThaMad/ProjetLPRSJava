package model;

public class Eleve {
	public int idEleve, classeint;
	
	public String nom, prenom, classe;
	
	public Eleve(int idEleve,String nom,String prenom) {
		this.idEleve=idEleve;
		this.nom=nom;
		this.prenom=prenom;
		
		}
	

	public Eleve(String nom,String prenom, String classe) {
		this.nom=nom;
		this.prenom=prenom;
		this.classe = classe;
		}
	
	public Eleve(String nom) {
		this.nom=nom;
		}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}


	public int getIdEleve() {
		return idEleve;
	}
	
	public void setIdEleve(int idEleve) {
		this.idEleve=idEleve;
	}

}
