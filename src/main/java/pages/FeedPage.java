package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    public static final String UPDATE_MOOD_BUTTON = "#LinkUpdate";
    public static final SelenideElement ACCOUNT_DROP_DOWN = $("#Settings");
    public static final String LIST_OF_ACCOUNT_MENU = "//*[@class='dropdown-menu']/ancestor::li[@id='Settings']//ul";
    public static final String SEND_A_HUG_BUTTON = "//*[contains(@class, 'm%d ')]//a[contains(@class, 'btnhugs')]";
    public static final String TEXT_AFTER_CLICKING_ON_SEND_A_HUG = "//*[contains(@class, 'mcw%d ')]//*[contains(@class, 'label-hug')]//a";
    public static final String REPLY_TEXTAREA = "#mcr%d";
    public static final String REPLY_BUTTON = "//*[contains(@class, 'mcw%d ')]//a[contains(text(), 'Reply')]";
    public static final String REPLY_TEXT = "//*[contains(@class,'mcw%d ')]//*[contains(@class, 'comment-tag')]//p";

    public RateYourHappinessModalPage clickUpdateMoodButton() {
        $(UPDATE_MOOD_BUTTON).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return new RateYourHappinessModalPage();
    }

    public AvatarPage selectOptionInAccountMenu(String option) {
        $(ACCOUNT_DROP_DOWN).click();
        $(By.xpath(LIST_OF_ACCOUNT_MENU)).find(withText(option)).click();
        return new AvatarPage();
    }

    public FeedPage clickOnSendAHugButton(int divNumber) {
        $(By.xpath(String.format(SEND_A_HUG_BUTTON, divNumber))).shouldBe(Condition.visible,Duration.ofSeconds(10)).click();
        return this;
    }

    public String getTextAfterClickingOnSendAHug(int divNumber) {
        return $(By.xpath(String.format(TEXT_AFTER_CLICKING_ON_SEND_A_HUG, divNumber)))
                .shouldBe(Condition.visible,Duration.ofSeconds(10)).getText();
    }

    public FeedPage writeTextInReplyTextArea(int divNumber, String text) {
        $(String.format(REPLY_TEXTAREA, divNumber)).sendKeys(text);
        $(By.xpath(String.format(REPLY_BUTTON, divNumber))).click();
        return this;
    }

    public String getReplyText(int divNumber) {
        return $(By.xpath(String.format(REPLY_TEXT, divNumber))).getText();
    }
}
