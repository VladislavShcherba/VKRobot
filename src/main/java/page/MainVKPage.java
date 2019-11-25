package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import page.section.Post;
import wait.Event;
import wait.EventWaiter;

import java.util.Iterator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainVKPage extends StandardVKPage implements Iterable<Post> {

    private SelenideElement pageNameElement = element(".page_name");
    private ElementsCollection wallPosts = elements(".wall_module .post");
    private SelenideElement pageAvatarBig = element(byId("page_avatar_wrap"));
    private SelenideElement pageAvatarSmall = element(".page_cover_image");

    public String getName() {
        return pageNameElement.text();
    }

    public void verifyPageNameIsVisible() {
        pageNameElement.shouldBe(visible);
    }

    public void verifyPageAvatarBigIsVisible() {
        pageAvatarBig.shouldBe(visible);
    }

    @Override
    public Iterator<Post> iterator() {
        return new WallIterator();
    }

    public Iterator<Post> iterator(int maximumAmount) {
        return new WallIterator(maximumAmount);
    }

    private class WallIterator implements Iterator<Post> {
        SelenideElement noPostsElement = elements("a").findBy(text("No posts yet"));
        int maximumAmount;
        int currentIndex = 0;
        EventWaiter waiter = new EventWaiter();
        Event hasNext = () -> wallPosts.size() > currentIndex && maximumAmount > currentIndex;

        WallIterator(int maximumAmount) {
            this.maximumAmount = maximumAmount;
        }

        WallIterator() {
            this(Integer.MAX_VALUE);
        }

        @Override
        public boolean hasNext() {
            if(currentIndex == 0 && noPostsElement.exists()) {
                return false;
            } else {
                return waiter.waitFor(hasNext);
            }
        }

        @Override
        public Post next() {
            SelenideElement currentElement = wallPosts.get(currentIndex).scrollTo();
            currentIndex++;
            return new Post(currentElement);
        }
    }

}
