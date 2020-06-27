package DataManagment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class UserSettings {
	private static Properties userSettings = new Properties();

	public static void inputProperties() {
		String inputPropertiesPath = System.getenv("HOMEPATH")+ File.separator + "Pokebot" + File.separator + "PokebotSettings.properties";{
			try (InputStream input = new FileInputStream(inputPropertiesPath)) {
				userSettings.load(input);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void outputProperties() {
		String outputPropertiesPath = System.getenv("HOMEPATH")+ File.separator + "Pokebot" + File.separator + "PokebotSettings.properties";{
			try (OutputStream output = new FileOutputStream(outputPropertiesPath)) {
				userSettings.store(output, null);
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}

	public static void addSetting(String componentName, String setting) {			
		userSettings.setProperty(componentName, setting);
	}

	public static String getSetting(String componentName) {
		return userSettings.getProperty(componentName);
	}

	public static HashMap<String, String> nonUniquehotKeys() {
		ArrayList<MapEntry<String, String>> hotKeys = new ArrayList<>();
		HashMap<String, String> nonUniquehotKeys = new HashMap<>(); 
		hotKeys.add(new MapEntry<>("EGG_HOTKEY", getSetting("EGG_HOTKEY")));
		hotKeys.add(new MapEntry<>("SURPRISE_HOTKEY", getSetting("SURPRISE_HOTKEY")));
		hotKeys.add(new MapEntry<>("DELETE_HOTKEY", getSetting("DELETE_HOTKEY")));
		hotKeys.add(new MapEntry<>("WATT_HOTKEY", getSetting("WATT_HOTKEY")));
		hotKeys.add(new MapEntry<>("MASTERBALL_HOTKEY", getSetting("MASTERBALL_HOTKEY")));
		hotKeys.add(new MapEntry<>("SPAM_A_HOTKEY", getSetting("SPAM_A_HOTKEY")));
		hotKeys.add(new MapEntry<>("BERRY_HOTKEY", getSetting("BERRY_HOTKEY")));
		hotKeys.add(new MapEntry<>("FIND_SHINY_HOTKEY", getSetting("FIND_SHINY_HOTKEY")));
		hotKeys.add(new MapEntry<>("BARGAINING_HOTKEY", getSetting("BARGAINING_HOTKEY")));
		hotKeys.add(new MapEntry<>("FOSSIL_HOTKEY", getSetting("FOSSIL_HOTKEY")));
		hotKeys.add(new MapEntry<>("TEST_HOTKEY", getSetting("TEST_HOTKEY")));
		for (int i = 0; i < hotKeys.size(); i++) {
			for (int j = i+1; j < hotKeys.size(); j++) {
				if(!hotKeys.get(i).getValue().trim().isEmpty()) {
					if(hotKeys.get(i).getValue().equals(hotKeys.get(j).getValue())) {
						nonUniquehotKeys.put(hotKeys.get(i).getKey(), hotKeys.get(i).getValue());
						nonUniquehotKeys.put(hotKeys.get(j).getKey(), hotKeys.get(j).getValue());
					}
				}
			}
		}
		return nonUniquehotKeys;
	}
}
