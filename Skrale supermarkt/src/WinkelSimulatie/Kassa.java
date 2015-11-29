package WinkelSimulatie;

import java.util.ArrayList;

@SuppressWarnings("all")
public class Kassa 
{

	private Controller controller;

	private Medewerker medewerker;
	
	public Kassa()
	{
		// TODO Auto-generated constructor stub
	}

	public void inhoudWinkelwagen(ArrayList<Product> producten)
	{
		controller.productAfgerekend(producten);
	}

	public void IsUitWinkel(int prodNr, int aantal)
	{

	}

}
