package nhl.winkel.simulatie;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nhl.winkel.personen.Medewerker;
import nhl.winkel.winkel.Afdeling;
import nhl.winkel.winkel.Kassa;
import nhl.winkel.winkel.Magazijn;
import nhl.winkel.winkel.Pad;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.Stelling;
import nhl.winkel.winkel.VoordeelPad;

public class Controller 
{
	private Afdeling[] afdeling;
	private Pad[] pad;
	private Kassa[] kassas;
	private VoordeelPad voordeelPad;
	private Medewerker[] medewerkers;
	private Magazijn magazijn;
	
	public Controller() 
	{
		pad = new Pad[] { new Pad(new Point(2, 4)), new Pad(new Point(2, 8)), new Pad(new Point(2, 12)), new Pad(new Point(2, 16))};
		kassas = new Kassa[] { new Kassa(new Point(3, 22)), new Kassa(new Point(6, 22)), new Kassa(new Point(9, 22)), new Kassa(new Point(12, 22)), new Kassa(new Point(15, 22))};
		afdeling = new Afdeling[] { new Afdeling(new Point(9, 5)), new Afdeling(new Point(9, 10))};
		voordeelPad = new VoordeelPad(new Point(9, 15));
		magazijn = new Magazijn();
		initMedewerkers(6);
		initProducten();
	}
	
	public Afdeling[] getAfdeling()
	{
		return afdeling;
	}

	public Pad[] getPad()
	{
		return pad;
	}

	public VoordeelPad getVoordeelPad()
	{
		return voordeelPad;
	}
	
	public Magazijn getMagazijn()
	{
		return magazijn;
	}
	
	public void updateMedewerkers()
	{
		for (Medewerker med : medewerkers)
		{
			med.update();
		}
	}

	public void tisOp(int prodNr, Stelling stel)
	{
		for (Medewerker medewerker : medewerkers)
		{
			if (!medewerker.isBezig())
			{
				medewerker.vulProductBij(prodNr, 20, stel);
			}
		}
	}
	
	public void vulBij(int prodNr, int aantal, Object locatie)
	{
		
	}

	public void ProductAfgeleverd(List<Product> prods) 
	{
		Main.getInstance().Aangevuld(prods);
	}
	
	public void productAfgerekend(List<Product> prods)
	{
		Main.getInstance().afgerekend(prods);
	}

	public List<Product> PaktProduct(int prodNr, int aantal, Stelling locatie)
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
	
	private void initMedewerkers(int maxAantal)
	{
		medewerkers = new Medewerker[maxAantal];
		for (int i = 0; i < maxAantal; i++)
		{
			medewerkers[i] = new Medewerker();
		}
		afdeling[0].addMedewerker(medewerkers[0]);
		afdeling[1].addMedewerker(medewerkers[1]);
		kassas[0].setMedewerker(medewerkers[2]);
	}
	
	private void initProducten()
	{
		Product[] producten = new Product[] {
					new Product("kaas",101), new Product("melk",102), 
					new Product("chocoladepasta",111), new Product("sperziebonen",112), 
					new Product("pasta",121), new Product("appeltaart",122), 
					new Product("chips",131), new Product("nootjes",132), 
					new Product("Ham",201), 
					new Product("bolletjes",202)};
		
		int startAantal = 25;
		pad[0].vulBij(producten[0], startAantal);
		pad[0].vulBij(producten[1], startAantal);
		pad[1].vulBij(producten[2], startAantal);
		pad[1].vulBij(producten[3], startAantal);
		pad[2].vulBij(producten[4], startAantal);
		pad[2].vulBij(producten[5], startAantal);
		pad[3].vulBij(producten[6], startAantal);
		pad[3].vulBij(producten[7], startAantal);
		afdeling[0].vulBij(producten[8], startAantal);
		afdeling[1].vulBij(producten[9], startAantal);
		voordeelPad.vulBij(producten[9], startAantal);
		voordeelPad.vulBij(producten[2], startAantal);
		for (int i = 0; i < 10; i++)
		{
			magazijn.KomtAan(producten[i], startAantal*3);
		}
		Main.getInstance().setProducten(producten);
	}
}
