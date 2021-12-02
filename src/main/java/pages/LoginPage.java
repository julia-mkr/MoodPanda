package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {

    public static final String LOGIN_URL = "https://moodpanda.com/Login/";
    public static final String EMAIL_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    public static final String PASSWORD_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    public static final String LOGIN_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonLogin";

    public LoginPage openPage() {
        log.info("Open the url: " + LOGIN_URL);
        open(LOGIN_URL);
        return this;
    }

    public FeedPage login(String email, String password) {
        log.info(String.format("Type the email: '%s' into the 'Email' field on the 'Login' page", email));
        $(EMAIL_INPUT_CSS).shouldBe(Condition.visible).sendKeys(email);
        log.info(String.format("Type the password: '%s' into the 'Password' field on the 'Login' page", password));
        $(PASSWORD_INPUT_CSS).shouldBe(Condition.visible).sendKeys(password);
        log.info("Click on the 'Login' button");
        $(LOGIN_BUTTON_CSS).click();
        return new FeedPage();
    }
}

