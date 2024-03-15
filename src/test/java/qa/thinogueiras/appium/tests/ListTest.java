package qa.thinogueiras.appium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static qa.thinogueiras.appium.core.DriverFactory.getDriver;
import static qa.thinogueiras.appium.core.Helpers.ClickElementByXpath;
import static qa.thinogueiras.appium.core.Helpers.ClickText;
import static qa.thinogueiras.appium.core.Helpers.NavigateTo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import qa.thinogueiras.appium.core.BaseTest;

public class ListTest extends BaseTest {

	@Test
	public void deveValidarTextoSobrePrincesaLeia() {

		NavigateTo("Star Wars");
		ClickText("Lista");

		ClickElementByXpath(
				"//android.widget.TextView[@text='Princesa Leia']/../../..//*[contains(@resource-id, 'indicator')]");

		String characterText = "Princesa do planeta Alderaan, membro do Senado Imperial, espiã da Aliança Rebelde e general da Resistência.";

		WebElement elementText = getDriver().findElement(By.id("com.qaxperience.yodapp:id/textAboutExtended"));

		assertEquals(characterText, elementText.getText());
	}

	@Test
	public void deveValidarTextoSobreChewbacca() {

		NavigateTo("Star Wars");
		ClickText("Lista");

		ClickElementByXpath(
				"//android.widget.TextView[@text='Chewbacca']/../../..//*[contains(@resource-id, 'indicator')]");

		String characterText = "Copiloto da Millennium Falcon e o melhor amigo de Han Solo, é um alienígena da raça Wookiee.";

		WebElement elementText = getDriver().findElement(By.id("com.qaxperience.yodapp:id/textAboutExtended"));

		assertEquals(characterText, elementText.getText());

	}
}
