package pokemonBot;

import java.awt.Robot;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import DataManagment.UserSettings;
import abstractClass.AbstractBotLogic;

public class SpamABot extends AbstractBotLogic implements NativeKeyListener, Runnable {

	public SpamABot(Robot robot, String macroProfilenNumber) {
		super(robot, macroProfilenNumber);

	}

	@Override
	public void run() {
		String xCoord = UserSettings.getSetting("A").substring(0, UserSettings.getSetting("A").lastIndexOf(" "));
		String yCoord = UserSettings.getSetting("A").substring(UserSettings.getSetting("A").lastIndexOf(" ")+1, UserSettings.getSetting("A").length());
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			robot.mouseMove(Integer.parseInt(xCoord), Integer.parseInt(yCoord));
		else
			return;
		while(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned()) {
			if(isOnlineTimerRunning) {
				this.spamA();
			}else {
				this.refreshOnline();
				this.startOnlineTimer();
			}
		}
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		abstractNativeKeyPressed(e, this);
	}

	private void spamA() {
		int delay1 = 100;
		int delay2 = 50;
		// A button
		if(this.getBotStateOf(macroProfileKeyBind) && !isShutdowned())
			leftClick(delay1, delay2);
	}
}
