package step;

import io.cucumber.java.en.When;
import page.FriendsPage;

public class FriendsPageSteps {

    private FriendsPage friendsPage = new FriendsPage();

    @When("user opens his friend {string} page")
    public void userOpensHisFriendPage(String name) {
        friendsPage.openMyFriendPage(name);
    }

    @When("user opens user from the search {string} page")
    public void userOpensUserFromTheSearchPage(String name) {
        friendsPage.openUserFromSearchPage(name);
    }
}
