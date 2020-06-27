package pokemonBot;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import DataManagment.UserSettings;
import abstractClass.AbstractBotLogic;

public class EggFarmBot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	private boolean isEggTimerRunning;
	private int secPassed;
	private int sec;
	private Timer timer;
	private String xCoord;
	private String yCoord;
	public EggFarmBot(Robot robot, String macroProfilenNumber, int sec) {
		super(robot, macroProfilenNumber);
		isEggTimerRunning = false;
		secPassed = 0;
		this.sec = sec;
		xCoord = UserSettings.getSetting("LEFTSTICK_CENTER").substring(0, UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" "));
		yCoord = UserSettings.getSetting("LEFTSTICK_CENTER").substring(UserSettings.getSetting("LEFTSTICK_CENTER").lastIndexOf(" ")+1, UserSettings.getSetting("LEFTSTICK_CENTER").length());
	}

	//StopWatch for egg hatching when going in circles.
	public void startEggTimer() {
		isEggTimerRunning = true;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				secPassed++;
				System.out.println("Egg " + secPassed);
				if(secPassed == sec) {
					stopEggTimer();
				}
			}
		}, 1000, 1000);
	}

	public void stopEggTimer() {
		secPassed = 0;
		timer.cancel();
		isEggTimerRunning = false;
	}

	@Override
	public void run() {
		while(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			this.hatchEggsForMe();	
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}

	private void hatchEggsForMe() {
		int delay1 = 200;
		int circle_Delay = 25;
		double angle = 0;
		int radius = 50;

		// Move Character Down
		moveDownLeftStick(delay1, 0);

		// L button
		pressL(delay1, 1500);

		// Move Character Up
		moveUpLeftStick(900, 1500);

		// Move Character Right
		moveRightLeftStick(300, 1500);

		// A button
		pressA(delay1, 1200);

		// A button
		pressA(delay1, 3100);

		// A button
		pressA(delay1, 2000);

		// A button
		pressA(delay1, 1000);

		// A button
		pressA(delay1, 2000);

		// Down button
		pressDown(delay1, 300);

		// A button
		pressA(delay1, 3200);

		// A button
		pressA(delay1, 2000);

		// A button
		pressA(delay1, 800);

		// Move Camera Left
		moveLeftRightStick(1350, 0);

		// Move Character Up
		moveUpLeftStick(3300, 1500);

		// Plus button
		pressPlus(delay1, 500);

		//Going in circles for egg hatching
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			startEggTimer();
		while(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned() && isEggTimerRunning) {
			/*Formula for any shape motion, like circular/hexagon/square ext.
			 *
			 * Variables that you need:
			 * 		Center point of the object X,Y
			 * 		Radius of the object
			 * 		Angle of the object. When incrementing the angle by a fixed
			 * 			constant, provides the animation for that shape.
			 *
			 * Formula:
			 * 		CenterX + cos(2*angle*pi/#ofEdges)*radius = posX
			 * 		CenterY + sin(2*angle*pi/#ofEdges)*radius = posY
			 */
			angle-=0.1;
			robot.mouseMove((int)(Integer.parseInt(xCoord)+Math.cos(angle)*radius), (int) (Integer.parseInt(yCoord) + Math.sin(angle)*radius));
			if(angle == -0.1) {
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			}
			robot.delay(circle_Delay);
		}
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		if(isEggTimerRunning || (this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()))
			stopEggTimer();

		// A button
		pressA(delay1, 16000);

		// A button
		pressA(delay1, 3800);

		// X button
		pressX(delay1, 1000);

		// A button
		pressA(delay1, 3800);

		// A button
		pressA(delay1, 1000);

		// A button
		pressA(delay1, 4800);

		// Plus button
		pressPlus(delay1, 1000);
	}
}
