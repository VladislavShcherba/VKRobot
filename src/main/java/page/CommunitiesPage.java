package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CommunitiesPage extends StandardVKPage {

    private SelenideElement communitySearch = element(byId("groups_list_search"));
    private ElementsCollection followingCommunitiesNames = elements("#groups_list_groups .group_row_title");
    private ElementsCollection searchResultsNames = elements("#groups_list_search_cont .group_row_title");

    public void openFollowedCommunity(String name) {
        communitySearch.val(name);
        followingCommunitiesNames.first().click();
    }

    public void openCommunityFromSearch(String name) {
        communitySearch.val(name);
        searchResultsNames.first().click();
    }

}
