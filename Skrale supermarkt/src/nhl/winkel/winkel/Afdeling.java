package nhl.winkel.winkel;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import nhl.winkel.personen.Medewerker;
import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.Main;
import nhl.winkel.simulatie.SimulatieItem;

public class Afdeling extends SimulatieItem
{

	private String naamAfdeling;

	private Controller controller;

	private Medewerker medewerker;

	private InAfdeling inAfdeling;
	
	private List<Product> producten;
	
	public Afdeling(Point loc)
	{
		id = 'A';
		location = loc;
		producten = new ArrayList<>();
		Main.getInstance().getWinkel()[loc.x - 1][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x + 1][loc.y] = id;
		inAfdeling = new InAfdeling();
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
		/*if (inAfdeling.CheckProduct(prodNr, aantal))
		{
			inAfdeling.productGepakt(prodNr, aantal);
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
