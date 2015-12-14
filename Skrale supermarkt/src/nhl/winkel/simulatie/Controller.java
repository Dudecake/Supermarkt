package nhl.winkel.simulatie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nhl.winkel.winkel.Afdeling;
import nhl.winkel.winkel.Kassa;
import nhl.winkel.winkel.Magazijn;
import nhl.winkel.winkel.Pad;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.VoordeelPad;

public class Controller 
{

	private Afdeling afdeling;

	private Pad pad;

	private Kassa kassa;

	private VoordeelPad voordeelPad;

	private Magazijn magazijn;

	private Main main;
	
	public Controller() 
	{
		
	}

	public void tisOp(int prodNr)
	{
		main.ProductOp(prodNr);
	}
	
	public void vulBij(int prodNr, int aantal, Object locatie)
	{
		
	}

	public void ProductAfgeleverd(List<Product> prods) 
	{
		main.Aangevuld(prods);
	}
	
	public void productAfgerekend(List<Product> prods)
	{
		main.afgerekend(prods);
	}

	public List<Product> PaktProduct(int prodNr, int aantal)
	{
		boolean uitkomst = false;
		List<Product> res = new ArrayList<>();
		char[] prod = Integer.toString(prodNr).toCharArray();
		if(prod.length > 1)
		{
			switch (prod[1]) 
			{
				case '1':
					res = afdeling.requestProduct(prodNr, aantal);
					//uitkomst = afdeling.requestProduct(prodNr, aantal); // tak is compleet, deze haalt ook meteen product uit de schappen
					break;
				case '2':
					res = afdeling.requestProduct(prodNr, aantal);
					//uitkomst = pad.requestProduct(prodNr, aantal); // tak is compleet
					break;
				case '3':
					res = afdeling.requestProduct(prodNr, aantal);
					//uitkomst = voordeelPad.requestProduct(prodNr, aantal); // tak is compleet
					break;
				default:
					break;
			}
		}
		return res;
	}

	public void inhoudWinkel(Map<Integer, Integer> producten) 
	{

	}

}
