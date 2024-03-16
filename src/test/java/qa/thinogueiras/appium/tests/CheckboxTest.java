package qa.thinogueiras.appium.tests;

import static java.util.List.of;
import static qa.thinogueiras.appium.core.DriverFactory.getDriver;
import static qa.thinogueiras.appium.core.Helpers.ClickText;
import static qa.thinogueiras.appium.core.Helpers.NavigateTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import qa.thinogueiras.appium.core.BaseTest;

public class CheckboxTest extends BaseTest {

	@Test
	public void deveMarcarAsTechsQueUsamAppium() {
		NavigateTo("Check e Radio");
		ClickText("Checkbox");
		
		List<String> techs = new ArrayList<>();
		techs.addAll(of("Ruby", "Python", "Java", "Javascript", "C#", "Robot Framework"));
		
		for (String tech : techs) {			
			getDriver()
				.findElement(By.xpath("//android.widget.CheckBox[contains(@text, '" + tech + "')]")).click();
		}
	}
}
