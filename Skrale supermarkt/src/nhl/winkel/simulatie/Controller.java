package nhl.winkel.simulatie;

import java.awt.Point;
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

	private Afdeling[] afdeling;

	private Pad[] pad;

	private Kassa[] kassas;

	private VoordeelPad voordeelPad;

	private Magazijn magazijn;

	private Main main;
	
	public Controller() 
	{
		pad = new Pad[] { new Pad(new Point(2, 5)), new Pad(new Point(2, 10)), new Pad(new Point(2, 15)), new Pad(new Point(2, 20))};
		kassas = new Kassa[] { new Kassa(new Point(4, 22)), new Kassa(new Point(8, 22)), new Kassa(new Point(12, 22)), new Kassa(new Point(16, 22)), new Kassa(new Point(20, 22))};
		afdeling = new Afdeling[] { new Afdeling(new Point(10, 5)), new Afdeling(new Point(10, 10))};
		voordeelPad = new VoordeelPad(new Point(10, 15));
		magazijn = new Magazijn();
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

	public List<Product> PaktProduct(int prodNr, int aantal, Afdeling afdeling)
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
