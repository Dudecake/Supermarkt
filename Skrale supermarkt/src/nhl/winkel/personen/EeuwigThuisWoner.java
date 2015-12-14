package nhl.winkel.personen;

import java.util.Map;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.winkel.Product;

public class EeuwigThuisWoner extends Klant 
{

	public EeuwigThuisWoner(Controller c, Map<Product, Integer> prods)
	{
		super(c);
		id = '@';
		boodschappenLijstje = prods;
	}

}
