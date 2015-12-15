package nhl.winkel.personen;

import java.util.List;

import nhl.winkel.simulatie.Main;
import nhl.winkel.winkel.Afdeling;
import nhl.winkel.winkel.Magazijn;
import nhl.winkel.winkel.Pad;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.Stelling;
import nhl.winkel.winkel.VoordeelPad;

public class Medewerker extends Persoon
{
	private Magazijn magazijn;
	private boolean bezig;
	
	public Medewerker()
	{
		id = 'M';
		setBezig(false);
		// TODO Auto-generated constructor stub
	}
	
	public void update()
	{
		// insert code here
		
		super.update();
	}

	public void vulProductBij(int prodNr, int aantal, Stelling locatie)
	{
		List<Product> prods = Main.getInstance().getController().getMagazijn().haalProducten(prodNr, aantal);
		if (!prods.isEmpty())
		{
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

	public boolean isBezig()
	{
		return bezig;
	}

	public void setBezig(boolean bezig)
	{
		this.bezig = bezig;
	}
}
