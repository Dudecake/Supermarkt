package WinkelSimulatie;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Afdeling 
{

	private String naamAfdeling;

	private Controller controller;

	private Medewerker medewerker;

	private InAfdeling inAfdeling;
	
	private List<Product> producten;
	
	public Afdeling() 
	{
		producten = new ArrayList<>();
		inAfdeling = new InAfdeling();
	}

	public List<Product> requestProduct(int prodNr, int aantal) 
	{
		int count = 0;
		List<Product> res = new ArrayList<>();
		for (int i = 0; i < producten.size(); i++)
		{
			if (producten.get(i).checkProduct(prodNr))
			{
				res.add(producten.get(i));
				producten.remove(i);
				count++; i--;
			}
			if (count == prodNr) break;
		}
		return res;
		/*if (inAfdeling.CheckProduct(prodNr, aantal))
		{
			inAfdeling.productGepakt(prodNr, aantal);
			return true;
		} else
		{
			return false;
		}*/
	}

	public void vulBij(List<Product> producten)
	{
		this.producten.addAll(producten);
	}

	public void tisOp(int prodNr) 
	{
		controller.tisOp(prodNr);
	}

}
