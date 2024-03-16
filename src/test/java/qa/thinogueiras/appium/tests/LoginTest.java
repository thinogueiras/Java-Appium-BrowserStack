package qa.thinogueiras.appium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static qa.thinogueiras.appium.core.Helpers.ClickElementById;
import static qa.thinogueiras.appium.core.Helpers.ClickText;
import static qa.thinogueiras.appium.core.Helpers.InputTextById;
import static qa.thinogueiras.appium.core.Helpers.NavigateTo;
import static qa.thinogueiras.appium.core.Helpers.ToastValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qa.thinogueiras.appium.core.BaseTest;

public class LoginTest extends BaseTest {
	
	private String email = "com.qaxperience.yodapp:id/etEmail";
	private String password = "com.qaxperience.yodapp:id/etPassword";
	private String btnEntrar = "com.qaxperience.yodapp:id/btnSubmit";
	
	@BeforeEach
	public void commonsMethods() {
		NavigateTo("Formulários");		
		ClickText("Login");
		InputTextById(email, "yoda@qax.com");
	}
	
	@Test
	public void deveLogarComSucesso() {		
		
		InputTextById(password, "jedi");
		
		ClickElementById(btnEntrar);
		
		assertEquals("Boas vindas, logado você está.", ToastValidator());
	}
	
	@Test
	public void deveValidarSenhaIncorreta() {		
		
		InputTextById(password, "test");
		
		ClickElementById(btnEntrar);
		
		assertEquals("Oops! Credenciais incorretas.", ToastValidator());
	}
}
