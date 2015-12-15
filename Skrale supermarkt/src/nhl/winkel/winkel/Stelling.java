package nhl.winkel.winkel;

import java.util.ArrayList;
import java.util.List;

import nhl.winkel.simulatie.Main;
import nhl.winkel.simulatie.SimulatieItem;

public class Stelling extends SimulatieItem
{
	protected List<Product> producten;
	
	protected Stelling()
	{
		producten = new ArrayList<>();
	}
	
	public List<Product> getProducten()
	{
		return producten;
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
			if (count == aantal) break;
		}
		if (!isGenoeg(prodNr))
		{
			tisOp(prodNr, this);
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
	
	private boolean isGenoeg(int prodNr)
	{
		int i = 0;
		for (Product product : producten)
		{
			if (product.getProdNr() == prodNr)
			{
				i++;
				if (i == 5) return true;
			}
		}
		return false;
	}

	public void vulBij(Product product, int aantal)
	{
		for (int i = 0; i < aantal; i++)
		{
			producten.add(product);
		}
	}

	public void tisOp(int prodNr, Stelling stel)
	{
		Main.getInstance().getController().tisOp(prodNr, stel);
	}
}
