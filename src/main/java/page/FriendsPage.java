package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class FriendsPage extends StandardVKPage {

    private SelenideElement search  = element("#s_search");
    private ElementsCollection myFriendsNames = elements("#friends_list .friends_field_title a");
    private ElementsCollection usersFromSearchNames = elements("#friends_search_wrap .friends_field_title a");

    public void openMyFriendPage(String name) {
        search.val(name);
        myFriendsNames.first().click();
    }

    public void openUserFromSearchPage(String name) {
        search.val(name);
        usersFromSearchNames.first().click();
    }

}
