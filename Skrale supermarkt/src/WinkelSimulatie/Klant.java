package WinkelSimulatie;

import java.util.HashMap;
import java.util.Map;

public class Klant
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
		if(controller.PaktProduct(prodNr, aantal))
		{
			winkelwagen.pleurInWinkelwagen(prodNr, aantal);
		}
		else 
		{
			//Ren schreeuwend de winkel uit.
		}
	}

}
