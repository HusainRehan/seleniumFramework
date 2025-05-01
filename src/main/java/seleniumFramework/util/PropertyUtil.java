package seleniumFramework.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {
private static Properties properties = new Properties();

private PropertyUtil() {
	// private constructor to prevent instantiation
}

public static void loadProperties() throws Exception {
	String rootDirectory = System.getProperty("user.dir");
	properties.load(new FileInputStream(new File(rootDirectory + "/src/test/resources/config/Application.properties")));
}

public static String getProperty(String key) {
	return properties.getProperty(key);
}
}
