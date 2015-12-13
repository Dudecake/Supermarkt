package nhl.winkel.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

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
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
}
