package driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import exception.DriverConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Driver class provides functionality to configure Selenium WebDriver instance based on configurations
 * provided by {@link DriverConfiguration} class. The only one method {@link #open(String)}
 * serves as a substitute for {@code Selenide.open(String)} method.
 */
public class Driver {

    /**
     * Configures WebDriver instance, opens browser window with given URL.
     * @param url URL that will be opened first in browser window.
     */
    public static void open(String url) throws DriverConfigurationException {
        DriverConfiguration configuration = DriverConfiguration.getInstance();
        if(configuration.isLocalExecution()) {
            /* WebDriver created automatically by Selenide will be used */
            Configuration.browser = configuration.getLocalBrowserName();
        } else {
            URL browserStackURL = configuration.getBrowserStackURL();
            DesiredCapabilities capabilities = configuration.getBrowserStackCapabilities();
            WebDriver webDriver = new RemoteWebDriver(browserStackURL, capabilities);
            /* Force Selenide to use WebDriver created by user */
            WebDriverRunner.setWebDriver(webDriver);
        }
        Selenide.open(url);
        Configuration.timeout = configuration.getMaxWaitingTime();
    }

}