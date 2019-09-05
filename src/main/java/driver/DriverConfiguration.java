package driver;

import encoder.Encoder;
import exception.DriverConfigurationException;
import helper.JSONHelper;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Map;

/**
 * A singleton which function is to read configuration files with the information
 * needed to configure {@link Driver} instance, store that information in the memory
 * and then return it on demand without reading the files again.
 */
public class DriverConfiguration {

    private static final String executionJSONFile = "src/main/resources/execution.json";
    private static final String browserStackJSONFile = "src/main/resources/browserstack.json";

    /* Singleton instance */
    private static DriverConfiguration driverConfiguration;

    private boolean localExecution;
    private String localBrowserName;
    private int maxWaitingTime;

    private String browserStackServer;
    private String browserStackUser;
    private String browserStackKey;
    private URL browserStackURL;
    private DesiredCapabilities browserStackCapabilities;

    /**
     * Returns the instance of that {@link DriverConfiguration}.
     * @return  {@link DriverConfiguration} instance.
     */
    public static DriverConfiguration getInstance() throws DriverConfigurationException {
        if(driverConfiguration == null) {
            driverConfiguration = new DriverConfiguration();
        }
        return driverConfiguration;
    }

    private DriverConfiguration() throws DriverConfigurationException {
        try {
            JSONObject executionObject = JSONHelper.fileToJSONObject(executionJSONFile);

            String executionLocation = (String) executionObject.get("execution_location");
            localExecution = "local".equals(executionLocation);

            maxWaitingTime = Integer.parseInt((String) executionObject.get("max_waiting_time"));

            if (localExecution) {
                localBrowserName = (String) executionObject.get("local_browser");
            }

            if (!localExecution) {
                String remoteEnvironment = (String) executionObject.get("remote_environment");

                JSONObject browserStackObject = JSONHelper.fileToJSONObject(browserStackJSONFile);

                browserStackServer = Encoder.getInstance().decrypt((String) browserStackObject.get("server"));
                browserStackUser = Encoder.getInstance().decrypt((String) browserStackObject.get("user"));
                browserStackKey = Encoder.getInstance().decrypt((String) browserStackObject.get("key"));
                browserStackURL = new URL("http://" + browserStackUser + ":" + browserStackKey +
                        "@" + browserStackServer + "/wd/hub");

                browserStackCapabilities = new DesiredCapabilities();
                /* Read common capabilities */
                Map<String, String> capabilities = (Map<String, String>) browserStackObject.get("capabilities");
                capabilities.forEach((key, value) -> browserStackCapabilities.setCapability(key, value));

                /* Read environment specific capabilities. Overwrite common if needed */
                JSONObject environments = (JSONObject) browserStackObject.get("environments");
                Map<String, String> environment = (Map<String, String>) environments.get(remoteEnvironment);
                environment.forEach((key, value) -> browserStackCapabilities.setCapability(key, value));
            }
        } catch (Exception e) {
            throw new DriverConfigurationException(e);
        }
    }

    /**
     * Determines if {@link Driver} is configured to be executed locally or remotely.
     * @return {@code true} if the {@link Driver} is configured to be executed locally,
     * otherwise {@code false}.
     */
    public boolean isLocalExecution() {
        return localExecution;
    }

    /**
     * Determines the name of the browser that is used by {@link Driver} in case of
     * local execution.
     * @return browser name if execution is local, otherwise {@code null}.
     */
    public String getLocalBrowserName() {
        return localBrowserName;
    }

    /**
     * Determines maximum amount of time that {@link Driver} can afford to spend
     * on a single action before giving an error. For example, finding an element on a web page.
     * @return amount of time in milliseconds.
     */
    public int getMaxWaitingTime() {
        return maxWaitingTime;
    }

    /**
     * Determines BrowserStack DesiredCapabilities that is used by {@link Driver}
     * in case of remote execution.
     * @return DesiredCapabilities for BrowserStack if execution is remote, otherwise {@code null}.
     */
    public DesiredCapabilities getBrowserStackCapabilities() {
        return browserStackCapabilities;
    }

    /**
     * Determines BrowserStack URL that is used by {@link Driver} in case of remote
     * execution.
     * @return BrowserStack URL if execution is remote, otherwise {@code null}.
     */
    public URL getBrowserStackURL() {
        return browserStackURL;
    }

    /**
     * Determines BrowserStack server that is used by {@link Driver} in case of remote
     * execution.
     * @return BrowserStack server if execution is remote, otherwise {@code null}.
     */
    public String getBrowserStackServer() {
        return browserStackServer;
    }

    /**
     * Determines BrowserStack user that is used by {@link Driver} in case of remote
     * execution.
     * @return BrowserStack user if execution is remote, otherwise {@code null}.
     */
    public String getBrowserStackUser() {
        return browserStackUser;
    }

    /**
     * Determines BrowserStack key that is used by {@link Driver} in case of remote
     * execution.
     * @return decrypted BrowserStack key if execution is remote, otherwise {@code null}.
     */
    public String getBrowserStackKey() {
        return browserStackKey;
    }
}
