package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import page.MainVKPage;

public class MainVKPageSteps {

    private MainVKPage mainVKPage = new MainVKPage();

    @Then("user page is displayed")
    public void userPageIsDisplayed() {
        mainVKPage.verifyPageNameIsVisible();
        mainVKPage.verifyPageAvatarBigIsVisible();
    }

    @And("the name of the user is {string}")
    public void theNameOfTheUserIs(String name) {
        mainVKPage.verifyPageNameIs(name);
    }

    @Then("community page is displayed")
    public void communityPageIsDisplayed() {
        mainVKPage.verifyPageNameIsVisible();
        mainVKPage.verifyPageAvatarSmallOrBigIsVisible();
    }

    @And("the name of the community is {string}")
    public void theNameOfTheCommunityIs(String name) {
        mainVKPage.verifyPageNameIs(name);
    }
}
