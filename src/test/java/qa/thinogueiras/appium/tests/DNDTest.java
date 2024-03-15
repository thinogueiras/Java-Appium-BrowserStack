package qa.thinogueiras.appium.tests;

import static qa.thinogueiras.appium.core.Helpers.ClickText;
import static qa.thinogueiras.appium.core.Helpers.Drag_n_Drop;
import static qa.thinogueiras.appium.core.Helpers.NavigateTo;

import org.junit.jupiter.api.Test;

import qa.thinogueiras.appium.core.BaseTest;

public class DNDTest extends BaseTest {

	@Test
	public void deveArrastarLukeSkywalkerParaTopoLista() {

		NavigateTo("Star Wars");
		ClickText("Lista");

		String locatorOrigin = "//*[contains(@text, '@leia')]/../../..//*[contains(@resource-id, 'drag_handle')]";

		String locatorTarget = "//*[contains(@text, '@skywalker')]/../../..//*[contains(@resource-id, 'drag_handle')]";
		
		Drag_n_Drop(locatorOrigin, locatorTarget);
		
		locatorOrigin = "//*[contains(@text, '@darthvader')]/../../..//*[contains(@resource-id, 'drag_handle')]";

		locatorTarget = "//*[contains(@text, '@skywalker')]/../../..//*[contains(@resource-id, 'drag_handle')]";
		
		Drag_n_Drop(locatorOrigin, locatorTarget);
		
		locatorOrigin = "//*[contains(@text, '@mando')]/../../..//*[contains(@resource-id, 'drag_handle')]";

		locatorTarget = "//*[contains(@text, '@skywalker')]/../../..//*[contains(@resource-id, 'drag_handle')]";
		
		Drag_n_Drop(locatorOrigin, locatorTarget);
	}
	
	@Test
	public void deveArrastarDarthVaderParaBaseLista() {
		NavigateTo("Star Wars");
		ClickText("Lista");

		String locatorOrigin = "//*[contains(@text, '@darthvader')]/../../..//*[contains(@resource-id, 'drag_handle')]";

		String locatorTarget = "//*[contains(@text, '@chewie')]/../../..//*[contains(@resource-id, 'drag_handle')]";
		
		Drag_n_Drop(locatorOrigin, locatorTarget);
	}
}
