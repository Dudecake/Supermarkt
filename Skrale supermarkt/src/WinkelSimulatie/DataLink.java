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
	
	public enum Mutatie
	{
		AF (false),
		BIJ (true);
		
		private final boolean value;
		private Mutatie(boolean value)
		{
			this.value = value;
		}
		
		public boolean value()
		{
			return value;
		}
	}

	public void Mutatie(int prodNr, int aantal) 
	{

	}
	
	public void Mutatie(Product product, Mutatie mut)
	{
		if (mut.value()) // product binnen
		{
			
		}
		else // product afgerekend
		{
			
		}
	}
	
	public void Mutatie(List<Product> products, Mutatie mut)
	{
		for (Product p : products) Mutatie(p, mut);
	}

	public void afgerekendeProducten(ArrayList<Product> producten) 
	{

	}
}
