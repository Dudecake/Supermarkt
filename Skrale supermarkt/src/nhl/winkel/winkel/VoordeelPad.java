package nhl.winkel.winkel;

import java.util.ArrayList;
import java.util.List;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.SimulatieItem;

@SuppressWarnings("all")
public class VoordeelPad extends SimulatieItem
{

	private Controller controller;

	private InVoordeelPad inVoordeelPad;
	
	private List<Product> producten;
	
	public VoordeelPad()
	{
		producten = new ArrayList<>();
		inVoordeelPad = new InVoordeelPad();
	}

	public List<Product> requestProduct(int prodNr, int aantal)
	{
		int count = 0;
		List<Product> res = new ArrayList<>();
		for (int i = 0; i < producten.size(); i++)
		{
			if (producten.get(i).checkProduct(prodNr))
			{
				res.add(producten.get(i));
				producten.remove(i);
				count++; i--;
			}
			if (count == prodNr) break;
		}
		return res;
		/*if (inVoordeelPad.CheckProduct(prodNr, aantal))
		{
			inVoordeelPad.productGepakt(prodNr, aantal);
			return true;
		} else
		{
			return false;
		}*/
	}

	public void vulBij(List<Product> producten)
	{
		this.producten.addAll(producten);
	}

	public void tisOp(int prodNr) 
	{
		controller.tisOp(prodNr);
	}

}
