package nhl.winkel.personen;

import java.util.TreeMap;

import nhl.winkel.simulatie.Controller;

public class HuisPersoon extends Klant
{
	public HuisPersoon(Controller c, TreeMap<Integer, Integer> prods)
	{
		super(c);
		id = '$';
		boodschappenLijstje = prods;
	}
}
