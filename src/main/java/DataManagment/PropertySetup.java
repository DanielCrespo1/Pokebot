package DataManagment;

import java.io.File;

public class PropertySetup {

	public PropertySetup() {
		String outputPropertiesPath = System.getenv("HOMEPATH")+ File.separator + "Pokebot" + File.separator + "PokebotSettings.properties";
		File f = new File(outputPropertiesPath);
		if(!f.isFile()) {
			UserSettings.addSetting("A", DefaultSettings.A_COORDS);
			UserSettings.addSetting("B", DefaultSettings.B_COORDS);
			UserSettings.addSetting("X", DefaultSettings.X_COORDS);
			UserSettings.addSetting("Y", DefaultSettings.Y_COORDS);
			UserSettings.addSetting("UP_DPAD", DefaultSettings.UP_COORDS);
			UserSettings.addSetting("DOWN_DPAD", DefaultSettings.DOWN_COODS);
			UserSettings.addSetting("LEFT_DPAD", DefaultSettings.LEFT_COORDS);
			UserSettings.addSetting("RIGHT_DPAD", DefaultSettings.RIGHT_COORDS);
			UserSettings.addSetting("PLUS", DefaultSettings.PLUS_COORDS);
			UserSettings.addSetting("MINUS", DefaultSettings.MINUS_COORDS);
			UserSettings.addSetting("HOME", DefaultSettings.HOME_COORDS);
			UserSettings.addSetting("L", DefaultSettings.L_COORDS);
			UserSettings.addSetting("ZL", DefaultSettings.ZL_COORDS);
			UserSettings.addSetting("R", DefaultSettings.R_COORDS);
			UserSettings.addSetting("ZR", DefaultSettings.ZR_COORDS);
			UserSettings.addSetting("LEFTSTICK_CENTER", DefaultSettings.LEFTSTICK_COORDS);
			UserSettings.addSetting("RIGHTSTICK_CENTER", DefaultSettings.RIGHTSTICK_COORDS);
			UserSettings.addSetting("EGG_SEC", DefaultSettings.EGG_SEC);
			UserSettings.addSetting("EGG_HOTKEY", DefaultSettings.EGG_HOTKEY);
			UserSettings.addSetting("SURPRISE_BOXES", DefaultSettings.SURPRISE_BOXES);
			UserSettings.addSetting("SURPRISE_HOTKEY", DefaultSettings.SURPRISE_HOTKEY);
			UserSettings.addSetting("DELETE_BOXES", DefaultSettings.DELETE_BOXES);
			UserSettings.addSetting("DELETE_HOTKEY", DefaultSettings.DELETE_HOTKEY);
			UserSettings.addSetting("WATT_HOTKEY", DefaultSettings.WATT_HOTKEY);
			UserSettings.addSetting("MASTERBALL_HOTKEY", DefaultSettings.MASTERBALL_HOTKEY);
			UserSettings.addSetting("SPAM_A_HOTKEY", DefaultSettings.SPAM_A_HOTKEY);
			UserSettings.addSetting("BERRY_HOTKEY", DefaultSettings.BERRY_HOTKEY);
			UserSettings.addSetting("FIND_SHINY_FRAMES", DefaultSettings.FIND_SHINY_FRAMES);
			UserSettings.addSetting("FIND_SHINY_HOTKEY", DefaultSettings.FIND_SHINY_HOTKEY);
			UserSettings.addSetting("BARGAINING_HOTKEY", DefaultSettings.BARGAINING_HOTKEY);
			UserSettings.addSetting("FOSSIL_TO_CONVERT", DefaultSettings.FOSSIL_TO_CONVERT);
			UserSettings.addSetting("FOSSIL_HOTKEY", DefaultSettings.FOSSIL_HOTKEY);
			UserSettings.addSetting("TEST_HOTKEY", DefaultSettings.TEST_HOTKEY);
			UserSettings.addSetting("WATT_FARM_ONLINE", DefaultSettings.WATT_FARM_ONLINE);
			UserSettings.addSetting("FOSSIL", DefaultSettings.FOSSIL);
			UserSettings.outputProperties();
		}
		
		UserSettings.inputProperties();
		
		if(UserSettings.getSetting("FOSSIL_TO_CONVERT") == null) {
			UserSettings.addSetting("BERRY_HOTKEY", DefaultSettings.BERRY_HOTKEY);
			UserSettings.addSetting("BARGAINING_HOTKEY", DefaultSettings.BARGAINING_HOTKEY);
			UserSettings.addSetting("FOSSIL_TO_CONVERT", DefaultSettings.FOSSIL_TO_CONVERT);
			UserSettings.addSetting("FOSSIL_HOTKEY", DefaultSettings.FOSSIL_HOTKEY);
			UserSettings.addSetting("TEST_HOTKEY", DefaultSettings.TEST_HOTKEY);
			UserSettings.addSetting("FOSSIL", DefaultSettings.FOSSIL);
			UserSettings.outputProperties();
		}
	}
}
