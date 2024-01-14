package qa.thinogueiras.appium.core;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.fail;
import static qa.thinogueiras.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class Helpers {

	private static WebElement element;

	public static void NavigateTo(String submenu) {

		getDriver().findElement(By.xpath("//*[@content-desc='Open navigation drawer']")).click();

		getDriver()
				.findElement(
						By.xpath("//*[@resource-id=\"com.qaxperience.yodapp:id/navView\"]//*[@text='" + submenu + "']"))
				.click();
	}

	public static void ClickText(String text) {
		getDriver().findElement(By.xpath("//*[@text='" + text + "']")).click();
	}

	public static void ClickElementByXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public static void ClickElementById(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public static void LongClick(String locator) {
		element = getDriver().findElement(By.id(locator));

		Actions actions = new Actions(getDriver());
		actions.clickAndHold(element).perform();
	}

	public static void InputTextByXpath(String xpath, String text) {
		getDriver().findElement(By.xpath(xpath)).sendKeys(text);
	}

	public static void InputTextById(String id, String text) {
		getDriver().findElement(By.id(id)).sendKeys(text);
	}

	public static String ToastValidator() {
		String toastMessage = "";

		try {
			toastMessage = getDriver().findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");

		} catch (NoSuchElementException e) {
			fail("An element could not be located on the page using the given search parameters.");
		}

		return toastMessage;
	}

	public static void Swipe(String locator, int deslocation, int seconds) {
		try {
			element = getDriver().findElement(By.xpath(locator));

			int startX = element.getLocation().getX();
			int startY = element.getLocation().getY();
			int endX = startX + element.getSize().getWidth() - deslocation;
			int endY = startY + element.getSize().getHeight();

			new TouchAction<>(getDriver())
				.press(point(startX, startY))
				.waitAction(waitOptions(ofSeconds(seconds)))
				.moveTo(point(endX, endY))
				.release()
				.perform();

		} catch (NoSuchElementException e) {
			fail("An element could not be located on the page using the given search parameters.");
		}
	}
	
	public static void Drag_n_Drop(String origin, String target) {		
		try {			
			WebElement start = getDriver().findElement(By.xpath(origin));
			WebElement end = getDriver().findElement(By.xpath(target));
			
			new TouchAction<>(getDriver())
				.longPress(longPressOptions().withElement(ElementOption.element(start)))
				.moveTo(element(end))
				.release()
				.perform();
			
		} catch (NoSuchElementException e) {
			fail("An element could not be located on the page using the given search parameters.");
		}
	}
}
