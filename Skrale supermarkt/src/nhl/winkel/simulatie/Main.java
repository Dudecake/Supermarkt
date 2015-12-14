package nhl.winkel.simulatie;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import nhl.winkel.gui.Window;
import nhl.winkel.personen.EeuwigThuisWoner;
import nhl.winkel.personen.HuisPersoon;
import nhl.winkel.personen.Klant;
import nhl.winkel.personen.Oudere;
import nhl.winkel.personen.Student;
import nhl.winkel.simulatie.DataLink.Mutatie;
import nhl.winkel.winkel.Pad;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.Vrachtwagen;

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
	private Window window = new Window();
	private static Main instance;
	public Product[] producten;
	
	public static Main getInstance()
	{
		return instance;
	}
	
	public int getWinkelSize()
	{
		return winkelGroote;
	}
	
	public static void main(String[] args) 
	{
		instance = new Main();
		instance.winkel = new char[instance.winkelGroote][instance.winkelGroote];
		instance.controller = new Controller();
		instance.dataLink = new DataLink();
		instance.klanten = new ArrayList<>();
		for (int i = 0; i < instance.winkelGroote; i++)
		{
			for (int j = 0; j < instance.winkelGroote; j++)
			{
				if ((i == 0 || i == instance.winkelGroote - 1) || (j == 0 || j == instance.winkelGroote - 1))
					if (i < 11 || i > 14)instance.winkel[i][j] = '+';
			}
		}
		instance.buffer = instance.winkel;
		instance.timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				instance.update();
			}
		}, 5, 8);
		instance.NieuweKlant();
		instance.update();
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
		winkel = buffer;
		Klant temp;
		for (int i = 0; i < klanten.size(); i++)
		{
			temp = klanten.get(i);
			if (temp.getLocation().equals(new Point(25, 13)))
			{
				klanten.remove(i);
				i--;
			}
			temp.update();
		}
	}

	private void NieuweKlant()
	{
		Klant temp = null;
		Map<Product, Integer> lijst = new HashMap<Product, Integer>();
		switch (random.nextInt(4))
		{
		case 0:
			lijst.put(producten[5], 2);
			lijst.put(producten[6], 4);
			lijst.put(producten[7], 3);
			temp = new EeuwigThuisWoner(controller, lijst);
			break;
		case 1:
			lijst.put(producten[2], 3);
			lijst.put(producten[0], 2);
			lijst.put(producten[3], 2);
			lijst.put(producten[9], 2);
			lijst.put(producten[4], 1);
			lijst.put(producten[1], 2);
			lijst.put(producten[8], 1);
			temp = new HuisPersoon(controller, lijst);
			break;
		case 2:
			lijst.put(producten[0], 2);
			lijst.put(producten[5], 1);
			lijst.put(producten[4], 1);
			lijst.put(producten[8], 1);
			temp = new Oudere(controller, lijst);
			break;
		case 3:
			lijst.put(producten[6], 6);
			lijst.put(producten[7], 3);
			lijst.put(producten[9], 2);
			temp = new Student(controller, lijst);
		}
		klanten.add(temp);
	}
}
