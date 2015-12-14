package nhl.winkel.personen;

import java.util.List;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.winkel.Product;

public class Student extends Klant
{

	public Student(Controller c, List<Product> prods) 
	{
		super(c);
		id = '#';
		lijstje.addAll(prods);
		// TODO Auto-generated constructor stub
	}

}
