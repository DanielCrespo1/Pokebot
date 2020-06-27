package pokemonBot;

import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import abstractClass.AbstractBotLogic;

public class BargainingBot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	private boolean isSpammingB;
	private int secPassed;
	private Timer timer;
	public BargainingBot(Robot robot, String macroProfilenNumber) {
		super(robot, macroProfilenNumber);
		isSpammingB = false;
		secPassed = 0;
	}

	@Override
	public void run() {
		while(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			bargainingFarm();
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}

	//StopWatch for spamming B when talking with bargaining guy.
	public void startSpammingBTimer() {
		isSpammingB = true;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				secPassed++;
				if(secPassed == 6) {
					stopSpammingBTimer();
				}
			}
		}, 1000, 1000);
	}

	public void stopSpammingBTimer() {
		secPassed = 0;
		timer.cancel();
		isSpammingB = false;
	}

	private void bargainingFarm() {
		int delay1 = 200;

		//A button
		pressA(delay1, 500);

		//A button
		pressA(delay1, 1200);

		//A button
		pressA(delay1, 1300);

		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			startSpammingBTimer();
		while(isSpammingB && this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			pressB(delay1, 80);
		if(isSpammingB || (this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()))
			stopSpammingBTimer();

		changeDayForward();

		// Home button
		for (int j = 0; j < 2; j++)
			pressHome(delay1, 800);
	}
}
