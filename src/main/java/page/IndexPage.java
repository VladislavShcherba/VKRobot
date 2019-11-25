package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.element;

public class IndexPage {

    private SelenideElement emailInput = element(byId("index_email"));
    private SelenideElement passwordInput = element(byId("index_pass"));
    private SelenideElement loginButton = element(byId("index_login_button"));

    public void login(String email, String password) {
        emailInput.val(email);
        passwordInput.val(password);
        loginButton.click();
    }

}
