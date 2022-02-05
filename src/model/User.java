package model;

public class User {
// TODO Auto-generated constructor stub
		public String nom,prenom,mail,profil, mdp;
		private static User usr;
		
		public static User getInstance(String nom, String prenom, String mail,String mdp,String profil) {
	        if (usr == null) {
	            usr = new User(nom,prenom,mail,mdp,profil);
	        }
	        return usr;
	    }
		
		public static User getInstance2(String mail,String mdp) {
	        if (usr == null) {
	            usr = new User(mail, mdp);
	        }
	        return usr;
	    }
		
		// je cree les constructeurs 
		private User(String nom, String prenom, String mail,String mdp,String profil) {
			this.nom=nom;
			this.prenom=prenom;
			this.mdp=mdp;
			this.mail=mail;
			this.profil=profil;			
		}
		
		private User(String mail,String mdp) {
			this.mdp=mdp;
			this.mail=mail;
		}
		
		// je fais les geteurs et les seteur pour recuperer ou modifier les valeurs de mes attributs
		public String getNom() {
			return this.nom;
		}
		
		public String getPrenom() {
			return this.prenom;
		}
		
		public String getMail() {
			return this.mail;
		}
		
		public String getMdp() {
			return this.mdp;
		}
		
		public String getProfil() {
			return this.profil;
		}
		
		public void setNom(String nom) {
			this.nom=nom;
		}
		
		public void setPrenom(String prenom) {
			this.prenom=prenom;
		}
		
		public void setMail(String mail) {
			this.mail=mail;
		}
		
		public void setMdp(String mdp) {
			this.mdp = mdp;
		}
		
		public void setProfil(String profil) {
			this.profil = profil;
		}
}
