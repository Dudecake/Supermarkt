package nhl.winkel.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import nhl.winkel.simulatie.Main;
import nhl.winkel.winkel.Afdeling;
import nhl.winkel.winkel.Pad;
import nhl.winkel.winkel.Product;
import nhl.winkel.winkel.VoordeelPad;

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
		this.setSize(700, sizeV);
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
		drawStatistics(g2d);
	}
	
	private void drawStatistics(Graphics2D g2d)
	{
		Pad[] paden = Main.getInstance().getController().getPad();
		int height = 15;
		int index = 0;
		for (Pad pad : paden)
		{
			g2d.drawString("pad " + String.valueOf(index), 715, height);
			height += 15; index++;
			for (Product prod : pad.getProducten())
			{
				g2d.drawString(prod.getProdNaam(), 715, height);
				height += 15;
			}
		}
		index = 0;
		int padding = height - 15;
		Afdeling[] afdelingen = Main.getInstance().getController().getAfdeling();
		for (Afdeling afdeling : afdelingen)
		{
			g2d.drawString("afdeling " + String.valueOf(index), 815, height - padding);
			height += 15; index++;
			for (Product prod : afdeling.getProducten())
			{
				g2d.drawString(prod.getProdNaam(), 815, height - padding);
				height += 15;
			}
		}
		VoordeelPad voordeelPad = Main.getInstance().getController().getVoordeelPad();
		g2d.drawString("voordeelpad", 815, height - padding);
		height += 15;
		for (Product prod : voordeelPad.getProducten())
		{
			g2d.drawString(prod.getProdNaam(), 815, height - padding);
			height += 15;
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
}
