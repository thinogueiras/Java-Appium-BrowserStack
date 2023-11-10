package qa.thinogueiras.appium.core;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverFactory {
	
	public static AppiumDriver<MobileElement> driver;
	
	public static AppiumDriver<?> getDriver() {
		if(driver == null) {
			createDriver();
		}
		return driver;
	}
	
	private static void createDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "Android Emulator");
		caps.setCapability("automationName", "UIAutomator2");
		caps.setCapability("app", "/home/thiago.nogueira/eclipse-workspace/java-appium-android/app/yodapp-beta.apk");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("autoGrantPermissions", true);

		try {
			driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/"), caps);			
		} catch (MalformedURLException e) {			
			e.printStackTrace();		
		}
		
		driver.manage().timeouts().implicitlyWait(0, SECONDS);
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;			
		}
	}
}
