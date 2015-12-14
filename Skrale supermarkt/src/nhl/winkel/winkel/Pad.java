package nhl.winkel.winkel;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.Main;
import nhl.winkel.simulatie.SimulatieItem;

public class Pad extends SimulatieItem
{

	private String naam;

	private Controller controller;

	private InPad inPad;
	
	private List<Product> producten;
	
	public Pad(Point loc)
	{
		id = 'P';
		location = loc;
		Main.getInstance().getWinkel()[loc.x - 1][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x + 1][loc.y] = id;
		inPad = new InPad();
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
		/*if (inPad.CheckProduct(prodNr, aantal))
		{
			inPad.productGepakt(prodNr, aantal);
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

	public void vulBij(int prodNr, int aantal)
	{
		
	}

	public void tisOp(int prodNr) 
	{

	}

}