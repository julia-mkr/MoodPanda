package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyDiaryPage {

    public static final String RATE_NUMBER = "//*[contains(@class, 'm1 ')]//h5//span[contains(@class,'badge')]";
    public static final String TEXT_FROM_WHATS_HAPPENS_TEXTAREA = "//*[contains(@class, 'm1 ')]//div[contains(@class, 'MoodPostItem')]";
    public static final String TEXT_OF_DATE = "//*[contains(@class, 'm1 ')]//div[contains(@class, 'xs-8')]";

    public String getRateNumber() {
        return $(By.xpath(RATE_NUMBER)).getText();
    }

    public String getTextFromWhatsHappensTextarea() {
        return $(By.xpath(TEXT_FROM_WHATS_HAPPENS_TEXTAREA)).getText();
    }

    public String getTextOfDate() {
        return $(By.xpath(TEXT_OF_DATE)).getText();
    }
}
