package nhl.winkel.winkel;

import java.awt.Point;
import java.util.List;

import nhl.winkel.personen.Medewerker;
import nhl.winkel.simulatie.Main;
import nhl.winkel.simulatie.SimulatieItem;

public class Kassa extends SimulatieItem
{
	private Medewerker medewerker;
	
	public Kassa(Point loc)
	{
		id = 'K';
		location = loc;
		Main.getInstance().getWinkel()[loc.x][loc.y - 1] = id;
		Main.getInstance().getWinkel()[loc.x][loc.y] = id;
	}
	
	public Kassa(int x, int y)
	{
		id = 'K';
		location = new Point(x, y);
		Main.getInstance().getWinkel()[x][y - 1] = id;
		Main.getInstance().getWinkel()[x][y] = id;
	}
	
	public Kassa(Point loc, Medewerker med)
	{
		id = 'K';
		location = loc;
		medewerker = med;
		medewerker.setLocation(location);
		Main.getInstance().getWinkel()[loc.x][loc.y - 1] = id;
		Main.getInstance().getWinkel()[loc.x][loc.y] = id;
		Main.getInstance().addKassa(this);
	}
	
	public Kassa(int x, int y, Medewerker med)
	{
		id = 'K';
		location = new Point(x, y);
		medewerker = med;
		medewerker.setLocation(location);
		Main.getInstance().getWinkel()[x][y - 1] = id;
		Main.getInstance().getWinkel()[x][y] = id;
		Main.getInstance().addKassa(this);
	}
	
	public void setMedewerker(Medewerker med)
	{
		medewerker = med;
		medewerker.setLocation(location);
		Main.getInstance().addKassa(this);
	}
	
	public Medewerker getMedewerker()
	{
		Medewerker res = medewerker;
		medewerker = null;
		Main.getInstance().removeKassa(this);
		return res;
	}

	public void inhoudWinkelwagen(List<Product> list)
	{
		Main.getInstance().getController().productAfgerekend(list);
		Main.getInstance().addKassa(this);
	}

	public void IsUitWinkel(int prodNr, int aantal)
	{

	}

}
