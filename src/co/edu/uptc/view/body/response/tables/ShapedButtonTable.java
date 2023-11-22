package co.edu.uptc.view.body.response.tables;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

import co.edu.uptc.view.Constants;

public class ShapedButtonTable extends BasicButtonUI {
	
	@Override
	public void paint(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		Shape buttonShape = null;
		buttonShape = new RoundRectangle2D.Double(2, 0, c.getHeight(), c.getHeight(), 100, 100);
		g2d.setPaint(Constants.COLORBACKGROUNDHEADER);
		g2d.fill(buttonShape);
		super.paint(g2d, c);
	}
}
