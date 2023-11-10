package qa.thinogueiras.appium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static qa.thinogueiras.appium.core.Helpers.ClickElementById;
import static qa.thinogueiras.appium.core.Helpers.ClickText;
import static qa.thinogueiras.appium.core.Helpers.InputTextById;
import static qa.thinogueiras.appium.core.Helpers.NavigateTo;
import static qa.thinogueiras.appium.core.Helpers.ToastValidator;

import org.junit.jupiter.api.Test;

import qa.thinogueiras.appium.core.BaseTest;

public class Spinner extends BaseTest {

	@Test
	public void deveEscolherNivelJedi() {
		
		NavigateTo("Formulários");
		ClickText("Cadastro");
		
		InputTextById("com.qaxperience.yodapp:id/etUsername", "Thiago");
		InputTextById("com.qaxperience.yodapp:id/etEmail", "thiago@qax.com");
		InputTextById("com.qaxperience.yodapp:id/etPassword", "qax@123");
		
		ClickElementById("com.qaxperience.yodapp:id/spinnerJob");
		
		ClickText("Jedi");
		ClickText("CADASTRAR");

	    assertEquals("Tudo certo, boas vindas ao Yodapp!", ToastValidator());
	}
}
