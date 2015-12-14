package nhl.winkel.winkel;

public class Product
{
	private String prodNaam;
	private Integer prodNummer;
	
	public Product(String naam, int id)
	{
		prodNaam = naam;
		prodNummer = id;
	}
	
	public boolean checkProduct(Integer prodNr)
	{
		return this.prodNummer == prodNr;
	}
	
	public int getProdNr()
	{
		return prodNummer;
	}
}
