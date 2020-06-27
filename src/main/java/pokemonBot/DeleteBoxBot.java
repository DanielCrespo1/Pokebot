package pokemonBot;

import java.awt.Robot;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import abstractClass.AbstractBotLogic;

public class DeleteBoxBot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	private int boxes;
	public DeleteBoxBot(Robot robot, String macroProfilenNumber, int numOfBoxesToDelete) {
		super(robot, macroProfilenNumber);
		boxes = numOfBoxesToDelete;
	}

	@Override
	public void run() {
		int i = 0;
		while(this.getBotStateOf(macroProfileKeyBind) && i!=boxes && !isShutdowned()) {
			this.deleteBox();
			this.changeBox();
			i++;
		}
		macroThatAreRunning.replace(macroProfileKeyBind, false);
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}

	private void changeBox() {
		int delay1 = 200;
		int delay2 = 120;
		// Down button
		pressDown(delay1, delay2);

		// Right button
		pressRight(delay1, delay2);
		
		// Down button
		pressDown(delay1, delay2);
		
		for (int i = 0; i < 2; i++) {
			// Right button
			pressRight(delay1, delay2);
		}
	}

	private void deletePokemon() {
		int delay1 = 200;
		int delay2 = 160;
		// A button
		pressA(delay1, delay2);
		
		// Up button
		pressUp(delay2, 120);

		// Up button
		pressUp(delay2, 120);

		// A button
		pressA(delay1, 900);

		// Up button
		pressUp(delay1, 120);

		// A button
		pressA(delay1, 1300);

		// A button
		pressA(delay1, 400);
	}

	private void deleteRowRight() {
		int delay1 = 200;
		int delay2 = 120;

		for (int i = 0; i < 6; i++) {
			if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
				this.deletePokemon();
			else
				return;
			if(i!=5) {
				// Right button
				pressRight(delay1, delay2);
			}else {
				// Down button
				pressDown(delay1, delay2);
			}
		}
	}

	private void deleteRowLeft() {
		int delay1 = 200;
		int delay2 = 120;

		for (int i = 0; i < 6; i++) {
			if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
				this.deletePokemon();
			else
				return;
			if(i!=5) {
				// Left button
				pressLeft(delay1, delay2);
			}else {
				// Down button
				pressDown(delay1, delay2);
			}
		}
	}

	private void deleteBox() {
		for (int i = 0; i < 3; i++) {
			if(i!=2) {
				this.deleteRowRight();
				this.deleteRowLeft();
			}else
				this.deleteRowRight();
		}
	}
}
