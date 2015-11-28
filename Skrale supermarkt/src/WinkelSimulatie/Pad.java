package WinkelSimulatie;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Pad
{

	private String naam;

	private Controller controller;

	private InPad inPad;
	
	private List<Product> producten;
	
	public Pad()
	{
		inPad = new InPad();
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
		/*if (inPad.CheckProduct(prodNr, aantal))
		{
			inPad.productGepakt(prodNr, aantal);
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

	public void vulBij(int prodNr, int aantal)
	{
		
	}

	public void tisOp(int prodNr) 
	{

	}

}
