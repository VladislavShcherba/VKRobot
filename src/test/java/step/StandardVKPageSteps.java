package step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.StandardVKPage;

public class StandardVKPageSteps {

    private StandardVKPage standardVKPage = new StandardVKPage();

    @When("user opens his profile")
    public void userOpensHisProfile() {
        standardVKPage.leftSideMenu().openMyProfile();
    }

    @Given("user has opened friends page")
    public void userHasOpenedFriendsPage() {
        standardVKPage.leftSideMenu().openFriends();
    }

    @Given("user has opened communities page")
    public void communityPageIsDisplayed() {
        standardVKPage.leftSideMenu().openCommunities();
    }

}
