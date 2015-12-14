package nhl.winkel.winkel;

import java.awt.Point;

import nhl.winkel.simulatie.Main;

public class VoordeelPad extends Stelling
{
	@SuppressWarnings("unused")
	private InVoordeelPad inVoordeelPad;
	
	public VoordeelPad(Point loc)
	{
		id = 'V';
		location = loc;
		Main.getInstance().getWinkel()[loc.x - 1][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x + 1][loc.y] = id;
		inVoordeelPad = new InVoordeelPad();
	}
}
