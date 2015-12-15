package nhl.winkel.winkel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Winkelwagen
{
	Map<Integer, Integer> inhoud;
	private List<Product> producten;
	
	public Winkelwagen() 
	{
		producten = new ArrayList<>();
		inhoud = new HashMap<Integer,Integer>();
	}
	
	public void pleurInWinkelwagen(List<Product> producten)
	{
		this.producten.addAll(producten);
	}

	public void pleurInWinkelwagen(int prodNr, int aantal) 
	{
		inhoud.put(prodNr, (inhoud.get(prodNr)+aantal));
	}
	
	public List<Product> getInhoud()
	{
		return producten;
	}

	public Map<Integer, Integer> getInhoudWinkelwagen() 
	{
		return inhoud;
	}
}
