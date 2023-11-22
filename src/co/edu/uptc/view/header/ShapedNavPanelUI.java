package co.edu.uptc.view.header;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicPanelUI;

public class ShapedNavPanelUI extends BasicPanelUI {
	private Color color1;
	private Color color2;
	
	public ShapedNavPanelUI(Color color1, Color color2) {
		this.color1 = color1;
		this.color2 = color2;
	}
	
	@Override
	public void paint(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp = new GradientPaint(0, 0, color1, 0, c.getHeight(), color2);
		Shape buttonShape = null;
		buttonShape = new Rectangle2D.Double(0, 0, c.getWidth(), c.getHeight());
		g2d.setPaint(gp);
		g2d.fill(buttonShape);
		c.setOpaque(false);
		super.paint(g, c);
	}
}
