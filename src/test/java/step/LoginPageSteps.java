package step;

import driver.Driver;
import exception.DriverConfigurationException;
import exception.EncoderException;
import exception.NoSuchUserException;
import exception.UsersDatabaseException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.IndexPage;
import page.LoginPage;
import user.User;
import user.UsersDatabase;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage();
    private IndexPage indexPage = new IndexPage();

    @Given("user is in {string} page")
    public void userIsInPage(String url)
            throws DriverConfigurationException {
        Driver.open(url);
    }

    @When("user {string} log in to the system from login page")
    public void userLogInToTheSystemFromLoginPage(String userName)
            throws UsersDatabaseException, NoSuchUserException, EncoderException {
        User user = UsersDatabase.getInstance().getUser(userName);
        loginPage.login(user.getEmail(), user.getPassword());
    }

    @When("user {string} log in to the system from index page")
    public void userLogInToTheSystemFromIndexPage(String userName)
            throws UsersDatabaseException, NoSuchUserException, EncoderException {
        User user = UsersDatabase.getInstance().getUser(userName);
        indexPage.login(user.getEmail(), user.getPassword());
    }
}
