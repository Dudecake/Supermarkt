package nhl.winkel.personen;

import java.util.TreeMap;

import nhl.winkel.simulatie.Controller;

public class Student extends Klant
{
	public Student(Controller c, TreeMap<Integer, Integer> prods) 
	{
		super(c);
		id = '#';
		boodschappenLijstje = prods;
	}
}
