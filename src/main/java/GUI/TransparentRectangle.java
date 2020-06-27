package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;

public class TransparentRectangle extends JLabel {

	private static final long serialVersionUID = 8860061313593748897L;
	
	public TransparentRectangle() {
		setBackground(new Color(0, 0, 0, 0));
	}
	
	public void draw() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (g instanceof Graphics2D) {
			final int R = 100;
			final int G = 100;
			final int B = 100;
			final int translucency = 200;
			Graphics2D g2d = (Graphics2D)g;
			RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON );
	        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY );
	        g2d.setRenderingHints( qualityHints ); 
			g2d.setStroke(new BasicStroke(2));
			g2d.setColor(new Color(R, G, B, translucency));
			g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
			g2d.setColor(Color.CYAN);
			g2d.draw(new RoundRectangle2D.Double(0, 0, getWidth()-2, getHeight()-2, 26, 26));
		}
	}
}
