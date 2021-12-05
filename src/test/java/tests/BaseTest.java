package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    BasePage basePage;
    LoginPage loginPage;
    FeedPage feedPage;
    MoodUpdatedModalPage moodUpdatedModalPage;
    MyDiaryPage myDiaryPage;
    RateYourHappinessModalPage rateYourHappinessModalPage;
    AvatarPage avatarPage;
    MoodPandaHomePage moodPandaHomePage;

    public static final String MOOD_PANDA_HOMEPAGE = "https://moodpanda.com/";
    public static final String LOGIN_URL = "https://moodpanda.com/Login/";

    @BeforeMethod
    public void init() {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
    }

    @BeforeMethod
    public void initPages() {
        basePage = new BasePage();
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        moodUpdatedModalPage = new MoodUpdatedModalPage();
        myDiaryPage = new MyDiaryPage();
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
        avatarPage = new AvatarPage();
        moodPandaHomePage = new MoodPandaHomePage();
    }

    @AfterMethod
    public void quit() {
        getWebDriver().quit();
    }
}
