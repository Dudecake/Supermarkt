package nhl.winkel.personen;

import java.util.TreeMap;

import nhl.winkel.simulatie.Controller;

public class EeuwigThuisWoner extends Klant 
{
	public EeuwigThuisWoner(Controller c, TreeMap<Integer, Integer> prods)
	{
		super(c);
		id = '@';
		boodschappenLijstje = prods;
	}
}
