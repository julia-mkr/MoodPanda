package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModalPage {

    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String UPDATE_MOOD_BUTTON = ".btn-primary.ButtonUpdate";
    public static final String WHAT_HAPPENS_TEXTAREA = "#TextBoxUpdateMoodTag";
    public static final String DATE_NOW_BUTTON = ".ResetNow.btn";
    public static final String DATE_YESTERDAY_BUTTON = ".ResetYesterday.btn";
    public static final String DATE_TWO_DAY_BUTTON = ".Reset2day.btn";
    public static final String DATE_THREE_DAY_BUTTON = ".Reset3day.btn";
    public static final String DATE_OLDER_BUTTON = ".ResetOlder.btn";
    public static final SelenideElement DATE_PICKER_MONTH = $(".ui-datepicker-month");
    public static final SelenideElement DATE_PICKER_YEAR = $(".ui-datepicker-year");
    public static final String DATE_PICKER_DAY = "//td//a[text()='%s']";
    public static final SelenideElement HOUR_PICKER = $("#ddlHistoricHour");
    public static final SelenideElement MINUTE_PICKER = $("#ddlHistoricMinute");

    public RateYourHappinessModalPage updateMood(int moodValue) {
        $(SLIDER_CSS).click();
        int defaultMoodValue = 5;
        Keys direction = null;
        if (moodValue > defaultMoodValue) {
            direction = Keys.ARROW_RIGHT;
        } else if (moodValue < defaultMoodValue) {
            direction = Keys.ARROW_LEFT;
        }
        if (moodValue != defaultMoodValue) {
            for (int i = 0; i < Math.abs(moodValue - defaultMoodValue); i++) {
                $(SLIDER_CSS).sendKeys(direction);
            }
        }
        return this;
    }

    public MoodUpdatedModalPage clickOnUpdateMoodButton() {
        $(UPDATE_MOOD_BUTTON).click();
        return new MoodUpdatedModalPage();
    }

    public RateYourHappinessModalPage writeTextInWhatHappensTextarea(String text) {
        $(WHAT_HAPPENS_TEXTAREA).sendKeys(text);
        return this;
    }

    public RateYourHappinessModalPage chooseDateAndClickOnButton(String date) {
        switch (date) {
            case "Now":
                $(DATE_NOW_BUTTON).click();
                break;
            case "Yesterday":
                $(DATE_YESTERDAY_BUTTON).click();
                break;
            case "2 days ago":
                $(DATE_TWO_DAY_BUTTON).click();
                break;
            case "3 days ago":
                $(DATE_THREE_DAY_BUTTON).click();
                break;
            case "Older":
                $(DATE_OLDER_BUTTON).click();
        }
        return this;
    }

    public RateYourHappinessModalPage selectMonthYearAndDayClickingOnOlderButton(int month, String year, int day) {
        $(DATE_PICKER_MONTH).click();
        $(DATE_PICKER_MONTH).selectOption(month);
        $(DATE_PICKER_YEAR).click();
        $(DATE_PICKER_YEAR).selectOptionByValue(year);
        $(By.xpath(String.format(DATE_PICKER_DAY, day))).click();
        return this;
    }

    public RateYourHappinessModalPage selectHourAndMinute(String hour, String minute) {
        $(HOUR_PICKER).click();
        $(HOUR_PICKER).selectOptionByValue(hour);
        $(MINUTE_PICKER).click();
        $(MINUTE_PICKER).selectOptionByValue(minute);
        return this;
    }
}
