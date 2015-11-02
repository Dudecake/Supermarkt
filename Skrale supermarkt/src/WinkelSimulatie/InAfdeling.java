package WinkelSimulatie;

import java.util.HashMap;
import java.util.Map;

public class InAfdeling
{

	private Afdeling afdeling;
	
	Map<Integer, Float> inhoud;
	
	public InAfdeling() 
	{
		inhoud = new HashMap<Integer, Float>();
	}

	public void vultBij(int prodNr, int aantal)
	{

	}

	public Boolean CheckProduct(int prodNr, int aantal)
	{
		float hoeveel = inhoud.get(prodNr);
		if (hoeveel>aantal)
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	public void productGepakt(int prodNr, int aantal)
	{

	}

}
