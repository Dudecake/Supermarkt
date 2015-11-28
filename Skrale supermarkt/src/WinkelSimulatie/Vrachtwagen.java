package WinkelSimulatie;

import java.util.List;

@SuppressWarnings("all")
public class Vrachtwagen
{

	private Main main;

	private Magazijn magazijn;
	
	private List<Product> producten;
	
	public Vrachtwagen(List<Product> producten) 
	{
		this.producten = producten;
		// TODO Auto-generated constructor stub
	}

	public void Inladen(List prodNr)
	{

	}
	
	public void laadUit()
	{
		magazijn.KomtAan(producten);
	}

}
