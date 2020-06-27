package pokemonBot;

import java.awt.Robot;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import abstractClass.AbstractBotLogic;

public class SurpriseTradeBot extends AbstractBotLogic implements NativeKeyListener, Runnable {
	private int boxes;
	public SurpriseTradeBot(Robot robot, String macroProfileKeyBind, int numOfBoxesToDelete) {
		super(robot, macroProfileKeyBind);
		boxes = numOfBoxesToDelete;
	}

	@Override
	public void run() {
		int i = 0;
		while(this.getBotStateOf(macroProfileKeyBind) && i!=boxes && !isShutdowned()) {
			i++;
			this.surpiseTrade();
			this.changeBox();
		}
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}

	private void surpiseTrade() {
		int delay1 = 200;
		int delay2 = 160;
		for (int i = 0; i < 5; i++) {
			if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()) {
				for (int j = 0; j < 6; j++) {
					if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()) {
						// Y button
						pressY(delay1, 900);

						// Down button
						pressDown(delay1, delay2);

						// A button 
						pressA(delay1, 1700);

						// Select next Pokemon
						this.lookForNextPokemon(j,i);

						robot.delay(60000);

						// Y button
						pressY(delay1, 23500);
					}else {break;}
				}
			}else {break;}
		}
	}
	
	public void lookForNextPokemon(int row, int columns) {
		int delay1 = 200;
		for (int i = 0; i < columns; i++) {
			if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()) {
				// Down button
				pressDown(delay1, 120);
			}else {break;}
		}
		for (int i = 0; i < row; i++) {
			if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()) {
				// Right button
				pressRight(delay1, 120);
			}else {break;}
		}
		selectThisPokemon();
	}

	public void selectThisPokemon() {
		int delay1 = 200;
		// A button
		pressA(delay1, 500);

		// A button
		pressA(delay1, 6000);

		// A button
		pressA(delay1, 1100);

		// A button
		pressA(delay1, 1100);

		// A button
		pressA(delay1, 800);
	}
	
	private void changeBox() {
		int delay1 = 200;
		int delay2 = 120;
		// X button
		pressX(delay1, 600);

		// A button 
		pressA(delay1, 1200);

		// R button
		pressR(delay1, 2200);

		// Up button
		pressUp(delay1, delay2);

		// Right button
		pressRight(delay1, delay2);

		// B button
		pressB(delay1, 2200);

		// B button
		pressB(delay1, 1200);

		// B button
		pressB(delay1, 800);
	}
}
