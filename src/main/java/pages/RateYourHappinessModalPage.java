package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class RateYourHappinessModalPage extends BasePage {

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
        log.info("Click on the 'Mood' slider and drag it to position: " + moodValue);
        $(SLIDER_CSS).click();
        int defaultMoodValue = 5;
        Keys direction = null;
        if (moodValue > defaultMoodValue) {
            log.info("The slider moves to the right");
            direction = Keys.ARROW_RIGHT;
        } else if (moodValue < defaultMoodValue) {
            log.info("The slider moves to the left");
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
        log.info("Click on the 'Update mood' button on the 'Rate your happiness' modal");
        $(UPDATE_MOOD_BUTTON).click();
        return new MoodUpdatedModalPage();
    }

    public RateYourHappinessModalPage writeTextInWhatHappensTextarea(String text) {
        log.info(String.format("Type the text: '%s' into the 'What happens' textarea on the 'Rate your happiness' modal", text));
        $(WHAT_HAPPENS_TEXTAREA).sendKeys(text);
        return this;
    }

    public RateYourHappinessModalPage chooseDateAndClickOnButton(String date) {
        log.info("The chosen date on the 'Rate your happiness' model is: " + date);
        switch (date) {
            case "Now":
                log.info("Click on the 'Now' button");
                $(DATE_NOW_BUTTON).click();
                break;
            case "Yesterday":
                log.info("Click on the 'Yesterday' button");
                $(DATE_YESTERDAY_BUTTON).click();
                break;
            case "2 days ago":
                log.info("Click on the '2 days ago' button");
                $(DATE_TWO_DAY_BUTTON).click();
                break;
            case "3 days ago":
                log.info("Click on the '3 days ago' button");
                $(DATE_THREE_DAY_BUTTON).click();
                break;
            case "Older":
                log.info("Click on the 'Older' button");
                $(DATE_OLDER_BUTTON).click();
        }
        return this;
    }

    public RateYourHappinessModalPage selectMonthYearAndDayClickingOnOlderButton(int month, String year, int day) {
        log.info("Click on the 'Month' dropdown");
        $(DATE_PICKER_MONTH).click();
        log.info("The selected month is " + month);
        $(DATE_PICKER_MONTH).selectOption(month);
        log.info("Click on the 'Year' dropdown");
        $(DATE_PICKER_YEAR).click();
        log.info("The selected year is " + year);
        $(DATE_PICKER_YEAR).selectOptionByValue(year);
        log.info("The selected day is " + day);
        $(By.xpath(String.format(DATE_PICKER_DAY, day))).click();
        return this;
    }

    public RateYourHappinessModalPage selectHourAndMinute(String hour, String minute) {
        log.info("Click on the 'Hour' dropdown");
        $(HOUR_PICKER).click();
        log.info("The selected hour is " + hour);
        $(HOUR_PICKER).selectOptionByValue(hour);
        log.info("Click on the 'Minute' dropdown");
        $(MINUTE_PICKER).click();
        log.info("The selected minutes are " + minute);
        $(MINUTE_PICKER).selectOptionByValue(minute);
        return this;
    }
}
