package nhl.winkel.personen;

import java.util.Map;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.winkel.Product;

public class Student extends Klant
{

	public Student(Controller c, Map<Product, Integer> prods) 
	{
		super(c);
		id = '#';
		boodschappenLijstje = prods;
	}

}
