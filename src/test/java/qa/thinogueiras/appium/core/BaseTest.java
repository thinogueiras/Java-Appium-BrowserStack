package qa.thinogueiras.appium.core;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.apache.commons.io.FileUtils.copyFile;
import static qa.thinogueiras.appium.core.DriverFactory.getDriver;
import static qa.thinogueiras.appium.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {

	public static AppiumDriver<MobileElement> driver;

	private String TestMethodName = "";
	
	public static void getStarted() {
		getDriver().findElement(By.xpath("//*[@text='QAX']")).click();
	}

	@BeforeEach
	public void startSession() throws MalformedURLException {
		getDriver();
		getDriver().manage().timeouts().implicitlyWait(10, SECONDS);

		getStarted();
	}	

	public void screenshot(String testName) throws IOException {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		copyFile(scrFile, new File("target/Screenshots/" + testName + ".jpg"));		
	}	

	@AfterEach
	public void finishSession(TestInfo testInfo) {
		try {
			TestMethodName = testInfo.getTestMethod().get().getName();			
			screenshot(TestMethodName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			killDriver();
		}
	}
}
