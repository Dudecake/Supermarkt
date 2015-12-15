package nhl.winkel.winkel;

import java.awt.Point;

import nhl.winkel.personen.Medewerker;
import nhl.winkel.simulatie.Main;

public class Afdeling extends Stelling
{
	private Medewerker medewerker;
	
	public Afdeling(Point loc)
	{
		id = 'A';
		location = loc;
		Main.getInstance().getWinkel()[loc.x - 1][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x + 1][loc.y] = id;
	}
	
	public void addMedewerker(Medewerker med)
	{
		if (medewerker == null)
		{
			medewerker = med;
			medewerker.setLocation(location);
			medewerker.setBezig(true);
		}
	}
	
	public Medewerker getMedewerker()
	{
		Medewerker res = medewerker;
		medewerker = null;
		res.setBezig(false);
		return res;
	}
}
