package nhl.winkel.personen;

import java.util.TreeMap;

import nhl.winkel.simulatie.Controller;

public class Oudere extends Klant
{
	public Oudere(Controller c, TreeMap<Integer, Integer> prods)
	{
		super(c);
		id = '&';
		boodschappenLijstje = prods;
	}
}
