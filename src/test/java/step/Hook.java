package step;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void before(Scenario scenario) {
    }

    @After
    public void after(Scenario scenario) {
        WebDriverRunner.getWebDriver().quit();
    }

}
