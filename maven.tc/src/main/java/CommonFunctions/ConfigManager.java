package CommonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	static Properties prop = new Properties();
	//getter
	public static Properties getProp() {
		return prop;
	}
	//setter
	public static void setProp(Properties prop) {
		ConfigManager.prop = prop;
	}
	//function to load properties
	public static void loadProperties() throws IOException{
		FileInputStream input = new FileInputStream("config");
		prop.load(input);
	}

}
