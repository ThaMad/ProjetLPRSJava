package model;

public class DemandeStockFournisseur {
		public int idFourni,idUser,nbrStock,valide,idStock;

		//public static Stock getInstance() {
			//if (stck == null) {
	            //stck = new Stock();
	        //}
	       // return stck;
	    //}
		
		//public static Stock getInstance1( String libelle, int nbrStock) {
			//if (stck == null) {
	           // stck = new Stock(libelle, nbrStock);
	        //}
	       // return stck;
	   // }
		
		// je cree les constructeurs 
		
		public DemandeStockFournisseur(int idFourni,int idUser,int nbrStock, int idStock) {
			this.idFourni= idFourni;
			this.idUser= idUser;
			this.nbrStock= nbrStock;
			this.idStock= idStock;

		}
		
		public int getIdFourni() {
			return idFourni;
		}

		public void setIdFourni(int idFourni) {
			this.idFourni = idFourni;
		}

		public int getIdUser() {
			return idUser;
		}

		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}

		public int getValide() {
			return valide;
		}

		public void setValide(int valide) {
			this.valide = valide;
		}

		public int getIdStock() {
			return idStock;
		}

		public void setIdStock(int idStock) {
			this.idStock = idStock;
		}

		
		public int getNbrStock() {
			return this.nbrStock;
		}
		
		
		public void setNbrStock(int nbrStock) {
			this.nbrStock=nbrStock;
		}

}
