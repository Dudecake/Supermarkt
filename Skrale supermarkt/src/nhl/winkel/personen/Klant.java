package nhl.winkel.personen;

import java.awt.Point;
import java.util.List;
import java.util.TreeMap;

import nhl.winkel.simulatie.Controller;
import nhl.winkel.simulatie.Main;
import nhl.winkel.winkel.Afdeling;
import nhl.winkel.winkel.Pad;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.Stelling;
import nhl.winkel.winkel.Winkelwagen;

public class Klant extends Persoon
{
	private Winkelwagen winkelwagen;
	private Controller controller;
	
	//lijstje met product en aantal
	TreeMap<Integer, Integer> boodschappenLijstje;
	
	public Klant(Controller c)
	{
		controller = c;
		location = new Point(13, 0);
		winkelwagen = new Winkelwagen();
	}
	
	@Override
	public void update()
	{
		if (boodschappenLijstje.size() == 0) 
		{
			setLocation(new Point(25, 13));
		} else
		{
			Stelling loca = null;
			int num = boodschappenLijstje.firstEntry().getKey();
			int aantal = boodschappenLijstje.get(num);
			switch (num/100)
			{
			case 1:
				//het is in een pad
				Pad[] paden = Main.getInstance().getController().getPad();
				
				switch ((num-100)/10)
				{
					case 0:
						//is in pad 1
						loca = paden[0];
						setLocation(paden[0].getLocation().x, paden[0].getLocation().y+1);
						break;
					case 1:
						//is in pad 2
						loca = paden[1];
						setLocation(paden[1].getLocation().x, paden[1].getLocation().y+1);
						break;
					case 2:
						//is in pad 3
						loca = paden[2];
						setLocation(paden[2].getLocation().x, paden[2].getLocation().y+1);
						break;
					case 3:
						//is in pad 4
						loca = paden[3];
						setLocation(paden[3].getLocation().x, paden[3].getLocation().y+1);
						break;
	
					default:
						break;
				}
				break;
			case 2:
				//het is een afdeling
				Afdeling[] afdelingen = Main.getInstance().getController().getAfdeling();
				switch ((num-200)/10)
				{
					case 0:
						//is in afdeling 1
						loca = afdelingen[0];
						setLocation(afdelingen[0].getLocation().x, afdelingen[0].getLocation().y+1);
						break;
					case 1:
						//is in afdeling 2
						loca = afdelingen[1];
						setLocation(afdelingen[1].getLocation().x, afdelingen[1].getLocation().y+1);
						break;
	
					default:
						break;
				}
				break;

			default:
				break;
			}
			if (loca==null)
			{
				throw new OutOfMemoryError();
			}
			WilProductPakken(num, aantal, loca);
			boodschappenLijstje.remove(num);
		}
		super.update();
	}

	private void WilProductPakken(int prodNr, int aantal, Stelling locatie)
	{
		List<Product> prods = controller.PaktProduct(prodNr, aantal, locatie);
		if(prods.size() != 0)
		{
			winkelwagen.pleurInWinkelwagen(prods);
		}
		else 
		{
			setLocation(new Point(13, 24));
			//Ren schreeuwend de winkel uit.
		}
	}
}
