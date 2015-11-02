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
		return inPad.CheckProduct(prodNr, aantal);
	}

	public void vulBij(int prodNr, int aantal)
	{

	}

	public void tisOp(int prodNr) 
	{

	}

}
