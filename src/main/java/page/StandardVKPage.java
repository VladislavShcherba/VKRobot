package page;

import page.section.LeftSideMenu;
import page.section.hasLeftSideMenu;

public class StandardVKPage implements hasLeftSideMenu {
    @Override
    public LeftSideMenu leftSideMenu() {
        return new LeftSideMenu();
    }
}
