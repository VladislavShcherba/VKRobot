package step;

import io.cucumber.java.en.When;
import page.StandardVKPage;

public class StandardVKPageSteps {

    private StandardVKPage standardVKPage = new StandardVKPage();

    @When("user opens his profile")
    public void userOpensHisProfile() {
        standardVKPage.leftSideMenu().openMyProfile();
    }

}
