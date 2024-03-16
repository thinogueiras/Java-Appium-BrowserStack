package qa.thinogueiras.appium.core;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverFactory {

	public static AppiumDriver driver;

	public static AppiumDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	private static void createDriver() {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("platformName", "Android");
		options.setCapability("deviceName", "Android Emulator");
		options.setCapability("automationName", "UIAutomator2");
		options.setCapability("app", "C:\\Users\\Thiago\\eclipse-workspace\\Java-Appium-Tests\\app\\yodapp-beta.apk");
		options.setCapability("udid", "emulator-5554");
		options.setCapability("autoGrantPermissions", true);

		try {
			driver = new AppiumDriver(new URL("http://localhost:4723"), options);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}