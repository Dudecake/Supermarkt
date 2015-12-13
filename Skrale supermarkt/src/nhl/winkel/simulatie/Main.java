package nhl.winkel.simulatie;

import java.nio.charset.spi.CharsetProvider;
import java.util.List;

import nhl.winkel.gui.Window;
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
	private char[][] winkel;
	private Window window = new Window();
	private static Main instance;
	
	public static Main getInstance()
	{
		return instance;
	}
	
	public static void main(String[] args) 
	{
		instance = new Main();
		instance.controller = new Controller();
		instance.dataLink = new DataLink();
		instance.winkel = new char[10][10];
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
	
	public char[][] getWinkel()
	{
		return winkel;
	}

	private void NieuweKlant()
	{
		
	}
}
