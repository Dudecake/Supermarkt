package nhl.winkel.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import nhl.winkel.simulatie.Main;

@SuppressWarnings("serial")
public class Surface extends JPanel
{
	public Surface() 
	{
		this.setSize(700, 700);
	}
	
	private void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(Color.black);
		
		char[][] mat = Main.getInstance().getWinkel();
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
}
