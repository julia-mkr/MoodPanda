import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTests extends BaseTest {

    @Test(description = "The test changes an avatar image")
    public void changeUserAvatarTest() {
        loginPage.openPage()
                .login(EMAIL, PASSWORD)
                .selectOptionInAccountMenu("Avatar")
                .changeAvatar(9);
        Assert.assertEquals(avatarPage.getSuccessTextAfterChangingAvatar(), "Success!");
    }

    @Test(description = "The test logs out of the website")
    public void LogoutTest() {
        loginPage.openPage()
                .login(EMAIL, PASSWORD)
                .selectOptionInAccountMenu("Logout");
        Assert.assertEquals(moodPandaHomePage.getCurrentUrl(), MOOD_PANDA_HOMEPAGE);
        Assert.assertTrue(moodPandaHomePage.isPandaImageOnHomepageDisplayed());
    }

    @Test(description = "The test clicks on the 'Send a hug' button in a user's post")
    public void sendHugToAnotherUserTest() {
        loginPage.openPage()
                .login(EMAIL, PASSWORD)
                .clickOnSendAHugButton(11);
        Assert.assertEquals(feedPage.getTextAfterClickingOnSendAHug(11), "- You");
    }

    @Test(description = "The test sends a reply message under a user's post")
    public void sendReplyToAnotherUserTest() {
        loginPage.openPage()
                .login(EMAIL, PASSWORD)
                .writeTextInReplyTextArea(9, "Have a nice day :)");
        Assert.assertEquals(feedPage.getReplyText(9), "Have a nice day :)");
    }
}
