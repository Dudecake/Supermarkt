package nhl.winkel.simulatie;

import java.awt.Point;
import java.util.concurrent.locks.Lock;

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
		synchronized (this)
		{
			return location;
		}
	}
	
	public void setLocation(int x, int y)
	{
		synchronized (this)
		{
			location = new Point(x, y);
		}
	}
	
	public void setLocation(Point loc)
	{
		synchronized (this)
		{
			location = loc;
		}
	}
}
