package WinkelSimulatie;

import java.util.List;

@SuppressWarnings("all")
public class Medewerker
{

	private Afdeling afdeling;

	private Kassa kassa;
	
	private Magazijn magazijn;
	
	public Medewerker()
	{
		// TODO Auto-generated constructor stub
	}

	public void vulProductBij(int prodNr, int aantal, Object locatie)
	{
		List<Product> prods = magazijn.haalProducten(prodNr, aantal);
		if (locatie instanceof Pad)
		{
			((Pad) locatie).vulBij(prods);
		}
		if (locatie instanceof VoordeelPad)
		{
			((VoordeelPad) locatie).vulBij(prods);
		}
		if (locatie instanceof Afdeling)
		{
			((Afdeling) locatie).vulBij(prods);
		}
	}
}
