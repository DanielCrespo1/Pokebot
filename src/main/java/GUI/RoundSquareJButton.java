package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class RoundSquareJButton extends JButton {

	private static final long serialVersionUID = -1318451016664816902L;
	public RoundSquareJButton(String label) {
		super(label);
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
		setRolloverEnabled(true);
	}
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			int R = getBackground().getRed();
			int G = getBackground().getGreen();
			int B = getBackground().getBlue();
			g.setColor(new Color(R-25, G-25, B-25));
		} else {
			g.setColor(getBackground());
		}
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 14, 14);
		super.paintComponent(g);
	}
	protected void paintBorder(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON );
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY );
        g2d.setRenderingHints( qualityHints ); 
        g2d.setColor(Color.CYAN);
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 14, 14);
	}
	Shape shape;
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 14, 14);
		}
		return shape.contains(x, y);
	}
}
