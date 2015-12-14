package nhl.winkel.winkel;

import java.awt.Point;

import nhl.winkel.simulatie.Main;

public class Pad extends Stelling
{
	@SuppressWarnings("unused")
	private InPad inPad;
	
	public Pad(Point loc)
	{
		id = 'P';
		location = loc;
		Main.getInstance().getWinkel()[loc.x - 1][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x + 1][loc.y] = id;
		inPad = new InPad();
	}
}
