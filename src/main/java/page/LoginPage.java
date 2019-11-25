package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class LoginPage {

    private SelenideElement emailInput = element(byId("email"));
    private SelenideElement passwordInput = element(byId("pass"));
    private SelenideElement loginButton = element(byId("login_button"));

    public void login(String email, String password) {
        emailInput.val(email);
        passwordInput.val(password);
        loginButton.click();
    }

}
