package qa.thinogueiras.appium.tests;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static qa.thinogueiras.appium.core.DriverFactory.getDriver;
import static qa.thinogueiras.appium.core.Helpers.ClickText;
import static qa.thinogueiras.appium.core.Helpers.InputTextByXpath;
import static qa.thinogueiras.appium.core.Helpers.NavigateTo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.thinogueiras.appium.core.BaseTest;

public class SearchTest extends BaseTest {

	private WebDriverWait wait;

	@Test
	public void deveBuscarPeloChewbacca() {

		NavigateTo("Star Wars");
		ClickText("Busca");

		String xpathCharacter = "//android.widget.EditText[@text=\"Busque aqui\"]";
		
		InputTextByXpath(xpathCharacter, "Chewbacca");

		try {
			wait = new WebDriverWait(getDriver(), ofSeconds(5));			
			wait.until(visibilityOf(getDriver().findElement(By.xpath(
					"//*[@resource-id='com.qaxperience.yodapp:id/tvResults'][contains(@text, '1 personagem encontrado')]"))));
		} catch (Exception e) {
			fail("Nenhum personagem encontrado!");
		}
	}
}
