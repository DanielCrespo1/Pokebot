package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jnativehook.GlobalScreen;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import DataManagment.UserSettings;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CalibrateButtons extends JFrame implements NativeMouseInputListener {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalibrateButtons frame = new CalibrateButtons(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static final long serialVersionUID = -432045269995384319L;
	private JPanel contentPane;
	private static Point point = new Point();
	private ArrayList<ImageIcon> images = new ArrayList<>(18);
	private HashMap<Integer, String> text = new HashMap<>();
	private HashMap<Integer, String> buttons = new HashMap<>();
	private JLabel imageLabel;
	private JLabel textLabel;
	public static int count = -1;
	private JButton btnCalibration;
	private boolean startingCalibration = false;
	private JFrame mainFrame;

	public CalibrateButtons(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 190, 105);
		setUndecorated(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setAlwaysOnTop(true);
		setBackground(new Color(0, 0, 0, 0));
		contentPane.setLayout(null);
		
		btnCalibration = new RoundSquareJButton("Start Calibration");
		btnCalibration.setBounds(7, 80, 175, 23);
		btnCalibration.setFocusPainted(false);
		btnCalibration.setBackground(new Color(150, 150, 150));
		contentPane.add(btnCalibration);
		btnCalibration.addActionListener(e-> {
			btnCalibration.setVisible(false);
			repaint();
			imageLabel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/AButton.png"))));
			textLabel.setText("Press A");
			startingCalibration = true;
		});
		
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
					g2d.draw(new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 30, 30));
				}
			}
		};

		panel.setBounds(10, 2, 170, 100);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		imageLabel = new JLabel();
		imageLabel.setBounds(0, 12, 170, 77);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(imageLabel);

		textLabel = new JLabel();
		textLabel.setBounds(0, 50, 170, 70);
		textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textLabel);
		
		buttons.put(1, "B");
		buttons.put(2, "X");
		buttons.put(3, "Y");
		buttons.put(4, "UP_DPAD");
		buttons.put(5, "DOWN_DPAD");
		buttons.put(6, "LEFT_DPAD");
		buttons.put(7, "RIGHT_DPAD");
		buttons.put(8, "PLUS");
		buttons.put(9, "MINUS");
		buttons.put(10, "HOME");
		buttons.put(11, "L");
		buttons.put(12, "ZL");
		buttons.put(13, "R");
		buttons.put(14, "ZR");
		buttons.put(15, "LEFTSTICK_CENTER");
		buttons.put(16, "RIGHTSTICK_CENTER");
		text.put(1, "Press B");
		text.put(2, "Press X");
		text.put(3, "Press Y");
		text.put(4, "Press Up d-pad");
		text.put(5, "Press Down d-pad");
		text.put(6, "Press Left d-pad");
		text.put(7, "Press Right d-pad");
		text.put(8, "Press Plus");
		text.put(9, "Press Minus");
		text.put(10, "Press Home");
		text.put(11, "Press L");
		text.put(12, "Press ZL");
		text.put(13, "Press R");
		text.put(14, "Press ZR");
		text.put(15, "Press Center of Left Stick");
		text.put(16, "Press Center of Right Stick");
		images.add(null);
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/BButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/XButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/YButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/UpButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/DownButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/LeftButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/RightButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/PlusButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/MinusButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/HomeButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/LButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/ZLButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/RButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/ZRButton.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Joystick.png"))));
		images.add(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Joystick.png"))));

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
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent e) {
		if(startingCalibration && count <= 16) {
			if(count == 0) {
				UserSettings.addSetting("A", e.getX() + " " + e.getY());
				UserSettings.outputProperties();
				count++;
				imageLabel.setIcon(images.get(count));
				textLabel.setText(text.get(count));
			}else if(count > 0){
				UserSettings.addSetting(buttons.get(count), e.getX() + " " + e.getY());
				UserSettings.outputProperties();
				count++;
				if(count <= 16) {
					imageLabel.setIcon(images.get(count));
					textLabel.setText(text.get(count));
				}else {
					count = -1;
					dispose();
					GlobalScreen.removeNativeMouseListener(this);
					MainGUI.calibrateButton.setSelected(false);
					MainGUI.advanceButton.setEnabled(true);
					mainFrame.setState(NORMAL);
				}
			}
		}
		else if(count == -1) count ++;
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent e) {
		// Don't need
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent e) {
		// Don't need
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent e) {
		// Don't need
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent e) {
		// Don't need
	}

}
