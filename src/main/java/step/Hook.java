package step;

import com.codeborne.selenide.WebDriverRunner;
import driver.Driver;
import exception.DriverConfigurationException;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class Hook {
    @Before
    public void before(Scenario scenario) throws DriverConfigurationException {
        Driver.open("https://www.google.com/");
    }

    @After
    public void after(Scenario scenario) {
        WebDriverRunner.getWebDriver().quit();
    }

    public static void main(String[] args) throws DriverConfigurationException {
        Driver.open("https://www.google.com/");
        element(byName("q")).val("hello selenide");
        WebDriverRunner.getWebDriver().quit();
    }
}
