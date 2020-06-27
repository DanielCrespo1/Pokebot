package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import DataManagment.DefaultSettings;
import DataManagment.UserSettings;

public class AdvanceSettings extends JFrame {

	private static final long serialVersionUID = 327669909416732800L;
	private GraphicsEnvironment ge;
	public static Process mousePosProcess;
	private Border empty;
	private ExecutorService executorService = Executors.newCachedThreadPool();
	private static Point point = new Point();
	private ImageIcon bpIcon;
	private ImageIcon pokebotLogo;
	private BackgroundPanel bp;
	private Font pokemonFont;
	private JLabel xCoordTitle;
	private JLabel yCoordTitle;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_24;
	private JLabel lblNewLabel_25;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_31;
	private JLabel lblNewLabel_32;
	private JLabel lblNewLabel_33;
	private JLabel lblNewLabel_34;
	private JLabel lblNewLabel_35;
	private JLabel lblNewLabel_36;
	private JLabel lblNewLabel_37;
	private JLabel lblNewLabel_38;
	private JLabel lblNewLabel_39;
	private JLabel lblNewLabel_40;
	private JLabel lblNewLabel_41;
	private JLabel lblNewLabel_42;
	private JLabel lblNewLabel_43;
	private JLabel lblNewLabel_44;
	private JLabel lblNewLabel_45;
	private JLabel lblNewLabel_46;
	private JLabel lblNewLabel_47;
	private JLabel lblNewLabel_48;
	private JLabel lblNewLabel_49;
	private JLabel lblNewLabel_50;
	private JLabel lblNewLabel_51;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_33;
	private JTextField textField_32;
	private JTextField textField_34;
	private JTextField txtpnUpDpad;
	private JTextField textPane_2;
	private JTextField textPane_3;
	private JTextField textPane_4;
	private JTextField textPane_5;
	private JTextField textPane_6;
	private JTextField textPane_7;
	private JTextField textPane_8;
	private JTextField textPane_9;
	private JTextField textPane_10;
	private JTextField textPane_11;
	private JTextField textPane_12;
	private JTextField textPane_13;
	private JTextField textPane_14;
	private JTextField textPane_15;
	private JTextField textPane_16;
	private JTextField textPane_17;
	private JToggleButton MousePosToggle;
	private JButton defaultButton;

	public AdvanceSettings() throws FontFormatException, IOException {
		super("Advance Settings");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1280, 860);
		setResizable(false);
		setLocationRelativeTo(null);
		pokebotLogo = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Pokebot.jpg")));
		setIconImage(pokebotLogo.getImage());
		empty = BorderFactory.createEmptyBorder();
		bpIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/AdvanceSettingsBackground.jpg")));
		bp = new BackgroundPanel(bpIcon.getImage());
		setContentPane(bp);
		bp.setLayout(null);
		pokemonFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("externalFonts/pokemonSwordFont.otf"))).deriveFont(22F);
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(pokemonFont);
		
		addWindowListener(new WindowAdapter(){			
			public void windowClosing(WindowEvent e) {
				String outputPropertiesPath = System.getenv("HOMEPATH") + File.separator + "Pokebot" + File.separator + ".pokebot.lock";
				File f = new File(outputPropertiesPath);
				f.delete();
				if(AdvanceSettings.mousePosProcess != null)
					AdvanceSettings.mousePosProcess.destroy();
			}
		});

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

		xCoordTitle = new JLabel("<html><u>X Coord</u></html>");
		xCoordTitle.setBounds(1045, 11, 75, 30);
		xCoordTitle.setFont(pokemonFont);
		xCoordTitle.setForeground(Color.BLACK);
		bp.add(xCoordTitle);
		
		yCoordTitle = new JLabel("<html><u>Y Coord</u></html>");
		yCoordTitle.setBounds(1153, 11, 75, 30);
		yCoordTitle.setFont(pokemonFont);
		yCoordTitle.setForeground(Color.BLACK);
		bp.add(yCoordTitle);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/UpButton.png"))));
		lblNewLabel_1.setBounds(10, 44, 35, 35);
		bp.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/DownButton.png"))));
		lblNewLabel_2.setBounds(10, 90, 35, 35);
		bp.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/LeftButton.png"))));
		lblNewLabel_3.setBounds(10, 136, 35, 35);
		bp.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/RightButton.png"))));
		lblNewLabel_4.setBounds(10, 182, 35, 35);
		bp.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/AButton.png"))));
		lblNewLabel_5.setBounds(10, 228, 35, 35);
		bp.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/BButton.png"))));
		lblNewLabel_6.setBounds(10, 274, 35, 35);
		bp.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/XButton.png"))));
		lblNewLabel_7.setBounds(10, 320, 35, 35);
		bp.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/YButton.png"))));
		lblNewLabel_8.setBounds(10, 366, 35, 35);
		bp.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/HomeButton.png"))));
		lblNewLabel_9.setBounds(10, 412, 35, 35);
		bp.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/LButton.png"))));
		lblNewLabel_10.setBounds(10, 458, 35, 35);
		bp.add(lblNewLabel_10);

		lblNewLabel_11 = new JLabel();
		lblNewLabel_11.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/ZLButton.png"))));
		lblNewLabel_11.setBounds(10, 504, 35, 35);
		bp.add(lblNewLabel_11);

		lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/RButton.png"))));
		lblNewLabel_12.setBounds(10, 550, 35, 35);
		bp.add(lblNewLabel_12);

		lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/ZRButton.png"))));
		lblNewLabel_13.setBounds(10, 596, 35, 35);
		bp.add(lblNewLabel_13);

		lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/PlusButton.png"))));
		lblNewLabel_14.setBounds(10, 642, 35, 35);
		bp.add(lblNewLabel_14);

		lblNewLabel_15 = new JLabel();
		lblNewLabel_15.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/MinusButton.png"))));
		lblNewLabel_15.setBounds(10, 688, 35, 35);
		bp.add(lblNewLabel_15);

		lblNewLabel_16 = new JLabel();
		lblNewLabel_16.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Joystick.png"))));
		lblNewLabel_16.setBounds(10, 734, 35, 35);
		bp.add(lblNewLabel_16);

		lblNewLabel_17 = new JLabel();
		lblNewLabel_17.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Joystick.png"))));
		lblNewLabel_17.setBounds(10, 780, 35, 35);
		bp.add(lblNewLabel_17);
		
		TransparentRectangle tr1 = new TransparentRectangle();
		tr1.setBounds(55, 42, 1197, 39);
		bp.add(tr1);
		tr1.setLayout(null);
		
		txtpnUpDpad = new JTextField();
		txtpnUpDpad.setDisabledTextColor(Color.BLACK);
		txtpnUpDpad.setEnabled(false);
		txtpnUpDpad.setFocusTraversalKeysEnabled(false);
		txtpnUpDpad.setFocusable(false);
		txtpnUpDpad.setHorizontalAlignment(SwingConstants.CENTER);
		txtpnUpDpad.setText("Up Dpad");
		txtpnUpDpad.setRequestFocusEnabled(false);
		txtpnUpDpad.setEditable(false);
		txtpnUpDpad.setBounds(15, 9, 86, 20);
		txtpnUpDpad.setAlignmentX(SwingConstants.CENTER);
		tr1.add(txtpnUpDpad);

		lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setBounds(981, 4, 98, 30);
		tr1.add(lblNewLabel_18);
		lblNewLabel_18.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));

		textField_1 = new JTextField();
		textField_1.setBounds(987, 9, 86, 20);
		tr1.add(textField_1);
		textField_1.setBorder(empty);
		textField_1.setText(UserSettings.getSetting("UP_DPAD").substring(0, UserSettings.getSetting("UP_DPAD").lastIndexOf(" ")));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		lblNewLabel_18.setVisible(false);
		/*
		 * This focusListener applies to every text field.
		 * Makes the label visible, to act as a border for the text field.
		 */
		textField_1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_18.setVisible(false);
				revalidate();
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_18.setVisible(true);
				revalidate();
			}
		});
		
		/*
		 * This keyListener applies to every text field.
		 * This verifies key inputs, letting only the ones that matter.
		 * Ex: directional keys, numbers and in some cases letters.
		 */		
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_1);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "UP_DPAD", textField_1, textField_2, true);
				if(isLeft(e) && textField_1.getCaretPosition() == 0) {
					textField_2.requestFocus();
				}else if(isDown(e)) {
					textField_3.requestFocus();
				}else if(isRight(e) && textField_1.getCaretPosition() == textField_1.getText().length()) {
					textField_2.requestFocus();
				}else if(isUp(e)) {
					textField_33.requestFocus();
				}
			}
		});
		
		lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_19.setBounds(1089, 4, 98, 30);
		lblNewLabel_19.setVisible(false);
		tr1.add(lblNewLabel_19);

		textField_2 = new JTextField();
		textField_2.setBorder(empty);
		textField_2.setText(UserSettings.getSetting("UP_DPAD").substring(UserSettings.getSetting("UP_DPAD").lastIndexOf(" ")+1, UserSettings.getSetting("UP_DPAD").length()));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(1095, 9, 86, 20);
		tr1.add(textField_2);
		textField_2.setColumns(10);
		textField_2.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_19.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_19.setVisible(true);
			}
		});
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_2);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "UP_DPAD", textField_1, textField_2, false);
				if(isLeft(e) && textField_2.getCaretPosition() == 0) {
					textField_1.requestFocus();
				}else if(isDown(e)) {
					textField_4.requestFocus();
				}else if(isRight(e) && textField_2.getCaretPosition() == textField_2.getText().length()) {
					textField_1.requestFocus();
				}else if(isUp(e)) {
					textField_34.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr2 = new TransparentRectangle();
		tr2.setBounds(55, 88, 1197, 39);
		bp.add(tr2);
		tr2.setLayout(null);
		
		textPane_2 = new JTextField();
		textPane_2.setDisabledTextColor(Color.BLACK);
		textPane_2.setText("Down Dpad");
		textPane_2.setRequestFocusEnabled(false);
		textPane_2.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_2.setEditable(false);
		textPane_2.setEnabled(false);
		textPane_2.setFocusable(false);
		textPane_2.setFocusTraversalKeysEnabled(false);
		textPane_2.setBounds(15, 9, 86, 20);
		tr2.add(textPane_2);

		lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_20.setBounds(981, 4, 98, 30);
		lblNewLabel_20.setVisible(false);
		tr2.add(lblNewLabel_20);

		textField_3 = new JTextField();
		textField_3.setBorder(empty);
		textField_3.setText(UserSettings.getSetting("DOWN_DPAD").substring(0, UserSettings.getSetting("DOWN_DPAD").lastIndexOf(" ")));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(987, 9, 86, 20);
		tr2.add(textField_3);
		textField_3.setColumns(10);
		textField_3.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_20.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_20.setVisible(true);
			}
		});
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_3);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "DOWN_DPAD", textField_3, textField_4, true);
				if(isLeft(e) && textField_3.getCaretPosition() == 0) {
					textField_4.requestFocus();
				}else if(isDown(e)) {
					textField_5.requestFocus();
				}else if(isRight(e) && textField_3.getCaretPosition() == textField_3.getText().length()) {
					textField_4.requestFocus();
				}else if(isUp(e)) {
					textField_1.requestFocus();
				}
			}
		});

		lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_21.setBounds(1089, 4, 98, 30);
		lblNewLabel_21.setVisible(false);
		tr2.add(lblNewLabel_21);

		textField_4 = new JTextField();
		textField_4.setBorder(empty);
		textField_4.setText(UserSettings.getSetting("DOWN_DPAD").substring(UserSettings.getSetting("DOWN_DPAD").lastIndexOf(" ")+1, UserSettings.getSetting("DOWN_DPAD").length()));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBounds(1095, 9, 86, 20);
		tr2.add(textField_4);
		textField_4.setColumns(10);
		textField_4.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_21.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_21.setVisible(true);
			}
		});
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_4);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "DOWN_DPAD", textField_3, textField_4, false);
				if(isLeft(e) && textField_4.getCaretPosition() == 0) {
					textField_3.requestFocus();
				}else if(isDown(e)) {
					textField_6.requestFocus();
				}else if(isRight(e) && textField_4.getCaretPosition() == textField_4.getText().length()) {
					textField_3.requestFocus();
				}else if(isUp(e)) {
					textField_2.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr3 = new TransparentRectangle();
		tr3.setBounds(55, 134, 1197, 39);
		bp.add(tr3);
		tr3.setLayout(null);
		
		textPane_3 = new JTextField();
		textPane_3.setDisabledTextColor(Color.BLACK);
		textPane_3.setText("Left Dpad");
		textPane_3.setRequestFocusEnabled(false);
		textPane_3.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_3.setFocusable(false);
		textPane_3.setFocusTraversalKeysEnabled(false);
		textPane_3.setEnabled(false);
		textPane_3.setEditable(false);
		textPane_3.setBounds(15, 9, 86, 20);
		tr3.add(textPane_3);

		lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_22.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_22.setBounds(981, 4, 98, 30);
		lblNewLabel_22.setVisible(false);
		tr3.add(lblNewLabel_22);

		textField_5 = new JTextField();
		textField_5.setBorder(empty);
		textField_5.setText(UserSettings.getSetting("LEFT_DPAD").substring(0, UserSettings.getSetting("LEFT_DPAD").lastIndexOf(" ")));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBounds(987, 9, 86, 20);
		tr3.add(textField_5);
		textField_5.setColumns(10);
		textField_5.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_22.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_22.setVisible(true);
			}
		});
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_5);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "LEFT_DPAD", textField_5, textField_6, true);
				if(isLeft(e) && textField_5.getCaretPosition() == 0) {
					textField_6.requestFocus();
				}else if(isDown(e)) {
					textField_7.requestFocus();
				}else if(isRight(e) && textField_5.getCaretPosition() == textField_5.getText().length()) {
					textField_6.requestFocus();
				}else if(isUp(e)) {
					textField_3.requestFocus();
				}
			}
		});

		lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_23.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_23.setBounds(1089, 4, 98, 30);
		lblNewLabel_23.setVisible(false);
		tr3.add(lblNewLabel_23);

		textField_6 = new JTextField();
		textField_6.setBorder(empty);
		textField_6.setText(UserSettings.getSetting("LEFT_DPAD").substring(UserSettings.getSetting("LEFT_DPAD").lastIndexOf(" ")+1, UserSettings.getSetting("LEFT_DPAD").length()));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBounds(1095, 9, 86, 20);
		tr3.add(textField_6);
		textField_6.setColumns(10);
		textField_6.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_23.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_23.setVisible(true);
			}
		});
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_6);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "LEFT_DPAD", textField_5, textField_6, false);
				if(isLeft(e) && textField_6.getCaretPosition() == 0) {
					textField_5.requestFocus();
				}else if(isDown(e)) {
					textField_8.requestFocus();
				}else if(isRight(e) && textField_6.getCaretPosition() == textField_6.getText().length()) {
					textField_5.requestFocus();
				}else if(isUp(e)) {
					textField_4.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr4 = new TransparentRectangle();
		tr4.setBounds(55, 180, 1197, 39);
		bp.add(tr4);
		tr4.setLayout(null);
		
		textPane_4 = new JTextField();
		textPane_4.setDisabledTextColor(Color.BLACK);
		textPane_4.setText("Right Dpad");
		textPane_4.setRequestFocusEnabled(false);
		textPane_4.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_4.setFocusable(false);
		textPane_4.setFocusTraversalKeysEnabled(false);
		textPane_4.setEnabled(false);
		textPane_4.setEditable(false);
		textPane_4.setBounds(15, 9, 86, 20);
		tr4.add(textPane_4);

		lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_24.setBounds(981, 4, 98, 30);
		lblNewLabel_24.setVisible(false);
		tr4.add(lblNewLabel_24);

		textField_7 = new JTextField();
		textField_7.setBorder(empty);
		textField_7.setText(UserSettings.getSetting("RIGHT_DPAD").substring(0, UserSettings.getSetting("RIGHT_DPAD").lastIndexOf(" ")));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setBounds(987, 9, 86, 20);
		tr4.add(textField_7);
		textField_7.setColumns(10);
		textField_7.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_24.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_24.setVisible(true);
			}
		});
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_7);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "RIGHT_DPAD", textField_7, textField_8, true);
				if(isLeft(e) && textField_7.getCaretPosition() == 0) {
					textField_8.requestFocus();
				}else if(isDown(e)) {
					textField_9.requestFocus();
				}else if(isRight(e) && textField_7.getCaretPosition() == textField_7.getText().length()) {
					textField_8.requestFocus();
				}else if(isUp(e)) {
					textField_5.requestFocus();
				}
			}
		});

		lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_25.setBounds(1089, 4, 98, 30);
		lblNewLabel_25.setVisible(false);
		tr4.add(lblNewLabel_25);

		textField_8 = new JTextField();
		textField_8.setBorder(empty);
		textField_8.setText(UserSettings.getSetting("RIGHT_DPAD").substring(UserSettings.getSetting("RIGHT_DPAD").lastIndexOf(" ")+1, UserSettings.getSetting("RIGHT_DPAD").length()));
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setBounds(1095, 9, 86, 20);
		tr4.add(textField_8);
		textField_8.setColumns(10);
		textField_8.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_25.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_25.setVisible(true);
			}
		});
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_8);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "RIGHT_DPAD", textField_7, textField_8, false);
				if(isLeft(e) && textField_8.getCaretPosition() == 0) {
					textField_7.requestFocus();
				}else if(isDown(e)) {
					textField_10.requestFocus();
				}else if(isRight(e) && textField_8.getCaretPosition() == textField_8.getText().length()) {
					textField_7.requestFocus();
				}else if(isUp(e)) {
					textField_6.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr5 = new TransparentRectangle();
		tr5.setBounds(55, 226, 1197, 39);
		bp.add(tr5);
		tr5.setLayout(null);
		
		textPane_5 = new JTextField();
		textPane_5.setDisabledTextColor(Color.BLACK);
		textPane_5.setText("A Button");
		textPane_5.setRequestFocusEnabled(false);
		textPane_5.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_5.setFocusable(false);
		textPane_5.setFocusTraversalKeysEnabled(false);
		textPane_5.setEnabled(false);
		textPane_5.setEditable(false);
		textPane_5.setBounds(15, 9, 86, 20);
		tr5.add(textPane_5);

		lblNewLabel_26 = new JLabel("");
		lblNewLabel_26.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_26.setBounds(981, 4, 98, 30);
		lblNewLabel_26.setVisible(false);
		tr5.add(lblNewLabel_26);

		textField_9 = new JTextField();
		textField_9.setBorder(empty);
		textField_9.setText(UserSettings.getSetting("A").substring(0, UserSettings.getSetting("A").lastIndexOf(" ")));
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setBounds(987, 9, 86, 20);
		tr5.add(textField_9);
		textField_9.setColumns(10);
		textField_9.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_26.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_26.setVisible(true);
			}
		});
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_9);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "A", textField_9, textField_10, true);
				if(isLeft(e) && textField_9.getCaretPosition() == 0) {
					textField_10.requestFocus();
				}else if(isDown(e)) {
					textField_11.requestFocus();
				}else if(isRight(e) && textField_9.getCaretPosition() == textField_9.getText().length()) {
					textField_10.requestFocus();
				}else if(isUp(e)) {
					textField_7.requestFocus();
				}
			}
		});

		lblNewLabel_27 = new JLabel("");
		lblNewLabel_27.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_27.setBounds(1089, 4, 98, 30);
		lblNewLabel_27.setVisible(false);
		tr5.add(lblNewLabel_27);

		textField_10 = new JTextField();
		textField_10.setBorder(empty);
		textField_10.setText(UserSettings.getSetting("A").substring(UserSettings.getSetting("A").lastIndexOf(" ")+1, UserSettings.getSetting("A").length()));
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setBounds(1095, 9, 86, 20);
		tr5.add(textField_10);
		textField_10.setColumns(10);
		textField_10.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_27.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_27.setVisible(true);
			}
		});
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_10);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "A", textField_9, textField_10, false);
				if(isLeft(e) && textField_10.getCaretPosition() == 0) {
					textField_9.requestFocus();
				}else if(isDown(e)) {
					textField_12.requestFocus();
				}else if(isRight(e) && textField_10.getCaretPosition() == textField_10.getText().length()) {
					textField_9.requestFocus();
				}else if(isUp(e)) {
					textField_8.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr6 = new TransparentRectangle();
		tr6.setBounds(55, 272, 1197, 39);
		bp.add(tr6);
		tr6.setLayout(null);
		
		textPane_6 = new JTextField();
		textPane_6.setDisabledTextColor(Color.BLACK);
		textPane_6.setText("B Button");
		textPane_6.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_6.setRequestFocusEnabled(false);
		textPane_6.setFocusable(false);
		textPane_6.setFocusTraversalKeysEnabled(false);
		textPane_6.setEnabled(false);
		textPane_6.setEditable(false);
		textPane_6.setBounds(15, 9, 86, 20);
		tr6.add(textPane_6);

		lblNewLabel_28 = new JLabel("");
		lblNewLabel_28.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_28.setBounds(981, 4, 98, 30);
		lblNewLabel_28.setVisible(false);
		tr6.add(lblNewLabel_28);

		textField_11 = new JTextField();
		textField_11.setBorder(empty);
		textField_11.setText(UserSettings.getSetting("B").substring(0, UserSettings.getSetting("B").lastIndexOf(" ")));
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setBounds(987, 9, 86, 20);
		tr6.add(textField_11);
		textField_11.setColumns(10);
		textField_11.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_28.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_28.setVisible(true);
			}
		});
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_11);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "B", textField_11, textField_12, true);
				if(isLeft(e) && textField_11.getCaretPosition() == 0) {
					textField_12.requestFocus();
				}else if(isDown(e)) {
					textField_13.requestFocus();
				}else if(isRight(e) && textField_11.getCaretPosition() == textField_11.getText().length()) {
					textField_12.requestFocus();
				}else if(isUp(e)) {
					textField_9.requestFocus();
				}
			}
		});

		lblNewLabel_29 = new JLabel("");
		lblNewLabel_29.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_29.setBounds(1089, 4, 98, 30);
		lblNewLabel_29.setVisible(false);
		tr6.add(lblNewLabel_29);

		textField_12 = new JTextField();
		textField_12.setBorder(empty);
		textField_12.setText(UserSettings.getSetting("B").substring(UserSettings.getSetting("B").lastIndexOf(" ")+1, UserSettings.getSetting("B").length()));
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setBounds(1095, 9, 86, 20);
		tr6.add(textField_12);
		textField_12.setColumns(10);
		textField_12.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_29.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_29.setVisible(true);
			}
		});
		textField_12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_12);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "B", textField_11, textField_12, false);
				if(isLeft(e) && textField_12.getCaretPosition() == 0) {
					textField_11.requestFocus();
				}else if(isDown(e)) {
					textField_14.requestFocus();
				}else if(isRight(e) && textField_12.getCaretPosition() == textField_12.getText().length()) {
					textField_11.requestFocus();
				}else if(isUp(e)) {
					textField_10.requestFocus();
				}
			}
		});

		TransparentRectangle tr7 = new TransparentRectangle();
		tr7.setBounds(55, 318, 1197, 39);
		bp.add(tr7);
		tr7.setLayout(null);
		
		textPane_7 = new JTextField();
		textPane_7.setDisabledTextColor(Color.BLACK);
		textPane_7.setText("X Button");
		textPane_7.setRequestFocusEnabled(false);
		textPane_7.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_7.setFocusable(false);
		textPane_7.setFocusTraversalKeysEnabled(false);
		textPane_7.setEnabled(false);
		textPane_7.setEditable(false);
		textPane_7.setBounds(15, 9, 86, 20);
		tr7.add(textPane_7);

		lblNewLabel_30 = new JLabel("");
		lblNewLabel_30.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_30.setBounds(981, 4, 98, 30);
		lblNewLabel_30.setVisible(false);
		tr7.add(lblNewLabel_30);

		textField_13 = new JTextField();
		textField_13.setBorder(empty);
		textField_13.setText(UserSettings.getSetting("X").substring(0, UserSettings.getSetting("X").lastIndexOf(" ")));
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setBounds(987, 9, 86, 20);
		tr7.add(textField_13);
		textField_13.setColumns(10);
		textField_13.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_30.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_30.setVisible(true);
			}
		});
		textField_13.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_13);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "X", textField_13, textField_14, true);
				if(isLeft(e) && textField_13.getCaretPosition() == 0) {
					textField_14.requestFocus();
				}else if(isDown(e)) {
					textField_15.requestFocus();
				}else if(isRight(e) && textField_13.getCaretPosition() == textField_13.getText().length()) {
					textField_14.requestFocus();
				}else if(isUp(e)) {
					textField_11.requestFocus();
				}
			}
		});

		lblNewLabel_31 = new JLabel("");
		lblNewLabel_31.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_31.setBounds(1089, 4, 98, 30);
		lblNewLabel_31.setVisible(false);
		tr7.add(lblNewLabel_31);

		textField_14 = new JTextField();
		textField_14.setBorder(empty);
		textField_14.setText(UserSettings.getSetting("X").substring(UserSettings.getSetting("X").lastIndexOf(" ")+1, UserSettings.getSetting("X").length()));
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setBounds(1095, 9, 86, 20);
		tr7.add(textField_14);
		textField_14.setColumns(10);
		textField_14.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_31.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_31.setVisible(true);
			}
		});
		textField_14.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_14);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "X", textField_13, textField_14, false);
				if(isLeft(e) && textField_14.getCaretPosition() == 0) {
					textField_13.requestFocus();
				}else if(isDown(e)) {
					textField_16.requestFocus();
				}else if(isRight(e) && textField_14.getCaretPosition() == textField_14.getText().length()) {
					textField_13.requestFocus();
				}else if(isUp(e)) {
					textField_12.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr8 = new TransparentRectangle();
		tr8.setBounds(55, 364, 1197, 39);
		bp.add(tr8);
		tr8.setLayout(null);
		
		textPane_8 = new JTextField();
		textPane_8.setDisabledTextColor(Color.BLACK);
		textPane_8.setText("Y Button");
		textPane_8.setRequestFocusEnabled(false);
		textPane_8.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_8.setFocusable(false);
		textPane_8.setFocusTraversalKeysEnabled(false);
		textPane_8.setEnabled(false);
		textPane_8.setEditable(false);
		textPane_8.setBounds(15, 9, 86, 20);
		tr8.add(textPane_8);

		lblNewLabel_32 = new JLabel("");
		lblNewLabel_32.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_32.setBounds(981, 4, 98, 30);
		lblNewLabel_32.setVisible(false);
		tr8.add(lblNewLabel_32);

		textField_15 = new JTextField();
		textField_15.setBorder(empty);
		textField_15.setText(UserSettings.getSetting("Y").substring(0, UserSettings.getSetting("Y").lastIndexOf(" ")));
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setBounds(987, 9, 86, 20);
		tr8.add(textField_15);
		textField_15.setColumns(10);
		textField_15.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_32.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_32.setVisible(true);
			}
		});
		textField_15.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_15);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "Y", textField_15, textField_16, true);
				if(isLeft(e) && textField_15.getCaretPosition() == 0) {
					textField_16.requestFocus();
				}else if(isDown(e)) {
					textField_17.requestFocus();
				}else if(isRight(e) && textField_15.getCaretPosition() == textField_15.getText().length()) {
					textField_16.requestFocus();
				}else if(isUp(e)) {
					textField_13.requestFocus();
				}
			}
		});

		lblNewLabel_33 = new JLabel("");
		lblNewLabel_33.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_33.setBounds(1089, 4, 98, 30);
		lblNewLabel_33.setVisible(false);
		tr8.add(lblNewLabel_33);

		textField_16 = new JTextField();
		textField_16.setBorder(empty);
		textField_16.setText(UserSettings.getSetting("Y").substring(UserSettings.getSetting("Y").lastIndexOf(" ")+1, UserSettings.getSetting("Y").length()));
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setBounds(1095, 9, 86, 20);
		tr8.add(textField_16);
		textField_16.setColumns(10);
		textField_16.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_33.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_33.setVisible(true);
			}
		});
		textField_16.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_16);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "Y", textField_15, textField_16, false);
				if(isLeft(e) && textField_16.getCaretPosition() == 0) {
					textField_15.requestFocus();
				}else if(isDown(e)) {
					textField_18.requestFocus();
				}else if(isRight(e) && textField_16.getCaretPosition() == textField_16.getText().length()) {
					textField_15.requestFocus();
				}else if(isUp(e)) {
					textField_14.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr9 = new TransparentRectangle();
		tr9.setBounds(55, 410, 1197, 39);
		bp.add(tr9);
		tr9.setLayout(null);
		
		textPane_9 = new JTextField();
		textPane_9.setDisabledTextColor(Color.BLACK);
		textPane_9.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_9.setText("Home Button");
		textPane_9.setRequestFocusEnabled(false);
		textPane_9.setFocusable(false);
		textPane_9.setFocusTraversalKeysEnabled(false);
		textPane_9.setEnabled(false);
		textPane_9.setEditable(false);
		textPane_9.setBounds(15, 9, 86, 20);
		tr9.add(textPane_9);

		lblNewLabel_34 = new JLabel("");
		lblNewLabel_34.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_34.setBounds(981, 4, 98, 30);
		lblNewLabel_34.setVisible(false);
		tr9.add(lblNewLabel_34);

		textField_17 = new JTextField();
		textField_17.setBorder(empty);
		textField_17.setText(UserSettings.getSetting("HOME").substring(0, UserSettings.getSetting("HOME").lastIndexOf(" ")));
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setBounds(987, 9, 86, 20);
		tr9.add(textField_17);
		textField_17.setColumns(10);
		textField_17.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_34.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_34.setVisible(true);
			}
		});
		textField_17.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_17);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "HOME", textField_17, textField_18, true);
				if(isLeft(e) && textField_17.getCaretPosition() == 0) {
					textField_18.requestFocus();
				}else if(isDown(e)) {
					textField_19.requestFocus();
				}else if(isRight(e) && textField_17.getCaretPosition() == textField_17.getText().length()) {
					textField_18.requestFocus();
				}else if(isUp(e)) {
					textField_15.requestFocus();
				}
			}
		});

		lblNewLabel_35 = new JLabel("");
		lblNewLabel_35.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_35.setBounds(1089, 4, 98, 30);
		lblNewLabel_35.setVisible(false);
		tr9.add(lblNewLabel_35);

		textField_18 = new JTextField();
		textField_18.setBorder(empty);
		textField_18.setText(UserSettings.getSetting("HOME").substring(UserSettings.getSetting("HOME").lastIndexOf(" ")+1, UserSettings.getSetting("HOME").length()));
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setBounds(1095, 9, 86, 20);
		tr9.add(textField_18);
		textField_18.setColumns(10);
		textField_18.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_35.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_35.setVisible(true);
			}
		});
		textField_18.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_18);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "HOME", textField_17, textField_18, false);
				if(isLeft(e) && textField_18.getCaretPosition() == 0) {
					textField_17.requestFocus();
				}else if(isDown(e)) {
					textField_20.requestFocus();
				}else if(isRight(e) && textField_18.getCaretPosition() == textField_18.getText().length()) {
					textField_17.requestFocus();
				}else if(isUp(e)) {
					textField_16.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr10 = new TransparentRectangle();
		tr10.setBounds(55, 456, 1197, 39);
		bp.add(tr10);
		tr10.setLayout(null);
		
		textPane_10 = new JTextField();
		textPane_10.setDisabledTextColor(Color.BLACK);
		textPane_10.setText("L Button");
		textPane_10.setRequestFocusEnabled(false);
		textPane_10.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_10.setFocusable(false);
		textPane_10.setFocusTraversalKeysEnabled(false);
		textPane_10.setEnabled(false);
		textPane_10.setEditable(false);
		textPane_10.setBounds(15, 9, 86, 20);
		tr10.add(textPane_10);

		lblNewLabel_36 = new JLabel("");
		lblNewLabel_36.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_36.setBounds(981, 4, 98, 30);
		lblNewLabel_36.setVisible(false);
		tr10.add(lblNewLabel_36);

		textField_19 = new JTextField();
		textField_19.setBorder(empty);
		textField_19.setText(UserSettings.getSetting("L").substring(0, UserSettings.getSetting("L").lastIndexOf(" ")));
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setBounds(987, 9, 86, 20);
		tr10.add(textField_19);
		textField_19.setColumns(10);
		textField_19.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_36.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_36.setVisible(true);
			}
		});
		textField_19.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_19);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "L", textField_19, textField_20, true);
				if(isLeft(e) && textField_19.getCaretPosition() == 0) {
					textField_20.requestFocus();
				}else if(isDown(e)) {
					textField_21.requestFocus();
				}else if(isRight(e) && textField_19.getCaretPosition() == textField_19.getText().length()) {
					textField_20.requestFocus();
				}else if(isUp(e)) {
					textField_17.requestFocus();
				}
			}
		});

		lblNewLabel_37 = new JLabel("");
		lblNewLabel_37.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_37.setBounds(1089, 4, 98, 30);
		lblNewLabel_37.setVisible(false);
		tr10.add(lblNewLabel_37);

		textField_20 = new JTextField();
		textField_20.setBorder(empty);
		textField_20.setText(UserSettings.getSetting("L").substring(UserSettings.getSetting("L").lastIndexOf(" ")+1, UserSettings.getSetting("L").length()));
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setBounds(1095, 9, 86, 20);
		tr10.add(textField_20);
		textField_20.setColumns(10);
		textField_20.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_37.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_37.setVisible(true);
			}
		});
		textField_20.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_20);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "L", textField_19, textField_20, false);
				if(isLeft(e) && textField_20.getCaretPosition() == 0) {
					textField_19.requestFocus();
				}else if(isDown(e)) {
					textField_22.requestFocus();
				}else if(isRight(e) && textField_20.getCaretPosition() == textField_20.getText().length()) {
					textField_19.requestFocus();
				}else if(isUp(e)) {
					textField_18.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr11 = new TransparentRectangle();
		tr11.setBounds(55, 502, 1197, 39);
		bp.add(tr11);
		tr11.setLayout(null);
		
		textPane_11 = new JTextField();
		textPane_11.setDisabledTextColor(Color.BLACK);
		textPane_11.setText("ZL Button");
		textPane_11.setRequestFocusEnabled(false);
		textPane_11.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_11.setFocusable(false);
		textPane_11.setFocusTraversalKeysEnabled(false);
		textPane_11.setEnabled(false);
		textPane_11.setEditable(false);
		textPane_11.setBounds(15, 9, 86, 20);
		tr11.add(textPane_11);

		lblNewLabel_38 = new JLabel("");
		lblNewLabel_38.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_38.setBounds(981, 4, 98, 30);
		lblNewLabel_38.setVisible(false);
		tr11.add(lblNewLabel_38);

		textField_21 = new JTextField();
		textField_21.setBorder(empty);
		textField_21.setText(UserSettings.getSetting("ZL").substring(0, UserSettings.getSetting("ZL").lastIndexOf(" ")));
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setBounds(987, 9, 86, 20);
		tr11.add(textField_21);
		textField_21.setColumns(10);
		textField_21.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_38.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_38.setVisible(true);
			}
		});
		textField_21.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_21);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "ZL", textField_21, textField_22, true);
				if(isLeft(e) && textField_21.getCaretPosition() == 0) {
					textField_22.requestFocus();
				}else if(isDown(e)) {
					textField_23.requestFocus();
				}else if(isRight(e) && textField_21.getCaretPosition() == textField_21.getText().length()) {
					textField_22.requestFocus();
				}else if(isUp(e)) {
					textField_19.requestFocus();
				}
			}
		});

		lblNewLabel_39 = new JLabel("");
		lblNewLabel_39.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_39.setBounds(1089, 4, 98, 30);
		lblNewLabel_39.setVisible(false);
		tr11.add(lblNewLabel_39);

		textField_22 = new JTextField();
		textField_22.setBorder(empty);
		textField_22.setText(UserSettings.getSetting("ZL").substring(UserSettings.getSetting("ZL").lastIndexOf(" ")+1, UserSettings.getSetting("ZL").length()));
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setBounds(1095, 9, 86, 20);
		tr11.add(textField_22);
		textField_22.setColumns(10);
		textField_22.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_39.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_39.setVisible(true);
			}
		});
		textField_22.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_22);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "ZL", textField_21, textField_22, false);
				if(isLeft(e) && textField_22.getCaretPosition() == 0) {
					textField_21.requestFocus();
				}else if(isDown(e)) {
					textField_24.requestFocus();
				}else if(isRight(e) && textField_22.getCaretPosition() == textField_22.getText().length()) {
					textField_21.requestFocus();
				}else if(isUp(e)) {
					textField_20.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr12 = new TransparentRectangle();
		tr12.setBounds(55, 548, 1197, 39);
		bp.add(tr12);
		tr12.setLayout(null);
		
		textPane_12 = new JTextField();
		textPane_12.setDisabledTextColor(Color.BLACK);
		textPane_12.setText("R Button");
		textPane_12.setRequestFocusEnabled(false);
		textPane_12.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_12.setFocusable(false);
		textPane_12.setFocusTraversalKeysEnabled(false);
		textPane_12.setEnabled(false);
		textPane_12.setEditable(false);
		textPane_12.setBounds(15, 9, 86, 20);
		tr12.add(textPane_12);

		lblNewLabel_40 = new JLabel("");
		lblNewLabel_40.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_40.setBounds(981, 4, 98, 30);
		lblNewLabel_40.setVisible(false);
		tr12.add(lblNewLabel_40);

		textField_23 = new JTextField();
		textField_23.setBorder(empty);
		textField_23.setText(UserSettings.getSetting("R").substring(0, UserSettings.getSetting("R").lastIndexOf(" ")));
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setBounds(987, 9, 86, 20);
		tr12.add(textField_23);
		textField_23.setColumns(10);
		textField_23.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_40.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_40.setVisible(true);
			}
		});
		textField_23.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_23);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "R", textField_23, textField_24, true);
				if(isLeft(e) && textField_23.getCaretPosition() == 0) {
					textField_24.requestFocus();
				}else if(isDown(e)) {
					textField_25.requestFocus();
				}else if(isRight(e) && textField_23.getCaretPosition() == textField_23.getText().length()) {
					textField_24.requestFocus();
				}else if(isUp(e)) {
					textField_21.requestFocus();
				}
			}
		});

		lblNewLabel_41 = new JLabel("");
		lblNewLabel_41.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_41.setBounds(1089, 4, 98, 30);
		lblNewLabel_41.setVisible(false);
		tr12.add(lblNewLabel_41);

		textField_24 = new JTextField();
		textField_24.setBorder(empty);
		textField_24.setText(UserSettings.getSetting("R").substring(UserSettings.getSetting("R").lastIndexOf(" ")+1, UserSettings.getSetting("R").length()));
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setBounds(1095, 9, 86, 20);
		tr12.add(textField_24);
		textField_24.setColumns(10);
		textField_24.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_41.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_41.setVisible(true);
			}
		});
		textField_24.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_24);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "R", textField_23, textField_24, false);
				if(isLeft(e) && textField_24.getCaretPosition() == 0) {
					textField_23.requestFocus();
				}else if(isDown(e)) {
					textField_26.requestFocus();
				}else if(isRight(e) && textField_24.getCaretPosition() == textField_24.getText().length()) {
					textField_23.requestFocus();
				}else if(isUp(e)) {
					textField_22.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr13 = new TransparentRectangle();
		tr13.setBounds(55, 594, 1197, 39);
		bp.add(tr13);
		tr13.setLayout(null);
		
		textPane_13 = new JTextField();
		textPane_13.setDisabledTextColor(Color.BLACK);
		textPane_13.setText("ZR Button");
		textPane_13.setRequestFocusEnabled(false);
		textPane_13.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_13.setFocusable(false);
		textPane_13.setFocusTraversalKeysEnabled(false);
		textPane_13.setEnabled(false);
		textPane_13.setEditable(false);
		textPane_13.setBounds(15, 9, 86, 20);
		tr13.add(textPane_13);

		lblNewLabel_42 = new JLabel("");
		lblNewLabel_42.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_42.setBounds(981, 4, 98, 30);
		lblNewLabel_42.setVisible(false);
		tr13.add(lblNewLabel_42);

		textField_25 = new JTextField();
		textField_25.setBorder(empty);
		textField_25.setText(UserSettings.getSetting("ZR").substring(0, UserSettings.getSetting("ZR").lastIndexOf(" ")));
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setBounds(987, 9, 86, 20);
		tr13.add(textField_25);
		textField_25.setColumns(10);
		textField_25.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_42.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_42.setVisible(true);
			}
		});
		textField_25.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_25);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "ZR", textField_25, textField_26, true);
				if(isLeft(e) && textField_25.getCaretPosition() == 0) {
					textField_26.requestFocus();
				}else if(isDown(e)) {
					textField_27.requestFocus();
				}else if(isRight(e) && textField_25.getCaretPosition() == textField_25.getText().length()) {
					textField_26.requestFocus();
				}else if(isUp(e)) {
					textField_23.requestFocus();
				}
			}
		});

		lblNewLabel_43 = new JLabel("");
		lblNewLabel_43.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_43.setBounds(1089, 4, 98, 30);
		lblNewLabel_43.setVisible(false);
		tr13.add(lblNewLabel_43);

		textField_26 = new JTextField();
		textField_26.setBorder(empty);
		textField_26.setText(UserSettings.getSetting("ZR").substring(UserSettings.getSetting("ZR").lastIndexOf(" ")+1, UserSettings.getSetting("ZR").length()));
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setBounds(1095, 9, 86, 20);
		tr13.add(textField_26);
		textField_26.setColumns(10);
		textField_26.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_43.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_43.setVisible(true);
			}
		});
		textField_26.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_26);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "ZR", textField_25, textField_26, false);
				if(isLeft(e) && textField_26.getCaretPosition() == 0) {
					textField_25.requestFocus();
				}else if(isDown(e)) {
					textField_28.requestFocus();
				}else if(isRight(e) && textField_26.getCaretPosition() == textField_26.getText().length()) {
					textField_25.requestFocus();
				}else if(isUp(e)) {
					textField_24.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr14 = new TransparentRectangle();
		tr14.setBounds(55, 640, 1197, 39);
		bp.add(tr14);
		tr14.setLayout(null);
		
		textPane_14 = new JTextField();
		textPane_14.setDisabledTextColor(Color.BLACK);
		textPane_14.setText("Plus Button");
		textPane_14.setRequestFocusEnabled(false);
		textPane_14.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_14.setFocusable(false);
		textPane_14.setFocusTraversalKeysEnabled(false);
		textPane_14.setEnabled(false);
		textPane_14.setEditable(false);
		textPane_14.setBounds(15, 9, 86, 20);
		tr14.add(textPane_14);

		lblNewLabel_44 = new JLabel("");
		lblNewLabel_44.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_44.setBounds(981, 4, 98, 30);
		lblNewLabel_44.setVisible(false);
		tr14.add(lblNewLabel_44);

		textField_27 = new JTextField();
		textField_27.setBorder(empty);
		textField_27.setText(UserSettings.getSetting("PLUS").substring(0, UserSettings.getSetting("PLUS").lastIndexOf(" ")));
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setBounds(987, 9, 86, 20);
		tr14.add(textField_27);
		textField_27.setColumns(10);
		textField_27.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_44.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_44.setVisible(true);
			}
		});
		textField_27.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_27);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "PLUS", textField_27, textField_28, true);
				if(isLeft(e) && textField_27.getCaretPosition() == 0) {
					textField_28.requestFocus();
				}else if(isDown(e)) {
					textField_29.requestFocus();
				}else if(isRight(e) && textField_27.getCaretPosition() == textField_27.getText().length()) {
					textField_28.requestFocus();
				}else if(isUp(e)) {
					textField_25.requestFocus();
				}
			}
		});

		lblNewLabel_45 = new JLabel("");
		lblNewLabel_45.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_45.setBounds(1089, 4, 98, 30);
		lblNewLabel_45.setVisible(false);
		tr14.add(lblNewLabel_45);

		textField_28 = new JTextField();
		textField_28.setBorder(empty);
		textField_28.setText(UserSettings.getSetting("PLUS").substring(UserSettings.getSetting("PLUS").lastIndexOf(" ")+1, UserSettings.getSetting("PLUS").length()));
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setBounds(1095, 9, 86, 20);
		tr14.add(textField_28);
		textField_28.setColumns(10);
		textField_28.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_45.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_45.setVisible(true);
			}
		});
		textField_28.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_28);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "PLUS", textField_27, textField_28, false);
				if(isLeft(e) && textField_28.getCaretPosition() == 0) {
					textField_27.requestFocus();
				}else if(isDown(e)) {
					textField_30.requestFocus();
				}else if(isRight(e) && textField_28.getCaretPosition() == textField_28.getText().length()) {
					textField_27.requestFocus();
				}else if(isUp(e)) {
					textField_26.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr15 = new TransparentRectangle();
		tr15.setBounds(55, 686, 1197, 39);
		bp.add(tr15);
		tr15.setLayout(null);
		
		textPane_15 = new JTextField();
		textPane_15.setDisabledTextColor(Color.BLACK);
		textPane_15.setText("Minus Button");
		textPane_15.setRequestFocusEnabled(false);
		textPane_15.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_15.setFocusable(false);
		textPane_15.setFocusTraversalKeysEnabled(false);
		textPane_15.setEnabled(false);
		textPane_15.setEditable(false);
		textPane_15.setBounds(15, 9, 86, 20);
		tr15.add(textPane_15);

		lblNewLabel_46 = new JLabel("");
		lblNewLabel_46.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_46.setBounds(981, 4, 98, 30);
		lblNewLabel_46.setVisible(false);
		tr15.add(lblNewLabel_46);

		textField_29 = new JTextField();
		textField_29.setBorder(empty);
		textField_29.setText(UserSettings.getSetting("MINUS").substring(0, UserSettings.getSetting("MINUS").lastIndexOf(" ")));
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setBounds(987, 9, 86, 20);
		tr15.add(textField_29);
		textField_29.setColumns(10);
		textField_29.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_46.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_46.setVisible(true);
			}
		});
		textField_29.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_29);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "MINUS", textField_29, textField_30, true);
				if(isLeft(e) && textField_29.getCaretPosition() == 0) {
					textField_30.requestFocus();
				}else if(isDown(e)) {
					textField_31.requestFocus();
				}else if(isRight(e) && textField_29.getCaretPosition() == textField_29.getText().length()) {
					textField_30.requestFocus();
				}else if(isUp(e)) {
					textField_27.requestFocus();
				}
			}
		});

		lblNewLabel_47 = new JLabel("");
		lblNewLabel_47.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_47.setBounds(1089, 4, 98, 30);
		lblNewLabel_47.setVisible(false);
		tr15.add(lblNewLabel_47);

		textField_30 = new JTextField();
		textField_30.setBorder(empty);
		textField_30.setText(UserSettings.getSetting("MINUS").substring(UserSettings.getSetting("MINUS").lastIndexOf(" ")+1, UserSettings.getSetting("MINUS").length()));
		textField_30.setHorizontalAlignment(SwingConstants.CENTER);
		textField_30.setBounds(1095, 9, 86, 20);
		tr15.add(textField_30);
		textField_30.setColumns(10);
		textField_30.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_47.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_47.setVisible(true);
			}
		});
		textField_30.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_30);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "MINUS", textField_29, textField_30, false);
				if(isLeft(e) && textField_30.getCaretPosition() == 0) {
					textField_29.requestFocus();
				}else if(isDown(e)) {
					textField_32.requestFocus();
				}else if(isRight(e) && textField_30.getCaretPosition() == textField_30.getText().length()) {
					textField_29.requestFocus();
				}else if(isUp(e)) {
					textField_28.requestFocus();
				}
			}
		});
		
		TransparentRectangle tr16 = new TransparentRectangle();
		tr16.setBounds(55, 732, 1197, 39);
		bp.add(tr16);
		tr16.setLayout(null);
		
		textPane_16 = new JTextField();
		textPane_16.setDisabledTextColor(Color.BLACK);
		textPane_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane_16.setText("Left Center");
		textPane_16.setRequestFocusEnabled(false);
		textPane_16.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_16.setFocusable(false);
		textPane_16.setFocusTraversalKeysEnabled(false);
		textPane_16.setEnabled(false);
		textPane_16.setEditable(false);
		textPane_16.setBounds(15, 9, 86, 20);
		tr16.add(textPane_16);

		lblNewLabel_48 = new JLabel("");
		lblNewLabel_48.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_48.setBounds(981, 4, 98, 30);
		lblNewLabel_48.setVisible(false);
		tr16.add(lblNewLabel_48);

		textField_31 = new JTextField();
		textField_31.setBorder(empty);
		textField_31.setText(UserSettings.getSetting("LEFTSTICK_CENTER").substring(0, UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" ")));
		textField_31.setHorizontalAlignment(SwingConstants.CENTER);
		textField_31.setBounds(987, 9, 86, 20);
		tr16.add(textField_31);
		textField_31.setColumns(10);
		textField_31.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_48.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_48.setVisible(true);
			}
		});
		textField_31.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_31);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "LEFTSTICK_CENTER", textField_31, textField_32, true);
				if(isLeft(e) && textField_31.getCaretPosition() == 0) {
					textField_32.requestFocus();
				}else if(isDown(e)) {
					textField_33.requestFocus();
				}else if(isRight(e) && textField_31.getCaretPosition() == textField_31.getText().length()) {
					textField_32.requestFocus();
				}else if(isUp(e)) {
					textField_29.requestFocus();
				}
			}
		});

		lblNewLabel_49 = new JLabel("");
		lblNewLabel_49.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_49.setBounds(1089, 4, 98, 30);
		lblNewLabel_49.setVisible(false);
		tr16.add(lblNewLabel_49);

		textField_32 = new JTextField();
		textField_32.setBorder(empty);
		textField_32.setText(UserSettings.getSetting("LEFTSTICK_CENTER").substring(UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("LEFTSTICK_CENTER").length()));
		textField_32.setHorizontalAlignment(SwingConstants.CENTER);
		textField_32.setBounds(1095, 9, 86, 20);
		tr16.add(textField_32);
		textField_32.setColumns(10);
		textField_32.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_49.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_49.setVisible(true);
			}
		});
		textField_32.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_32);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "LEFTSTICK_CENTER", textField_31, textField_32, false);
				if(isLeft(e) && textField_32.getCaretPosition() == 0) {
					textField_31.requestFocus();
				}else if(isDown(e)) {
					textField_34.requestFocus();
				}else if(isRight(e) && textField_32.getCaretPosition() == textField_32.getText().length()) {
					textField_31.requestFocus();
				}else if(isUp(e)) {
					textField_30.requestFocus();
				}
			}
		});

		TransparentRectangle tr17 = new TransparentRectangle();
		tr17.setBounds(55, 778, 1197, 39);
		bp.add(tr17);
		tr17.setLayout(null);
		
		textPane_17 = new JTextField();
		textPane_17.setDisabledTextColor(Color.BLACK);
		textPane_17.setText("Right Center");
		textPane_17.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane_17.setRequestFocusEnabled(false);
		textPane_17.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_17.setFocusable(false);
		textPane_17.setFocusTraversalKeysEnabled(false);
		textPane_17.setEnabled(false);
		textPane_17.setEditable(false);
		textPane_17.setBounds(15, 9, 86, 20);
		tr17.add(textPane_17);

		lblNewLabel_50 = new JLabel("");
		lblNewLabel_50.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_50.setBounds(981, 4, 98, 30);
		lblNewLabel_50.setVisible(false);
		tr17.add(lblNewLabel_50);

		textField_33 = new JTextField();
		textField_33.setBorder(empty);
		textField_33.setText(UserSettings.getSetting("RIGHTSTICK_CENTER").substring(0, UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" ")));
		textField_33.setHorizontalAlignment(SwingConstants.CENTER);
		textField_33.setBounds(987, 9, 86, 20);
		tr17.add(textField_33);
		textField_33.setColumns(10);
		textField_33.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_50.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_50.setVisible(true);
			}
		});
		textField_33.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_33);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "RIGHTSTICK_CENTER", textField_33, textField_34, true);
				if(isLeft(e) && textField_33.getCaretPosition() == 0) {
					textField_34.requestFocus();
				}else if(isDown(e)) {
					textField_1.requestFocus();
				}else if(isRight(e) && textField_33.getCaretPosition() == textField_33.getText().length()) {
					textField_34.requestFocus();
				}else if(isUp(e)) {
					textField_31.requestFocus();
				}
			}
		});

		lblNewLabel_51 = new JLabel("");
		lblNewLabel_51.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_51.setBounds(1089, 4, 98, 30);
		lblNewLabel_51.setVisible(false);
		tr17.add(lblNewLabel_51);

		textField_34 = new JTextField();
		textField_34.setBorder(empty);
		textField_34.setText(UserSettings.getSetting("RIGHTSTICK_CENTER").substring(UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("RIGHTSTICK_CENTER").length()));
		textField_34.setHorizontalAlignment(SwingConstants.CENTER);
		textField_34.setBounds(1095, 9, 86, 20);
		tr17.add(textField_34);
		textField_34.setColumns(10);
		textField_34.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_51.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_51.setVisible(true);
			}
		});
		textField_34.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_34);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "RIGHTSTICK_CENTER", textField_33, textField_34, false);
				if(isLeft(e) && textField_34.getCaretPosition() == 0) {
					textField_33.requestFocus();
				}else if(isDown(e)) {
					textField_2.requestFocus();
				}else if(isRight(e) && textField_34.getCaretPosition() == textField_34.getText().length()) {
					textField_33.requestFocus();
				}else if(isUp(e)) {
					textField_32.requestFocus();
				}
			}
		});
		
		/*
		 * Toggle button for activating MousePos.exe, located in Users/Pokebot/mousePosApp/MousePos.exe
		 */
		MousePosToggle = new JToggleButton("Coord App");
		MousePosToggle.setFocusable(false);
		MousePosToggle.addActionListener(e -> {
			if(MousePosToggle.isSelected()) {
				try {
					String path[] = new String[] {System.getenv("HOMEPATH") + File.separator + "Pokebot" + File.separator + "mousePosApp" + File.separator + "MousePos.exe"};
					mousePosProcess = Runtime.getRuntime().exec(path);
					//Waits app to close to then de-select toggle.
					executorService.execute(()-> {
						try {mousePosProcess.waitFor();}
						catch (InterruptedException e1) {e1.printStackTrace();}
						MousePosToggle.setSelected(false);
					});
				}
				catch(Exception ex) {ex.printStackTrace();}
			}else {
				mousePosProcess.destroy();
			}
		});
		MousePosToggle.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		MousePosToggle.setBounds(300, 11, 90, 23);
		MousePosToggle.setFont(pokemonFont.deriveFont(13F));
		MousePosToggle.setFocusPainted(false);
		MousePosToggle.setHorizontalAlignment(SwingConstants.CENTER);
		MousePosToggle.setVerticalAlignment(SwingConstants.VERTICAL);
		bp.add(MousePosToggle);
		
		defaultButton = new JButton("Default");
		defaultButton.setFont(pokemonFont.deriveFont(13F));
		defaultButton.setHorizontalAlignment(SwingConstants.CENTER);
		defaultButton.setVerticalAlignment(SwingConstants.VERTICAL);
		defaultButton.setForeground(Color.BLACK);
		defaultButton.setFocusPainted(false);
		defaultButton.setFocusable(false);
		defaultButton.addActionListener(e -> {
			textField_1.setText(DefaultSettings.UP_COORDS.substring(0, DefaultSettings.UP_COORDS.lastIndexOf(" ")));
			textField_2.setText(DefaultSettings.UP_COORDS.substring(DefaultSettings.UP_COORDS.lastIndexOf(" ")+1, DefaultSettings.UP_COORDS.length()));
			textField_3.setText(DefaultSettings.DOWN_COODS.substring(0, DefaultSettings.DOWN_COODS.lastIndexOf(" ")));
			textField_4.setText(DefaultSettings.DOWN_COODS.substring(DefaultSettings.DOWN_COODS.lastIndexOf(" ")+1, DefaultSettings.DOWN_COODS.length()));
			textField_5.setText(DefaultSettings.LEFT_COORDS.substring(0, DefaultSettings.LEFT_COORDS.lastIndexOf(" ")));
			textField_6.setText(DefaultSettings.LEFT_COORDS.substring(DefaultSettings.LEFT_COORDS.lastIndexOf(" ")+1, DefaultSettings.LEFT_COORDS.length()));
			textField_7.setText(DefaultSettings.RIGHT_COORDS.substring(0, DefaultSettings.RIGHT_COORDS.lastIndexOf(" ")));
			textField_8.setText(DefaultSettings.RIGHT_COORDS.substring(DefaultSettings.RIGHT_COORDS.lastIndexOf(" ")+1, DefaultSettings.RIGHT_COORDS.length()));
			textField_9.setText(DefaultSettings.A_COORDS.substring(0, DefaultSettings.A_COORDS.lastIndexOf(" ")));
			textField_10.setText(DefaultSettings.A_COORDS.substring(DefaultSettings.A_COORDS.lastIndexOf(" ")+1, DefaultSettings.A_COORDS.length()));
			textField_11.setText(DefaultSettings.B_COORDS.substring(0, DefaultSettings.B_COORDS.lastIndexOf(" ")));
			textField_12.setText(DefaultSettings.B_COORDS.substring(DefaultSettings.B_COORDS.lastIndexOf(" ")+1, DefaultSettings.B_COORDS.length()));
			textField_13.setText(DefaultSettings.X_COORDS.substring(0, DefaultSettings.X_COORDS.lastIndexOf(" ")));
			textField_14.setText(DefaultSettings.X_COORDS.substring(DefaultSettings.X_COORDS.lastIndexOf(" ")+1, DefaultSettings.X_COORDS.length()));
			textField_15.setText(DefaultSettings.Y_COORDS.substring(0, DefaultSettings.Y_COORDS.lastIndexOf(" ")));
			textField_16.setText(DefaultSettings.Y_COORDS.substring(DefaultSettings.Y_COORDS.lastIndexOf(" ")+1, DefaultSettings.Y_COORDS.length()));
			textField_17.setText(DefaultSettings.HOME_COORDS.substring(0, DefaultSettings.HOME_COORDS.lastIndexOf(" ")));
			textField_18.setText(DefaultSettings.HOME_COORDS.substring(DefaultSettings.HOME_COORDS.lastIndexOf(" ")+1, DefaultSettings.HOME_COORDS.length()));
			textField_19.setText(DefaultSettings.L_COORDS.substring(0, DefaultSettings.L_COORDS.lastIndexOf(" ")));
			textField_20.setText(DefaultSettings.L_COORDS.substring(DefaultSettings.L_COORDS.lastIndexOf(" ")+1, DefaultSettings.L_COORDS.length()));
			textField_21.setText(DefaultSettings.ZL_COORDS.substring(0, DefaultSettings.ZL_COORDS.lastIndexOf(" ")));
			textField_22.setText(DefaultSettings.ZL_COORDS.substring(DefaultSettings.ZL_COORDS.lastIndexOf(" ")+1, DefaultSettings.ZL_COORDS.length()));
			textField_23.setText(DefaultSettings.R_COORDS.substring(0, DefaultSettings.R_COORDS.lastIndexOf(" ")));
			textField_24.setText(DefaultSettings.R_COORDS.substring(DefaultSettings.R_COORDS.lastIndexOf(" ")+1, DefaultSettings.R_COORDS.length()));
			textField_25.setText(DefaultSettings.ZR_COORDS.substring(0, DefaultSettings.ZR_COORDS.lastIndexOf(" ")));
			textField_26.setText(DefaultSettings.ZR_COORDS.substring(DefaultSettings.ZR_COORDS.lastIndexOf(" ")+1, DefaultSettings.ZR_COORDS.length()));
			textField_27.setText(DefaultSettings.PLUS_COORDS.substring(0, DefaultSettings.PLUS_COORDS.lastIndexOf(" ")));
			textField_28.setText(DefaultSettings.PLUS_COORDS.substring(DefaultSettings.PLUS_COORDS.lastIndexOf(" ")+1, DefaultSettings.PLUS_COORDS.length()));
			textField_29.setText(DefaultSettings.MINUS_COORDS.substring(0, DefaultSettings.MINUS_COORDS.lastIndexOf(" ")));
			textField_30.setText(DefaultSettings.MINUS_COORDS.substring(DefaultSettings.MINUS_COORDS.lastIndexOf(" ")+1, DefaultSettings.MINUS_COORDS.length()));
			textField_31.setText(DefaultSettings.LEFTSTICK_COORDS.substring(0, DefaultSettings.LEFTSTICK_COORDS.lastIndexOf(" ")));
			textField_32.setText(DefaultSettings.LEFTSTICK_COORDS.substring(DefaultSettings.LEFTSTICK_COORDS.lastIndexOf(" ")+1, DefaultSettings.LEFTSTICK_COORDS.length()));
			textField_33.setText(DefaultSettings.RIGHTSTICK_COORDS.substring(0, DefaultSettings.RIGHTSTICK_COORDS.lastIndexOf(" ")));
			textField_34.setText(DefaultSettings.RIGHTSTICK_COORDS.substring(DefaultSettings.RIGHTSTICK_COORDS.lastIndexOf(" ")+1, DefaultSettings.RIGHTSTICK_COORDS.length()));
			UserSettings.addSetting("A", DefaultSettings.A_COORDS);
			UserSettings.addSetting("B", DefaultSettings.B_COORDS);
			UserSettings.addSetting("X", DefaultSettings.X_COORDS);
			UserSettings.addSetting("Y", DefaultSettings.Y_COORDS);
			UserSettings.addSetting("UP_DPAD", DefaultSettings.UP_COORDS);
			UserSettings.addSetting("DOWN_DPAD", DefaultSettings.DOWN_COODS);
			UserSettings.addSetting("LEFT_DPAD", DefaultSettings.LEFT_COORDS);
			UserSettings.addSetting("RIGHT_DPAD", DefaultSettings.RIGHT_COORDS);
			UserSettings.addSetting("PLUS", DefaultSettings.PLUS_COORDS);
			UserSettings.addSetting("MINUS", DefaultSettings.MINUS_COORDS);
			UserSettings.addSetting("HOME", DefaultSettings.HOME_COORDS);
			UserSettings.addSetting("L", DefaultSettings.L_COORDS);
			UserSettings.addSetting("ZL", DefaultSettings.ZL_COORDS);
			UserSettings.addSetting("R", DefaultSettings.R_COORDS);
			UserSettings.addSetting("ZR", DefaultSettings.ZR_COORDS);
			UserSettings.addSetting("LEFTSTICK_CENTER", DefaultSettings.LEFTSTICK_COORDS);
			UserSettings.addSetting("RIGHTSTICK_CENTER", DefaultSettings.RIGHTSTICK_COORDS);
			UserSettings.outputProperties();
		});
		defaultButton.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		defaultButton.setBounds(69, 11, 88, 23);
		bp.add(defaultButton);
	}

	/*
	 * Checks that the key entered is digit.
	 * @param key entered in a form of a char.
	 * @return true if is digit, false otherwise.
	 */
	public boolean isDigit(char c) {
		return Character.isDigit(c);
	}

	/*
	 * Checks that the key entered is alphabetic.
	 * @param key entered in a form of a char.
	 * @return true if is alphabetic, false otherwise.
	 */
	public boolean isAlphabetic(char c) {
		return Character.isAlphabetic(c);
	}

	/*
	 * Checks that the key entered is backspace.
	 * @param key entered in a form of a char.
	 * @return true if is backspace, false otherwise.
	 */
	public boolean isBackSpace(char c) {
		return c == KeyEvent.VK_BACK_SPACE;
	}

	/*
	 * Checks that the key entered is delete.
	 * @param key entered in a form of a char.
	 * @return true if is delete, false otherwise.
	 */
	public boolean isDelete(char c) {
		return c == KeyEvent.VK_DELETE;
	}

	/*
	 * Checks that the key entered is left direction.
	 * @param key entered in a form of a KeyEvent.
	 * @return true if is left direction, false otherwise.
	 */
	public boolean isLeft(KeyEvent e) {
		return e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_KP_LEFT;
	}

	/*
	 * Checks that the key entered is left direction.
	 * @param key entered in a form of a KeyEvent.
	 * @return true if is left direction, false otherwise.
	 */
	public boolean isRight(KeyEvent e) {
		return e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_KP_RIGHT;
	}

	/*
	 * Checks that the key entered is up direction.
	 * @param key entered in a form of a KeyEvent.
	 * @return true if is up direction, false otherwise.
	 */
	public boolean isUp(KeyEvent e) {
		return e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_KP_UP;
	}

	/*
	 * Checks that the key entered is down direction.
	 * @param key entered in a form of a KeyEvent.
	 * @return true if is down direction, false otherwise.
	 */
	public boolean isDown(KeyEvent e) {
		return e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_KP_DOWN;
	}

	/*
	 * Checks that the key entered are move or remove keys.
	 * @param key entered in a form of a KeyEvent.
	 * @return true if is move or remove keys, false otherwise.
	 */
	public boolean isMoveOrRemoveKeys(KeyEvent e, char c) {
		return isBackSpace(c) || isDelete(c) || isLeft(e) || isRight(e) || isUp(e) || isDown(e);
	}

	public void textFieldLogicTyped(KeyEvent e, JTextField textField) {
		char c = e.getKeyChar();
		if(textField.getSelectedText() != null && !(isDigit(c))) 
			e.consume();
		else if(!(isMoveOrRemoveKeys(e, c) || isDigit(c))) 
			e.consume();
		else if(isDigit(c) && textField.getText().length() == 4 && textField.getSelectedText() == null) 
			e.consume();
		else if(isDigit(c) && textField.getText().equals("0") && textField.getCaretPosition() > 0)
			e.consume();
	}

	public void textFieldLogicPressed(KeyEvent e, String userSettingKey, JTextField textFieldX, 
			JTextField textFieldY, Boolean isX) {
		char c = e.getKeyChar();
		String userSettingValue = "";
		String userSetting = UserSettings.getSetting(userSettingKey);
		if(isX)
			userSettingValue = userSetting.substring(0, userSetting.lastIndexOf(" "));
		else
			userSettingValue = userSetting.substring(userSetting.lastIndexOf(" ")+1, userSetting.length());
		if(textFieldX.isEditable() && textFieldY.isEditable()) {
			inputTextFieldLogicForBot(e, c, textFieldX, textFieldY, userSettingValue, userSettingKey, isX);
			deleteTextFieldLogic(c, textFieldX, textFieldY, userSettingValue, userSettingKey, isX);
		}
	}
	
	public void inputTextFieldLogicForBot(KeyEvent e, char c, JTextField textFieldX, JTextField textFieldY, 
			String userSettingValue, String userSettingKey, Boolean isX) {
		if(!(isMoveOrRemoveKeys(e, c) || isDigit(c))) {
			getToolkit().beep();
			e.consume();
		}
		if(isX) {
			if(textFieldX.getSelectedText() != null && isDigit(c)) {
				StringBuilder str= new StringBuilder(userSettingValue);
				str.delete(textFieldX.getSelectionStart(), textFieldX.getSelectionEnd());
				if(str.length() == 0)
					str.append(c);
				else
					str.insert(textFieldX.getCaretPosition(), c);
				UserSettings.addSetting(userSettingKey, str.toString() + " " + textFieldY.getText());
				UserSettings.outputProperties();
			}else if(isDigit(c) && userSettingValue.length() < 4) {
				if(textFieldX.getText().equals("0") && textFieldX.getCaretPosition() > 0) {
					getToolkit().beep();
					e.consume();
					return;
				}
				StringBuilder str= new StringBuilder(userSettingValue);
				str.insert(textFieldX.getCaretPosition(), c);
				UserSettings.addSetting(userSettingKey, str.toString() + " " + textFieldY.getText());
				UserSettings.outputProperties();
			}else if(isDigit(c)) {
				getToolkit().beep();
				e.consume();
			}
		}else {
			if(textFieldY.getSelectedText() != null && isDigit(c)) {
				StringBuilder str= new StringBuilder(userSettingValue);
				str.delete(textFieldY.getSelectionStart(), textFieldY.getSelectionEnd());
				if(str.length() == 0)
					str.append(c);
				else
					str.insert(textFieldY.getCaretPosition(), c);
				UserSettings.addSetting(userSettingKey, textFieldX.getText() + " " + str.toString());
				UserSettings.outputProperties();
			}else if(isDigit(c) && userSettingValue.length() < 4) {
				if(textFieldY.getText().equals("0") && textFieldY.getCaretPosition() > 0) {
					getToolkit().beep();
					e.consume();
					return;
				}
				StringBuilder str= new StringBuilder(userSettingValue);
				str.insert(textFieldY.getCaretPosition(), c);
				UserSettings.addSetting(userSettingKey, textFieldX.getText() + " " + str.toString());
				UserSettings.outputProperties();
			}else if(isDigit(c)) {
				getToolkit().beep();
				e.consume();
			}
		}
	}
	
	public void deleteTextFieldLogic(char c, JTextField textFieldX, JTextField textFieldY, String userSettingValue, String userSettingKey, Boolean isX) {
		if(isX) {
			if(textFieldX.getSelectedText() != null && (isBackSpace(c) || isDelete(c))) {
				StringBuilder str = new StringBuilder(userSettingValue); 
				str.delete(textFieldX.getSelectionStart(), textFieldX.getSelectionEnd());
				UserSettings.addSetting(userSettingKey, str.toString() + " " + textFieldY.getText());
				UserSettings.outputProperties();
			}else if(isBackSpace(c) && textFieldX.getCaretPosition() != 0) {
				StringBuilder str = new StringBuilder(userSettingValue);
				str.deleteCharAt(textFieldX.getCaretPosition()-1);
				UserSettings.addSetting(userSettingKey, str.toString() + " " + textFieldY.getText());
				UserSettings.outputProperties();
			}else if(isDelete(c) && textFieldX.getCaretPosition() != textFieldX.getText().length()) {
				StringBuilder str = new StringBuilder(userSettingValue);
				str.deleteCharAt(textFieldX.getCaretPosition());
				UserSettings.addSetting(userSettingKey, str.toString() + " " + textFieldY.getText());
				UserSettings.outputProperties();
			}
		}else {
			if(textFieldY.getSelectedText() != null && (isBackSpace(c) || isDelete(c))) {
				StringBuilder str = new StringBuilder(userSettingValue); 
				str.delete(textFieldY.getSelectionStart(), textFieldY.getSelectionEnd());
				UserSettings.addSetting(userSettingKey, textFieldX.getText() + " " + str.toString());
				UserSettings.outputProperties();
			}else if(isBackSpace(c) && textFieldY.getCaretPosition() != 0) {
				StringBuilder str = new StringBuilder(userSettingValue);
				str.deleteCharAt(textFieldY.getCaretPosition()-1);
				UserSettings.addSetting(userSettingKey, textFieldX.getText() + " " + str.toString());
				UserSettings.outputProperties();
			}else if(isDelete(c) && textFieldY.getCaretPosition() != textFieldY.getText().length()) {
				StringBuilder str = new StringBuilder(userSettingValue);
				str.deleteCharAt(textFieldY.getCaretPosition());
				UserSettings.addSetting(userSettingKey, textFieldX.getText() + " " + str.toString());
				UserSettings.outputProperties();
			}
		}
	}
}
