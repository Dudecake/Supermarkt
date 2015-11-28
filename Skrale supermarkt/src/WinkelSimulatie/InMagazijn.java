package WinkelSimulatie;

@SuppressWarnings("all")
public class InMagazijn
{

	private Integer aantal;

	private Magazijn magazijn;

	private Product product;
	
	public InMagazijn(Integer aantal, Magazijn magazijn, Product product)
	{
		this.aantal = aantal;
		this.magazijn = magazijn;
		this.product = product;
	}

}
