package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class RateYourHappinessModalTests extends BaseTest {

    @Test(description = "The test rates user's happiness level moving the slider")
    public void rateHappinessLevelTest() {
        loginPage.openPage()
                .login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickUpdateMoodButton()
                .updateMood(8)
                .clickOnUpdateMoodButton()
                .clickOnGoToMyDiaryButton();
        Assert.assertEquals(myDiaryPage.getRateNumber(), "8");
    }

    @Test(description = "The test rates user's happiness level moving the slider, fills in the 'What's Happens?' " +
            "textarea and chooses date: 'Now'")
    public void rateHappinessLevelFillTextareaAndChooseNowDateTest() {
        loginPage.openPage()
                .login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickUpdateMoodButton()
                .updateMood(7)
                .writeTextInWhatHappensTextarea("Everything is just fine")
                .chooseDateAndClickOnButton("Now")
                .clickOnUpdateMoodButton()
                .clickOnGoToMyDiaryButton();
        Assert.assertEquals(myDiaryPage.getRateNumber(), "7");
        Assert.assertEquals(myDiaryPage.getTextFromWhatsHappensTextarea(), "Everything is just fine");
        Assert.assertEquals(myDiaryPage.getTextOfDate(), "Just Now");
    }

    @Test(description = "The test rates user's happiness level moving the slider, and chooses date: 'Yesterday'," +
            " and selects hour and minutes")
    public void rateHappinessLevelChooseYesterdayDateTest() {
        loginPage.openPage()
                .login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickUpdateMoodButton()
                .updateMood(8)
                .chooseDateAndClickOnButton("Yesterday")
                .selectHourAndMinute("04", ":15")
                .clickOnUpdateMoodButton()
                .clickOnGoToMyDiaryButton();
        Assert.assertEquals(myDiaryPage.getRateNumber(), "8");
        Assert.assertEquals(myDiaryPage.getTextOfDate(), "1 day ago");
    }

    @Test(description = "The test rates user's happiness level moving the slider, fills in the 'What's Happens?' " +
            "textarea and chooses date: '2 days ago', and selects hour and minutes")
    public void rateHappinessLevelFillTextareaAndChooseTwoDaysAgoDateTest() {
        loginPage.openPage()
                .login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickUpdateMoodButton()
                .updateMood(4)
                .writeTextInWhatHappensTextarea("People are strange")
                .chooseDateAndClickOnButton("2 days ago")
                .selectHourAndMinute("14", ":30")
                .clickOnUpdateMoodButton()
                .clickOnGoToMyDiaryButton();
        Assert.assertEquals(myDiaryPage.getRateNumber(), "4");
        Assert.assertEquals(myDiaryPage.getTextFromWhatsHappensTextarea(), "People are strange");
        Assert.assertEquals(myDiaryPage.getTextOfDate(), "2 days ago");
    }

    @Test(description = "The test rates user's happiness level moving the slider, and chooses date: '3 days ago'")
    public void rateHappinessLevelAndChooseThreeDaysAgoDateTest() {
        loginPage.openPage()
                .login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickUpdateMoodButton()
                .updateMood(7)
                .chooseDateAndClickOnButton("3 days ago")
                .selectHourAndMinute("10", ":45")
                .clickOnUpdateMoodButton()
                .clickOnGoToMyDiaryButton();
        Assert.assertEquals(myDiaryPage.getRateNumber(), "7");
        Assert.assertEquals(myDiaryPage.getTextOfDate(), "3 days ago");
    }

    @Test(description = "The test rates user's happiness level moving the slider, fills in the 'What's Happens?' " +
            "textarea and chooses date: 'Older', and then selects month, year, and day")
    public void rateHappinessLevelFillTextareaAndChooseOlderDateTest() {
        loginPage.openPage()
                .login(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")))
                .clickUpdateMoodButton()
                .updateMood(10)
                .writeTextInWhatHappensTextarea("Feeling awesome!")
                .chooseDateAndClickOnButton("Older")
                .selectMonthYearAndDayClickingOnOlderButton(5, "2016", 30)
                .clickOnUpdateMoodButton()
                .clickOnGoToMyDiaryButton();
        Assert.assertEquals(myDiaryPage.getRateNumber(), "10");
        Assert.assertEquals(myDiaryPage.getTextFromWhatsHappensTextarea(), "Feeling awesome!");
        Assert.assertEquals(myDiaryPage.getTextOfDate(), "30 Jun 2016");
    }
}
