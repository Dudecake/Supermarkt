package nhl.winkel.winkel;

import java.util.ArrayList;
import java.util.List;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.SimulatieItem;

@SuppressWarnings("all")
public class Magazijn extends SimulatieItem
{

	private Controller controller;

	private Vrachtwagen[] vrachtwagen;

	private InMagazijn[] inMagazijn;
	
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
	
	public void KomtAan(List<Product> producten)
	{
		this.producten.addAll(producten);
		controller.ProductAfgeleverd(producten);
	}

	public void KomtAan(int prodNr, int aantal)
	{

	}

}
