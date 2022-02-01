package model;


public class user {
// TODO Auto-generated constructor stub
		protected String nom,prenom,mail,profil, mdp;
		
		// je cree les constructeurs 
		public user(String nom, String prenom, String mail,String mdp,String profil) {
			this.nom=nom;
			this.prenom=prenom;
			this.mdp=mdp;
			this.mail=mail;
			this.profil=profil;		
			
			
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
