package WinkelSimulatie;

public class Pad
{

	private String naam;

	private Controller controller;

	private InPad inPad;
	
	public Pad()
	{
		inPad = new InPad();
	}

	public boolean requestProduct(int prodNr, int aantal)
	{
		if (inPad.CheckProduct(prodNr, aantal))
		{
			inPad.productGepakt(prodNr, aantal);
			return true;
		} else
		{
			return false;
		} 
	}

	public void vulBij(int prodNr, int aantal)
	{

	}

	public void tisOp(int prodNr) 
	{

	}

}
