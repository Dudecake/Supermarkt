package nhl.winkel.simulatie;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nhl.winkel.winkel.Afdeling;
import nhl.winkel.winkel.Kassa;
import nhl.winkel.winkel.Magazijn;
import nhl.winkel.winkel.Pad;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.VoordeelPad;

public class Controller 
{

	private Afdeling[] afdeling;

	private Pad[] pad;

	private Kassa[] kassas;

	private VoordeelPad voordeelPad;

	private Magazijn magazijn;

	private Main main;
	
	public Controller() 
	{
		main = Main.getInstance();
		pad = new Pad[] { new Pad(new Point(2, 4)), new Pad(new Point(2, 8)), new Pad(new Point(2, 12)), new Pad(new Point(2, 16))};
		kassas = new Kassa[] { new Kassa(new Point(3, 22)), new Kassa(new Point(6, 22)), new Kassa(new Point(9, 22)), new Kassa(new Point(12, 22)), new Kassa(new Point(15, 22))};
		afdeling = new Afdeling[] { new Afdeling(new Point(9, 5)), new Afdeling(new Point(9, 10))};
		voordeelPad = new VoordeelPad(new Point(9, 15));
		magazijn = new Magazijn();
		initProducten();
	}

	public void tisOp(int prodNr)
	{
		main.ProductOp(prodNr);
	}
	
	public void vulBij(int prodNr, int aantal, Object locatie)
	{
		
	}

	public void ProductAfgeleverd(List<Product> prods) 
	{
		main.Aangevuld(prods);
	}
	
	public void productAfgerekend(List<Product> prods)
	{
		main.afgerekend(prods);
	}

	public List<Product> PaktProduct(int prodNr, int aantal, Object locatie)
	{
		List<Product> res = new ArrayList<>();
		char[] prod = Integer.toString(prodNr).toCharArray();
		if(prod.length > 1)
		{
			switch (prod[0]) 
			{
				case '1':
					res = ((Pad) locatie).requestProduct(prodNr, aantal);
					break;
				case '2':
					res = ((Afdeling) locatie).requestProduct(prodNr, aantal);
				default:
					break;
			}
		}
		return res;
	}

	public void inhoudWinkel(Map<Integer, Integer> producten) 
	{

	}

	private void initProducten()
	{
		main.producten = new Product[] {
					new Product("kaas",101), new Product("melk",102), 
					new Product("chocoladepasta",111), new Product("sperziebonen",112), 
					new Product("pasta",121), new Product("appeltaart",122), 
					new Product("chips",131), new Product("nootjes",132), 
					new Product("Ham",201), 
					new Product("bolletjes",202)};
		pad[0].vulBij(main.producten[0], 20);
		pad[0].vulBij(main.producten[1], 20);
		pad[1].vulBij(main.producten[2], 20);
		pad[1].vulBij(main.producten[3], 20);
		pad[2].vulBij(main.producten[4], 20);
		pad[2].vulBij(main.producten[5], 20);
		pad[3].vulBij(main.producten[6], 20);
		pad[3].vulBij(main.producten[7], 20);
		afdeling[0].vulBij(main.producten[8], 20);
		afdeling[1].vulBij(main.producten[9], 20);
		voordeelPad.vulBij(main.producten[9], 20);
		voordeelPad.vulBij(main.producten[2], 20);
		for (int i = 0; i < 10; i++)
		{
			magazijn.KomtAan(main.producten[i], 50);
		}
	}
}
