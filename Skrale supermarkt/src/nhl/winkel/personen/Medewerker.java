package nhl.winkel.personen;

import java.util.List;

import nhl.winkel.winkel.Afdeling;
import nhl.winkel.winkel.Kassa;
import nhl.winkel.winkel.Magazijn;
import nhl.winkel.winkel.Pad;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.VoordeelPad;

public class Medewerker extends Persoon
{
	private Afdeling afdeling;
	private Kassa kassa;	
	private Magazijn magazijn;
	
	public Medewerker()
	{
		id = 'M';
		// TODO Auto-generated constructor stub
	}

	public void vulProductBij(int prodNr, int aantal, Object locatie)
	{
		List<Product> prods = magazijn.haalProducten(prodNr, aantal);
		if (locatie instanceof Pad)
		{
			((Pad) locatie).vulBij(prods.get(0),prods.size());
		}
		if (locatie instanceof VoordeelPad)
		{
			((VoordeelPad) locatie).vulBij(prods.get(0),prods.size());
		}
		if (locatie instanceof Afdeling)
		{
			((Afdeling) locatie).vulBij(prods.get(0),prods.size());
		}
	}
}
