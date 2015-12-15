package nhl.winkel.personen;

import nhl.winkel.simulatie.Main;
import nhl.winkel.simulatie.SimulatieItem;

public class Persoon extends SimulatieItem
{
	public void update()
	{
		Main.getInstance().getWinkel()[location.x][location.y] = id;
	}
}
