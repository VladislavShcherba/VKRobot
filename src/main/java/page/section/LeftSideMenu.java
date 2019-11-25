package page.section;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LeftSideMenu {

    private ElementsCollection menuItems = elements("#side_bar_inner li");

    public void openMyProfile() {
        open("My Profile");
    }

    public void openNews() {
        open("News");
    }

    public void openMessages() {
        open("Messages");
    }

    public void openFriends() {
        open("Friends");
    }

    public void openCommunities() {
        open("Communities");
    }

    private void open(String menuItemName) {
        menuItems.find(exactText(menuItemName)).click();
    }

}
