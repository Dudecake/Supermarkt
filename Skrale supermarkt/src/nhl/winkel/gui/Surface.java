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
		int height = 0;
		int index = 0;
		for (Pad pad : paden)
		{
			height += 15;
			g2d.drawString("pad " + String.valueOf(index), 715, height);
			height += 15; index++;
			int prod1 = pad.getProducten().get(0).getProdNr();
			int prod2 = 0, numProd1 = 0, numProd2 = 0;
			String naamprod2 = "";
			for (Product prod : pad.getProducten())
			{
				if (prod.getProdNr()==prod1)
				{
					numProd1++;
				} else if (prod2==0)
				{
					prod2 = prod.getProdNr();
					naamprod2 = prod.getProdNaam();
					numProd2++;
				} else
				{
					numProd2++;
				}
			}
			g2d.drawString(pad.getProducten().get(0).getProdNaam()+ ": " + String.valueOf(numProd1), 715, height);
			height += 15;
			g2d.drawString(naamprod2+ ": " + String.valueOf(numProd2), 715, height);
			height += 15;
		}
		index = 0;
		Afdeling[] afdelingen = Main.getInstance().getController().getAfdeling();
		for (Afdeling afdeling : afdelingen)
		{
			height += 15;
			g2d.drawString("afdeling " + String.valueOf(index), 715, height);
			height += 15; index++;
			int numProd1 = 0;
			for (@SuppressWarnings("unused") Product prod : afdeling.getProducten())
			{
				numProd1++;
			}
			g2d.drawString(afdeling.getProducten().get(0).getProdNaam()+ ": " + String.valueOf(numProd1), 715, height);
			height += 15;
		}
		VoordeelPad voordeelPad = Main.getInstance().getController().getVoordeelPad();
		height += 15;
		g2d.drawString("voordeelpad", 715, height);
		height += 15;
		int prod1 = voordeelPad.getProducten().get(0).getProdNr();
		int prod2 = 0, numProd1 = 0, numProd2 = 0;
		String naamprod2 = "";
		for (Product prod : voordeelPad.getProducten())
		{
			if (prod.getProdNr()==prod1)
			{
				numProd1++;
			} else if (prod2==0)
			{
				prod2 = prod.getProdNr();
				naamprod2 = prod.getProdNaam();
				numProd2++;
			} else
			{
				numProd2++;
			}
		}
		g2d.drawString(voordeelPad.getProducten().get(0).getProdNaam()+ ": " + String.valueOf(numProd1), 715, height);
		height += 15;
		g2d.drawString(naamprod2+ ": " + String.valueOf(numProd2), 715, height);
		height += 15;
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
}
