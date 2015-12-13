package nhl.winkel.simulatie;

import java.awt.Point;

public class SimulatieItem
{
	protected Point location;
	protected char id;
	
	protected SimulatieItem()
	{
		location = new Point();
	}
	
	protected SimulatieItem(int x, int y)
	{
		location = new Point(x, y);
	}
	
	public Point getLocation()
	{
		return location;
	}
	
	public void setLocation(int x, int y)
	{
		location = new Point(x, y);
	}
	
	public void setLocation(Point loc)
	{
		location = loc;
	}
}
