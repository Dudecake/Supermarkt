package WinkelSimulatie;

public class VoordeelPad
{

	private Controller controller;

	private InVoordeelPad inVoordeelPad;
	
	public VoordeelPad()
	{
		inVoordeelPad = new InVoordeelPad();
	}

	public boolean requestProduct(int prodNr, int aantal)
	{
		return inVoordeelPad.CheckProduct(prodNr, aantal);
	}

	public void VulBij()
	{

	}

	public void tisOp(int prodNr) 
	{

	}

}
