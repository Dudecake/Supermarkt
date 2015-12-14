package nhl.winkel.simulatie;

import java.awt.Dimension;
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
	private int winkelGroote = 25;
	private char[][] winkel;
	private Window window = new Window();
	private static Main instance;
	
	public static Main getInstance()
	{
		return instance;
	}
	
	public int getWinkelSize()
	{
		return winkelGroote;
	}
	
	public static void main(String[] args) 
	{
		instance = new Main();
		instance.controller = new Controller();
		instance.dataLink = new DataLink();
		instance.winkel = new char[instance.winkelGroote][instance.winkelGroote];
		for (int i = 0; i < instance.winkelGroote; i++)
		{
			for (int j = 0; j < instance.winkelGroote; j++)
			{
				if ((i == 0 || i == instance.winkelGroote - 1) || (j == 0 || j == instance.winkelGroote - 1))
					instance.winkel[i][j] = '+';
			}
		}
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
