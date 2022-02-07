package model;

public class Stock {
	public String libelle;
	public int nbrStock;
	private static Stock stck;
	
	public static Stock getInstance() {
		if (stck == null) {
            stck = new Stock();
        }
        return stck;
    }
	
	public static Stock getInstance1( String libelle, int nbrStock) {
		if (stck == null) {
            stck = new Stock(libelle, nbrStock);
        }
        return stck;
    }
	
	// je cree les constructeurs 
	
	private Stock(String libelle,int nbrStock) {
		this.libelle=libelle;
		this.nbrStock= nbrStock;
	}
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public String getLibelle() {
		return this.libelle;
	}
	
	public int getNbrStock() {
		return this.nbrStock;
	}
	
	public void setLibelle(String libelle) {
		this.libelle=libelle;
	}
	
	public void setNbrStock(int nbrStock) {
		this.nbrStock=nbrStock;
	}
}
