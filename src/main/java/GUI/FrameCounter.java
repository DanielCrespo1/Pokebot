package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.JButton;

public class FrameCounter extends JDialog {

	private static final long serialVersionUID = 3878181656628265926L;
	private BackgroundPanel bp;
	private ImageIcon bpIcon;
	private Border empty;
	private JLabel lblNewLabel;
	private static JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private static Point point = new Point();

	public FrameCounter(String frameGoal, String framesSkipped) {
		setBounds(100, 100, 166, 100);
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		empty = BorderFactory.createEmptyBorder();
		bpIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/PokeWindowFrame.png")));
		bp = new BackgroundPanel(bpIcon.getImage());
		bp.setBackground(new Color(0, 0, 0, 0));
		setContentPane(bp);
		bp.setLayout(null);
		
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
		
		lblNewLabel = new JLabel("Shinny Frame:" + frameGoal);
		lblNewLabel.setBounds(20, 30, 134, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Frames Skipped:" + framesSkipped);
		lblNewLabel_1.setBounds(20, 50, 134, 14);
		getContentPane().add(lblNewLabel_1);
		
		btnNewButton = new JButton("") {
			
			private static final long serialVersionUID = -4365091780156022422L;

			@Override
			protected void paintComponent(Graphics g) {
				g.setColor(new Color(0, 0, 0, 0));
			}
		};
		btnNewButton.addActionListener(e->{
			dispose();
		});
		btnNewButton.setBounds(154, 0, 12, 10);
		btnNewButton.setBackground(new Color(0, 0, 0, 0));
		btnNewButton.setForeground(new Color(0, 0, 0, 0));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(empty);
		bp.add(btnNewButton);
	}
	
	public static void setFrameSkipCounter(Integer counter) {
		lblNewLabel_1.setText("Frames Skipped:" + counter);
	}
}
