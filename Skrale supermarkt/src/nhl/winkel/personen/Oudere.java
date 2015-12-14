package nhl.winkel.personen;

import java.util.Map;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.winkel.Product;

public class Oudere extends Klant
{
	public Oudere(Controller c, Map<Product, Integer> prods)
	{
		super(c);
		id = '&';
		boodschappenLijstje = prods;
	}
}
