package WinkelSimulatie;

public class Afdeling 
{

	private String naamAfdeling;

	private Controller controller;

	private Medewerker medewerker;

	private InAfdeling inAfdeling;

	public boolean requestProduct(int prodNr, int aantal) 
	{
		return inAfdeling.CheckProduct(prodNr, aantal);
	}

	public void vulBij()
	{

	}

	public void tisOp(int prodNr) 
	{

	}

}
