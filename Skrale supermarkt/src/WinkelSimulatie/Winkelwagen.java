package WinkelSimulatie;

import java.util.Map;
import java.util.HashMap;

public class Winkelwagen
{
	
	Map<Integer, Integer> inhoud;
	
	public Winkelwagen() 
	{
		inhoud = new HashMap<Integer,Integer>();
	}

	public void pleurInWinkelwagen(int prodNr, int aantal) 
	{
		inhoud.put(prodNr, aantal);
	}

	public Map<Integer, Integer> getInhoudWinkelwagen() 
	{
		return inhoud;
	}

}
