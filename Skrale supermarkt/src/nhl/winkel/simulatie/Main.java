package nhl.winkel.simulatie;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.Vrachtwagen;

public class Main 
{
	private Timer timer = new Timer();
	private Random random = new Random();
	private List<Klant> klanten;
	private Vrachtwagen[] vrachtwagen;
	private Controller controller;
	private DataLink dataLink;
	private int winkelGroote = 25;
	private char[][] buffer;
	private char[][] winkel;
	private Window window = new Window();
	private static Main instance;
	
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
		switch (random.nextInt(4))
		{
		case 0:
			temp = new EeuwigThuisWoner(controller, Arrays.asList(new Product[] {}));
			break;
		case 1:
			temp = new HuisPersoon(controller, Arrays.asList(new Product[] {}));
			break;
		case 2:
			temp = new Oudere(controller, Arrays.asList(new Product[] {}));
			break;
		case 3:
			temp = new Student(controller, Arrays.asList(new Product[] {}));
		}
		klanten.add(temp);
	}
}
