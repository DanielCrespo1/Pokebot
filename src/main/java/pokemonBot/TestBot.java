package pokemonBot;

import java.awt.Robot;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import abstractClass.AbstractBotLogic;

public class TestBot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	public TestBot(Robot robot, String macroProfileKeyBind) {
		super(robot, macroProfileKeyBind);
	}

	@Override
	public void run() {
		while(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			this.test();
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}
	
	private void test() {
		int delay1 = 1000;
		int delay2 = 1000;
		pressA(delay1, delay2);
		pressB(delay1, delay2);
		pressX(delay1, delay2);
		pressY(delay1, delay2);
		pressPlus(delay1, delay2);
		pressMinus(delay1, delay2);
		pressHome(delay1, delay2);
		pressLeft(delay1, delay2);
		pressRight(delay1, delay2);
		pressUp(delay1, delay2);
		pressDown(delay1, delay2);
		pressZL(delay1, delay2);
		pressL(delay1, delay2);
		pressR(delay1, delay2);
		pressZR(delay1, delay2);
		pressRightStick(delay1, delay2);
		pressLeftStick(delay1, delay2);
		moveDownLeftStick(delay1, delay2);
		moveUpLeftStick(delay1, delay2);
		moveLeftLeftStick(delay1, delay2);
		moveRightLeftStick(delay1, delay2);
		moveUpRightStick(delay1, delay2);
		moveDownRightStick(delay1, delay2);
		moveLeftRightStick(delay1, delay2);
		moveRightRightStick(delay1, delay2);
	}
}
