package nhl.winkel.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4401258277282345771L;
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
		JButton button = new JButton("lepra");
		button.addActionListener(new ActionListener()
		{
			int i = 0;
			@Override
			public void actionPerformed(ActionEvent e)
			{
				i++;
				button.setText(String.valueOf(i+1));
			}
		});
		//this.setLayout(new FlowLayout());
		this.add(button);
		this.add(surface);
		this.setTitle("Blokken");
	    this.setSize(1280, 720);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
}
