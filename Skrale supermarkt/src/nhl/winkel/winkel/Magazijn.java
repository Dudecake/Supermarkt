package nhl.winkel.winkel;

import java.util.ArrayList;
import java.util.List;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.SimulatieItem;

public class Magazijn extends SimulatieItem
{
	@SuppressWarnings("unused")
	private Controller controller;
	@SuppressWarnings("unused")
	private Vrachtwagen[] vrachtwagen;
	
	private List<Product> producten;
	
	public Magazijn()
	{
		this.producten = new ArrayList<>();
	}

	public void Uitladen(ArrayList<Integer> prodNrs)
	{

	}

	public boolean voorraadCheck(int ProdNr, int aantal)
	{
		int count = 0;
		for (Product p : producten)
		{
			if (p.checkProduct(ProdNr)) count++;
		}
		return count == aantal;
	}

	public List<Product> haalProducten(int prodNr, int aantal)
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
	}
	
	public void KomtAan(Product product, int aantal)
	{
		for (int i = 0; i < aantal; i++)
		{
			this.producten.add(product);
		}
	}

}
