package model;

public class Sanction {
	public int idSanction, idType, idEleve, idProf;
	public String commentaire, date;
	
	
	
	public Sanction(int idSanction, int idType, int idEleve, int idProf, String commentaire, String date) {
		
		this.idSanction=idSanction;
		this.idType=idType;
		this.idEleve=idEleve;
		this.idProf=idProf;
		this.commentaire=commentaire;
		this.date=date;
	}
	public int getIdSanction() {
		return idSanction;
	}
	public void setIdSanction(int idSanction) {
		this.idSanction = idSanction;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
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
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
