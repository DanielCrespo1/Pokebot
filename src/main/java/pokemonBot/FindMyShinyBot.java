package pokemonBot;

import java.awt.Robot;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import DataManagment.UserSettings;
import GUI.FrameCounter;
import abstractClass.AbstractBotLogic;

public class FindMyShinyBot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	private int frame;
	private int count;
	private FrameCounter window;
	public FindMyShinyBot(Robot robot, String macroProfilenNumber, Integer frame) {
		super(robot, macroProfilenNumber);
		this.frame = frame;
		count = 1;
	}

	@Override
	public void run() {
		if(window != null)
			window.dispose();
		window = new FrameCounter(UserSettings.getSetting("FIND_SHINY_FRAMES"), "0");
		window.setVisible(true);
		while(count < frame-3 && this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			findMyShiny();
		
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}
	
	private void findMyShiny() {
		int delay1 = 200;
		changeDayForward();
		FrameCounter.setFrameSkipCounter(count);
		while(count < frame-3 && this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()) {
			if(Math.floorMod(count, 200) == 0) {
				// Home button
				for (int j = 0; j < 2; j++)
					pressHome(delay1, 800);
				
				//X button
				pressX(delay1, 1000);
				
				//A button
				pressA(delay1, 1500);
				
				//A button
				pressA(delay1, 2500);
				
				changeDayForward();
				count++;
				FrameCounter.setFrameSkipCounter(count);
			}else if(Math.floorMod(count, 30) != 0) {
				fastChangeDayForward();
				count++;
				FrameCounter.setFrameSkipCounter(count);
			}else if(Math.floorMod(count, 30) == 0) {
				fastChangeDayForward();
				fastChangeDayForward();
				count++;
				FrameCounter.setFrameSkipCounter(count);
			}
		}
	}
}
