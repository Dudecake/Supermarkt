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
		if (inVoordeelPad.CheckProduct(prodNr, aantal))
		{
			inVoordeelPad.productGepakt(prodNr, aantal);
			return true;
		} else
		{
			return false;
		} 
	}

	public void VulBij()
	{

	}

	public void tisOp(int prodNr) 
	{

	}

}
