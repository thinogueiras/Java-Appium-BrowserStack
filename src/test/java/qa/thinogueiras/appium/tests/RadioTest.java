package qa.thinogueiras.appium.tests;

import static qa.thinogueiras.appium.core.Helpers.ClickElementByXpath;
import static qa.thinogueiras.appium.core.Helpers.ClickText;
import static qa.thinogueiras.appium.core.Helpers.NavigateTo;

import org.junit.jupiter.api.Test;

import qa.thinogueiras.appium.core.BaseTest;

public class RadioTest extends BaseTest {

	@Test
	public void deveSelecionarOpcaoPython() {
		NavigateTo("Check e Radio");
		
		ClickText("Botões de radio");
		
		ClickElementByXpath("//android.widget.RadioButton[contains(@text, 'Python')]");		
	}
}
