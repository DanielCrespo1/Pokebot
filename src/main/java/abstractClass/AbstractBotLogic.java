package abstractClass;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import GUI.AdvanceSettings;
import GUI.MainGUI;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import DataManagment.UserSettings;

//Abstract class for all bot classes with methods for start/stop/restart/shutdown/online timer/refresh online/left click
public abstract class AbstractBotLogic {

	protected static Map<String, Boolean> macroThatAreRunning = new HashMap<>();
	protected boolean shutdownState;
	protected boolean isOnlineTimerRunning;
	protected Robot robot;
	protected String macroProfileKeyBind;
	private int minPassed = 0;
	private Timer timer;
	private Thread thread;

	public AbstractBotLogic(Robot robot, String macroProfileKeyBind) {
		this.robot = robot;
		shutdownState = false;
		isOnlineTimerRunning = false;
		this.macroProfileKeyBind = macroProfileKeyBind;
		macroThatAreRunning.put(macroProfileKeyBind, false);
	}

	public synchronized void abstractNativeKeyPressed(NativeKeyEvent e, Runnable bot) {
		//Fully shutdown the program
		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {turnOff();}
		//Starts the bot thats bind to the required hotkey.
		else if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals(macroProfileKeyBind)) {
			turnOn_Or_Pause(bot, macroProfileKeyBind);			
		}
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		//Don't need it 
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		//Don't need it 
	}

	//verifies that all bots are off.
	public boolean allOtherBotsAreOff(String keyPressed) {
		for (String macroPreset : macroThatAreRunning.keySet()) {
			if(!macroPreset.equals(keyPressed)) {
				if(macroThatAreRunning.get(macroPreset))
					return false;
			}
		}
		return true;
	}

	//Returns the state of the bot using the hotkey.
	public boolean getBotStateOf(String key) {
		if(macroThatAreRunning.get(key) == null) {
			throw new IllegalArgumentException("Key was not found in the map");
		}
		return macroThatAreRunning.get(key);
	}

	@SuppressWarnings("deprecation")
	public synchronized void turnOn_Or_Pause(Runnable macro, String keyPressed) {
		if(allOtherBotsAreOff(keyPressed)) {
			if(!macroThatAreRunning.get(keyPressed)) {
				macroThatAreRunning.replace(keyPressed, true);
				thread = new Thread(macro);
				startOnlineTimer();
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				thread.start();
			}
			else {
				thread.stop();
				macroThatAreRunning.replace(keyPressed, false);
				stopOnlineTimer();
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyRelease(KeyEvent.VK_SPACE);
			}
		}
	}

	public void turnOff() {
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.keyRelease(KeyEvent.VK_SPACE);
		if(AdvanceSettings.mousePosProcess != null)
			AdvanceSettings.mousePosProcess.destroy();
		if(MainGUI.streamPhoneProcess != null)
			MainGUI.streamPhoneProcess.destroy();
		this.shutdown();
		try {Thread.sleep(500);} 
		catch (InterruptedException e) {e.printStackTrace();}
		try {GlobalScreen.unregisterNativeHook();} 
		catch (NativeHookException e1) {e1.printStackTrace();}
		System.exit(1);
	}

	public void shutdown() {
		shutdownState = true;
		if(isOnlineTimerRunning)
			stopOnlineTimer();
	}

	public boolean isShutdowned() {
		return shutdownState;
	}

	//StopWatch for online timer.
	public void startOnlineTimer() {
		isOnlineTimerRunning = true;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				minPassed++;
				if(minPassed == 30)
					stopOnlineTimer();
			}
		} ,60000, 60000);
	}

	public void stopOnlineTimer() {
		minPassed = 0;
		timer.cancel();
		isOnlineTimerRunning = false;
	}

	public void moveMouse(int x, int y) {
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(x, y);
		else
			return;
	}

	public void moveAndClick(int x, int y, int delay1, int delay2) {
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()) {
			robot.mouseMove(x, y);
			robot.delay(100);
		}
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.delay(delay1);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.delay(delay2);
	}

	public void leftClick(int delay1, int delay2) {
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.delay(delay1);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.delay(delay2);
	}

	public void rightClick(int delay1, int delay2) {
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.delay(delay1);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.delay(delay2);
	}

	public void pressA(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("A"));
		String xCoord = coords.substring(0, UserSettings.getSetting("A").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("A").lastIndexOf(" ")+1, UserSettings.getSetting("A").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressB(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("B"));
		String xCoord = coords.substring(0, UserSettings.getSetting("B").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("B").lastIndexOf(" ")+1, UserSettings.getSetting("B").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressX(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("X"));
		String xCoord = coords.substring(0, UserSettings.getSetting("X").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("X").lastIndexOf(" ")+1, UserSettings.getSetting("X").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressY(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("Y"));
		String xCoord = coords.substring(0, UserSettings.getSetting("Y").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("Y").lastIndexOf(" ")+1, UserSettings.getSetting("Y").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressPlus(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("PLUS"));
		String xCoord = coords.substring(0, UserSettings.getSetting("PLUS").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("PLUS").lastIndexOf(" ")+1, UserSettings.getSetting("PLUS").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressMinus(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("MINUS"));
		String xCoord = coords.substring(0, UserSettings.getSetting("MINUS").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("MINUS").lastIndexOf(" ")+1, UserSettings.getSetting("MINUS").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressHome(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("HOME"));
		String xCoord = coords.substring(0, UserSettings.getSetting("HOME").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("HOME").lastIndexOf(" ")+1, UserSettings.getSetting("HOME").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressRight(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("RIGHT_DPAD"));
		String xCoord = coords.substring(0, UserSettings.getSetting("RIGHT_DPAD").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("RIGHT_DPAD").lastIndexOf(" ")+1, UserSettings.getSetting("RIGHT_DPAD").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressLeft(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("LEFT_DPAD"));
		String xCoord = coords.substring(0, UserSettings.getSetting("LEFT_DPAD").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("LEFT_DPAD").lastIndexOf(" ")+1, UserSettings.getSetting("LEFT_DPAD").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressUp(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("UP_DPAD"));
		String xCoord = coords.substring(0, UserSettings.getSetting("UP_DPAD").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("UP_DPAD").lastIndexOf(" ")+1, UserSettings.getSetting("UP_DPAD").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressDown(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("DOWN_DPAD"));
		String xCoord = coords.substring(0, UserSettings.getSetting("DOWN_DPAD").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("DOWN_DPAD").lastIndexOf(" ")+1, UserSettings.getSetting("DOWN_DPAD").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressZR(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("ZR"));
		String xCoord = coords.substring(0, UserSettings.getSetting("ZR").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("ZR").lastIndexOf(" ")+1, UserSettings.getSetting("ZR").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressR(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("R"));
		String xCoord = coords.substring(0, UserSettings.getSetting("R").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("R").lastIndexOf(" ")+1, UserSettings.getSetting("R").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressL(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("L"));
		String xCoord = coords.substring(0, UserSettings.getSetting("L").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("L").lastIndexOf(" ")+1, UserSettings.getSetting("L").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressZL(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("ZL"));
		String xCoord = coords.substring(0, UserSettings.getSetting("ZL").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("ZL").lastIndexOf(" ")+1, UserSettings.getSetting("ZL").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressRightStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("RIGHTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("RIGHTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void pressLeftStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("LEFTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("LEFTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void moveUpLeftStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("LEFTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("LEFTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord)+50, Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void moveDownLeftStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("LEFTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("LEFTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord)-50, Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void moveLeftLeftStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("LEFTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("LEFTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord)-50);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void moveRightLeftStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("LEFTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("LEFTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord)+50);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void moveUpRightStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("RIGHTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("RIGHTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord)+50, Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void moveDownRightStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("RIGHTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("RIGHTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord)-50, Integer.parseInt(yCoord));
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void moveLeftRightStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("RIGHTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("RIGHTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord)-50);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void moveRightRightStick(int delay1, int delay2) {
		String coords = UserSettings.getSetting(("RIGHTSTICK_CENTER"));
		String xCoord = coords.substring(0, UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" "));
		String yCoord = coords.substring(UserSettings.getSetting("RIGHTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("RIGHTSTICK_CENTER").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord)+50);
		else
			return;
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}

	public void refreshOnline() {
		int delay1 = 180;
		// Y button
		pressY(delay1, 1000);

		// Plus button
		pressPlus(delay1, 20000);

		// A button
		pressA(delay1, 120);

		// B button
		pressB(delay1, 1500);

		// Y button
		pressY(delay1, 1000);

		// Plus button
		pressPlus(delay1, 1000);

		// A button1
		pressA(delay1, 5000);

		// A button
		pressA(delay1, 120);

		// B button
		pressB(delay1, 500);
	}

	public void openCalendar() {
		int delay1 = 180;
		int delay2 = 100;
		// Home button
		pressHome(delay1, 500);

		// Down button
		pressDown(delay1, 420);

		// Right button
		pressRight(600, delay2);

		// Left button
		pressLeft(delay1, delay2);

		// A button
		pressA(delay1, 900);

		// Down button
		pressDown(1400, delay2);

		// A button
		pressA(delay1, 400);

		// Down button
		pressDown(680, delay2);

		// A button
		pressA(delay1, 400);

		// Down button
		for (int i = 0; i < 2; i++)
			pressDown(200, 100);

		// A button
		pressA(delay1, 185);
	}

	public void changeDayBackwards() {
		int delay1 = 180;
		int delay2 = 100;

		openCalendar();

		// Right button
		pressRight(delay1, delay2);

		// Down button
		pressDown(delay1, delay2);

		// Right button
		pressRight(600, delay2);

		// A button
		pressA(delay1, 185);
	}

	public void changeDayForward() {
		int delay1 = 180;
		int delay2 = 100;

		openCalendar();

		// Right button
		pressRight(delay1, delay2);

		// Up button
		pressUp(delay1, delay2);

		// Right button
		pressRight(600, delay2);

		// A button
		pressA(delay1, 185);
	}

	public void fastChangeDayBackwards() {
		int delay1 = 200;
		int delay2 = 100;

		openCalendar();

		// Right button
		pressRight(delay1, delay2);

		// Down button
		pressDown(delay1-20, delay2);

		// Right button5
		pressRight(700, delay2);

		// A button
		pressA(250, 250);
	}


	public void fastChangeDayForward() {
		int delay1 = 200;
		int delay2 = 100;

		// A button
		pressA(250,  250);

		// Left button
		pressLeft(700, delay2);

		// Right button
		pressRight(delay1, delay2);

		// Up button
		pressUp(delay1-20, delay2);

		// Right button
		pressRight(700, delay2);

		// A button
		pressA(250, 350);
	}
}
