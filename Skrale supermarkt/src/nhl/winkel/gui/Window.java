package nhl.winkel.gui;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame
{
	private Timer timer;
	private Surface surface;
	
	public Window()
	{
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				surface.repaint();
			}
		}, 10, 8);
		surface = new Surface();
		this.add(surface);
		this.setTitle("Blokken");
	    this.setSize(1280, 720);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
}
