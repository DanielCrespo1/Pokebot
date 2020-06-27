package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class ErrorGUI extends JDialog {
	private static final long serialVersionUID = 1344334778252348762L;
	private static Point point = new Point();
	
	public ErrorGUI() {
		setUndecorated(true);
		setAlwaysOnTop(true);
		setSize(450, 300);
		setBackground(new Color(0, 0, 0, 0));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});

		JButton btnNewButton = new RoundSquareJButton("OK");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(0, 277, 450, 23);
		btnNewButton.setBackground(new Color(150, 150, 150));
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(e -> dispose());
		
		JPanel panel = new JPanel() {
			private static final long serialVersionUID = -8783524014602913885L;

			protected void paintComponent(Graphics g) {
				if (g instanceof Graphics2D) {
					final int R = 150;
					final int G = 150;
					final int B = 150;
					final int translucency = 240;
					Graphics2D g2d = (Graphics2D)g;
					RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON );
			        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY );
			        g2d.setRenderingHints(qualityHints); 
					g2d.setStroke(new BasicStroke(2));
					g2d.setColor(new Color(R, G, B, translucency));
					g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 30, 30));
					g2d.setColor(Color.CYAN);
					g2d.draw(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 28, 28));
				}
			}
		};
		panel.setBounds(10, 11, 430, 280);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phone not connected.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(127, 111, 176, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please reconnect your phone to your PC,");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(50, 130, 330, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("via wifi or cable.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(149, 150, 330, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Please visit this page for more information:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(39, 200, 400, 20);
		panel.add(lblNewLabel_3);
		
		JTextField lblNewTextField = new JTextField("https://github.com/Genymobile/scrcpy");
		lblNewTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewTextField.setBounds(15, 230, 400, 20);
		lblNewTextField.setEditable(false);
		lblNewTextField.setBackground(new Color(0, 0, 0, 0));
		lblNewTextField.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewTextField.setBorder(null);
		panel.add(lblNewTextField);
		
		JLabel lblNewLabel_5 = new JLabel("ERROR: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(176, 60, 176, 20);
		panel.add(lblNewLabel_5);
	}
}
