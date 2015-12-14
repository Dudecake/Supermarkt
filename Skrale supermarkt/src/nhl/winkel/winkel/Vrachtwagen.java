package nhl.winkel.winkel;

import java.util.List;

import nhl.winkel.simulatie.Main;
import nhl.winkel.simulatie.SimulatieItem;

public class Vrachtwagen extends SimulatieItem
{

	private Main main;

	private Magazijn magazijn;
	
	private List<Product> producten;
	
	public Vrachtwagen(List<Product> producten) 
	{
		id = 'W';
		this.producten = producten;
		// TODO Auto-generated constructor stub
	}

	public void Inladen(List prodNr)
	{

	}
	
	public void laadUit()
	{
		magazijn.KomtAan(producten);
		producten.clear();
	}

}
