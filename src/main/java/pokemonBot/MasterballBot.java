package pokemonBot;

import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import abstractClass.AbstractBotLogic;

public class MasterballBot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	private boolean isSpammingB;
	private int secPassed;
	private Timer timer;
	public MasterballBot(Robot robot, String macroProfileKeyBind) {
		super(robot, macroProfileKeyBind);
		isSpammingB = false;
		secPassed = 0;
	}

	//StopWatch for spamming B in the lotto.
	public void startSpammingBTimer() {
		isSpammingB = true;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				secPassed++;
				if(secPassed == 11) {
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

	@Override
	public void run() {
		while(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()) {
			this.lottoFarm();
		}
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}

	private void lottoFarm() {
		int delay1 = 200;
		int delay2 = 600;

		// A button
		for (int i = 0; i < 2; i++)
			pressA(delay1, 500);

		// Down button
		pressDown(delay1, 180);

		// A button
		pressA(delay1, 900);

		// A button
		pressA(delay1, delay2);

		// A button
		pressA(delay1, delay2);

		// A button
		pressA(delay1, delay2);

		// A button
		pressA(delay1, delay2);

		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			startSpammingBTimer();
		while(isSpammingB && this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			pressB(delay1, 80);
		if(isSpammingB || (this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()))
			stopSpammingBTimer();

		changeDayBackwards();
		fastChangeDayForward();
		
		// Home button
		for (int i = 0; i < 2; i++)
			pressHome(delay1, 800);
	}
}
