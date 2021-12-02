package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class AvatarPage {

    public static final String AVATAR_IMAGE = "#ContentPlaceHolderContent_RepeaterImage_ImageButton1_%d";
    public static final String SUCCESS_TEXT = "//*[@id='ContentPlaceHolderContent_MessageSuccess']//strong";

    public AvatarPage changeAvatar(int number) {
        log.info("Change the avatar image on the 'Avatar' page");
        log.info("The number of the avatar image is " + number);
        log.info("Click on the selected avatar");
        $(String.format(AVATAR_IMAGE, number)).click();
        return this;
    }

    public String getSuccessTextAfterChangingAvatar() {
        return $(By.xpath(SUCCESS_TEXT)).getText();
    }
}
