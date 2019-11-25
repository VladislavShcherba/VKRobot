package page.section;

import com.codeborne.selenide.SelenideElement;

public class Post {

    private static final String likedClassAttribute = "active";

    private SelenideElement like;

    public Post(SelenideElement root) {
        like = root.find(".post_info>.like_wrap .like");
    }

    public boolean isLiked() {
        return like.getAttribute("class").contains(likedClassAttribute);
    }

    public void like() {
        if(!isLiked()) {
            like.click();
        }
    }

    public void unlike() {
        if(isLiked()) {
            like.click();
        }
    }

}
