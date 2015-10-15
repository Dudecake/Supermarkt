package WinkelSimulatie;

import java.util.HashMap;
import java.util.Map;

public class Klant
{

	private Winkelwagen winkelwagen = new Winkelwagen();
	private Controller controller;
	
	Map<Integer, Integer> boodschappenLijstje = new HashMap<Integer, Integer>();
	
	public Klant(Controller c)
	{
		controller = c;
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
