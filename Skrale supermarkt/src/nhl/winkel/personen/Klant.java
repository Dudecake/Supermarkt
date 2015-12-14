package nhl.winkel.personen;

import java.awt.Point;
import java.util.List;
import java.util.Map;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.Main;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.Winkelwagen;

public class Klant extends Persoon
{

	private Winkelwagen winkelwagen;
	private Controller controller;
	
	Map<Product, Integer> boodschappenLijstje;
	
	public Klant(Controller c)
	{
		controller = c;
		location = new Point(13, 0);
		winkelwagen = new Winkelwagen();
	}
	
	public void update()
	{
		Main.getInstance().getWinkel()[location.x][location.y] = id;
		if (boodschappenLijstje.size() == 0) setLocation(new Point(25, 13));
	}

	public void WilProductPakken(int prodNr, int aantal)
	{
		List<Product> prods = controller.PaktProduct(prodNr, aantal, null);
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
