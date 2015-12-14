package nhl.winkel.winkel;

import java.awt.Point;
import java.util.List;

import nhl.winkel.personen.Medewerker;
import nhl.winkel.simulatie.Main;

public class Afdeling extends Stelling
{

	private Medewerker medewerker;
	private InAfdeling inAfdeling;	
	
	public Afdeling(Point loc)
	{
		id = 'A';
		location = loc;
		Main.getInstance().getWinkel()[loc.x - 1][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x][loc.y] = id;
		Main.getInstance().getWinkel()[loc.x + 1][loc.y] = id;
		inAfdeling = new InAfdeling();
	}

	public List<Product> requestProduct(int prodNr, int aantal)
	{
		return super.requestProduct(prodNr, aantal);
	}

	public void vulBij(Product product, int aantal)
	{
		super.vulBij(product, aantal);
	}

	public void tisOp(int prodNr) 
	{
		super.tisOp(prodNr);
	}
}
