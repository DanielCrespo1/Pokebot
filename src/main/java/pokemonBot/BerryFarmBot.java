package pokemonBot;

import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import abstractClass.AbstractBotLogic;

public class BerryFarmBot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	private boolean isSpammingB;
	private boolean isSpammingA;
	private int secPassed1;
	private int secPassed2;
	private Timer timer1;
	private Timer timer2;
	public BerryFarmBot(Robot robot, String macroProfilenNumber) {
		super(robot, macroProfilenNumber);
		isSpammingB = false;
		isSpammingA = false;
		secPassed1 = 0;
		secPassed2 = 0;
	}

	@Override
	public void run() {
		while(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			berryFarm();
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}

	//StopWatch for spamming A when collecting berry.
	public void startSpammingATimer() {
		isSpammingA = true;
		timer1 = new Timer();
		timer1.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				secPassed1++;
				if(secPassed1 == 2) {
					stopSpammingATimer();
				}
			}
		}, 1000, 1000);
	}

	public void stopSpammingATimer() {
		secPassed1 = 0;
		timer1.cancel();
		isSpammingA = false;
	}


	//StopWatch for spamming B when collecting berry.
	public void startSpammingBTimer() {
		isSpammingB = true;
		timer2 = new Timer();
		timer2.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				secPassed2++;
				if(secPassed2 == 8) {
					stopSpammingBTimer();
				}
			}
		}, 1000, 1000);
	}

	public void stopSpammingBTimer() {
		secPassed2 = 0;
		timer2.cancel();
		isSpammingB = false;
	}

	private void berryFarm() {

		int delay1 = 200;

		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			startSpammingATimer();
		while(isSpammingA && this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			pressA(delay1, 80);
		if(isSpammingA || (this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()))
			stopSpammingATimer();

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
