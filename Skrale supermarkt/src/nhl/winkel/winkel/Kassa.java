package nhl.winkel.winkel;

import java.util.ArrayList;

import nhl.winkel.personen.Medewerker;
import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.SimulatieItem;

@SuppressWarnings("all")
public class Kassa extends SimulatieItem
{

	private Controller controller;

	private Medewerker medewerker;
	
	public Kassa()
	{
		// TODO Auto-generated constructor stub
	}

	public void inhoudWinkelwagen(ArrayList<Product> producten)
	{
		controller.productAfgerekend(producten);
	}

	public void IsUitWinkel(int prodNr, int aantal)
	{

	}

}
