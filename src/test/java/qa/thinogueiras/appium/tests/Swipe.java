package qa.thinogueiras.appium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static qa.thinogueiras.appium.core.DriverFactory.getDriver;
import static qa.thinogueiras.appium.core.Helpers.ClickElementById;
import static qa.thinogueiras.appium.core.Helpers.ClickText;
import static qa.thinogueiras.appium.core.Helpers.NavigateTo;
import static qa.thinogueiras.appium.core.Helpers.Swipe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import qa.thinogueiras.appium.core.BaseTest;

public class Swipe extends BaseTest {

	@Test
	public void deveRemoverDarthVader() {

		NavigateTo("Star Wars");
		ClickText("Lista");
		
		String character = "@darthvader";
		String locator = "//android.widget.TextView[@text='" + character + "']";

		Swipe(locator, 650, 3);

		ClickElementById("com.qaxperience.yodapp:id/btnRemove");
		
		String message = getDriver().findElement(By
				.xpath("//*[@resource-id='com.qaxperience.yodapp:id/snackbar_text']"))
				.getText();

		assertEquals("Item removido! (posição = 1)", message);
	}
}
