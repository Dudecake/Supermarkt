package WinkelSimulatie;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class DataLink 
{

	private Main main;
	
	public DataLink() 
	{
		// TODO Auto-generated constructor stub
	}

	public void Mutatie(int prodNr, int aantal) 
	{

	}
	
	public void Mutatie(Product product)
	{
		
	}
	
	public void Mutatie(List<Product> products)
	{
		for (Product p : products) Mutatie(p);
	}

	public void afgerekendeProducten(ArrayList<Product> producten) 
	{

	}

}
