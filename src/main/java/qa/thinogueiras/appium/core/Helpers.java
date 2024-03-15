package qa.thinogueiras.appium.core;

import static org.junit.jupiter.api.Assertions.fail;
import static qa.thinogueiras.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.Sequence;

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

			GenericSwipe(startX, startY, endX, endY);

		} catch (NoSuchElementException e) {
			fail("An element could not be located on the page using the given search parameters.");
		}
	}

	public static void GenericSwipe(int startX, int startY, int endX, int endY) {
		PointerInput FINGER = new PointerInput(Kind.TOUCH, "finger");
		Sequence drag = new Sequence(FINGER, 1)
				.addAction(
						FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
				.addAction(FINGER.createPointerDown(MouseButton.LEFT.asArg()))
				.addAction(new Pause(FINGER, Duration.ofMillis(500)))
				.addAction(
						FINGER.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY))
				.addAction(FINGER.createPointerUp(MouseButton.LEFT.asArg()));
		getDriver().perform(Arrays.asList(drag));
	}

	public static void Drag_n_Drop(String origem, String destino) {
		WebElement inicio = getDriver().findElement(By.xpath(origem));
		WebElement fim = getDriver().findElement(By.xpath(destino));

		PointerInput FINGER = new PointerInput(Kind.TOUCH, "finger");
		Sequence drag_n_drop = new Sequence(FINGER, 1);
		drag_n_drop
				.addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
						inicio.getLocation().getX(), inicio.getLocation().getY()));

		drag_n_drop.addAction(FINGER.createPointerDown(MouseButton.LEFT.asArg()));
		drag_n_drop.addAction(new Pause(FINGER, Duration.ofMillis(1000)));

		drag_n_drop.addAction(FINGER.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),
						fim.getLocation().getX(), fim.getLocation().getY()));

		drag_n_drop.addAction(FINGER.createPointerUp(MouseButton.LEFT.asArg()));
		getDriver().perform(Arrays.asList(drag_n_drop));
	}
}
