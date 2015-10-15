package WinkelSimulatie;

import java.util.HashMap;
import java.util.Map;

public class InAfdeling
{

	private Integer aantal;

	private Afdeling afdeling;

	private Product product;
	
	Map<Integer, Float> inhoud;
	
	public InAfdeling(Afdeling a) 
	{
		afdeling = a;
		inhoud = new HashMap<Integer, Float>();
	}

	public void vultBij(int prodNr, int aantal)
	{

	}

	public Boolean CheckProduct(int prodNr, int aantal)
	{
		float hoeveel = inhoud.get(prodNr);
		return false;
	}
	
	public void productGepakt(int prodNr, int aantal)
	{

	}

}
