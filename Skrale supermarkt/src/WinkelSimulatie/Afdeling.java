package WinkelSimulatie;

public class Afdeling 
{

	private String naamAfdeling;

	private Controller controller;

	private Medewerker medewerker;

	private InAfdeling inAfdeling;
	
	public Afdeling() 
	{
		inAfdeling = new InAfdeling();
	}

	public boolean requestProduct(int prodNr, int aantal) 
	{
		if (inAfdeling.CheckProduct(prodNr, aantal))
		{
			inAfdeling.productGepakt(prodNr, aantal);
			return true;
		} else
		{
			return false;
		}
	}

	public void vulBij()
	{

	}

	public void tisOp(int prodNr) 
	{

	}

}
