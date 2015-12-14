package nhl.winkel.winkel;

import java.awt.Point;
import java.util.ArrayList;

import nhl.winkel.personen.Medewerker;
import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.Main;
import nhl.winkel.simulatie.SimulatieItem;

public class Kassa extends SimulatieItem
{

	private Controller controller;

	private Medewerker medewerker;
	
	public Kassa(Point loc)
	{
		id = 'K';
		location = loc;
		Main.getInstance().getWinkel()[loc.x][loc.y] = id;
	}
	
	public Kassa(int x, int y)
	{
		id = 'K';
		location = new Point(x, y);
		//Main.getInstance().getWinkel()[loc.x][loc.y] = id;
	}

	public void inhoudWinkelwagen(ArrayList<Product> producten)
	{
		controller.productAfgerekend(producten);
	}

	public void IsUitWinkel(int prodNr, int aantal)
	{

	}

}
