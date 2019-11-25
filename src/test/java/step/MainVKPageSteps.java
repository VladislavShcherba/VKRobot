package step;

import io.cucumber.java.en.Then;
import page.MainVKPage;

public class MainVKPageSteps {

    private MainVKPage mainVKPage = new MainVKPage();

    @Then("user page is displayed")
    public void userPageIsDisplayed() {
        mainVKPage.verifyPageNameIsVisible();
        mainVKPage.verifyPageAvatarBigIsVisible();
    }
}
