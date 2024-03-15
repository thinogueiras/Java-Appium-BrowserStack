package qa.thinogueiras.appium.suite;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Yodapp Android Tests")
@SelectPackages("qa.thinogueiras.appium.tests")
public class SuiteTest {

}
