package qa.thinogueiras.appium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static qa.thinogueiras.appium.core.Helpers.ClickText;
import static qa.thinogueiras.appium.core.Helpers.LongClick;
import static qa.thinogueiras.appium.core.Helpers.NavigateTo;
import static qa.thinogueiras.appium.core.Helpers.ToastValidator;

import org.junit.jupiter.api.Test;

import qa.thinogueiras.appium.core.BaseTest;

public class ClickTest extends BaseTest {	

	@Test
	public void deveRealizarUmCliqueSimples() {
		
		NavigateTo("Clique em Botões");
		ClickText("Clique simples");
		ClickText("CLIQUE SIMPLES");
		
		assertEquals("Isso é um clique simples", ToastValidator());
	}
	
	@Test
	public void deveRealizarUmCliqueLongo() {
		NavigateTo("Clique em Botões");
		ClickText("Clique longo");
		
		LongClick("com.qaxperience.yodapp:id/long_click");
		
		assertEquals("Isso é um clique longo", ToastValidator());
	}
}
