package nhl.winkel.winkel;

import java.util.ArrayList;
import java.util.List;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.SimulatieItem;

public class Stelling extends SimulatieItem
{
	protected Controller controller;
	protected List<Product> producten;
	
	protected Stelling()
	{
		producten = new ArrayList<>();
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

	public void vulBij(Product product, int aantal)
	{

		for (int i = 0; i < aantal; i++)
		{
			producten.add(product);
		}
	}

	public void tisOp(int prodNr)
	{
		controller.tisOp(prodNr);
	}
}
