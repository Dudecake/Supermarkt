package nhl.winkel.simulatie;

import java.util.List;

import nhl.winkel.personen.Klant;
import nhl.winkel.simulatie.DataLink.Mutatie;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.Vrachtwagen;

@SuppressWarnings("all")
public class Main 
{

	private Klant[] klant;

	private Vrachtwagen[] vrachtwagen;

	private Controller controller;

	private DataLink dataLink;
	
	public static void main(String[] args) 
	{
		Main p = new Main();
		p.controller = new Controller();
		p.dataLink = new DataLink();
	}

	public void ProductOp(Integer prodNr) 
	{

	}
	
	public void afgerekend(List<Product> prods)
	{
		dataLink.Mutatie(prods, Mutatie.AF);
	}

	public void Aangevuld(List<Product> prods)
	{
		dataLink.Mutatie(prods, Mutatie.BIJ);
	}

	private void NieuweKlant()
	{
		
	}
}
