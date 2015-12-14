package nhl.winkel.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import nhl.winkel.simulatie.Main;

public class Surface extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6892110344210533478L;
	private int sizeH = 700;
	private int sizeV = 700;
	public Surface() 
	{
		this.setSize(sizeH, sizeV);
	}
	
	private void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(Color.black);
		
		char[][] mat = Main.getInstance().getWinkel();
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat.length; j++)
			{
				g2d.drawString(Character.toString(mat[i][j]), j * (sizeH / Main.getInstance().getWinkelSize()) + 15, i * (sizeV / Main.getInstance().getWinkelSize()) + 15);
			}
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
}
