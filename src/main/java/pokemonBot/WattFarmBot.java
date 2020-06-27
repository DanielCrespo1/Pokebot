package pokemonBot;

import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import abstractClass.AbstractBotLogic;

public class WattFarmBot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	private boolean useOnline;
	private boolean isSaveTimerUp;
	private boolean firstTime;
	private int secPassed;
	private Timer timer;
	public WattFarmBot(Robot robot, String macroProfilenNumber, Boolean useOnline) {
		super(robot, macroProfilenNumber);
		this.useOnline = useOnline;
		isSaveTimerUp = false;
		firstTime = true;
		secPassed = 0;
	}

	@Override
	public void run() {
		startSaveTimer();
		while(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()) {
			if(useOnline && !isSaveTimerUp)
				fastWattFarm();
			else if(!isSaveTimerUp)
				wattFarm();
			else {
				stopSaveTimer();
				saveGame();
				startSaveTimer();
			}
		}
		firstTime = false;
	}

	//StopWatch for saving the game.1800
	public void startSaveTimer() {
		isSaveTimerUp = false;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				secPassed++;
				if(secPassed == 1800) {
					stopSaveTimer();
				}
			}
		}, 1000, 1000);
	}

	public void stopSaveTimer() {
		secPassed = 0;
		timer.cancel();
		isSaveTimerUp = true;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}

	private void saveGame() {
		int delay1 = 200;

		//X button
		pressX(delay1, 1000);

		//A button
		pressA(delay1, 1500);

		//A button
		pressA(delay1, 2500);
	}

	private void fastWattFarm() {
		int delay1 = 200;

		fastChangeDayBackwards();		
		fastChangeDayForward();

		// Home button
		for (int i = 0; i < 2; i++)
			pressHome(delay1, 800);

		// A button
		for (int i = 0; i < 3; i++)
			pressA(delay1, 600);

		// B button
		pressB(delay1, 1200);
	}

	private void wattFarm() {
		int delay1 = 200;

		if(firstTime) {
			firstTime = false;
			// A button
			pressA(delay1, 1600);

			// A button
			pressA(delay1, 3200);
		}else {
			// A button
			for (int i = 0; i < 3; i++)
				pressA(delay1, 600);

			robot.delay(3200);

			// A button
			pressA(delay1, 5200);
		}

		changeDayBackwards();

		// Home button
		for (int i = 0; i < 2; i++)
			pressHome(delay1, 800);

		// B button
		pressB(delay1, 1200);

		// A button
		pressA(delay1, 5200);

		// A button
		pressA(delay1, 1600);

		// A button
		pressA(delay1, 3200);

		changeDayForward();	

		// Home button
		for (int i = 0; i < 2; i++)
			pressHome(delay1, 800);

		// B button
		pressB(delay1, 1200);

		// A button
		pressA(delay1, 5200);
	}
}