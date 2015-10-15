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

	public void tisOp(int prodNr) 
	{
		main.ProductOp(prodNr);
	}

	public void ProductAfgeleverd(List<Integer> prodNrs) 
	{

	}

	public Boolean PaktProduct(int prodNr, int aantal) 
	{
		boolean uitkomst = false;
		char[] prod = Integer.toString(prodNr).toCharArray();
		if(prod.length > 1)
		{
			switch (prod[1]) {
			case '1':
				uitkomst = afdeling.requestProduct(prodNr, aantal);
				break;
			case '2':
				uitkomst = pad.requestProduct(prodNr, aantal);
				break;
			case '3':
				uitkomst = voordeelPad.requestProduct(prodNr, aantal);
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
