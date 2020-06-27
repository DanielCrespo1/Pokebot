package pokemonBot;

import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import GUI.MainGUI.Fossil;
import abstractClass.AbstractBotLogic;

public class FossilBot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	private Fossil fossil;
	private boolean isSpammingB;
	private int secPassed;
	private int count;
	private int fossilToConvert;
	private Timer timer;
	public FossilBot(Robot robot, String macroProfilenNumber, String fossilToConvert, Fossil fossil) {
		super(robot, macroProfilenNumber);
		this.fossil = fossil;
		isSpammingB = false;
		secPassed = 0;
		count = 0;
		this.fossilToConvert = Integer.parseInt(fossilToConvert);
	}

	@Override
	public void run() {
		while(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned() && count < fossilToConvert) {
			farmFossil(fossil);
			count++;
		}
		macroThatAreRunning.replace(macroProfileKeyBind, false);
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}

	//StopWatch for spamming B when talking with scientist.
	public void startSpammingBTimer() {
		isSpammingB = true;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				secPassed++;
				if(secPassed == 14) {
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

	private void farmFossil(Object fossil) {
		if(fossil == Fossil.DRACOZOLT)
			farmDracozolt();
		else if(fossil == Fossil.ARCTOZOLT)
			farmArctozolt();
		else if(fossil == Fossil.DRACOVISH)
			farmDracovish();
		else if(fossil == Fossil.ARCTOVISH)
			farmArctovish();
	}

	private void farmDracozolt() {
		int delay1 = 200;

		//A button
		pressA(delay1, 700);

		//A button
		pressA(delay1, 1000);

		//A button
		pressA(delay1, 1000);

		//A button
		pressA(delay1, 1000);

		//A button
		pressA(delay1, 800);

		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			startSpammingBTimer();
		while(isSpammingB && this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			pressB(delay1, 80);
		if(isSpammingB || (this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()))
			stopSpammingBTimer();
	}

	private void farmArctozolt() {
		int delay1 = 200;

		//A button
		pressA(delay1, 700);

		//A button
		pressA(delay1, 1000);

		//A button
		pressA(delay1, 1000);

		// Down button
		pressDown(delay1, 80);

		//A button
		pressA(delay1, 1000);

		//A button
		pressA(delay1, 800);

		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			startSpammingBTimer();
		while(isSpammingB && this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			pressB(delay1, 80);
		if(isSpammingB || (this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()))
			stopSpammingBTimer();
	}

	private void farmDracovish() {
		int delay1 = 200;

		//A button
		pressA(delay1, 700);

		//A button
		pressA(delay1, 1000);

		// Down button
		pressDown(delay1, 80);

		//A button
		pressA(delay1, 1000);

		//A button
		pressA(delay1, 1000);

		//A button
		pressA(delay1, 800);

		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			startSpammingBTimer();
		while(isSpammingB && this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			pressB(delay1, 80);
		if(isSpammingB || (this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()))
			stopSpammingBTimer();
	}

	private void farmArctovish() {
		int delay1 = 200;

		//A button
		pressA(delay1, 700);

		//A button
		pressA(delay1, 1000);

		// Down button
		pressDown(delay1, 80);

		//A button
		pressA(delay1, 1000);

		// Down button
		pressDown(delay1, 80);

		//A button
		pressA(delay1, 1000);

		//A button
		pressA(delay1, 800);

		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			startSpammingBTimer();
		while(isSpammingB && this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			pressB(delay1, 80);
		if(isSpammingB || (this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()))
			stopSpammingBTimer();
	}
}
