package co.edu.uptc.view.header;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class ShapedButtonProfile extends BasicButtonUI {
	private Color background;
	
	public ShapedButtonProfile(Color background) {
		this.background = background;
	}
	
	@Override
	public void paint(Graphics g, JComponent c) {
	Graphics2D g2d = (Graphics2D) g;
	Shape buttonShape = null;
	buttonShape = new RoundRectangle2D.Double(0, 0, c.getWidth(), c.getHeight(), 10, 10);
	g2d.setPaint(background);
	g2d.fill(buttonShape);
	super.paint(g2d, c);
	}
}
