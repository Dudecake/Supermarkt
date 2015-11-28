package WinkelSimulatie;

@SuppressWarnings("all")
public class Product
{

	private Integer prodNummer;

	private InMagazijn inMagazijn;

	private InVoordeelPad inVoordeelPad;

	private InPad inPad;

	private InAfdeling inAfdeling;
	
	public Product()
	{
		// TODO Auto-generated constructor stub
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
