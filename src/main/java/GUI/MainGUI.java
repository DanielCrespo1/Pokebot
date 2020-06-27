package GUI;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Robot;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import DataManagment.*;
import pokemonBot.BargainingBot;
import pokemonBot.BerryFarmBot;
import pokemonBot.DeleteBoxBot;
import pokemonBot.EggFarmBot;
import pokemonBot.FindMyShinyBot;
import pokemonBot.FossilBot;
import pokemonBot.MasterballBot;
import pokemonBot.SpamABot;
import pokemonBot.SurpriseTradeBot;
import pokemonBot.TestBot;
import pokemonBot.WattFarmBot;
import org.apache.commons.lang3.SystemUtils;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainGUI extends JFrame {

	public enum Fossil {
		DRACOZOLT, ARCTOZOLT, DRACOVISH, ARCTOVISH
	}

	private static final long serialVersionUID = 2270012004089476761L;
	public static Process streamPhoneProcess;
	private final ExecutorService executorService = Executors.newCachedThreadPool();
	private boolean wattFarmOnline;
	private boolean calibrateWasActive;
	private static final Point point = new Point();
	private final JLabel lblNewLabel_1;
	private final JLabel lblNewLabel_2;
	private final JLabel lblNewLabel_3;
	private final JLabel lblNewLabel_4;
	private final JLabel lblNewLabel_5;
	private final JLabel lblNewLabel_6;
	private final JLabel lblNewLabel_7;
	private final JLabel lblNewLabel_8;
	private final JLabel lblNewLabel_9;
	private final JLabel lblNewLabel_10;
	private final JLabel lblNewLabel_11;
	private final JLabel lblNewLabel_12;
	private final JLabel lblNewLabel_13;
	private final JLabel lblNewLabel_14;
	private final JLabel lblNewLabel_15;
	private final JLabel lblNewLabel_16;
	private final JLabel lblNewLabel_17;
	private final JTextField textField_1;
	private final JTextField textField_2;
	private final JTextField textField_3;
	private final JTextField textField_4;
	private final JTextField textField_5;
	private final JTextField textField_6;
	private final JTextField textField_7;
	private final JTextField textField_8;
	private final JTextField textField_9;
	private final JTextField textField_10;
	private final JTextField textField_11;
	private final JTextField textField_12;
	private final JTextField textField_13;
	private final JTextField textField_14;
	private final JTextField textField_15;
	private final JTextField textField_16;
	private JTextField txtHotkeyTaken_1;
	private JTextField txtHotkeyTaken_2;
	private JTextField txtHotkeyTaken_3;
	private JTextField txtHotkeyTaken_4;
	private JTextField txtHotkeyTaken_5;
	private JTextField txtHotkeyTaken_6;
	private JTextField txtHotkeyTaken_7;
	private JTextField txtHotkeyTaken_8;
	private JTextField txtHotkeyTaken_9;
	private JTextField txtHotkeyTaken_10;
	private JTextField txtHotkeyTaken_11;
	private final JComboBox<Object> comboBox;
	private Fossil fossilSelected;
	private final JToggleButton StreamingPhoneToggle;
	private final JToggleButton StartBotToggle;
	public static JToggleButton calibrateButton;
	public static JButton advanceButton;
	private AdvanceSettings advSet;
	private JButton defaultButton;
	private JCheckBox chckbxOnlineGlitch_1;
	private EggFarmBot eggFarmMacro;
	private SurpriseTradeBot surpriseTradeMacro;
	private DeleteBoxBot deleteBoxMacro;
	private WattFarmBot wattFarmMacro;
	private MasterballBot masterbalMacro;
	private SpamABot spamAMacro;
	private BerryFarmBot berryMacro;
	private FindMyShinyBot findMyShiny;
	private BargainingBot bargainingMacro;
	private FossilBot fossilMacro;
	private TestBot test;

	//Main GUI for Pokebot
	public static void main(String[] args) throws IOException, NumberFormatException, FontFormatException {
		File pokebotFolder = new File(System.getenv("HOMEPATH")+ File.separator + "Pokebot");
		if (!pokebotFolder.isDirectory()) {
			//Creates a folder called Pokebot
			pokebotFolder.mkdir();

			//Copies exe files from zip folder inside resources to /Users/Pokebot folder
			try (ZipInputStream zis = new ZipInputStream(Objects.requireNonNull(MainGUI.class.getClassLoader().getResourceAsStream("externalApps.zip")))) {
				extract(zis, new File(System.getenv("HOMEPATH") + File.separator + "Pokebot"));
			}
		}

		//Setting up property file
		new PropertySetup();

		//Set the log level to only display warnings and errors.
		//Get the logger for "org.jnativehook" and set the level to warning.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);

		logger.setUseParentHandlers(false);
		try {GlobalScreen.registerNativeHook();}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
			System.exit(1);
		}
		MainGUI frame = new MainGUI();
		frame.setVisible(true);
	}

	public MainGUI() throws NumberFormatException, IOException, FontFormatException {
		super("Pokebot -By dandanXD");
		advSet = new AdvanceSettings();
		calibrateWasActive = false;
		fossilSelected = Fossil.DRACOZOLT;
		Border empty = BorderFactory.createEmptyBorder();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1280, 800);
		setLocationRelativeTo(null);
		ImageIcon pokebotLogo = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Pokebot.jpg")));
		setIconImage(pokebotLogo.getImage());
		ImageIcon bpIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Background.jpg")));
		BackgroundPanel bp = new BackgroundPanel(bpIcon.getImage());
		setContentPane(bp);
		bp.setLayout(null);
		Font pokemonFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("externalFonts/pokemonSwordFont.otf"))).deriveFont(22F);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(pokemonFont);

		//When window is closed the lock file is deleted and if any exe processes are running, they get closed.
		addWindowListener(new WindowAdapter(){			
			public void windowClosing(WindowEvent e) {
				String outputPropertiesPath = System.getenv("HOMEPATH")+ File.separator + "Pokebot" + File.separator + ".pokebot.lock";
				File f = new File(outputPropertiesPath);
				f.delete();
				if(AdvanceSettings.mousePosProcess != null)
					AdvanceSettings.mousePosProcess.destroy();
				if(streamPhoneProcess != null)
					streamPhoneProcess.destroy();
			}
		});

		//This gives the ability to drag the window from the panel instead of only the frame
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

		JLabel lblstreamingPhone = new JLabel("<html><u>Streaming Phone App</u></html>");
		lblstreamingPhone.setForeground(Color.BLACK);
		lblstreamingPhone.setFont(pokemonFont);
		lblstreamingPhone.setBounds(686, 11, 209, 30);
		bp.add(lblstreamingPhone);

		lblstreamingPhone = new JLabel("<html><u>Pokebot Tutorials</u></html>");
		lblstreamingPhone.setForeground(Color.BLACK);
		lblstreamingPhone.setFont(pokemonFont);
		lblstreamingPhone.setBounds(1061, 11, 182, 30);
		bp.add(lblstreamingPhone);

		JLabel lblStartBot = new JLabel("<html><u>Start Bot</u></html>");
		lblStartBot.setForeground(Color.BLACK);
		lblStartBot.setFont(pokemonFont);
		lblStartBot.setBounds(588, 351, 103, 30);
		bp.add(lblStartBot);

		JLabel lblAdvanceSetting = new JLabel("<html><u>Advance Setting</u></html>");
		lblAdvanceSetting.setForeground(Color.BLACK);
		lblAdvanceSetting.setFont(pokemonFont);
		lblAdvanceSetting.setBounds(429, 675, 169, 30);
		bp.add(lblAdvanceSetting);

		JLabel lblCalibrateButtons = new JLabel("<html><u>Calibrate Buttons</u></html>");
		lblCalibrateButtons.setForeground(Color.BLACK);
		lblCalibrateButtons.setFont(pokemonFont);
		lblCalibrateButtons.setBounds(401, 11, 182, 30);
		bp.add(lblCalibrateButtons);

		JLabel lblSetDefaultSetting = new JLabel("<html><u>Set Default Setting</u></html>");
		lblSetDefaultSetting.setForeground(Color.BLACK);
		lblSetDefaultSetting.setFont(pokemonFont);
		lblSetDefaultSetting.setBounds(727, 675, 209, 30);
		bp.add(lblSetDefaultSetting);

		JLabel lblHotKey = new JLabel("<html><u>Hotkey</u></html>");
		lblHotKey.setForeground(Color.BLACK);
		lblHotKey.setFont(pokemonFont);
		lblHotKey.setBounds(220, 48, 73, 30);
		bp.add(lblHotKey);

		JLabel lblEggFarm_1 = new JLabel("Egg Farm");
		lblEggFarm_1.setForeground(Color.BLACK);
		lblEggFarm_1.setFont(pokemonFont);
		lblEggFarm_1.setBounds(52, 52, 98, 30);
		bp.add(lblEggFarm_1);

		JLabel lblEggFarm_2 = new JLabel("Egg Farm");
		lblEggFarm_2.setForeground(Color.BLACK);
		lblEggFarm_2.setFont(pokemonFont);
		lblEggFarm_2.setBounds(1071, 52, 98, 30);
		bp.add(lblEggFarm_2);

		JLabel lblSurpriseTrade_1 = new JLabel("Surprise Trade");
		lblSurpriseTrade_1.setForeground(Color.BLACK);
		lblSurpriseTrade_1.setFont(pokemonFont);
		lblSurpriseTrade_1.setBounds(52, 111, 160, 30);
		bp.add(lblSurpriseTrade_1);

		JLabel lblSurpriseTrade_2 = new JLabel("Surprise Trade");
		lblSurpriseTrade_2.setForeground(Color.BLACK);
		lblSurpriseTrade_2.setFont(pokemonFont);
		lblSurpriseTrade_2.setBounds(1071, 111, 160, 30);
		bp.add(lblSurpriseTrade_2);

		JLabel lblDeleteBox_1 = new JLabel("Delete Box");
		lblDeleteBox_1.setForeground(Color.BLACK);
		lblDeleteBox_1.setFont(pokemonFont);
		lblDeleteBox_1.setBounds(52, 170, 110, 30);
		bp.add(lblDeleteBox_1);

		JLabel lblDeleteBox_2 = new JLabel("Delete Box");
		lblDeleteBox_2.setForeground(Color.BLACK);
		lblDeleteBox_2.setFont(pokemonFont);
		lblDeleteBox_2.setBounds(1071, 170, 110, 30);
		bp.add(lblDeleteBox_2);

		JLabel lblWattFarm_1 = new JLabel("Watt Farm");
		lblWattFarm_1.setForeground(Color.BLACK);
		lblWattFarm_1.setFont(pokemonFont);
		lblWattFarm_1.setBounds(52, 229, 110, 30);
		bp.add(lblWattFarm_1);

		JLabel lblWattFarm_2 = new JLabel("Watt Farm");
		lblWattFarm_2.setForeground(Color.BLACK);
		lblWattFarm_2.setFont(pokemonFont);
		lblWattFarm_2.setBounds(1071, 229, 110, 30);
		bp.add(lblWattFarm_2);

		JLabel lblMasterballFarm_1 = new JLabel("Masterball Farm");
		lblMasterballFarm_1.setForeground(Color.BLACK);
		lblMasterballFarm_1.setFont(pokemonFont);
		lblMasterballFarm_1.setBounds(52, 288, 176, 30);
		bp.add(lblMasterballFarm_1);

		JLabel lblMasterballFarm_2 = new JLabel("Masterball Farm");
		lblMasterballFarm_2.setForeground(Color.BLACK);
		lblMasterballFarm_2.setFont(pokemonFont);
		lblMasterballFarm_2.setBounds(1071, 288, 176, 30);
		bp.add(lblMasterballFarm_2);

		JLabel lblSpamA_1 = new JLabel("Spaming A");
		lblSpamA_1.setForeground(Color.BLACK);
		lblSpamA_1.setFont(pokemonFont);
		lblSpamA_1.setBounds(52, 347, 110, 30);
		bp.add(lblSpamA_1);

		JLabel lblSpamA_2 = new JLabel("Spaming A");
		lblSpamA_2.setForeground(Color.BLACK);
		lblSpamA_2.setFont(pokemonFont);
		lblSpamA_2.setBounds(1071, 347, 110, 30);
		bp.add(lblSpamA_2);

		JLabel lblBerryFarm_1 = new JLabel("Berry Farm");
		lblBerryFarm_1.setForeground(Color.BLACK);
		lblBerryFarm_1.setFont(pokemonFont);
		lblBerryFarm_1.setBounds(52, 406, 121, 30);
		bp.add(lblBerryFarm_1);

		JLabel lblBerryFarm_2 = new JLabel("Berry Farm");
		lblBerryFarm_2.setForeground(Color.BLACK);
		lblBerryFarm_2.setFont(pokemonFont);
		lblBerryFarm_2.setBounds(1071, 406, 121, 30);
		bp.add(lblBerryFarm_2);

		JLabel lblFindMyShiny_1 = new JLabel("Find my shiny");
		lblFindMyShiny_1.setForeground(Color.BLACK);
		lblFindMyShiny_1.setFont(pokemonFont);
		lblFindMyShiny_1.setBounds(52, 465, 133, 30);
		bp.add(lblFindMyShiny_1);

		JLabel lblFindMyShiny_2 = new JLabel("Find my shiny");
		lblFindMyShiny_2.setForeground(Color.BLACK);
		lblFindMyShiny_2.setFont(pokemonFont);
		lblFindMyShiny_2.setBounds(1071, 465, 133, 30);
		bp.add(lblFindMyShiny_2);

		JLabel lblBargaining_1 = new JLabel("Bargaining Bot");
		lblBargaining_1.setForeground(Color.BLACK);
		lblBargaining_1.setFont(pokemonFont);
		lblBargaining_1.setBounds(52, 524, 139, 30);
		bp.add(lblBargaining_1);

		JLabel lblBargaining_2 = new JLabel("Bargaining Bot");
		lblBargaining_2.setForeground(Color.BLACK);
		lblBargaining_2.setFont(pokemonFont);
		lblBargaining_2.setBounds(1071, 524, 193, 30);
		bp.add(lblBargaining_2);

		JLabel lblFossile_1 = new JLabel("Fossile Bot");
		lblFossile_1.setForeground(Color.BLACK);
		lblFossile_1.setFont(new Font("Sword", Font.PLAIN, 22));
		lblFossile_1.setBounds(52, 583, 121, 30);
		bp.add(lblFossile_1);

		JLabel lblTestAllButtons = new JLabel("Test All Buttons");
		lblTestAllButtons.setForeground(Color.BLACK);
		lblTestAllButtons.setFont(pokemonFont);
		lblTestAllButtons.setBounds(52, 642, 169, 30);
		bp.add(lblTestAllButtons);

		JLabel lblHowTo = new JLabel("How to use Pokebot");
		lblHowTo.setForeground(Color.BLACK);
		lblHowTo.setFont(pokemonFont);
		lblHowTo.setBounds(1071, 583, 193, 30);
		bp.add(lblHowTo);

		JLabel lblSettingsForPokebot = new JLabel("<html><u>Settings for Pokebot</u></html>");
		lblSettingsForPokebot.setBounds(30, 11, 214, 30);
		lblSettingsForPokebot.setFont(pokemonFont);
		lblSettingsForPokebot.setForeground(Color.BLACK);
		bp.add(lblSettingsForPokebot);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_1.setBounds(56, 75, 98, 30);
		lblNewLabel_1.setVisible(false);
		bp.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Seconds for bot to go in circles when hatching eggs.");
		textField_1.setBorder(empty);
		textField_1.setText(UserSettings.getSetting("EGG_SEC"));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(62, 80, 86, 20);
		bp.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_1.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_1.setVisible(true);
			}
		});
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_1, 3, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "EGG_SEC", textField_1, 3, true);
				if(isLeft(e) && textField_1.getCaretPosition() == 0) {
					textField_2.requestFocus();
				}else if(isDown(e)) {
					textField_3.requestFocus();
				}else if(isRight(e) && textField_1.getCaretPosition() == textField_1.getText().length()) {
					textField_2.requestFocus();
				}else if(isUp(e)) {
					textField_16.requestFocus();
				}
			}
		});

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_2.setBounds(208, 75, 98, 30);
		lblNewLabel_2.setVisible(false);
		bp.add(lblNewLabel_2);

		textField_2 = new UpperJTextField();
		textField_2.setToolTipText("Hotkey");
		textField_2.setBorder(empty);
		textField_2.setText(UserSettings.getSetting("EGG_HOTKEY"));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(214, 80, 86, 20);
		bp.add(textField_2);
		textField_2.setColumns(10);
		textField_2.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_2.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_2.setVisible(true);
			}
		});
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_2, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "EGG_HOTKEY", textField_2, 1, true);
				if(isLeft(e) && textField_2.getCaretPosition() == 0) {
					textField_1.requestFocus();
				}else if(isDown(e)) {
					textField_4.requestFocus();
				}else if(isRight(e) && textField_2.getCaretPosition() == textField_2.getText().length()) {
					textField_1.requestFocus();
				}else if(isUp(e)) {
					textField_16.requestFocus();
				}
			}
		});

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_3.setBounds(56, 134, 98, 30);
		lblNewLabel_3.setVisible(false);
		bp.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setToolTipText("Number of boxes to trade.");
		textField_3.setBorder(empty);
		textField_3.setText(UserSettings.getSetting("SURPRISE_BOXES"));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(62, 139, 86, 20);
		bp.add(textField_3);
		textField_3.setColumns(10);
		textField_3.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_3.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_3.setVisible(true);
			}
		});
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_3, 2, false);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "SURPRISE_BOXES", textField_3, 2, false);
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

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_4.setBounds(208, 134, 98, 30);
		lblNewLabel_4.setVisible(false);
		bp.add(lblNewLabel_4);

		textField_4 = new UpperJTextField();
		textField_4.setToolTipText("Hotkey");
		textField_4.setBorder(empty);
		textField_4.setText(UserSettings.getSetting("SURPRISE_HOTKEY"));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(214, 139, 86, 20);
		bp.add(textField_4);
		textField_4.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_4.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_4.setVisible(true);
			}
		});
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_4, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "SURPRISE_HOTKEY", textField_4, 1, true);
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

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_5.setBounds(56, 193, 98, 30);
		lblNewLabel_5.setVisible(false);
		bp.add(lblNewLabel_5);

		textField_5 = new JTextField();
		textField_5.setToolTipText("Number of boxes to delete.");
		textField_5.setBorder(empty);
		textField_5.setText(UserSettings.getSetting("DELETE_BOXES"));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(62, 198, 86, 20);
		bp.add(textField_5);
		textField_5.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_5.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_5.setVisible(true);
			}
		});
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_5, 2, false);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "DELETE_BOXES", textField_5, 2, false);
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

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_6.setBounds(208, 193, 98, 30);
		lblNewLabel_6.setVisible(false);
		bp.add(lblNewLabel_6);

		textField_6 = new UpperJTextField();
		textField_6.setToolTipText("Hotkey");
		textField_6.setBorder(empty);
		textField_6.setText(UserSettings.getSetting("DELETE_HOTKEY"));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		textField_6.setBounds(214, 198, 86, 20);
		bp.add(textField_6);
		textField_6.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_6.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_6.setVisible(true);
			}
		});
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_6, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "DELETE_HOTKEY", textField_6, 1, true);
				if(isLeft(e) && textField_6.getCaretPosition() == 0) {
					textField_5.requestFocus();
				}else if(isDown(e)) {
					textField_7.requestFocus();
				}else if(isRight(e) && textField_6.getCaretPosition() == textField_6.getText().length()) {
					textField_5.requestFocus();
				}else if(isUp(e)) {
					textField_4.requestFocus();
				}
			}
		});

		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_7.setBounds(208, 252, 98, 30);
		lblNewLabel_7.setVisible(false);
		bp.add(lblNewLabel_7);

		textField_7 = new UpperJTextField();
		textField_7.setToolTipText("Hotkey");
		textField_7.setBorder(empty);
		textField_7.setText(UserSettings.getSetting("WATT_HOTKEY"));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		textField_7.setBounds(214, 257, 86, 20);
		bp.add(textField_7);
		textField_7.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_7.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_7.setVisible(true);
			}
		});
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_7, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "WATT_HOTKEY", textField_7, 1, true);
				if(isLeft(e) && textField_7.getCaretPosition() == 0) {
					//add focus here
				}else if(isDown(e)) {
					textField_8.requestFocus();
				}else if(isRight(e) && textField_7.getCaretPosition() == textField_7.getText().length()) {
					//add focus here
				}else if(isUp(e)) {
					textField_6.requestFocus();
				}
			}
		});

		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_8.setBounds(208, 311, 98, 30);
		lblNewLabel_8.setVisible(false);
		bp.add(lblNewLabel_8);

		textField_8 = new UpperJTextField();
		textField_8.setToolTipText("Hotkey");
		textField_8.setBorder(empty);
		textField_8.setText(UserSettings.getSetting("MASTERBALL_HOTKEY"));
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		textField_8.setBounds(214, 316, 86, 20);
		bp.add(textField_8);
		textField_8.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_8.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_8.setVisible(true);
			}
		});
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_8, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "MASTERBALL_HOTKEY", textField_8, 1, true);
				if(isLeft(e) && textField_8.getCaretPosition() == 0) {
					//add focus here
				}else if(isDown(e)) {
					textField_9.requestFocus();
				}else if(isRight(e) && textField_8.getCaretPosition() == textField_8.getText().length()) {
					//add focus here
				}else if(isUp(e)) {
					textField_7.requestFocus();
				}
			}
		});

		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_9.setBounds(208, 370, 98, 30);
		lblNewLabel_9.setVisible(false);
		bp.add(lblNewLabel_9);

		textField_9 = new UpperJTextField();
		textField_9.setToolTipText("Hotkey");
		textField_9.setBorder(empty);
		textField_9.setText(UserSettings.getSetting("SPAM_A_HOTKEY"));
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setColumns(10);
		textField_9.setBounds(214, 375, 86, 20);
		bp.add(textField_9);
		textField_9.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_9.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_9.setVisible(true);
			}
		});
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_9, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "SPAM_A_HOTKEY", textField_9, 1, true);
				if(isLeft(e) && textField_9.getCaretPosition() == 0) {
					//add focus here
				}else if(isDown(e)) {
					textField_10.requestFocus();
				}else if(isRight(e) && textField_9.getCaretPosition() == textField_9.getText().length()) {
					//add focus here
				}else if(isUp(e)) {
					textField_8.requestFocus();
				}
			}
		});

		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_10.setBounds(208, 429, 98, 30);
		lblNewLabel_10.setVisible(false);
		bp.add(lblNewLabel_10);

		textField_10 = new UpperJTextField();
		textField_10.setToolTipText("Hotkey");
		textField_10.setBorder(empty);
		textField_10.setText(UserSettings.getSetting("BERRY_HOTKEY"));
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		textField_10.setBounds(214, 434, 86, 20);
		bp.add(textField_10);
		textField_10.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_10.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_10.setVisible(true);
			}
		});
		textField_10.addKeyListener(new KeyAdapter() {			
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_10, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "BERRY_HOTKEY", textField_10, 1, true);
				if(isLeft(e) && textField_10.getCaretPosition() == 0) {
					//add focus here
				}else if(isDown(e)) {
					textField_12.requestFocus();
				}else if(isRight(e) && textField_10.getCaretPosition() == textField_10.getText().length()) {
					//add focus here
				}else if(isUp(e)) {
					textField_9.requestFocus();
				}
			}
		});

		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_11.setBounds(56, 488, 98, 30);
		lblNewLabel_11.setVisible(false);
		bp.add(lblNewLabel_11);

		textField_11 = new UpperJTextField();
		textField_11.setToolTipText("How many frames to reach shiny.");
		textField_11.setBorder(empty);
		textField_11.setText(UserSettings.getSetting("FIND_SHINY_FRAMES"));
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(62, 493, 86, 20);
		bp.add(textField_11);
		textField_11.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_11.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_11.setVisible(true);
			}
		});
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_11, 5, false);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "FIND_SHINY_FRAMES", textField_11, 5, false);
				if(isLeft(e) && textField_11.getCaretPosition() == 0) {
					textField_12.requestFocus();
				}else if(isDown(e)) {
					textField_13.requestFocus();
				}else if(isRight(e) && textField_11.getCaretPosition() == textField_11.getText().length()) {
					textField_12.requestFocus();
				}else if(isUp(e)) {
					textField_10.requestFocus();
				}
			}
		});

		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_12.setBounds(208, 488, 98, 30);
		lblNewLabel_12.setVisible(false);
		bp.add(lblNewLabel_12);

		textField_12 = new UpperJTextField();
		textField_12.setToolTipText("Hotkey");
		textField_12.setBorder(empty);
		textField_12.setText(UserSettings.getSetting("FIND_SHINY_HOTKEY"));
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setColumns(10);
		textField_12.setBounds(214, 493, 86, 20);
		bp.add(textField_12);
		textField_12.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_12.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_12.setVisible(true);
			}
		});
		textField_12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_12, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "FIND_SHINY_HOTKEY", textField_12, 1, true);
				if(isLeft(e) && textField_12.getCaretPosition() == 0) {
					textField_11.requestFocus();
				}else if(isDown(e)) {
					textField_13.requestFocus();
				}else if(isRight(e) && textField_12.getCaretPosition() == textField_12.getText().length()) {
					textField_11.requestFocus();
				}else if(isUp(e)) {
					textField_10.requestFocus();
				}
			}
		});

		lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_13.setBounds(208, 547, 98, 30);
		lblNewLabel_13.setVisible(false);
		bp.add(lblNewLabel_13);

		textField_13 = new UpperJTextField();
		textField_13.setToolTipText("Hotkey");
		textField_13.setBorder(empty);
		textField_13.setText(UserSettings.getSetting("BARGAINING_HOTKEY"));
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setColumns(10);
		textField_13.setBounds(214, 552, 86, 20);
		bp.add(textField_13);
		textField_13.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_13.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_13.setVisible(true);
			}
		});
		textField_13.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_13, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "BARGAINING_HOTKEY", textField_13, 1, true);
				if(isLeft(e) && textField_13.getCaretPosition() == 0) {
					//add focus here
				}else if(isDown(e)) {
					textField_15.requestFocus();
				}else if(isRight(e) && textField_13.getCaretPosition() == textField_13.getText().length()) {
					//add focus here
				}else if(isUp(e)) {
					textField_12.requestFocus();
				}
			}
		});

		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_14.setBounds(121, 606, 70, 30);
		lblNewLabel_14.setVisible(false);
		bp.add(lblNewLabel_14);

		lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_15.setBounds(141, 606, 62, 30);
		lblNewLabel_15.setVisible(false);
		bp.add(lblNewLabel_15);

		textField_14 = new UpperJTextField();
		textField_14.setToolTipText("How many fossils to convert");
		textField_14.setBorder(empty);
		textField_14.setText(UserSettings.getSetting("FOSSIL_TO_CONVERT"));
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setColumns(10);
		textField_14.setBounds(127, 611, 70, 20);
		bp.add(textField_14);
		textField_14.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_14.setVisible(false);
				lblNewLabel_15.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_14.setVisible(true);
				lblNewLabel_15.setVisible(true);
			}
		});
		textField_14.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_14, 3, false);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "FOSSIL_TO_CONVERT", textField_14, 3, false);
				if(isLeft(e) && textField_14.getCaretPosition() == 0) {
					textField_15.requestFocus();
				}else if(isDown(e)) {
					textField_16.requestFocus();
				}else if(isRight(e) && textField_14.getCaretPosition() == textField_14.getText().length()) {
					textField_15.requestFocus();
				}else if(isUp(e)) {
					textField_13.requestFocus();
				}
			}
		});

		lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_16.setBounds(208, 606, 98, 30);
		lblNewLabel_16.setVisible(false);
		bp.add(lblNewLabel_16);

		textField_15 = new UpperJTextField();
		textField_15.setToolTipText("Hotkey");
		textField_15.setBorder(empty);
		textField_15.setText(UserSettings.getSetting("FOSSIL_HOTKEY"));
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(10);
		textField_15.setBounds(214, 611, 86, 20);
		bp.add(textField_15);
		textField_15.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_16.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_16.setVisible(true);
			}
		});
		textField_15.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_15, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "FOSSIL_HOTKEY", textField_15, 1, true);
				if(isLeft(e) && textField_15.getCaretPosition() == 0) {
					textField_14.requestFocus();
				}else if(isDown(e)) {
					textField_16.requestFocus();
				}else if(isRight(e) && textField_15.getCaretPosition() == textField_15.getText().length()) {
					textField_14.requestFocus();
				}else if(isUp(e)) {
					textField_13.requestFocus();
				}
			}
		});

		lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/pokemonTextBorder.png"))));
		lblNewLabel_17.setBounds(208, 665, 98, 30);
		lblNewLabel_17.setVisible(false);
		bp.add(lblNewLabel_17);

		textField_16 = new UpperJTextField();
		textField_16.setToolTipText("Hotkey");
		textField_16.setBorder(empty);
		textField_16.setText(UserSettings.getSetting("TEST_HOTKEY"));
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setColumns(10);
		textField_16.setBounds(214, 670, 86, 20);
		bp.add(textField_16);
		textField_16.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				lblNewLabel_17.setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_17.setVisible(true);
			}
		});
		textField_16.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldLogicTyped(e, textField_16, 1, true);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldLogicPressed(e, "TEST_HOTKEY", textField_16, 1, true);
				if(isLeft(e) && textField_16.getCaretPosition() == 0) {
					//add focus here
				}else if(isDown(e)) {
					textField_2.requestFocus();
				}else if(isRight(e) && textField_16.getCaretPosition() == textField_16.getText().length()) {
					//add focus here
				}else if(isUp(e)) {
					textField_15.requestFocus();
				}
			}
		});

		/*
		 * Toggle button for activating scrcpy.exe, (streaming phone app) located in Users/Pokebot/streamPhoneApp/scrcpy.exe
		 */
		StreamingPhoneToggle = new JToggleButton("");
		StreamingPhoneToggle.setFocusable(false);
		StreamingPhoneToggle.addActionListener(e -> {
			if(StreamingPhoneToggle.isSelected()) {
				try {
					String[] path = new String[] {System.getenv("HOMEPATH") + File.separator + "Pokebot" + File.separator + "streamPhoneApp" + File.separator + "scrcpy.exe"};
					streamPhoneProcess = Runtime.getRuntime().exec(path);
					executorService.execute(()-> {
						//stream phone app closes if it doesn't find a connection with a phone.
						try {
							//Here I wait 10 seconds for the app to finish checking if connection can be established.
							streamPhoneProcess.waitFor(10, TimeUnit.SECONDS);
							//If connection not found in the first 5 seconds or the app finished checking the connection, an error window pops up.
							if(!streamPhoneProcess.isAlive()) {
								ErrorGUI dialog = new ErrorGUI();
								dialog.setVisible(true);
							}else {
								//connection found now we wait for app.
								streamPhoneProcess.waitFor();
							}
							//if streaming phone app closed then the toggle de-selects.
							StreamingPhoneToggle.setSelected(false);
						}
						catch (InterruptedException e1) {e1.printStackTrace();}
					});
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}

			}else {
				streamPhoneProcess.destroy();
			}
		});
		StreamingPhoneToggle.setBounds(727, 60, 121, 23);
		bp.add(StreamingPhoneToggle);
		StreamingPhoneToggle.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});

		comboBox = new JComboBox<Object>();
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if(Fossil.DRACOZOLT == comboBox.getSelectedItem()) {
					fossilSelected = Fossil.DRACOZOLT;
					UserSettings.addSetting("FOSSIL", "DRACOZOLT");
					UserSettings.outputProperties();
				}else if(Fossil.ARCTOZOLT == comboBox.getSelectedItem()) {
					fossilSelected = Fossil.ARCTOZOLT;
					UserSettings.addSetting("FOSSIL", "ARCTOZOLT");
					UserSettings.outputProperties();
				}else if(Fossil.DRACOVISH == comboBox.getSelectedItem()) {
					fossilSelected = Fossil.DRACOVISH;
					UserSettings.addSetting("FOSSIL", "DRACOVISH");
					UserSettings.outputProperties();
				}else if(Fossil.ARCTOVISH == comboBox.getSelectedItem()) {
					fossilSelected = Fossil.ARCTOVISH;
					UserSettings.addSetting("FOSSIL", "ARCTOVISH");
					UserSettings.outputProperties();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<Object>(Fossil.values()));
		if("DRACOZOLT".equals(UserSettings.getSetting("FOSSIL")))
			comboBox.setSelectedItem(Fossil.DRACOZOLT);
		else if("ARCTOZOLT".equals(UserSettings.getSetting("FOSSIL"))) 
			comboBox.setSelectedItem(Fossil.ARCTOZOLT);
		else if("DRACOVISH".equals(UserSettings.getSetting("FOSSIL"))) 
			comboBox.setSelectedItem(Fossil.DRACOVISH);
		else if("ARCTOVISH".equals(UserSettings.getSetting("FOSSIL"))) 
			comboBox.setSelectedItem(Fossil.ARCTOVISH);
		comboBox.setBounds(20, 611, 96, 22);
		bp.add(comboBox);

		/*
		 * Toggle button for activating global key listeners.
		 * Utilizing external library called jNativeHook.
		 */
		StartBotToggle = new JToggleButton("");
		StartBotToggle.setFocusable(false);
		StartBotToggle.setToolTipText("When pressed the bot is activated and its waiting for your comand.");
		StartBotToggle.addActionListener(e -> {
			if(StartBotToggle.isSelected()) {
				HashMap<String, String> uniqueKeys = UserSettings.nonUniquehotKeys();
				if(!uniqueKeys.isEmpty()) {
					StartBotToggle.setSelected(false);
					for (Entry<String, String> string : uniqueKeys.entrySet()) {
						//Here I verify that every hotkey is unique, if not, display a error using a jLabel
						switch (string.getKey()) {
						case "EGG_HOTKEY":
							txtHotkeyTaken_1.setVisible(true);
							break;
						case "SURPRISE_HOTKEY":
							txtHotkeyTaken_2.setVisible(true);
							break;
						case "DELETE_HOTKEY":
							txtHotkeyTaken_3.setVisible(true);
							break;
						case "WATT_HOTKEY":
							txtHotkeyTaken_4.setVisible(true);
							break;
						case "MASTERBALL_HOTKEY":
							txtHotkeyTaken_5.setVisible(true);
							break;
						case "SPAM_A_HOTKEY":
							txtHotkeyTaken_6.setVisible(true);
							break;
						case "BERRY_HOTKEY":
							txtHotkeyTaken_7.setVisible(true);
							break;
						case "FIND_SHINY_HOTKEY":
							txtHotkeyTaken_8.setVisible(true);
							break;
						case "BARGAINING_HOTKEY":
							txtHotkeyTaken_9.setVisible(true);
							break;
						case "FOSSIL_HOTKEY":
							txtHotkeyTaken_10.setVisible(true);
							break;
						case "TEST_HOTKEY":
							txtHotkeyTaken_11.setVisible(true);
							break;
						}
					}
				}else {
					if(advSet != null)
						advSet.dispose();
					//Make sure that the user doesn't change values while jNativeHook library is active. 
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField_4.setEditable(false);
					textField_5.setEditable(false);
					textField_6.setEditable(false);
					textField_7.setEditable(false);
					textField_8.setEditable(false);
					textField_9.setEditable(false);
					textField_10.setEditable(false);
					textField_11.setEditable(false);
					textField_12.setEditable(false);
					textField_13.setEditable(false);
					textField_14.setEditable(false);
					textField_15.setEditable(false);
					textField_16.setEditable(false);
					advanceButton.setEnabled(false);
					calibrateButton.setEnabled(false);
					defaultButton.setEnabled(false);
					chckbxOnlineGlitch_1.setEnabled(false);
					comboBox.setEnabled(false);
					txtHotkeyTaken_1.setVisible(false);
					txtHotkeyTaken_2.setVisible(false);
					txtHotkeyTaken_3.setVisible(false);
					txtHotkeyTaken_4.setVisible(false);
					txtHotkeyTaken_5.setVisible(false);
					txtHotkeyTaken_6.setVisible(false);
					txtHotkeyTaken_7.setVisible(false);
					txtHotkeyTaken_8.setVisible(false);
					txtHotkeyTaken_9.setVisible(false);
					txtHotkeyTaken_10.setVisible(false);
					txtHotkeyTaken_11.setVisible(false);
					//JNativeHook library requires a class that implements NativeKeyListener to listen keys and act upon it. 
					//Input your bot class here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					try {
						eggFarmMacro = new EggFarmBot(new Robot(), UserSettings.getSetting("EGG_HOTKEY"), Integer.parseInt(UserSettings.getSetting("EGG_SEC")));
						surpriseTradeMacro = new SurpriseTradeBot(new Robot(), UserSettings.getSetting("SURPRISE_HOTKEY"), Integer.parseInt(UserSettings.getSetting("SURPRISE_BOXES")));
						deleteBoxMacro = new DeleteBoxBot(new Robot(), UserSettings.getSetting("DELETE_HOTKEY"), Integer.parseInt(UserSettings.getSetting("DELETE_BOXES")));
						wattFarmMacro = new WattFarmBot(new Robot(), UserSettings.getSetting("WATT_HOTKEY"), wattFarmOnline);
						masterbalMacro = new MasterballBot(new Robot(), UserSettings.getSetting("MASTERBALL_HOTKEY"));
						spamAMacro = new SpamABot(new Robot(), UserSettings.getSetting("SPAM_A_HOTKEY"));
						berryMacro = new BerryFarmBot(new Robot(), UserSettings.getSetting("BERRY_HOTKEY"));
						findMyShiny = new FindMyShinyBot(new Robot(), UserSettings.getSetting("FIND_SHINY_HOTKEY"), Integer.parseInt(UserSettings.getSetting("FIND_SHINY_FRAMES")));
						bargainingMacro = new BargainingBot(new Robot(), UserSettings.getSetting("BARGAINING_HOTKEY"));
						fossilMacro = new FossilBot(new Robot(), UserSettings.getSetting("FOSSIL_HOTKEY"), UserSettings.getSetting("FOSSIL_TO_CONVERT"), fossilSelected);
						test = new TestBot(new Robot(), UserSettings.getSetting("TEST_HOTKEY"));
						//Activate global key listener for your class here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
						GlobalScreen.addNativeKeyListener(eggFarmMacro);
						GlobalScreen.addNativeKeyListener(surpriseTradeMacro);
						GlobalScreen.addNativeKeyListener(deleteBoxMacro);
						GlobalScreen.addNativeKeyListener(wattFarmMacro);
						GlobalScreen.addNativeKeyListener(masterbalMacro);
						GlobalScreen.addNativeKeyListener(spamAMacro);
						GlobalScreen.addNativeKeyListener(berryMacro);
						GlobalScreen.addNativeKeyListener(findMyShiny);
						GlobalScreen.addNativeKeyListener(bargainingMacro);
						GlobalScreen.addNativeKeyListener(fossilMacro);
						GlobalScreen.addNativeKeyListener(test);
					} catch (AWTException e1) {
						e1.printStackTrace();
					}
					setState(ICONIFIED);
				}
			}else {
				/*
				 * When toggle is off, all JNativeHook threads are closed.
				 * This prevents accidental activation on any of the bot classes.
				 * I also then let the user have the ability to use the buttons and edit settings.
				 */
				GlobalScreen.removeNativeKeyListener(eggFarmMacro);
				GlobalScreen.removeNativeKeyListener(surpriseTradeMacro);
				GlobalScreen.removeNativeKeyListener(deleteBoxMacro);
				GlobalScreen.removeNativeKeyListener(wattFarmMacro);
				GlobalScreen.removeNativeKeyListener(masterbalMacro);
				GlobalScreen.removeNativeKeyListener(spamAMacro);
				GlobalScreen.removeNativeKeyListener(berryMacro);
				GlobalScreen.removeNativeKeyListener(findMyShiny);
				GlobalScreen.removeNativeKeyListener(bargainingMacro);
				GlobalScreen.removeNativeKeyListener(fossilMacro);
				GlobalScreen.removeNativeKeyListener(test);
				textField_1.setEditable(true);
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				textField_4.setEditable(true);
				textField_5.setEditable(true);
				textField_6.setEditable(true);
				textField_7.setEditable(true);
				textField_8.setEditable(true);
				textField_9.setEditable(true);
				textField_10.setEditable(true);
				textField_11.setEditable(true);
				textField_12.setEditable(true);
				textField_13.setEditable(true);
				textField_14.setEditable(true);
				textField_15.setEditable(true);
				textField_16.setEditable(true);
				advanceButton.setEnabled(true);
				calibrateButton.setEnabled(true);
				defaultButton.setEnabled(true);
				chckbxOnlineGlitch_1.setEnabled(true);
				comboBox.setEnabled(true);
			}
		});
		StartBotToggle.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		StartBotToggle.setBounds(590, 392, 103, 23);
		bp.add(StartBotToggle);

		advanceButton = new JButton();
		advanceButton.setFocusable(false);
		advanceButton.addActionListener(e -> {
			//Hides the window when its visible to reuse the same window
			if(advSet.isVisible())
				advSet.setVisible(false);
			/*
			 * If calibrate button was activated, it means that the coordinates changed
			 * so we create a new window with the updated coordinates
			 */
			else if(calibrateWasActive) {
				calibrateWasActive = false;
				try {advSet = new AdvanceSettings();}
				catch (FontFormatException | IOException e1) {e1.printStackTrace();}
				advSet.setVisible(true);
				advSet.setLocationRelativeTo(null);
			}
			//Make the window visible again to reuse the same window
			else {
				advSet.setVisible(true);
				advSet.setLocationRelativeTo(null);
			}
		});
		advanceButton.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		advanceButton.setBounds(463, 716, 89, 23);
		bp.add(advanceButton);

		/*
		 * This button turns all the "settings" or text, in each textfield to default coordinates 
		 * that equate for a screen resolution of 1920x1080.
		 */
		defaultButton = new JButton("");
		defaultButton.setFocusable(false);
		defaultButton.addActionListener(e -> {
			textField_1.setText(DefaultSettings.EGG_SEC);
			textField_2.setText(DefaultSettings.EGG_HOTKEY);
			textField_3.setText(DefaultSettings.SURPRISE_BOXES);
			textField_4.setText(DefaultSettings.SURPRISE_HOTKEY);
			textField_5.setText(DefaultSettings.DELETE_BOXES);
			textField_6.setText(DefaultSettings.DELETE_HOTKEY);
			textField_7.setText(DefaultSettings.WATT_HOTKEY);
			textField_8.setText(DefaultSettings.MASTERBALL_HOTKEY);
			textField_9.setText(DefaultSettings.SPAM_A_HOTKEY);
			textField_10.setText(DefaultSettings.BERRY_HOTKEY);
			textField_11.setText(DefaultSettings.FIND_SHINY_FRAMES);
			textField_12.setText(DefaultSettings.FIND_SHINY_HOTKEY);
			textField_13.setText(DefaultSettings.BARGAINING_HOTKEY);
			textField_14.setText(DefaultSettings.FOSSIL_TO_CONVERT);
			textField_15.setText(DefaultSettings.FOSSIL_HOTKEY);
			textField_16.setText(DefaultSettings.TEST_HOTKEY);
			comboBox.setSelectedItem(Fossil.DRACOZOLT);
			chckbxOnlineGlitch_1.setSelected(true);
			wattFarmOnline = true;
			UserSettings.addSetting("WATT_FARM_ONLINE", "true");
			UserSettings.addSetting("EGG_SEC", DefaultSettings.EGG_SEC);
			UserSettings.addSetting("EGG_HOTKEY", DefaultSettings.EGG_HOTKEY);
			UserSettings.addSetting("SURPRISE_BOXES", DefaultSettings.SURPRISE_BOXES);
			UserSettings.addSetting("SURPRISE_HOTKEY", DefaultSettings.SURPRISE_HOTKEY);
			UserSettings.addSetting("DELETE_BOXES", DefaultSettings.DELETE_BOXES);
			UserSettings.addSetting("DELETE_HOTKEY", DefaultSettings.DELETE_HOTKEY);
			UserSettings.addSetting("WATT_HOTKEY", DefaultSettings.WATT_HOTKEY);
			UserSettings.addSetting("MASTERBALL_HOTKEY", DefaultSettings.MASTERBALL_HOTKEY);
			UserSettings.addSetting("SPAM_A_HOTKEY", DefaultSettings.SPAM_A_HOTKEY);
			UserSettings.addSetting("BERRY_HOTKEY", DefaultSettings.BERRY_HOTKEY);
			UserSettings.addSetting("FIND_SHINY_FRAMES", DefaultSettings.FIND_SHINY_FRAMES);
			UserSettings.addSetting("FIND_SHINY_HOTKEY", DefaultSettings.FIND_SHINY_HOTKEY);
			UserSettings.addSetting("BARGAINING_HOTKEY", DefaultSettings.BARGAINING_HOTKEY);
			UserSettings.addSetting("FOSSIL_TO_CONVERT", DefaultSettings.FOSSIL_TO_CONVERT);
			UserSettings.addSetting("FOSSIL_HOTKEY", DefaultSettings.FOSSIL_HOTKEY);
			UserSettings.addSetting("TEST_HOTKEY", DefaultSettings.TEST_HOTKEY);
			UserSettings.outputProperties();
		});
		defaultButton.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		defaultButton.setBounds(783, 719, 89, 23);
		bp.add(defaultButton);

		calibrateButton = new JToggleButton();
		calibrateButton.setFocusable(false);
		calibrateButton.setBounds(429, 60, 121, 23);
		bp.add(calibrateButton);
		calibrateButton.addActionListener(e -> {
			/*
			 * This is a really ugly way I'm keeping track of what's happening with CalibrateButton class.
			 * I'm using a count to know when calibration has ended.
			 */
			if(calibrateButton.isSelected() && CalibrateButtons.count == -1) {
				advanceButton.setEnabled(false);
				CalibrateButtons calibrateButtons = new CalibrateButtons(this);
				setState(ICONIFIED);
				calibrateWasActive = true;
				try {GlobalScreen.registerNativeHook();}
				catch (NativeHookException ex) {
					System.err.println("There was a problem registering the native hook.");
					System.err.println(ex.getMessage());
					System.exit(1);
				}
				GlobalScreen.addNativeMouseListener(calibrateButtons);
				calibrateButtons.setVisible(true);
			}else if(CalibrateButtons.count <= 17)
				calibrateButton.setSelected(true);
		});
		calibrateButton.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});

		txtHotkeyTaken_1 = new JTextField();
		txtHotkeyTaken_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_1.setEditable(false);
		txtHotkeyTaken_1.setVisible(false);
		txtHotkeyTaken_1.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_1.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_1.setText("Taken");
		txtHotkeyTaken_1.setBounds(316, 80, 40, 20);
		bp.add(txtHotkeyTaken_1);
		txtHotkeyTaken_1.setColumns(10);

		txtHotkeyTaken_2 = new JTextField();
		txtHotkeyTaken_2.setText("Taken");
		txtHotkeyTaken_2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_2.setEditable(false);
		txtHotkeyTaken_2.setColumns(10);
		txtHotkeyTaken_2.setVisible(false);
		txtHotkeyTaken_2.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_2.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_2.setBounds(316, 139, 40, 20);
		bp.add(txtHotkeyTaken_2);

		txtHotkeyTaken_3 = new JTextField();
		txtHotkeyTaken_3.setText("Taken");
		txtHotkeyTaken_3.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_3.setEditable(false);
		txtHotkeyTaken_3.setColumns(10);
		txtHotkeyTaken_3.setVisible(false);
		txtHotkeyTaken_3.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_3.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_3.setBounds(316, 198, 40, 20);
		bp.add(txtHotkeyTaken_3);

		txtHotkeyTaken_4 = new JTextField();
		txtHotkeyTaken_4.setText("Taken");
		txtHotkeyTaken_4.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_4.setEditable(false);
		txtHotkeyTaken_4.setColumns(10);
		txtHotkeyTaken_4.setVisible(false);
		txtHotkeyTaken_4.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_4.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_4.setBounds(316, 257, 40, 20);
		bp.add(txtHotkeyTaken_4);

		txtHotkeyTaken_5 = new JTextField();
		txtHotkeyTaken_5.setText("Taken");
		txtHotkeyTaken_5.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_5.setEditable(false);
		txtHotkeyTaken_5.setColumns(10);
		txtHotkeyTaken_5.setVisible(false);
		txtHotkeyTaken_5.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_5.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_5.setBounds(316, 316, 40, 20);
		bp.add(txtHotkeyTaken_5);

		txtHotkeyTaken_6 = new JTextField();
		txtHotkeyTaken_6.setText("Taken");
		txtHotkeyTaken_6.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_6.setEditable(false);
		txtHotkeyTaken_6.setColumns(10);
		txtHotkeyTaken_6.setVisible(false);
		txtHotkeyTaken_6.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_6.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_6.setBounds(316, 375, 40, 20);
		bp.add(txtHotkeyTaken_6);

		txtHotkeyTaken_7 = new JTextField();
		txtHotkeyTaken_7.setText("Taken");
		txtHotkeyTaken_7.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_7.setEditable(false);
		txtHotkeyTaken_7.setColumns(10);
		txtHotkeyTaken_7.setVisible(false);
		txtHotkeyTaken_7.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_7.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_7.setBounds(316, 434, 40, 20);
		bp.add(txtHotkeyTaken_7);

		txtHotkeyTaken_8 = new JTextField();
		txtHotkeyTaken_8.setText("Taken");
		txtHotkeyTaken_8.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_8.setEditable(false);
		txtHotkeyTaken_8.setColumns(10);
		txtHotkeyTaken_8.setVisible(false);
		txtHotkeyTaken_8.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_8.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_8.setBounds(316, 493, 40, 20);
		bp.add(txtHotkeyTaken_8);

		txtHotkeyTaken_9 = new JTextField();
		txtHotkeyTaken_9.setText("Taken");
		txtHotkeyTaken_9.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_9.setEditable(false);
		txtHotkeyTaken_9.setColumns(10);
		txtHotkeyTaken_9.setVisible(false);
		txtHotkeyTaken_9.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_9.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_9.setBounds(316, 552, 40, 20);
		bp.add(txtHotkeyTaken_9);

		txtHotkeyTaken_10 = new JTextField();
		txtHotkeyTaken_10.setText("Taken");
		txtHotkeyTaken_10.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_10.setEditable(false);
		txtHotkeyTaken_10.setColumns(10);
		txtHotkeyTaken_10.setVisible(false);
		txtHotkeyTaken_10.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_10.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_10.setBounds(316, 611, 40, 20);
		bp.add(txtHotkeyTaken_10);

		txtHotkeyTaken_11 = new JTextField();
		txtHotkeyTaken_11.setText("Taken");
		txtHotkeyTaken_11.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHotkeyTaken_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtHotkeyTaken_11.setEditable(false);
		txtHotkeyTaken_11.setColumns(10);
		txtHotkeyTaken_11.setVisible(false);
		txtHotkeyTaken_11.setBorder(new LineBorder(new Color(255, 0, 0)));
		txtHotkeyTaken_11.setBackground(new Color(255, 0, 0, 190));
		txtHotkeyTaken_11.setBounds(316, 670, 40, 20);
		bp.add(txtHotkeyTaken_11);

		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_1.addActionListener(e -> {
			String domain = "youtu.be/CRE97cH2_FE";
			openURL(domain);
		});
		btnNewButton_1.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_1.setBounds(1100, 80, 89, 23);
		bp.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_2.addActionListener(e -> {
			String domain = "youtu.be/0nwdn0QM7BE";
			openURL(domain);
		});
		btnNewButton_2.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_2.setBounds(1100, 139, 89, 23);
		bp.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_3.addActionListener(e -> {
			String domain = "youtu.be/3N1VolXBmI4";
			openURL(domain);
		});
		btnNewButton_3.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_3.setBounds(1100, 198, 89, 23);
		bp.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton();
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_4.addActionListener(e -> {
			String domain = "youtu.be/nEokB5rQ4rE";
			openURL(domain);
		});
		btnNewButton_4.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_4.setBounds(1100, 257, 89, 23);
		bp.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton();
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_5.addActionListener(e -> {
			String domain = "youtu.be/OFmOPiPKZ1Q";
			openURL(domain);
		});
		btnNewButton_5.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_5.setBounds(1100, 316, 89, 23);
		bp.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton();
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_6.addActionListener(e -> {
			String domain = "youtu.be/X2bsT7JYT2Q";
			openURL(domain);
		});
		btnNewButton_6.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_6.setBounds(1100, 375, 89, 23);
		bp.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Comming Soon");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_7.addActionListener(e -> {
			//			String domain = "";
			//			openURL(domain);
		});
		btnNewButton_7.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_7.setBounds(1100, 434, 89, 23);
		bp.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton();
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_8.addActionListener(e -> {
			String domain = "youtu.be/hHD3pseU_bc";
			openURL(domain);
		});
		btnNewButton_8.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_8.setBounds(1100, 493, 89, 23);
		bp.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("Comming Soon");
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_9.addActionListener(e -> {
			//			String domain = "";
			//			openURL(domain);
		});
		btnNewButton_9.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_9.setBounds(1100, 552, 89, 23);
		bp.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("Comming Soon");
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_10.addActionListener(e -> {
			//			String domain = "";
			//			openURL(domain);
		});
		btnNewButton_10.setUI(new MetalToggleButtonUI() {
			@Override
			protected Color getSelectColor() {
				return Color.GREEN;
			}
		});
		btnNewButton_10.setBounds(1100, 611, 89, 23);
		bp.add(btnNewButton_10);

		chckbxOnlineGlitch_1 = new JCheckBox("Online Glitch");
		chckbxOnlineGlitch_1.addActionListener( e -> {
			if(chckbxOnlineGlitch_1.isSelected()) {
				wattFarmOnline = true;
				UserSettings.addSetting("WATT_FARM_ONLINE", "true");
				UserSettings.outputProperties();
			}
			else {
				wattFarmOnline = false;
				UserSettings.addSetting("WATT_FARM_ONLINE", "false");
				UserSettings.outputProperties();
			}
		});
		chckbxOnlineGlitch_1.setToolTipText("Uses the new and safe Link Battle glitch thats faster and infinite.");
		if(UserSettings.getSetting("WATT_FARM_ONLINE").equals("true")) {
			chckbxOnlineGlitch_1.setSelected(true);
			wattFarmOnline = true;
		}
		else {
			chckbxOnlineGlitch_1.setSelected(false);
			wattFarmOnline = false;
		}
		chckbxOnlineGlitch_1.setBackground(new Color(0, 0, 0, 0));
		chckbxOnlineGlitch_1.setForeground(Color.BLACK);
		chckbxOnlineGlitch_1.setOpaque(false);
		chckbxOnlineGlitch_1.setFocusPainted(false);
		chckbxOnlineGlitch_1.setBounds(58, 257, 96, 23);
		bp.add(chckbxOnlineGlitch_1);
	}

	/*
	 * Opens URL using the default search engine.
	 * Works with Windows, Mac, Linux, Unix.
	 * @param Domain name.
	 */
	public static void openURL(String domain)
	{
		String url = "https://" + domain;
		Runtime rt = Runtime.getRuntime();
		try {
			if (isWindows()) {
				rt.exec("rundll32 url.dll,FileProtocolHandler " + url).waitFor();
			} else if (isMac()) {
				String[] cmd = {"open", url};
				rt.exec(cmd).waitFor();
			} else if (isLinux()) {
				String[] cmd = {"xdg-open", url};
				rt.exec(cmd).waitFor();
			} else if (isUnix()) {
				String[] cmd = {"xdg-open", url};
				rt.exec(cmd).waitFor();
			} else {
				try {
					throw new IllegalStateException();
				} catch (IllegalStateException e1) {
					e1.printStackTrace();
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Checks that the OS is Windows 
	 * @return true if OS is Windows else false
	 */
	public static boolean isWindows()
	{
		return SystemUtils.IS_OS_WINDOWS;
	}

	/*
	 * Checks that the OS is Mac 
	 * @return true if OS is Mac else false
	 */
	public static boolean isMac()
	{
		return SystemUtils.IS_OS_MAC;
	}

	/*
	 * Checks that the OS is Unix 
	 * @return true if OS is Unix else false
	 */
	public static boolean isUnix()
	{
		return SystemUtils.IS_OS_UNIX;
	}

	/*
	 * Checks that the OS is Linux 
	 * @return true if OS is Linux else false
	 */
	public static boolean isLinux()
	{
		return SystemUtils.IS_OS_LINUX;
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

	/*
	 * Extracts the full zip file to a desired directory.
	 * @param zis Zip file to extract.
	 * @param zis outputFolder directory to past the zip file.
	 */
	private static void extract(ZipInputStream zis, File outputFolder) {
		try {
			ZipEntry ze = zis.getNextEntry();
			byte[] buffer = new byte[1024];
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);
				//create directories for sub directories in zip
				new File(newFile.getParent()).mkdirs();
				if (!ze.isDirectory()) {
					FileOutputStream fos = new FileOutputStream(newFile);
					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close();
				}
				//close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			//close last ZipEntry
			zis.closeEntry();
			zis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void textFieldLogicTyped(KeyEvent e, JTextField textField, Integer inputLength, Boolean isHotkey) {
		char c = e.getKeyChar();
		if(isHotkey) {
			if(textField.getSelectedText() != null && !(isDigit(c) || isAlphabetic(c)))
				e.consume();
			else if(!(isMoveOrRemoveKeys(e, c) || isDigit(c) || isAlphabetic(c)))
				e.consume();
			else if((isDigit(c) || isAlphabetic(c)) && textField.getText().length() == inputLength && textField.getSelectedText() == null) 
				e.consume();
			else if(isDigit(c) && textField.getText().equals("0") && textField.getCaretPosition() > 0)
				e.consume();
		}else {
			if(textField.getSelectedText() != null && !(isDigit(c))) 
				e.consume();
			else if(!(isMoveOrRemoveKeys(e, c) || isDigit(c))) 
				e.consume();
			else if(isDigit(c) && textField.getText().length() == inputLength && textField.getSelectedText() == null) 
				e.consume();
			else if(isDigit(c) && textField.getText().equals("0") && textField.getCaretPosition() > 0)
				e.consume();
		}
	}

	public void textFieldLogicPressed(KeyEvent e, String userSettingKey, JTextField textField, Integer inputLength, Boolean isHotkey) {
		char c = e.getKeyChar();
		String userSettingValue = UserSettings.getSetting(userSettingKey);

		if(textField.isEditable()) {
			if(isHotkey)
				inputTextFieldLogicForHotkey(e, c, textField, userSettingValue, userSettingKey, inputLength);
			else
				inputTextFieldLogicForBot(e, c, textField, userSettingValue, userSettingKey, inputLength);
			deleteTextFieldLogic(c, textField, userSettingValue, userSettingKey);
		}
	}

	public void inputTextFieldLogicForHotkey(KeyEvent e, char c, JTextField textField, String userSettingValue, String userSettingKey, Integer inputLength) {
		if(!(isMoveOrRemoveKeys(e, c) || isDigit(c) || isAlphabetic(c))) {
			getToolkit().beep();
			e.consume();
		}else if(textField.getSelectedText() != null && (isDigit(c) || isAlphabetic(c))) {
			StringBuilder str= new StringBuilder(userSettingValue);
			str.delete(textField.getSelectionStart(), textField.getSelectionEnd());
			if(str.length() == 0) 
				str.append(c);
			else
				str.insert(textField.getCaretPosition(), c);
			UserSettings.addSetting(userSettingKey, str.toString().toUpperCase());
			UserSettings.outputProperties();
		}else if((isDigit(c) || isAlphabetic(c)) && userSettingValue.length() < inputLength) {
			if(textField.getText().equals("0") && textField.getCaretPosition() > 0) {
				getToolkit().beep();
				e.consume();
				return;
			}
			StringBuilder str= new StringBuilder(userSettingValue);
			str.insert(textField.getCaretPosition(), c);
			UserSettings.addSetting(userSettingKey, str.toString().toUpperCase());
			UserSettings.outputProperties();
		}else if(isDigit(c) || isAlphabetic(c)) {
			getToolkit().beep();
			e.consume();
		}
	}

	public void inputTextFieldLogicForBot(KeyEvent e, char c, JTextField textField, String userSettingValue, String userSettingKey, Integer inputLength) {
		if(!(isMoveOrRemoveKeys(e, c) || isDigit(c))) {
			getToolkit().beep();
			e.consume();
		}else if(textField.getSelectedText() != null && isDigit(c)) {
			StringBuilder str= new StringBuilder(userSettingValue);
			str.delete(textField.getSelectionStart(), textField.getSelectionEnd());
			if(str.length() == 0)
				str.append(c);
			else
				str.insert(textField.getCaretPosition(), c);
			UserSettings.addSetting(userSettingKey, str.toString());
			UserSettings.outputProperties();
		}else if(isDigit(c) && userSettingValue.length() < inputLength) {
			if(textField.getText().equals("0") && textField.getCaretPosition() > 0) {
				getToolkit().beep();
				e.consume();
				return;
			}
			StringBuilder str= new StringBuilder(userSettingValue);
			str.insert(textField.getCaretPosition(), c);
			UserSettings.addSetting(userSettingKey, str.toString());
			UserSettings.outputProperties();
		}else if(isDigit(c)) {
			getToolkit().beep();
			e.consume();
		}
	}

	public void deleteTextFieldLogic(char c, JTextField textField, String userSettingValue, String userSettingKey) {
		if(textField.getSelectedText() != null && (isBackSpace(c) || isDelete(c))) {
			StringBuilder str = new StringBuilder(userSettingValue); 
			str.delete(textField.getSelectionStart(), textField.getSelectionEnd());
			UserSettings.addSetting(userSettingKey, str.toString());
			UserSettings.outputProperties();
		}else if(isBackSpace(c) && textField.getCaretPosition() != 0) {
			StringBuilder str = new StringBuilder(userSettingValue);
			str.deleteCharAt(textField.getCaretPosition()-1);
			UserSettings.addSetting(userSettingKey, str.toString());
			UserSettings.outputProperties();
		}else if(isDelete(c) && textField.getCaretPosition() != textField.getText().length()) {
			StringBuilder str = new StringBuilder(userSettingValue);
			str.deleteCharAt(textField.getCaretPosition());
			UserSettings.addSetting(userSettingKey, str.toString());
			UserSettings.outputProperties();
		}
	}
}