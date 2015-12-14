package nhl.winkel.winkel;

import java.util.Map;

public class InPad
{

	private Pad pad;
	
	Map<Integer, Integer> inhoud;
	
	public InPad()
	{
		// TODO Auto-generated constructor stub
	}

	public void vultBij(int prodNr, int aantal)
	{

	}
	
	public Boolean CheckProduct(int prodNr, int aantal)
	{
		int hoeveel = inhoud.get(prodNr);
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
		int aantalHuidig = inhoud.get(prodNr);
		int resterend = aantalHuidig-aantal;
		inhoud.put(prodNr, resterend);
	}

}
