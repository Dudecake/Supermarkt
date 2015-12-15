package nhl.winkel.simulatie;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import nhl.winkel.gui.Window;
import nhl.winkel.personen.EeuwigThuisWoner;
import nhl.winkel.personen.HuisPersoon;
import nhl.winkel.personen.Klant;
import nhl.winkel.personen.Oudere;
import nhl.winkel.personen.Student;
import nhl.winkel.simulatie.DataLink.Mutatie;
import nhl.winkel.winkel.Product;

public class Main 
{
	private Timer timer = new Timer();
	private Random random = new Random();
	private List<Klant> klanten;
	//private Vrachtwagen[] vrachtwagen;
	private Controller controller;
	private DataLink dataLink;
	private int winkelGroote = 25;
	private char[][] buffer;
	private char[][] winkel;
	@SuppressWarnings("unused")
	private Window window = new Window();
	private static Main instance;
	private Product[] producten;
	
	public static Main getInstance()
	{
		return instance;
	}
	
	public int getWinkelSize()
	{
		return winkelGroote;
	}

	public Product[] getProducten()
	{
		return producten;
	}

	public void setProducten(Product[] producten)
	{
		this.producten = producten;
	}

	public Controller getController()
	{
		return controller;
	}
	
	public static void main(String[] args) 
	{
		Main p = new Main();
		instance = p;
		p.winkel = new char[p.winkelGroote][p.winkelGroote];
		for (int i = 0; i < p.winkelGroote; i++)
		{
			for (int j = 0; j < p.winkelGroote; j++)
			{
				if ((i == 0 || i == p.winkelGroote - 1) || (j == 0 || j == p.winkelGroote - 1))
				{
					if (i < 11 || i > 14) p.winkel[i][j] = '+';
					else p.winkel[i][j] = '.';
				}
				else
				{
					p.winkel[i][j] = '.';
				}
			}
		}
		p.controller = new Controller();
		p.dataLink = new DataLink();
		p.klanten = new ArrayList<>();
		p.buffer = p.winkel;
		p.timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				instance.update();
			}
		}, 500, 1000);
		p.NieuweKlant();
		p.update();
	}

	public void ProductOp(Integer prodNr)
	{

	}
	
	public void afgerekend(List<Product> prods)
	{
		dataLink.Mutatie(prods, Mutatie.AF);
	}

	public void Aangevuld(List<Product> prods)
	{
		dataLink.Mutatie(prods, Mutatie.BIJ);
	}
	
	public char[][] getWinkel()
	{
		return winkel;
	}
	
	private void update()
	{
		winkel = clone(buffer);
		Klant temp;
		for (int i = 0; i < klanten.size(); i++)
		{
			temp = klanten.get(i);
			if (temp.getLocation().equals(new Point(13, 24)))
			{
				klanten.remove(i);
				i--;
			}
			temp.update();
		}
		NieuweKlant();
	}

	private void NieuweKlant()
	{
		Klant temp = null;
		TreeMap<Integer, Integer> lijst = new TreeMap<Integer, Integer>();
		switch (random.nextInt(4))
		{
		case 0:
			lijst.put(producten[5].getProdNr(), 2);
			lijst.put(producten[6].getProdNr(), 4);
			lijst.put(producten[7].getProdNr(), 3);
			temp = new EeuwigThuisWoner(controller, lijst);
			break;
		case 1:
			lijst.put(producten[2].getProdNr(), 3);
			lijst.put(producten[0].getProdNr(), 2);
			lijst.put(producten[3].getProdNr(), 2);
			lijst.put(producten[9].getProdNr(), 2);
			lijst.put(producten[4].getProdNr(), 1);
			lijst.put(producten[1].getProdNr(), 2);
			lijst.put(producten[8].getProdNr(), 1);
			temp = new HuisPersoon(controller, lijst);
			break;
		case 2:
			lijst.put(producten[0].getProdNr(), 2);
			lijst.put(producten[5].getProdNr(), 1);
			lijst.put(producten[4].getProdNr(), 1);
			lijst.put(producten[8].getProdNr(), 1);
			temp = new Oudere(controller, lijst);
			break;
		case 3:
			lijst.put(producten[6].getProdNr(), 6);
			lijst.put(producten[7].getProdNr(), 3);
			lijst.put(producten[9].getProdNr(), 2);
			temp = new Student(controller, lijst);
		}
		klanten.add(temp);
	}
	
	private char[][] clone(char[][] x)
	{
		char[][] res = new char[x.length][x.length];
		for (int i = 0; i < x.length; i++)
		{
			for (int j = 0; j < x.length; j++)
			{
				res[i][j] = x[i][j];
			}
		}
		return res;
	}
}
