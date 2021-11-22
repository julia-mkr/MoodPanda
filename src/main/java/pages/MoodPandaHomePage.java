package pages;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;

public class MoodPandaHomePage {

    public static final String PANDA_IMAGE_ON_HOMEPAGE = ".intro-content>img";

    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public boolean isPandaImageOnHomepageDisplayed() {
        return $(PANDA_IMAGE_ON_HOMEPAGE).isDisplayed();
    }
}
