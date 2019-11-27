package step;

import io.cucumber.java.en.When;
import page.CommunitiesPage;

public class CommunitiesPageSteps {

    private CommunitiesPage communitiesPage = new CommunitiesPage();

    @When("user opens followed community {string} page")
    public void userOpensFollowedCommunityPage(String name) {
        communitiesPage.openFollowedCommunity(name);
    }

    @When("user opens community from the search {string} page")
    public void userOpensCommunityFromTheSearchPage(String name) {
        communitiesPage.openCommunityFromSearch(name);
    }
}
