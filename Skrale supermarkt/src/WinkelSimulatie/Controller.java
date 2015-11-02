package WinkelSimulatie;

import java.util.List;
import java.util.Map;

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

	public void ProductAfgeleverd(List<Integer> prodNrs) 
	{

	}

	public boolean PaktProduct(int prodNr, int aantal) 
	{
		boolean uitkomst = false;
		char[] prod = Integer.toString(prodNr).toCharArray();
		if(prod.length > 1)
		{
			switch (prod[1]) 
			{
				case '1':
					uitkomst = afdeling.requestProduct(prodNr, aantal); // tak is compleet, deze haalt ook meteen product uit de schappen
					break;
				case '2':
					uitkomst = pad.requestProduct(prodNr, aantal); // tak is compleet
					break;
				case '3':
					uitkomst = voordeelPad.requestProduct(prodNr, aantal); // tak is compleet
					break;
				default:
					return false;
			}
		}
		return uitkomst;
	}

	public void inhoudWinkel(Map<Integer, Integer> producten) 
	{

	}

}
