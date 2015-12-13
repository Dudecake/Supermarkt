package nhl.winkel.personen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.Winkelwagen;

public class Klant extends Persoon
{

	private Winkelwagen winkelwagen;
	private Controller controller;
	
	Map<Integer, Integer> boodschappenLijstje;
	
	public Klant(Controller c)
	{
		controller = c;
		winkelwagen = new Winkelwagen();
		boodschappenLijstje = new HashMap<Integer,Integer>();
	}

	public void WilProductPakken(int prodNr, int aantal)
	{
		List<Product> prods = controller.PaktProduct(prodNr, aantal);
		if(prods.size() != 0)
		{
			winkelwagen.pleurInWinkelwagen(prods);
		}
		else 
		{
			//Ren schreeuwend de winkel uit.
		}
	}

}
