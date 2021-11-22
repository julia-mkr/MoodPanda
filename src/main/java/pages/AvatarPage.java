package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AvatarPage {

    public static final String AVATAR_IMAGE = "#ContentPlaceHolderContent_RepeaterImage_ImageButton1_%d";
    public static final String SUCCESS_TEXT = "//*[@id='ContentPlaceHolderContent_MessageSuccess']//strong";

    public AvatarPage changeAvatar(int number) {
        $(String.format(AVATAR_IMAGE, number)).click();
        return this;
    }

    public String getSuccessTextAfterChangingAvatar() {
        return $(By.xpath(SUCCESS_TEXT)).getText();
    }
}
