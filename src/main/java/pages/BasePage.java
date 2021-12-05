package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class BasePage {

    public LoginPage openPage(String url) {
        log.info("Open the url: " + url);
        open(url);
        return new LoginPage();
    }
}
